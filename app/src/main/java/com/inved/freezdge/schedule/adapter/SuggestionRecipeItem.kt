package com.inved.freezdge.schedule.adapter

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.storage.FirebaseStorage
import com.inved.freezdge.R
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.utils.Domain
import com.inved.freezdge.utils.GlideUtils
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

class SuggestionRecipeItem : AbstractItem<SuggestionRecipeItem.ViewHolder>(){

    var model: Recipes? = null

    // defines the type defining this item. must be unique. preferably an id
    override val type: Int
        get() = R.id.item_recipe_suggestion

    // defines the layout which will be used for this item in the list
    override val layoutRes: Int
        get() = R.layout.item_recipe_suggestion

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(val view: View) : FastAdapter.ViewHolder<SuggestionRecipeItem>(view) {

        var domain= Domain()
        var chooseButton: Button = view.findViewById(R.id.chooseButton)
        private var recipeName: TextView = view.findViewById(R.id.recipeName)
        private var recipeImage: ImageView = view.findViewById(R.id.recipeImage)

        override fun bindView(item: SuggestionRecipeItem, payloads: MutableList<Any>) {
            recipeName.text = item.model?.recipeTitle

            val storage = FirebaseStorage.getInstance()
            val gsReference = item.model?.recipePhotoUrl?.let { storage.getReferenceFromUrl(it) }
            // we show photo from our firebase storage
            GlideUtils.loadPhotoWithGlide(gsReference, null, recipeImage)
        }

        override fun unbindView(item: SuggestionRecipeItem) {
            recipeName.text = null
        }
    }
}