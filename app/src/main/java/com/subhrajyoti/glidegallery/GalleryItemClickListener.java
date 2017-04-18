package com.subhrajyoti.glidegallery;

import android.widget.ImageView;

public interface GalleryItemClickListener {
    void onGalleryItemClickListener(int position, ImageModel imageModel, ImageView imageView);
}
