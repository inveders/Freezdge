package com.inved.freezdge.favourites.adapter

import android.content.res.ColorStateList
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import com.inved.freezdge.R
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.enumtype.ChipsDayType
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

class SelectDayItem : AbstractItem<SelectDayItem.ViewHolder>() {
    var day: String?=null
    var isChecked:Boolean?=false
    var isOccuped:Boolean?=false
    var lunchId:Long?=0
    var dinnerId:Long?=0
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
        var dinnerChip: Chip = view.findViewById(R.id.dinner_chips)
        override fun bindView(item: SelectDayItem, payloads: MutableList<Any>) {
            textDay.text=item.day

            when (item.selectedPosition) {
                ChipsDayType.LUNCH.chipPosition -> {

                    if(item.isChecked==true && item.isOccuped==true){
                        lunchChip.isChecked=true
                        dinnerChip.chipBackgroundColor = ColorStateList.valueOf(ContextCompat.getColor(
                            App.appContext, R.color.colorPrimaryLight))
                    }else if(item.isChecked==true){
                        lunchChip.isChecked=true
                    } else if (item.isOccuped==true){
                        lunchChip.chipBackgroundColor = ColorStateList.valueOf(ContextCompat.getColor(
                            App.appContext, R.color.colorPrimaryLight))
                    }


                }
                ChipsDayType.DINNER.chipPosition -> {

                    if(item.isChecked==true && item.isOccuped==true){
                        dinnerChip.isChecked=true
                        lunchChip.chipBackgroundColor = ColorStateList.valueOf(ContextCompat.getColor(
                            App.appContext, R.color.colorPrimaryLight))
                    }else if(item.isChecked==true){
                        dinnerChip.isChecked=true
                    }else if(item.isOccuped==true){
                        dinnerChip.chipBackgroundColor = ColorStateList.valueOf(ContextCompat.getColor(
                            App.appContext, R.color.colorPrimaryLight))
                    }

                }
            }


        }

        override fun unbindView(item: SelectDayItem) {

        }

    }
}