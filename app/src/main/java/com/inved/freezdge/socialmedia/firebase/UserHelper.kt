package com.inved.freezdge.socialmedia.firebase

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class UserHelper {

    companion object{
        private const val COLLECTION_NAME = "users"

        // --- COLLECTION REFERENCE ---
        private fun getUsersCollection(): CollectionReference? {
            return FirebaseFirestore.getInstance()
                .collection(COLLECTION_NAME)
        }

        // --- CREATE ---
        fun createUser(
            uid: String,
            firstname: String?,
            lastname: String?,
            photoUrl: String?
        ): Task<Void?>? {
            // 1 - Create Obj
            val userToCreate = User(
                uid,
                firstname,
                lastname,
                photoUrl
            )

            return getUsersCollection()?.document(uid)?.set(userToCreate)
        }

        // --- GET ---
        fun getUser(uid: String?): Query? {
            return getUsersCollection()
                ?.whereEqualTo("uid", uid)
        }

        // --- UPDATE ---
        fun updateFirstname(
            firstname: String?,
            uid: String?
        ): Task<Void?>? {
            return uid?.let { getUsersCollection()?.document(it)?.update("firstname", firstname) }
        }

        fun updateLastname(
            lastname: String?,
            uid: String?
        ): Task<Void?>? {
            return uid?.let { getUsersCollection()?.document(it)?.update("lastname", lastname) }
        }

        fun updatePhotoUrl(
            photoUrl: String?,
            uid: String?
        ): Task<Void?>? {
            return uid?.let { getUsersCollection()?.document(it)?.update("photoUrl", photoUrl) }
        }
    }

}