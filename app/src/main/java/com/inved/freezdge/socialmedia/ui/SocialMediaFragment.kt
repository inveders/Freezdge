package com.inved.freezdge.socialmedia.ui

import android.Manifest
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.Query
import com.inved.freezdge.R
import com.inved.freezdge.databinding.FragmentSocialMediaBinding
import com.inved.freezdge.socialmedia.firebase.Post
import com.inved.freezdge.socialmedia.firebase.PostHelper
import com.inved.freezdge.socialmedia.firebase.User
import com.inved.freezdge.socialmedia.firebase.UserHelper
import com.inved.freezdge.socialmedia.view.PostsAdapter
import com.inved.freezdge.utils.*
import kotlinx.android.synthetic.main.fragment_social_media.*
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.RuntimePermissions

@RuntimePermissions
class SocialMediaFragment : Fragment(), PostsAdapter.ClickListener, LoaderListener,ProfileDialog.ChangePhotoListener {

    private lateinit var binding : FragmentSocialMediaBinding
    var domain=Domain()
    private lateinit var mRecyclerPostsAdapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // in here you can do logic when backPress is clicked
                nestedScrollView.smoothScrollTo(0, 0)

            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (!::binding.isInitialized) {
            binding = FragmentSocialMediaBinding.inflate(inflater, container, false)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        showLoader()
        initButtons()
        initProfil()
        displayAllPosts()
    }

    override fun onResume() {
        super.onResume()
        initProfil()
        displayAllPosts()
    }

    // retrieve user's photo and firstname
    private fun initProfil() {

        UserHelper.getUser(FirebaseAuth.getInstance().currentUser?.uid)?.get()
            ?.addOnCompleteListener { task ->
                if (task.result != null) {
                    if (task.result?.documents?.isNotEmpty()==true) {
                        val user: User? =
                            task.result!!.documents[0].toObject(User::class.java)
                        topDescription.text =
                            App.resource()
                                .getString(R.string.social_media_description, user?.firstname)
                        //to show photo from Firebase storage or url. If photo is not from google, it's also from firebase
                        GlideUtils.loadPhotoWithGlideCircleCropUrl(user?.photoUrl, photoProfile)
                        hideLoader()
                    }
                }
            }?.addOnFailureListener {
                hideLoader()
            }
    }

    // init click listener on different button and text of page (tip, camera, gallery, profile)
    private fun initButtons() {
        addPhotoCamera.setOnClickListener {
            addPhotoCamera.startAnimation(domain.animation())
            addPhotoCameraText.startAnimation(domain.animation())
            onClickAddPhotoWithPermissionCheck(1, "")
        }
        addPhotoCameraText.setOnClickListener {
            addPhotoCamera.startAnimation(domain.animation())
            addPhotoCameraText.startAnimation(domain.animation())
            onClickAddPhotoWithPermissionCheck(1, "")
        }
        addPhotoGallery.setOnClickListener {
            addPhotoGallery.startAnimation(domain.animation())
            addPhotoGalleryText.startAnimation(domain.animation())
            onClickAddPhotoGalleryWithPermissionCheck()
        }
        addPhotoGalleryText.setOnClickListener {
            addPhotoGallery.startAnimation(domain.animation())
            addPhotoGalleryText.startAnimation(domain.animation())
            onClickAddPhotoGalleryWithPermissionCheck()
        }
        addTipImage.setOnClickListener {
            addTipImage.startAnimation(domain.animation())
            addTipText.startAnimation(domain.animation())
            onClickAddTips(0, "")
        }
        addTipText.setOnClickListener {
            addTipImage.startAnimation(domain.animation())
            addTipText.startAnimation(domain.animation())
            onClickAddTips(0, "")
        }
        photoProfile.setOnClickListener { onClickUpdateProfil() }
        mSwipeRefreshLayout?.setOnRefreshListener {
            mSwipeRefreshLayout?.isRefreshing = true
            //4second splash time
            Handler().postDelayed({
                //start main activity
                displayAllPosts()
                mSwipeRefreshLayout?.isRefreshing = false
            }, 1000)
        }
    }


    private fun displayAllPosts() {
        mRecyclerPostsAdapter = PostsAdapter(
            generateOptionsForAdapter(PostHelper.getAllPosts()), this
        )
        mRecyclerPostsAdapter.startListening()
        //Choose how to display the list in the RecyclerView (vertical or horizontal)
        recyclerview.layoutManager = LinearLayoutManager(
            context,
            RecyclerView.VERTICAL,
            false
        )
        recyclerview.adapter = mRecyclerPostsAdapter
    }

    override fun onStart() {
        super.onStart()
        mRecyclerPostsAdapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        mRecyclerPostsAdapter.stopListening()
    }


    // Create options for RecyclerView from a Query
    private fun generateOptionsForAdapter(query: Query): FirestoreRecyclerOptions<Post> {
        return FirestoreRecyclerOptions.Builder<Post>()
            .setQuery(query, Post::class.java)
            .setLifecycleOwner(this)
            .build()
    }

    // click on camera button to create new image post
    @NeedsPermission(Manifest.permission.CAMERA)
    fun onClickAddPhoto(value: Int, postId: String) {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        val previous = activity?.supportFragmentManager?.findFragmentByTag(PhotoDialog.TAG)
        if (previous != null) {
            transaction?.remove(previous)
        }
        transaction?.addToBackStack(null)

        val dialogFragment = PhotoDialog.newInstance(value, postId)
        if (transaction != null) {
            dialogFragment.show(transaction, PhotoDialog.TAG)
        }
    }

    // click on gallery button to create new image post
    @NeedsPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
    fun onClickAddPhotoGallery() {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        val previous = activity?.supportFragmentManager?.findFragmentByTag(PhotoDialog.TAG)
        if (previous != null) {
            transaction?.remove(previous)
        }
        transaction?.addToBackStack(null)

        val dialogFragment = PhotoDialog.newInstance(2, "")
        if (transaction != null) {
            dialogFragment.show(transaction, PhotoDialog.TAG)
        }
    }

    // click on tip add to create new tip post
    private fun onClickAddTips(value: Int, postId: String) {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        val previous = activity?.supportFragmentManager?.findFragmentByTag(TipsDialog.TAG)
        if (previous != null) {
            transaction?.remove(previous)
        }
        transaction?.addToBackStack(null)

        val dialogFragment = TipsDialog.newInstance(value, postId)
        if (transaction != null) {
            dialogFragment.show(transaction, TipsDialog.TAG)
        }
    }

    // click on photo profil to launch update profile dialog
    private fun onClickUpdateProfil() {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        val previous = activity?.supportFragmentManager?.findFragmentByTag(ProfileDialog.TAG)
        if (previous != null) {
            transaction?.remove(previous)
        }
        transaction?.addToBackStack(null)

        val dialogFragment = ProfileDialog.newInstance("profil")
        ProfileDialog.setChangePhotoListener(this)
        if (transaction != null) {
            dialogFragment.show(transaction, ProfileDialog.TAG)
        }
    }


    override fun onRequestPermissionsResult(
        rc: Int,
        permissions: Array<out String>,
        results: IntArray
    ) {
        this.onRequestPermissionsResult(rc, results)
    }

    // dialog before to delete a post
    private fun launchAlertDialog(postId: String) {
        val builder = context?.let { MaterialAlertDialogBuilder(it) }
        builder?.setTitle(
            App.resource().getString(R.string.social_media_post_delete_title_dialog)
        )
        builder?.setMessage(
            App.resource().getString(R.string.social_media_post_delete_message_dialog)
        )

        builder?.setPositiveButton(App.resource().getString(R.string.Yes)) { _, _ ->
            PostHelper.deletePost(postId)
            Toast.makeText(
                App.applicationContext(),
                App.resource().getString(R.string.social_media_post_delete_confirmation_dialog),
                Toast.LENGTH_SHORT
            ).show()
        }

        builder?.setNegativeButton(android.R.string.no) { dialog, _ ->
            dialog.dismiss()
        }

        builder?.show()
    }

    // click listener on update or delete button inside post item in recycler view
    override fun onClickListener(value: Int, postId: String) {
        when (value) {
            1 -> {
                launchAlertDialog(postId)
            }
            2 -> {
                onClickAddTips(value, postId)
            }
            3 -> {
                onClickAddPhotoWithPermissionCheck(value, postId)
            }
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        val searchItem = menu.findItem(R.id.searchItem)
        searchItem.isVisible = false
        val clearIngredientItem = menu.findItem(R.id.clearIngredientItem)
        clearIngredientItem.isVisible = false
        super.onPrepareOptionsMenu(menu)
    }

    // to update UI when data changed in the firestore database
    override fun onDataChanged() {
        // 7 - Show TextView in case RecyclerView is empty
        if (mRecyclerPostsAdapter.itemCount == 0) {
            if (NetworkUtils.isNetworkAvailable(App.applicationContext())) {
                noPostFound.visibility = View.VISIBLE
            } else {
                noPostFound.visibility = View.VISIBLE
                noPostFound.text = getString(R.string.internet_connexion)
            }

        } else {
            noPostFound.visibility = View.GONE
        }
    }

    // click on post image to open preview dialog
    override fun onClickImageListener(postImage: String?) {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        val previous = activity?.supportFragmentManager?.findFragmentByTag(PreviewPhotoDialog.TAG)
        if (previous != null) {
            transaction?.remove(previous)
        }
        transaction?.addToBackStack(null)

        val dialogFragment = postImage?.let { PreviewPhotoDialog.newInstance(it) }
        if (transaction != null) {
            dialogFragment?.show(transaction, PreviewPhotoDialog.TAG)
        }
    }

    override fun showLoader() {
        loader?.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        loader?.visibility = View.GONE
        nestedScrollView.visibility = View.VISIBLE
    }

    override fun onPhotoChanged() {
        initProfil()
    }
}