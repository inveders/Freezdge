package com.inved.freezdge.socialmedia.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.inved.freezdge.R
import com.inved.freezdge.socialmedia.firebase.Post

class PostsAdapter(
    options: FirestoreRecyclerOptions<Post?>
) : FirestoreRecyclerAdapter<Post, PostViewHolder>(options) {


    //FOR DATA
    private val glide: RequestManager? = null

    override fun onBindViewHolder(
        postViewHolder: PostViewHolder,
        position: Int,
        post: Post) {
        postViewHolder.updateWithPosts(post, glide)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_social_media, parent, false)
        )
    }



}