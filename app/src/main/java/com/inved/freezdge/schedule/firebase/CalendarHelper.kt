package com.inved.freezdge.schedule.firebase

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.inved.freezdge.schedule.database.DaySelected

class CalendarHelper {

    companion object{
        private const val COLLECTION_NAME = "users"

        private const val SUB_COLLECTION_SCHEDULE_RECIPE = "scheduledRecipes"

        // --- COLLECTION REFERENCE ---
        private fun getUsersScheduledRecipesCollection(uid: String): CollectionReference? {
            return FirebaseFirestore.getInstance()
                .collection(COLLECTION_NAME).document(uid)
                .collection(SUB_COLLECTION_SCHEDULE_RECIPE)
        }

        // --- CREATE ---
        fun createScheduleRecipes(
            uid: String,
            documentId:String,
            daySelected: DaySelected
        ): Task<Void?>? {
            // 1 - Create Obj
            return daySelected.let { getUsersScheduledRecipesCollection(uid)?.document(documentId)?.set(it) }
        }

        // --- GET ---
        fun getDayScheduled(uid: String?,documentId: Long): Query? {
            return uid?.let {
                getUsersScheduledRecipesCollection(
                    it
                )?.whereEqualTo("id", documentId)
            }
        }

        fun updateLunchValue(
            uid: String?,documentId: String,lunchValue:Long
        ): Task<Void?>? {
            return uid?.let { getUsersScheduledRecipesCollection(it)
                ?.document(documentId)?.update("lunch", lunchValue) }
        }

        fun updateDinnerValue(
            uid: String?,documentId: String,dinnerValue:Long
        ): Task<Void?>? {
            return uid?.let { getUsersScheduledRecipesCollection(it)
                ?.document(documentId)?.update("dinner", dinnerValue) }
        }

    }
}