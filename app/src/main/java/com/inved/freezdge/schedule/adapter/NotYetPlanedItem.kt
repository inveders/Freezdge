package com.inved.freezdge.schedule.adapter

import android.content.Context
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import com.inved.freezdge.R
import com.inved.freezdge.utils.Domain
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import kotlin.math.roundToInt


class NotYetPlanedItem : AbstractItem<NotYetPlanedItem.ViewHolder>(){

    var day:Long?=0L
    var isLunchOrDinner:Int?=0

    // defines the type defining this item. must be unique. preferably an id
    override val type: Int
        get() = R.id.item_not_yet_planed

    // defines the layout which will be used for this item in the list
    override val layoutRes: Int
        get() = R.layout.item_not_yet_planed

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(val view: View) : FastAdapter.ViewHolder<NotYetPlanedItem>(view) {

        private var metrics = DisplayMetrics()

        private fun getDisplayMetrics() {
            val windowManager: WindowManager =
                view.context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            windowManager.defaultDisplay.getMetrics(metrics)
        }

        var domain= Domain()
        var imageItem: ImageView = view.findViewById(R.id.image)


        override fun bindView(item: NotYetPlanedItem, payloads: MutableList<Any>) {
                getDisplayMetrics().also {
                    view.layoutParams.width =(metrics.widthPixels * 0.4).roundToInt()
                }
        }

        override fun unbindView(item: NotYetPlanedItem) {
        }
    }
}