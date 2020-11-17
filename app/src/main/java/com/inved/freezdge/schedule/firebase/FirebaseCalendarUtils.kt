package com.inved.freezdge.schedule.firebase

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.inved.freezdge.schedule.database.DaySelected
import com.inved.freezdge.schedule.database.DaySelected_
import com.inved.freezdge.utils.App
import io.objectbox.kotlin.boxFor

class FirebaseCalendarUtils {

    fun getAllScheduledDaySelected() {
        for (i in 1..7){
            CalendarHelper.getDayScheduled(
                FirebaseAuth.getInstance().currentUser?.uid,
                i.toString()
            )?.get()
                ?.addOnCompleteListener { task ->
                    if (task.result != null) {
                        if (task.result?.documents?.size == 0) {
                            createCalendarInFirebase()
                        }else if (task.result?.documents?.isNotEmpty() == true) {
                            val scheduleDay: DaySelected? =
                                task.result!!.documents[0].toObject(DaySelected::class.java)

                            val daySelected: DaySelected? =
                                scheduleDay?.id?.let {
                                    App.ObjectBox.boxStore.boxFor<DaySelected>().query()?.equal(DaySelected_.id,
                                        it
                                    )?.build()?.findUnique()
                                }
                            daySelected.apply {
                                this?.lunch=scheduleDay?.lunch
                                this?.dinner=scheduleDay?.dinner
                            }
                            if (daySelected != null)
                                App.ObjectBox.boxStore.boxFor<DaySelected>().put(daySelected)
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

    private fun createCalendarInFirebase(){
        FirebaseAuth.getInstance().currentUser?.uid?.let {
            for (i in 1..7){
                CalendarHelper.createScheduleRecipes(
                    it,
                    i.toString(),
                    DaySelected().apply {
                        this.id = i.toLong()
                        this.lunch = 0
                        this.dinner = 0
                    }
                )
            }
        }
    }

}