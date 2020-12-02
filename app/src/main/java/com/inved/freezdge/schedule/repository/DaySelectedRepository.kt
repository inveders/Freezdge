package com.inved.freezdge.schedule.repository

import com.google.firebase.auth.FirebaseAuth
import com.inved.freezdge.schedule.database.DaySelected
import com.inved.freezdge.schedule.database.DaySelected_
import com.inved.freezdge.schedule.firebase.CalendarHelper
import com.inved.freezdge.utils.AddSelectedDay
import io.objectbox.Box

class DaySelectedRepository(private val getDaySelectedBox: Box<DaySelected>?) {

    // insert all day for first implementation of the database
    fun insertDays() {
        AddSelectedDay(getDaySelectedBox)
    }

    fun getSelectedDays(): MutableList<DaySelected>? {
        return getDaySelectedBox?.query()?.order(DaySelected_.fixedId)?.build()?.find()

    }

    fun deleteAllDayInBox() {
        getDaySelectedBox?.removeAll()
        insertDays()
    }

    fun countDay(): Long? {
        return getDaySelectedBox?.count()
    }

    // update daySelected lunch
    fun updateSelectedDayValues(id: Long, lunchValue: Long, dinnerValue: Long) {

        val daySelected: DaySelected? =
            getDaySelectedBox?.query()?.equal(DaySelected_.fixedId, id)?.build()?.findUnique()
        daySelected.apply {
            this?.lunch=lunchValue
            this?.dinner=dinnerValue
        }

        if (daySelected != null)
            getDaySelectedBox?.put(daySelected)

        //update values in firebase
        CalendarHelper.updateLunchValue(FirebaseAuth.getInstance().currentUser?.uid,id.toString(),lunchValue)
        CalendarHelper.updateDinnerValue(FirebaseAuth.getInstance().currentUser?.uid,id.toString(),dinnerValue)

    }

    // get recipe if selected in calendar
    fun isRecipeSelected(recipeId: Long):Boolean {
        for (i in 1..7){
            val daySelected: DaySelected? =
                getDaySelectedBox?.query()?.equal(DaySelected_.fixedId, i.toLong())?.build()?.findUnique()
            if(daySelected?.lunch==recipeId || daySelected?.dinner==recipeId){
                return true
            }
        }
        return false
    }

    // reinit Calendar Values
    fun reinitCalendarValues() {
        for (i in 1..7){
            val daySelected: DaySelected? =
                getDaySelectedBox?.get(i.toLong())
            daySelected.apply {
                this?.lunch = 0
                this?.dinner = 0
            }
            if (daySelected != null)
                getDaySelectedBox?.put(daySelected)
        }
    }



}
