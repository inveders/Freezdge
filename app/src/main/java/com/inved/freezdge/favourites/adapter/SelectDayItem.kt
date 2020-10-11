package com.inved.freezdge.favourites.adapter

import android.view.View
import android.widget.TextView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.inved.freezdge.R
import com.inved.freezdge.utils.ChipsDayType
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

        private var textDay : TextView = view.findViewById(R.id.titleChipDate)
        var lunchChip: Chip = view.findViewById(R.id.lunch_chips)
        var snackChip: Chip = view.findViewById(R.id.snack_chips)
        var dinnerChip: Chip = view.findViewById(R.id.dinner_chips)
        override fun bindView(item: SelectDayItem, payloads: MutableList<Any>) {
            textDay.text=item.day
            if(item.isChecked==true){
                when (item.selectedPosition) {
                    ChipsDayType.LUNCH.chipPosition -> {
                        lunchChip.isChecked=true
                    }
                    ChipsDayType.SNACK.chipPosition -> {
                        snackChip.isChecked=true
                    }
                    ChipsDayType.DINNER.chipPosition -> {
                        dinnerChip.isChecked=true
                    }
                }
            }
        }

        override fun unbindView(item: SelectDayItem) {

        }

    }
}