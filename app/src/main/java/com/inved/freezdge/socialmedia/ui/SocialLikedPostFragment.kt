package com.inved.freezdge.socialmedia.ui

import android.Manifest
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.FirebaseAuth
import com.inved.freezdge.R
import com.inved.freezdge.databinding.FragmentSocialLikedPostBinding
import com.inved.freezdge.socialmedia.firebase.FavoritePostHelper
import com.inved.freezdge.socialmedia.firebase.Post
import com.inved.freezdge.socialmedia.firebase.PostHelper
import com.inved.freezdge.socialmedia.view.LikedPostItem
import com.inved.freezdge.socialmedia.view.PostsAdapter
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.NetworkUtils
import com.inved.freezdge.utils.eventbus.HandleBottomNavVisibilityEvent
import com.inved.freezdge.utils.eventbus.RefreshEvent
import com.inved.freezdge.utils.eventbus.SocialLikedPostDeleteEvent
import com.inved.freezdge.utils.eventbus.SocialLikedPostUpdateEvent
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.GenericItemAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.listeners.addClickListener
import kotlinx.android.synthetic.main.fragment_social_liked_post.*
import kotlinx.android.synthetic.main.fragment_social_liked_post.view.*
import kotlinx.android.synthetic.main.fragment_social_media.*
import kotlinx.android.synthetic.main.fragment_social_media.recyclerview
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.RuntimePermissions

@RuntimePermissions
class SocialLikedPostFragment : Fragment(), PostsAdapter.ClickListener {

    private lateinit var binding: FragmentSocialLikedPostBinding
    private lateinit var itemAdapter: ItemAdapter<GenericItem>
    private lateinit var fastAdapter: FastAdapter<GenericItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (!::binding.isInitialized) {
            binding = FragmentSocialLikedPostBinding.inflate(inflater, container, false)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        EventBus.getDefault().post(HandleBottomNavVisibilityEvent(false))
        setHasOptionsMenu(true)
        initRecyclerView()
        retrieveAllLikedPost()
    }

    override fun onResume() {
        super.onResume()
        EventBus.getDefault().register(this)
    }

    override fun onPause() {
        EventBus.getDefault().unregister(this)
        super.onPause()
    }


    private fun retrieveAllLikedPost() {
        FirebaseAuth.getInstance().currentUser?.uid?.let { it ->
            FavoritePostHelper.getAllFavoritePost(
                it
            )?.get()
                ?.addOnCompleteListener { task ->
                    if (task.result?.isEmpty==false) {
                        val listToSend:MutableList<String?> = mutableListOf()
                        val listIdLikedPost= task.result.let {results-> results?.documents }
                        listIdLikedPost?.forEach {likedPost->
                            listToSend.add(likedPost.getString("postId"))
                        }
                        displayAllLikedPost(listToSend)
                    }else{
                        displayEmptyView()
                    }
                }
                ?.addOnFailureListener { }
        }
    }

    private fun displayEmptyView() {
        itemAdapter.clear()
        binding.root.not_found.visibility = View.VISIBLE
        binding.root.not_found.text = getString(R.string.no_item_found_liked_post)
    }

    private fun displayAllLikedPost(listPostId:MutableList<String?>) {
        val items = mutableListOf<GenericItem>()

        listPostId.forEach { postId ->
            postId?.let {
                PostHelper.getPost(it)?.get()?.addOnCompleteListener { task ->
                    if (task.result != null) {
                        if (task.result?.documents?.isNotEmpty() == true) {
                            val post: Post? =
                                task.result!!.documents[0].toObject(Post::class.java)
                            items.add(LikedPostItem().apply {
                                this.post = post
                            })
                            fillRecyclerView(items)
                        }else{

                            FirebaseAuth.getInstance().currentUser?.uid?.let { it1 ->
                                FavoritePostHelper.deleteFavoritePost(
                                    it1,postId)
                            }
                        }
                    }
                }?.addOnFailureListener {it1->
                    Log.e(
                        "firebase",
                        "post not found ${it1.message}"
                    )
                }
            }
        }


    }

    private fun fillRecyclerView(data: MutableList<GenericItem>) {
        itemAdapter.clear()
        binding.root.not_found.visibility = View.GONE
        itemAdapter.add(data)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        val searchItem = menu.findItem(R.id.searchItem)
        searchItem.isVisible = false
        val clearIngredientItem = menu.findItem(R.id.clearIngredientItem)
        val likeItem = menu.findItem(R.id.likeItem)
        likeItem.isVisible = true
        clearIngredientItem.isVisible = false
        likeItem.setOnMenuItemClickListener {
            findNavController().navigateUp()
            //Todo debago navigate up on social media fragment
            true
        }
        super.onPrepareOptionsMenu(menu)
    }

    private fun initRecyclerView() {
        recyclerview.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerview.isNestedScrollingEnabled = false
        //   fastAdapter?.onClickListener = this
        itemAdapter = GenericItemAdapter()
        fastAdapter= FastAdapter.with(itemAdapter)
        recyclerview.adapter = fastAdapter

        fastAdapter.addClickListener({ vh: LikedPostItem.ViewHolder -> vh.postImage }) { _, pos: Int, _: FastAdapter<GenericItem>, item: GenericItem ->
            if (item is LikedPostItem) {
                onClickImageListener(item.post?.urlPhoto)
            }
        }

        fastAdapter.addClickListener({ vh: LikedPostItem.ViewHolder -> vh.moreButton }) { _, pos: Int, _: FastAdapter<GenericItem>, item: GenericItem ->
            if (item is LikedPostItem) {
                onClickImageListener(item.post?.urlPhoto)
            }
        }

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

    // to update UI when data changed in the firestore database
    override fun onDataChanged() {
        // 7 - Show TextView in case RecyclerView is empty
        if (itemAdapter.adapterItemCount == 0) {
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: SocialLikedPostUpdateEvent) {
        if (event.post.postType.equals(
                App.resource().getString(R.string.social_media_post_type_photo)
            )
        ) {
            event.post.postId?.let { it1 ->
                onClickListener(
                    3,
                    it1
                )
            }
        } else if (event.post.postType.equals(
                App.resource().getString(R.string.social_media_post_type_tips)
            )
        ) {
            event.post.postId?.let { it1 ->
                onClickListener(
                    2,
                    it1
                )
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: SocialLikedPostDeleteEvent) {
        event.post.postId?.let { it1 ->
            onClickListener(
                1,
                it1
            )
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: RefreshEvent) {
        GlobalScope.launch {
            delay(300)
            retrieveAllLikedPost()
        }
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

    override fun onRequestPermissionsResult(
        rc: Int,
        permissions: Array<out String>,
        results: IntArray
    ) {
        this.onRequestPermissionsResult(rc, results)
    }

}