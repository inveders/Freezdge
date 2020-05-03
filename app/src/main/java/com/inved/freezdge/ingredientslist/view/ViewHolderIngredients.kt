package com.inved.freezdge.ingredientslist.view

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.firebase.storage.FirebaseStorage
import com.inved.freezdge.R
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.GlideApp
import com.mikepenz.fastadapter.FastAdapter

class ViewHolderIngredients(view: View) : FastAdapter.ViewHolder<Ingredients>(view) {


    var label: TextView = view.findViewById(R.id.item_ingredients_list_textview)
    var imageFood: ImageView = view.findViewById(R.id.item_ingredients_list_image_ingredient_image)
    var imageSelection: ImageView =
        view.findViewById(R.id.item_ingredients_list_image_favorite_selected_or_not_imageview)
    var shimmer: ShimmerFrameLayout = view.findViewById(R.id.shimmer_view_container)

    override fun bindView(item: Ingredients, payloads: MutableList<Any>) {
        label.text = item.name

        val storage = FirebaseStorage.getInstance()
        // Create a reference to a file from a Google Cloud Storage URI
        val gsReference = item.photoUrl?.let { storage.getReferenceFromUrl(it) }
        GlideApp.with(App.applicationContext())
            .load(gsReference)
            .listener(object : RequestListener<Drawable?> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any,
                    target: Target<Drawable?>,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.e("debago", "Exception is : $e")
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any,
                    target: Target<Drawable?>,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    shimmer.stopShimmer()
                    shimmer.hideShimmer()
                    return false
                }
            })
            .into(imageFood)






        if (!item.selectedIngredient) {
            imageSelection.setImageResource(R.drawable.ic_add_ingredient_selected_24dp)
        } else {
            imageSelection.setImageResource(R.drawable.ic_remove_ingredient_not_selected_24dp)
        }

    }

    override fun unbindView(item: Ingredients) {
        label.text = null
        imageFood.setImageURI(null)
    }

}