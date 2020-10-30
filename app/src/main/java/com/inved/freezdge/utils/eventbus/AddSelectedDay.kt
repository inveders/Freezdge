package com.inved.freezdge.utils.eventbus

import com.inved.freezdge.favourites.database.DaySelected
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