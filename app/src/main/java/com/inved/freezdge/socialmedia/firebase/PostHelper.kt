package com.inved.freezdge.socialmedia.firebase

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import java.util.Date

class PostHelper {

    companion object{
        private val COLLECTION_NAME = "posts"

        // --- COLLECTION REFERENCE ---
        fun getPostCollection(): CollectionReference {
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

            return getPostCollection()?.document(postId)?.set(postToCreate)
        }

        // --- GET ---
        fun getPost(postId: String): Query? {
            return getPostCollection()
                ?.whereEqualTo("postId", postId)
        }

        fun getAllPosts(): Query {
            return getPostCollection()
                .orderBy("timestamp", Query.Direction.DESCENDING)
        }

        fun getAllPostsByType(postType: String?): Query? {
            return getPostCollection()
                ?.whereEqualTo("postType", postType)
                ?.orderBy("timestamp", Query.Direction.DESCENDING)
        }

        // --- GET ---
        fun getMyPost(userUid: String?): Query? {
            return getPostCollection()
                ?.whereEqualTo("userUid", userUid)
        }

        // --- UPDATE ---
        fun updateTitleAstuce(
            titleAstuce: String?,
            postId: String
        ): Task<Void?>? {
            return getPostCollection()?.document(postId)?.update("titleAstuce", titleAstuce)
        }

        fun updateDescriptionAstuce(
            descriptionAstuce: String?,
            postId: String
        ): Task<Void?>? {
            return getPostCollection()?.document(postId)?.update("descriptionAstuce", descriptionAstuce)
        }

        fun updatePhotoUrl(
            urlPhoto: String?,
            postId: String
        ): Task<Void?>? {
            return getPostCollection()?.document(postId)?.update("urlPhoto", urlPhoto)
        }

        fun updateLikeNumber(
            likeNumber: Int?,
            postId: String
        ): Task<Void?>? {
            return getPostCollection()?.document(postId)?.update("likeNumber", likeNumber)
        }


        // --- DELETE ---
        fun deletePost(postId: String): Task<Void?>? {
            return getPostCollection()?.document(postId)?.delete()
        }

    }
}