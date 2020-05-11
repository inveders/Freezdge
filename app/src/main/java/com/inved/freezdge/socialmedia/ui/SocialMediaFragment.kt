package com.inved.freezdge.socialmedia.ui

import android.Manifest
import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.*
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.Query
import com.google.firebase.storage.FirebaseStorage
import com.inved.freezdge.R
import com.inved.freezdge.socialmedia.firebase.Post
import com.inved.freezdge.socialmedia.firebase.PostHelper
import com.inved.freezdge.socialmedia.firebase.User
import com.inved.freezdge.socialmedia.firebase.UserHelper
import com.inved.freezdge.socialmedia.view.PostsAdapter
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.Domain
import com.inved.freezdge.utils.LoaderListener
import com.inved.freezdge.utils.NetworkUtils
import kotlinx.android.synthetic.main.dialog_image.*
import kotlinx.android.synthetic.main.fragment_social_media.*
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.RuntimePermissions

@RuntimePermissions
class SocialMediaFragment : Fragment(), PostsAdapter.ClickListener, LoaderListener,ProfilDialog.ChangePhotoListener {

    private lateinit var mRecyclerPostsAdapter: PostsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var nestedScrollView: NestedScrollView
    private lateinit var addPhotoGallery: ImageView
    private lateinit var addPhotoCamera: ImageView
    private lateinit var addTipImage: ImageView
    private lateinit var photoProfile: ImageView
    private lateinit var addPhotoGalleryText: TextView
    private lateinit var addPhotoCameraText: TextView
    private lateinit var addTipText: TextView
    private lateinit var topDescription: TextView
    private var loader: FrameLayout? = null
    private var mSwipeRefreshLayout: SwipeRefreshLayout? = null
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
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mView: View = inflater.inflate(R.layout.fragment_social_media, container, false)
        recyclerView = mView.findViewById(R.id.recyclerview)
        addPhotoGallery = mView.findViewById(R.id.image_photo_post)
        addPhotoCamera = mView.findViewById(R.id.image_camera_post)
        addTipImage = mView.findViewById(R.id.image_tips_post)
        nestedScrollView = mView.findViewById(R.id.nested_scroll_view)
        addPhotoGalleryText = mView.findViewById(R.id.title_photo_post)
        addPhotoCameraText = mView.findViewById(R.id.title_camera_post)
        addTipText = mView.findViewById(R.id.title_tips_post)
        photoProfile = mView.findViewById(R.id.profile_image)
        topDescription = mView.findViewById(R.id.profile_activity_top_description)
        loader = mView.findViewById(R.id.animation_view_container)
        mSwipeRefreshLayout = mView.findViewById(R.id.swipeRefreshLayout)
        setHasOptionsMenu(true)
        showLoader()
        initButtons()
        initProfil()
        displayAllPosts()
        return mView
    }

    override fun onResume() {
        super.onResume()
        initProfil()
        displayAllPosts()
    }

    private fun initProfil() {

        UserHelper.getUser(FirebaseAuth.getInstance().currentUser?.uid)?.get()
            ?.addOnCompleteListener { task ->
                if (task.result != null) {
                    if (task.result!!.documents.isNotEmpty()) {
                        val user: User =
                            task.result!!.documents[0].toObject(User::class.java)!!
                        topDescription.text =
                            App.resource()
                                .getString(R.string.social_media_description, user.firstname)
                        //to show photo from Firebase storage or url. If photo is not from google, it's also from firebase
                        Domain.loadPhotoWithGlideCircleCropUrl(user.photoUrl, photoProfile)
                        hideLoader()
                    }
                }
            }?.addOnFailureListener {
                hideLoader()
            }
    }

    private fun initButtons() {
        addPhotoCamera.setOnClickListener {
            addPhotoCamera.startAnimation(Domain.animation())
            addPhotoCameraText.startAnimation(Domain.animation())
            onClickAddPhotoWithPermissionCheck(1, "")
        }
        addPhotoCameraText.setOnClickListener {
            addPhotoCamera.startAnimation(Domain.animation())
            addPhotoCameraText.startAnimation(Domain.animation())
            onClickAddPhotoWithPermissionCheck(1, "")
        }
        addPhotoGallery.setOnClickListener {
            addPhotoGallery.startAnimation(Domain.animation())
            addPhotoGalleryText.startAnimation(Domain.animation())
            onClickAddPhotoGalleryWithPermissionCheck()
        }
        addPhotoGalleryText.setOnClickListener {
            addPhotoGallery.startAnimation(Domain.animation())
            addPhotoGalleryText.startAnimation(Domain.animation())
            onClickAddPhotoGalleryWithPermissionCheck()
        }
        addTipImage.setOnClickListener {
            addTipImage.startAnimation(Domain.animation())
            addTipText.startAnimation(Domain.animation())
            onClickAddTips(0, "")
        }
        addTipText.setOnClickListener {
            addTipImage.startAnimation(Domain.animation())
            addTipText.startAnimation(Domain.animation())
            onClickAddTips(0, "")
        }
        photoProfile.setOnClickListener { onClickUpdateProfil() }
        mSwipeRefreshLayout!!.setOnRefreshListener {
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
        recyclerView.layoutManager = LinearLayoutManager(
            context,
            RecyclerView.VERTICAL,
            false
        )
        recyclerView.adapter = mRecyclerPostsAdapter
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


    private fun onClickUpdateProfil() {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        val previous = activity?.supportFragmentManager?.findFragmentByTag(ProfilDialog.TAG)
        if (previous != null) {
            transaction?.remove(previous)
        }
        transaction?.addToBackStack(null)

        val dialogFragment = ProfilDialog.newInstance("profil")
        ProfilDialog.setChangePhotoListener(this)
        if (transaction != null) {
            dialogFragment.show(transaction, ProfilDialog.TAG)
        }
    }


    override fun onRequestPermissionsResult(
        rc: Int,
        permissions: Array<out String>,
        results: IntArray
    ) {
        this.onRequestPermissionsResult(rc, results)
    }

    private fun launchAlertDialog(postId: String) {
        val builder = MaterialAlertDialogBuilder(activity)
        builder.setTitle(
            App.resource().getString(R.string.social_media_post_delete_title_dialog)
        )
        builder.setMessage(
            App.resource().getString(R.string.social_media_post_delete_message_dialog)
        )

        builder.setPositiveButton(App.resource().getString(R.string.Yes)) { _, _ ->
            PostHelper.deletePost(postId)
            Toast.makeText(
                App.applicationContext(),
                App.resource().getString(R.string.social_media_post_delete_confirmation_dialog),
                Toast.LENGTH_SHORT
            ).show()
        }

        builder.setNegativeButton(android.R.string.no) { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }

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
        val searchItem = menu.findItem(R.id.search_menu)
        searchItem.isVisible = false
        super.onPrepareOptionsMenu(menu)
    }

    override fun onDataChanged() {
        // 7 - Show TextView in case RecyclerView is empty
        if (mRecyclerPostsAdapter.itemCount == 0) {
            if (NetworkUtils.typeNetworkConnection(App.applicationContext()) != NetworkUtils.Companion.TypeConnection.NONE) {
                no_post_found.visibility = View.VISIBLE
            } else {
                no_post_found.visibility = View.VISIBLE
                no_post_found.text = getString(R.string.internet_connexion)
            }

        } else {
            no_post_found.visibility = View.GONE
        }
    }

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
        Log.d("debago","in onPhotoChangedInterface")
        initProfil()
    }


}