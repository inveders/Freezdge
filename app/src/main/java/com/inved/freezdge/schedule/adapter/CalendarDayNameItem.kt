package com.inved.freezdge.schedule.adapter

import android.view.View
import android.widget.TextView
import com.inved.freezdge.R
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

class CalendarDayNameItem : AbstractItem<CalendarDayNameItem.ViewHolder>() {

    var dayName:String?=null
    override val layoutRes: Int
        get() = R.layout.item_day_name

    override val type: Int
        get() = R.id.item_day_name

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(val view: View) : FastAdapter.ViewHolder<CalendarDayNameItem>(view) {

        private var dayNameText : TextView = view.findViewById(R.id.day_name)
        override fun bindView(item: CalendarDayNameItem, payloads: MutableList<Any>) {
              dayNameText.text=item.dayName
        }

        override fun unbindView(item: CalendarDayNameItem) {
            dayNameText.text=null
        }

    }
}