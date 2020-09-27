package com.inved.freezdge.uiGeneral.adapter

import android.view.View
import android.widget.Button
import com.inved.freezdge.R
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

class CloseButtonItem : AbstractItem<CloseButtonItem.ViewHolder>() {

    override val layoutRes: Int
        get() = R.layout.item_close_button

    override val type: Int
        get() = R.id.item_close_button

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(val view: View) : FastAdapter.ViewHolder<CloseButtonItem>(view) {

        var closeButton : Button = view.findViewById(R.id.ok_button)

        override fun bindView(item: CloseButtonItem, payloads: MutableList<Any>) {

        }

        override fun unbindView(item: CloseButtonItem) {

        }

    }
}