package com.inved.freezdge.view

import android.util.Log
import android.view.View
import android.widget.TextView
import com.inved.freezdge.R
import com.inved.freezdge.model.food.Hint
import com.mikepenz.fastadapter.FastAdapter

class ViewHolderFood(view: View) : FastAdapter.ViewHolder<Hint>(view) {

    var label: TextView = view.findViewById(R.id.item_ingredients_list_textview)

    override fun bindView(item: Hint, payloads: MutableList<Any>) {

        Log.d("debago", "item bindvIEW")
        label.text = item.food?.label

    }

    override fun unbindView(item: Hint) {
        label.text = null
    }
}