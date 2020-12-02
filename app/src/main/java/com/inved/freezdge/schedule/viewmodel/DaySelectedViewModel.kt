package com.inved.freezdge.schedule.viewmodel

import androidx.lifecycle.ViewModel
import com.inved.freezdge.schedule.database.DaySelected
import com.inved.freezdge.schedule.repository.DaySelectedRepository

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

    fun getSelectedDay(): MutableList<DaySelected>? {
        return daySelectedRepository.getSelectedDays()
    }

    fun updateSelectedDayValues(id: Long, lunchValue: Long, dinnerValue: Long) {
        return daySelectedRepository.updateSelectedDayValues(id,lunchValue,dinnerValue)
    }

    fun isRecipeSelectedInCalendar(recipeId: Long):Boolean {
        return daySelectedRepository.isRecipeSelected(recipeId)
    }

    fun reinitCalendarValues() {
        daySelectedRepository.reinitCalendarValues()
    }

}