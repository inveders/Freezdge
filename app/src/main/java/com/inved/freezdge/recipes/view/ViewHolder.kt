package com.inved.freezdge.recipes.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
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
    var imageFavourite: ImageView =
        view.findViewById(R.id.fragment_recipe_list_favorite_selected_or_not)
    var cardView: CardView = view.findViewById(R.id.recipe_list_row_id)
    override fun bindView(item: Hit, payloads: MutableList<Any>) {

        label.text = item.recipe?.label
        preparationTime.text = item.recipe?.totalTime.toString()
        kcal.text = item.recipe?.calories.toString()
        var url: String = item.recipe?.url.toString()

        GlideApp.with(App.applicationContext())
            .load(item.recipe?.image)
            .into(imageItem)

    }

    override fun unbindView(item: Hit) {
        label.text = null
        preparationTime.text = null
        kcal.text = null
        imageItem.setImageDrawable(null)
    }

}