package com.inved.freezdge.socialmedia.firebase

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import java.util.*


//For future implementation
class FavoritePostHelper {

    companion object{
        private const val COLLECTION_NAME = "users"

        private const val SUB_COLLECTION_FAVORITE_RESTAURANT = "favoritePosts"

        // --- COLLECTION REFERENCE ---
        private fun getUsersFavoritePostCollection(uid: String): CollectionReference? {
            return FirebaseFirestore.getInstance()
                .collection(COLLECTION_NAME).document(uid)
                .collection(SUB_COLLECTION_FAVORITE_RESTAURANT)
        }

        // --- CREATE ---
        fun createUserFavoritePost(
            uid: String,
            postId: String,
            timestamp: Date
        ): Task<Void?>? {
            // 1 - Create Obj
            val favoritePostToCreate = FavoritePost(
                postId,timestamp
            )
            return getUsersFavoritePostCollection(uid)?.document(postId)?.set(favoritePostToCreate)
        }

        // --- GET ---
        fun getAllFavoritePost(uid: String): Query? {
            return getUsersFavoritePostCollection(
                uid
            )?.orderBy("timestamp", Query.Direction.DESCENDING)
        }

        fun isThisPostIsFavorite(uid: String?,postId: String?): Query? {
            return uid?.let {
                getUsersFavoritePostCollection(it)
                    ?.whereEqualTo("postId", postId)
            }
        }

        // --- DELETE ---
        fun deleteFavoritePost(
            uid: String,
            postId: String
        ) {
            getUsersFavoritePostCollection(uid
            )?.document(postId)?.delete()
        }
    }
}