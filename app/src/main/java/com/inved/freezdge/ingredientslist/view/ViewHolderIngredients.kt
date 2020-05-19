package com.inved.freezdge.ingredientslist.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.firebase.storage.FirebaseStorage
import com.inved.freezdge.R
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.utils.GlideUtils
import com.mikepenz.fastadapter.FastAdapter

class ViewHolderIngredients(view: View) : FastAdapter.ViewHolder<Ingredients>(view) {

    private var label: TextView = view.findViewById(R.id.item_ingredients_list_textview)
    private var imageFood: ImageView = view.findViewById(R.id.item_ingredients_list_image_ingredient_image)
    var imageSelection: ImageView =
        view.findViewById(R.id.item_ingredients_list_image_favorite_selected_or_not_imageview)
    private var shimmer: ShimmerFrameLayout = view.findViewById(R.id.shimmer_view_container)

    override fun bindView(item: Ingredients, payloads: MutableList<Any>) {
        label.text = item.name

        val storage = FirebaseStorage.getInstance()
        // Create a reference to a file from a Google Cloud Storage URI
        val gsReference = item.photoUrl?.let { storage.getReferenceFromUrl(it) }
        // we show an image from our own database in firebase storage
        GlideUtils.loadPhotoWithGlide(gsReference,shimmer,imageFood)

        // if item is selected, we show a +, if not we show a minus
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