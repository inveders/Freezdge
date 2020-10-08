package com.inved.freezdge.favourites.adapter

import android.view.View
import android.widget.TextView
import com.google.android.material.chip.ChipGroup
import com.inved.freezdge.R
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

class SelectDayItem : AbstractItem<SelectDayItem.ViewHolder>() {
    var day: String?=null
    var isChecked:Boolean?=false
    var selectedPosition:Int?=0

    override val layoutRes: Int
        get() = R.layout.item_dialog_select_day

    override val type: Int
        get() = R.id.item_dialog_select_day

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(val view: View) : FastAdapter.ViewHolder<SelectDayItem>(view) {

        var textDay : TextView = view.findViewById(R.id.titleChipDate)
        var chipGroup: ChipGroup = view.findViewById(R.id.day_chips_group)

        override fun bindView(item: SelectDayItem, payloads: MutableList<Any>) {
            textDay.text=item.day
            if(item.isChecked==true){
                item.selectedPosition?.let { chipGroup.check(it) }
            }
        }

        override fun unbindView(item: SelectDayItem) {

        }

    }
}