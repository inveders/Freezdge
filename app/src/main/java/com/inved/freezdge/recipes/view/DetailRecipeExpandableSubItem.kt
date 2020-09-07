package com.inved.freezdge.recipes.view

import android.view.View
import android.widget.TextView
import com.inved.freezdge.R
import com.inved.freezdge.utils.App
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.IExpandable
import com.mikepenz.fastadapter.expandable.items.AbstractExpandableItem

class DetailRecipeExpandableSubItem :
    AbstractExpandableItem<DetailRecipeExpandableSubItem.ViewHolder>(),
    IExpandable<DetailRecipeExpandableSubItem.ViewHolder> {

    var numberStep: Int? = 0
    var recipeStep: String? = null


    override val layoutRes: Int
        get() = R.layout.item_recipe_steps

    override val type: Int
        get() = R.id.item_recipe_steps

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(val view: View) : FastAdapter.ViewHolder<DetailRecipeExpandableSubItem>(view) {

        private val textView: TextView = view.findViewById(R.id.itemNameTextView)

        override fun bindView(item: DetailRecipeExpandableSubItem, payloads: MutableList<Any>) {
            textView.text=App.appContext.getString(R.string.step_recipe,item.numberStep,item.recipeStep)
        }

        override fun unbindView(item: DetailRecipeExpandableSubItem) {
            textView.text=null
        }
    }
}