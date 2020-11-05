package com.inved.freezdge.utils.enumtype

import com.inved.freezdge.R
import com.inved.freezdge.utils.App

enum class DayType(val day:Long, val dayName:String){
    MONDAY(1, App.appContext.getString(R.string.monday)),
    TUESDAY(2, App.appContext.getString(R.string.tuesday)),
    WEDNESDAY(3, App.appContext.getString(R.string.wednesday)),
    THURSDAY(4, App.appContext.getString(R.string.thursday)),
    FRIDAY(5, App.appContext.getString(R.string.friday)),
    SATURDAY(6, App.appContext.getString(R.string.saturday)),
    SUNDAY(7, App.appContext.getString(R.string.sunday))
}