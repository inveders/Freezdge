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
                    fixedId = 1,
                    lunch = 0,
                    dinner = 0
                )
            )

            selectedDayBox?.put(
                DaySelected(
                    fixedId = 2,
                    lunch = 0,
                    dinner = 0
                )
            )

            selectedDayBox?.put(
                DaySelected(
                    fixedId = 3,
                    lunch = 0,
                    dinner = 0
                )
            )

            selectedDayBox?.put(
                DaySelected(
                    fixedId = 4,
                    lunch = 0,
                    dinner = 0
                )
            )

            selectedDayBox?.put(
                DaySelected(
                    fixedId = 5,
                    lunch = 0,
                    dinner = 0
                )
            )

            selectedDayBox?.put(
                DaySelected(
                    fixedId = 6,
                    lunch = 0,
                    dinner = 0
                )
            )

            selectedDayBox?.put(
                DaySelected(
                    fixedId = 7,
                    lunch = 0,
                    dinner = 0
                )
            )
        }
    }

}