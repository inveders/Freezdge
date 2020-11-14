package com.inved.freezdge.favourites.viewmodel

import androidx.lifecycle.ViewModel
import com.inved.freezdge.favourites.database.DaySelected
import com.inved.freezdge.favourites.repository.DaySelectedRepository
import io.objectbox.android.ObjectBoxLiveData

class DaySelectedViewModel(private val daySelectedRepository: DaySelectedRepository): ViewModel() {

    fun insertDays() {
        daySelectedRepository.insertDays()
    }

    fun deleteAllDays() {
        daySelectedRepository.deleteAllDayInBox()
    }

    fun countDays():Long? {
        return daySelectedRepository.countDay()
    }

    fun getSelectedDay(): ObjectBoxLiveData<DaySelected> {
        return daySelectedRepository.getSelectedDays()
    }

    fun updateSelectedDayValues(id: Long, lunchValue: Long, dinnerValue: Long) {
        return daySelectedRepository.updateSelectedDayValues(id,lunchValue,dinnerValue)
    }

    fun reinitLunchValues(lunchValue: Long) {
       daySelectedRepository.reinitLunchValue(lunchValue)
    }

    fun reinitDinnerValues(dinnerValue: Long) {
        daySelectedRepository.reinitDinnerValue(dinnerValue)
    }

}