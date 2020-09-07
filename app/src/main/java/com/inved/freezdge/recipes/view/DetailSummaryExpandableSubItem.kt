package com.inved.freezdge.recipes.view

import android.view.View
import android.widget.TextView
import com.inved.freezdge.R
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.IExpandable
import com.mikepenz.fastadapter.expandable.items.AbstractExpandableItem

class DetailSummaryExpandableSubItem :
    AbstractExpandableItem<DetailSummaryExpandableSubItem.ViewHolder>(),
    IExpandable<DetailSummaryExpandableSubItem.ViewHolder> {

    var ingredient: String? = null

    override val layoutRes: Int
        get() = R.layout.item_recipe_detail_list_expandable_item

    override val type: Int
        get() = R.id.item_recipe_detail_list_expandable_item

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(val view: View) : FastAdapter.ViewHolder<DetailSummaryExpandableSubItem>(view) {

        private val textView: TextView = view.findViewById(R.id.item)

        override fun bindView(item: DetailSummaryExpandableSubItem, payloads: MutableList<Any>) {
            textView.text=item.ingredient
        }

        override fun unbindView(item: DetailSummaryExpandableSubItem) {
            textView.text=null
        }
    }
}