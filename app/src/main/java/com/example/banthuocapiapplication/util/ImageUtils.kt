package com.example.banthuocapiapplication.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.banthuocapiapplication.R
import com.makeramen.roundedimageview.RoundedImageView

class ImageUtils {
    companion object{
        fun loadImage(roundedImageView: RoundedImageView, imageUrl: String, context: Context) {
            var requestOptions = RequestOptions()
            requestOptions = requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .placeholder(R.drawable.img_splash_1)
                .dontAnimate()

            Glide.with(context).load(imageUrl).apply(requestOptions).into(roundedImageView)
        }

        fun loadImage(imageView: ImageView, imageUrl: String, context: Context) {
            var requestOptions = RequestOptions()
            requestOptions = requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .placeholder(R.drawable.img_splash_1)
                .dontAnimate()

            Glide.with(context).load(imageUrl).apply(requestOptions).into(imageView)
        }
    }
}