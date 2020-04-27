package com.inved.freezdge.socialmedia.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.inved.freezdge.R
import com.inved.freezdge.socialmedia.firebase.Post

class PostsAdapter(
    options: FirestoreRecyclerOptions<Post?>,
    glide: RequestManager?,
    callback: Listener?,
    context: Context?
) : FirestoreRecyclerAdapter<Post, PostViewHolder>(options) {


    interface Listener {
        fun onDataChanged()
    }

    //FOR DATA
    private val glide: RequestManager? = null

    //FOR COMMUNICATION
    private val callback: Listener? = null

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

    override fun onDataChanged() {
        super.onDataChanged()
        this.callback?.onDataChanged()
    }


}