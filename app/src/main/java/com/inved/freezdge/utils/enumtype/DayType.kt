package com.inved.freezdge.utils.enumtype

import com.inved.freezdge.R
import com.inved.freezdge.utils.App

enum class DayType(val day:Long, val dayName:String){
    MONDAY(0, App.appContext.getString(R.string.monday)),
    TUESDAY(1, App.appContext.getString(R.string.tuesday)),
    WEDNESDAY(2, App.appContext.getString(R.string.wednesday)),
    THURSDAY(3, App.appContext.getString(R.string.thursday)),
    FRIDAY(4, App.appContext.getString(R.string.friday)),
    SATURDAY(5, App.appContext.getString(R.string.saturday)),
    SUNDAY(6, App.appContext.getString(R.string.sunday))
}