package com.subhrajyoti.glidegallery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class RecyclerViewFragment extends Fragment implements GalleryItemClickListener{

    public static final String TAG = RecyclerViewFragment.class.getSimpleName();

    public RecyclerViewFragment() {
    }


    public static RecyclerViewFragment newInstance() {
        return new RecyclerViewFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GalleryAdapter galleryAdapter = new GalleryAdapter(Utils.getData(),this);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(galleryAdapter);
    }

    @Override
    public void onGalleryItemClickListener(int position, ImageModel imageModel, ImageView imageView) {
        GalleryViewPagerFragment galleryViewPagerFragment = GalleryViewPagerFragment.newInstance(position, Utils.getData());

        getFragmentManager()
                .beginTransaction()
                .addSharedElement(imageView, ViewCompat.getTransitionName(imageView))
                .addToBackStack(TAG)
                .replace(R.id.content, galleryViewPagerFragment)
                .commit();
    }


}
