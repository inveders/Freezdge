package com.inved.freezdge.favourites.repository

import com.inved.freezdge.favourites.database.DaySelected
import com.inved.freezdge.favourites.database.DaySelected_
import com.inved.freezdge.utils.AddSelectedDay
import io.objectbox.Box
import io.objectbox.android.ObjectBoxLiveData

class DaySelectedRepository(private val getDaySelectedBox: Box<DaySelected>?) {

    // insert all day for first implementation of the database
    fun insertDays() {
        AddSelectedDay(getDaySelectedBox)
    }

    fun getSelectedDays(): ObjectBoxLiveData<DaySelected> {
        return ObjectBoxLiveData(
            getDaySelectedBox?.query()?.order(DaySelected_.id)?.build()
        )
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
            getDaySelectedBox?.query()?.equal(DaySelected_.id, id+1)?.build()?.findUnique()
        daySelected.apply {
            this?.lunch=lunchValue
            this?.dinner=dinnerValue
        }
        if (daySelected != null)
            getDaySelectedBox?.put(daySelected)

    }

    // update daySelected lunch
    fun reinitLunchValue(lunchValue: Long) {

        val daySelected: MutableList<DaySelected>? =
            getDaySelectedBox?.query()?.equal(DaySelected_.lunch, lunchValue)?.build()?.find()

        daySelected?.forEach {
            it.apply {
                this?.lunch=0
            }
            getDaySelectedBox?.put(it)
        }

    }

    // update daySelected dinner
    fun reinitDinnerValue(dinnerValue: Long) {

        val daySelected: MutableList<DaySelected>? =
            getDaySelectedBox?.query()?.equal(DaySelected_.dinner, dinnerValue)?.build()?.find()

        daySelected?.forEach {
            it.apply {
                this?.lunch=0
            }
            getDaySelectedBox?.put(it)
        }

    }



}
