package com.inved.freezdge.uiGeneral.adapter

import android.view.View
import com.inved.freezdge.R
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

class TitleItem : AbstractItem<TitleItem.ViewHolder>() {

    override val layoutRes: Int
        get() = R.layout.item_title

    override val type: Int
        get() = R.id.item_title

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(val view: View) : FastAdapter.ViewHolder<TitleItem>(view) {

        override fun bindView(item: TitleItem, payloads: MutableList<Any>) {

        }

        override fun unbindView(item: TitleItem) {

        }

    }
}