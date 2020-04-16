package com.inved.freezdge.utils

import com.inved.freezdge.R
import kotlin.math.roundToInt

class Domain {

    companion object{
        fun preparationTime(time:Double?):String{

            when {
                time==0.0 -> {
                    return App.resource().getString(R.string.recipe_list_item_no_time_known)
                }
                time!! <=60.0 -> {
                    return App.resource().getString(R.string.recipe_list_item_time_min, time.roundToInt())
                }
                else -> {
                    val timeInt=time.toInt()
                    val hours: Int = timeInt / 60 //since both are ints, you get an int

                    val minutes: Int = timeInt % 60
                    return App.resource().getString(R.string.recipe_list_item_time_min_hours,hours, minutes)
                }
            }

        }
    }



}