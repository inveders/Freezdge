package com.inved.freezdge.view

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.inved.freezdge.R
import com.inved.freezdge.model.food.Parsed
import com.mikepenz.fastadapter.FastAdapter

class ViewHolderFood(view: View) : FastAdapter.ViewHolder<Parsed>(view) {

    var label: TextView = view.findViewById(R.id.item_ingredients_list_textview)
    var imageItem: ImageView = view.findViewById(R.id.item_ingredients_list_image_favorite_selected_or_not_imageview)

    override fun bindView(item: Parsed, payloads: MutableList<Any>) {

        Log.d("debago", "item bindvIEW")

        label.text = item.food?.label

        // imageItem.setImageURI() = item.kcal
    }

    override fun unbindView(item: Parsed) {
        label.text = null
    }
}