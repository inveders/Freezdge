package com.inved.freezdge.view

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.inved.freezdge.R
import com.inved.freezdge.model.recipes.Hit
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.GlideApp
import com.mikepenz.fastadapter.FastAdapter

class ViewHolder(view: View) : FastAdapter.ViewHolder<Hit>(view) {
    var label: TextView = view.findViewById(R.id.fragment_recipes_list_item_label)
    var preparationTime: TextView =
        view.findViewById(R.id.fragment_recipes_list_item_preparation_time_text)
    var kcal: TextView = view.findViewById(R.id.fragment_recipes_list_item_kcal)
    var imageItem: ImageView = view.findViewById(R.id.fragment_recipes_list_item_image)

    override fun bindView(item: Hit, payloads: MutableList<Any>) {

        Log.d("debago", "item bindvIEW")

        label.text = item.recipe?.label
        preparationTime.text = item.recipe?.totalTime.toString()
        kcal.text = item.recipe?.calories.toString()

        GlideApp.with(App.applicationContext())
            .load(item.recipe?.image)
            .into(imageItem)


        Log.d("debago", "item bindvIEW IN LOOP ${item.recipe?.image}")

        // imageItem.setImageURI() = item.kcal
    }

    override fun unbindView(item: Hit) {
        label.text = null
        preparationTime.text = null
        kcal.text = null
        imageItem.setImageDrawable(null)
    }

}