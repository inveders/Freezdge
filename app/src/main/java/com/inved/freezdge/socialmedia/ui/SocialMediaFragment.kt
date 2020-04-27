package com.inved.freezdge.socialmedia.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
    private lateinit var recyclerView: RecyclerView
    private lateinit var addPhotoImage: ImageView
    private lateinit var addTipImage: ImageView
    private lateinit var photoProfile: ImageView
    private lateinit var addPhotoText: TextView
    private lateinit var addTipText: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mView: View = inflater.inflate(R.layout.fragment_social_media, container, false)
        recyclerView= mView.findViewById(R.id.recyclerview)
        addPhotoImage=mView.findViewById(R.id.image_photo_post)
        addTipImage=mView.findViewById(R.id.image_tips_post)
        addPhotoText=mView.findViewById(R.id.title_photo_post)
        addTipText=mView.findViewById(R.id.title_tips_post)
        photoProfile=mView.findViewById(R.id.profile_image)
        //RecyclerView initialization
        displayAllPosts()
        initButtons()
        return mView
    }

    private fun initButtons() {
        addPhotoImage.setOnClickListener { onClickAddPhoto() }
        addPhotoText.setOnClickListener { onClickAddPhoto() }
        addTipImage.setOnClickListener { onClickAddTips() }
        addTipText.setOnClickListener { onClickAddTips() }
        photoProfile.setOnClickListener { onClickUpdateProfil() }
    }

    private fun displayAllPosts() {
        mRecyclerPostsAdapter = PostsAdapter(
            generateOptionsForAdapter(PostHelper.getAllPosts()),
            Glide.with(this),
            this,
            activity
        )
        //Choose how to display the list in the RecyclerView (vertical or horizontal)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(
            context,
            RecyclerView.VERTICAL,
            false
        )
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                activity,
                DividerItemDecoration.VERTICAL
            )
        )
        recyclerView.adapter = mRecyclerPostsAdapter
    }

    // Create options for RecyclerView from a Query
    private fun generateOptionsForAdapter(query: Query): FirestoreRecyclerOptions<Post?> {
        return FirestoreRecyclerOptions.Builder<Post>()
            .setQuery(query, Post::class.java)
            .setLifecycleOwner(this)
            .build()
    }

    private fun onClickAddPhoto(){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        val previous = activity?.supportFragmentManager?.findFragmentByTag(PhotoDialog.TAG)
        if (previous != null) {
            transaction?.remove(previous)
        }
        transaction?.addToBackStack(null)

        val dialogFragment = PhotoDialog.newInstance("parameter")
        if (transaction != null) {
            dialogFragment.show(transaction, PhotoDialog.TAG)
        }
    }

    private fun onClickAddTips(){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        val previous = activity?.supportFragmentManager?.findFragmentByTag(TipsDialog.TAG)
        if (previous != null) {
            transaction?.remove(previous)
        }
        transaction?.addToBackStack(null)

        val dialogFragment = TipsDialog.newInstance("parameter")
        if (transaction != null) {
            dialogFragment.show(transaction, TipsDialog.TAG)
        }
    }

    private fun onClickUpdateProfil(){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        val previous = activity?.supportFragmentManager?.findFragmentByTag(ProfilDialog.TAG)
        if (previous != null) {
            transaction?.remove(previous)
        }
        transaction?.addToBackStack(null)

        val dialogFragment = ProfilDialog.newInstance("profil")
        if (transaction != null) {
            dialogFragment.show(transaction, ProfilDialog.TAG)
        }
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