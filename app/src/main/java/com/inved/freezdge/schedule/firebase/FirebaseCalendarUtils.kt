package com.inved.freezdge.schedule.firebase

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.inved.freezdge.schedule.database.DaySelected
import com.inved.freezdge.schedule.viewmodel.DaySelectedViewModel


class FirebaseCalendarUtils {

    fun getAllScheduledDaySelected(daySelectedViewModel: DaySelectedViewModel) {
        for (i in 1..7) {
            CalendarHelper.getDayScheduled(
                FirebaseAuth.getInstance().currentUser?.uid,
                i.toLong()
            )?.get()?.addOnCompleteListener { task ->

                if (task.result != null) {
                    if (task.result?.documents?.size != 0) {
                        val scheduleDay: DaySelected? =
                            task.result!!.documents[0].toObject(DaySelected::class.java)

                        scheduleDay?.let {
                            it.lunch?.let { it1 ->
                                scheduleDay.dinner?.let { it2 ->
                                    daySelectedViewModel.updateSelectedDayValues(i.toLong(),
                                        it1, it2
                                    )
                                }
                            }
                        }

                    }else{
                        createCalendarInFirebase()
                    }
                }
            }?.addOnFailureListener {
                Log.e(
                    "firebase",
                    "Problem during the day selected update"
                )
            }
        }
    }

    fun createCalendarInFirebase() {
        FirebaseAuth.getInstance().currentUser?.uid?.let {
            for (i in 1..7) {
                CalendarHelper.createScheduleRecipes(
                    it,
                    i.toString(),
                    DaySelected().apply {
                        this.fixedId = i.toLong()
                        this.lunch = 0
                        this.dinner = 0
                    }
                )
            }
        }
    }

}