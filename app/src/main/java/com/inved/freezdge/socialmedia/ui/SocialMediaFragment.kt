package com.inved.freezdge.socialmedia.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.Query
import com.inved.freezdge.R
import com.inved.freezdge.socialmedia.firebase.Post
import com.inved.freezdge.socialmedia.firebase.PostHelper
import com.inved.freezdge.socialmedia.view.PostsAdapter
import kotlinx.android.synthetic.main.fragment_social_media.*

class SocialMediaFragment: Fragment(),PostsAdapter.Listener {

    private lateinit var mRecyclerPostsAdapter:PostsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mView: View = inflater.inflate(R.layout.fragment_social_media, container, false)

        //RecyclerView initialization
        displayAllPosts()
        return mView
    }



    private fun displayAllPosts() {
        mRecyclerPostsAdapter = PostsAdapter(
            generateOptionsForAdapter(PostHelper.getAllPosts()),
            Glide.with(this),
            this,
            activity
        )
        //Choose how to display the list in the RecyclerView (vertical or horizontal)
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = LinearLayoutManager(
            context,
            RecyclerView.VERTICAL,
            false
        )
        recyclerview.addItemDecoration(
            DividerItemDecoration(
                recyclerview.context,
                DividerItemDecoration.VERTICAL
            )
        )
        recyclerview.adapter = mRecyclerPostsAdapter
    }

    // Create options for RecyclerView from a Query
    private fun generateOptionsForAdapter(query: Query): FirestoreRecyclerOptions<Post?> {
        return FirestoreRecyclerOptions.Builder<Post>()
            .setQuery(query, Post::class.java)
            .setLifecycleOwner(this)
            .build()
    }

    // --------------------
    // CALLBACK
    // --------------------
    override fun onDataChanged() {
        // 7 - Show TextView in case RecyclerView is empty
        if(mRecyclerPostsAdapter.itemCount==0){
            no_post_found.visibility=View.VISIBLE
        }else{
            no_post_found.visibility=View.GONE
        }
    }



}