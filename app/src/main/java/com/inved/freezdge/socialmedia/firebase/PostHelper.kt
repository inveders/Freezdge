package com.inved.freezdge.socialmedia.firebase

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import java.util.*

class PostHelper {

    companion object{
        private const val COLLECTION_NAME = "posts"

        // --- COLLECTION REFERENCE ---
        private fun getPostCollection(): CollectionReference {
            return FirebaseFirestore.getInstance()
                .collection(COLLECTION_NAME)
        }

        // --- CREATE ---
        fun createPost(
            postId: String,
            timestamp: Date,
            titleAstuce: String?,
            descriptionAstuce: String?,
            urlPhoto: String?,
            userUid: String?,
            postType: String?,
            likeNumber: Int?
        ): Task<Void?>? {
            // 1 - Create Obj
            val postToCreate = Post(
                postId,
                timestamp,
                titleAstuce,
                descriptionAstuce,
                urlPhoto,
                userUid,
                postType,
                likeNumber
            )

            return getPostCollection().document(postId).set(postToCreate)
        }

        // --- GET ---
        fun getPost(postId: String): Query? {
            return getPostCollection()
                .whereEqualTo("postId", postId)
        }

        fun getAllPosts(): Query {
            return getPostCollection()
                .orderBy("timestamp", Query.Direction.DESCENDING)
        }

        // --- UPDATE ---
        fun updateTitleAstuce(
            titleAstuce: String?,
            postId: String?
        ): Task<Void?>? {
            return postId?.let { getPostCollection().document(it).update("titleAstuce", titleAstuce) }
        }

        fun updateDescriptionAstuce(
            descriptionAstuce: String?,
            postId: String?
        ): Task<Void?>? {
            return postId?.let { getPostCollection().document(it).update("descriptionAstuce", descriptionAstuce) }
        }

        fun updatePhotoUrl(
            urlPhoto: String?,
            postId: String?
        ): Task<Void?>? {
            return postId?.let { getPostCollection().document(it).update("urlPhoto", urlPhoto) }
        }

        fun updateLikeNumber(
            likeNumber: Int?,
            postId: String?
        ): Task<Void?>? {
            return postId?.let { getPostCollection().document(it).update("likeNumber", likeNumber) }
        }


        // --- DELETE ---
        fun deletePost(postId: String): Task<Void?>? {
            return getPostCollection().document(postId).delete()
        }

    }
}