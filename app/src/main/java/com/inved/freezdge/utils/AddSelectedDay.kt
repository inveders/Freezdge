package com.inved.freezdge.utils

import com.inved.freezdge.schedule.database.DaySelected
import io.objectbox.Box

class AddSelectedDay(private var selectedDayBox: Box<DaySelected>?) {

    init {
        addDay()
    }

    private fun addDay() {

        if (selectedDayBox?.isEmpty == true) {
            selectedDayBox?.put(
                DaySelected(
                    lunch = 0,
                    dinner = 0
                )
            )

            selectedDayBox?.put(
                DaySelected(
                    lunch = 0,
                    dinner = 0
                )
            )

            selectedDayBox?.put(
                DaySelected(
                    lunch = 0,
                    dinner = 0
                )
            )

            selectedDayBox?.put(
                DaySelected(
                    lunch = 0,
                    dinner = 0
                )
            )

            selectedDayBox?.put(
                DaySelected(
                    lunch = 0,
                    dinner = 0
                )
            )

            selectedDayBox?.put(
                DaySelected(
                    lunch = 0,
                    dinner = 0
                )
            )

            selectedDayBox?.put(
                DaySelected(
                    lunch = 0,
                    dinner = 0
                )
            )
        }
    }

}