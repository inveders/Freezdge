package com.inved.freezdge.ingredientslist.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.inved.freezdge.R
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.GlideApp
import com.mikepenz.fastadapter.FastAdapter

class ViewHolderIngredients(view: View) : FastAdapter.ViewHolder<Ingredients>(view) {



    var label: TextView = view.findViewById(R.id.item_ingredients_list_textview)
    var imageFood: ImageView = view.findViewById(R.id.item_ingredients_list_image_ingredient_image)
    var imageSelection: ImageView = view.findViewById(R.id.item_ingredients_list_image_favorite_selected_or_not_imageview)

    override fun bindView(item: Ingredients, payloads: MutableList<Any>) {
        label.text = item.name

        GlideApp.with(App.applicationContext())
            .load(item.photoUrl)
            .centerCrop()
            .into(imageFood)

        if(!item.selectedIngredient){
            imageSelection.setImageResource(R.drawable.ic_add_ingredient_selected_24dp)
        }else{
            imageSelection.setImageResource(R.drawable.ic_remove_ingredient_not_selected_24dp)
        }

    }

    override fun unbindView(item: Ingredients) {
        label.text = null
        imageFood.setImageURI(null)
    }

}