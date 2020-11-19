package com.inved.freezdge.utils

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.firebase.storage.StorageReference
import com.inved.freezdge.R

class GlideUtils {

    //Glide functions for show images (center crop, circle crop, placeholder are handle here and not in the code)

    companion object{
        fun loadPhotoWithGlideCircleCropUrl(url:String?,image: ImageView?){
            image?.let {
                GlideApp.with(App.applicationContext())
                    .load(url)
                    .circleCrop()
                    .placeholder(R.drawable.ic_anon_user_48dp)
                    .into(it)
            }

        }

        fun loadPhotoWithGlideCenterCropUrl(url:String?,image: ImageView){
            GlideApp.with(App.applicationContext())
                .load(url)
                .centerCrop()
                .into(image)
        }

        fun loadPhotoWithGlideUrl(url:String?, shimmer: ShimmerFrameLayout?, image:ImageView?){
            image?.let {
                GlideApp.with(App.applicationContext())
                    .load(url)
                    .centerCrop()
                    .listener(object : RequestListener<Drawable?> {
                        override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: Target<Drawable?>,
                            isFirstResource: Boolean
                        ): Boolean {
                            Log.e("glide", "Exception is : $e")
                            if(shimmer!=null){
                                shimmer.stopShimmer()
                                shimmer.hideShimmer()
                            }
                            return false
                        }

                        override fun onResourceReady(
                            resource: Drawable?,
                            model: Any?,
                            target: Target<Drawable?>,
                            dataSource: DataSource,
                            isFirstResource: Boolean
                        ): Boolean {
                            if(shimmer!=null){
                                shimmer.stopShimmer()
                                shimmer.hideShimmer()
                            }
                            return false
                        }
                    })
                    .into(it)
            }
        }

        fun loadPhotoWithGlideCircleCrop(gsReference: StorageReference?, image:ImageView){
            GlideApp.with(App.applicationContext())
                .load(gsReference)
                .circleCrop()
                .into(image)
        }


        fun loadPhotoWithGlide(gsReference:StorageReference?,shimmer:ShimmerFrameLayout?,image:ImageView?){
            image?.let {
                GlideApp.with(App.applicationContext())
                    .load(gsReference)
                    .centerCrop()
                    .listener(object : RequestListener<Drawable?> {
                        override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: Target<Drawable?>,
                            isFirstResource: Boolean
                        ): Boolean {
                            Log.e("glide", "Exception is : $e")
                            if(shimmer!=null){
                                shimmer.stopShimmer()
                                shimmer.hideShimmer()
                            }
                            return false
                        }

                        override fun onResourceReady(
                            resource: Drawable?,
                            model: Any?,
                            target: Target<Drawable?>,
                            dataSource: DataSource,
                            isFirstResource: Boolean
                        ): Boolean {
                            if(shimmer!=null){
                                shimmer.stopShimmer()
                                shimmer.hideShimmer()
                            }
                            return false
                        }
                    })
                    .into(it)
            }
        }

    }
}