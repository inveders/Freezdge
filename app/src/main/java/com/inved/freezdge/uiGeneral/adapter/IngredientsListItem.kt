package com.inved.freezdge.uiGeneral.adapter

import android.view.View
import android.widget.TextView
import com.inved.freezdge.R
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

class IngredientsListItem : AbstractItem<IngredientsListItem.ViewHolder>() {
    var ingredientText:String?=null

    override val layoutRes: Int
        get() = R.layout.item_ingredient_list_dialog

    override val type: Int
        get() = R.id.item_ingredient_list_dialog

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(val view: View) : FastAdapter.ViewHolder<IngredientsListItem>(view) {
        var ingredientText : TextView = view.findViewById(R.id.ingredient_name)

        override fun bindView(item: IngredientsListItem, payloads: MutableList<Any>) {
            ingredientText.text = item.ingredientText
        }

        override fun unbindView(item: IngredientsListItem) {

        }

    }
}