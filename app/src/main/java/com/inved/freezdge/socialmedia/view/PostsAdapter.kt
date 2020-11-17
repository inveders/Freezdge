package com.inved.freezdge.socialmedia.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.inved.freezdge.R
import com.inved.freezdge.socialmedia.firebase.*
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.Domain
import com.inved.freezdge.utils.GlideUtils
import com.like.LikeButton
import com.like.OnLikeListener
import java.sql.Date
import java.util.*

class PostsAdapter(
    options: FirestoreRecyclerOptions<Post>,
    private val listener: ClickListener
) : FirestoreRecyclerAdapter<Post, PostsAdapter.PostViewHolder>(options) {

    interface ClickListener {
        fun onClickListener(value: Int, postId: String)
        fun onDataChanged()
        fun onClickImageListener(postImage: String?)
    }

    var domain=Domain()

    override fun onBindViewHolder(
        postViewHolder: PostViewHolder,
        position: Int,
        post: Post
    ) {
        postViewHolder.updateWithPosts(post, listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_social_media, parent, false)
        )
    }

    inner class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var postTitle: TextView = view.findViewById(R.id.title)
        private var username: TextView = view.findViewById(R.id.username)
        private var postContent: TextView = view.findViewById(R.id.description)
        private var likeText: TextView = view.findViewById(R.id.like_number)
        private var profileImage: ImageView = view.findViewById(R.id.photoProfile)
        private var postImage: ImageView = view.findViewById(R.id.image)
        private var moreButton: ImageButton = view.findViewById(R.id.more_button)
        private var likeButton: LikeButton = view.findViewById(R.id.like_number_image2)
        private var shimmer: ShimmerFrameLayout = view.findViewById(R.id.shimmer_view_container)

        fun updateWithPosts(post: Post, listener: ClickListener) {

            //post and user ui
            if (post.userUid.equals(FirebaseAuth.getInstance().currentUser?.uid)) {
                moreButton.visibility = View.VISIBLE
            } else {
                moreButton.visibility = View.INVISIBLE
            }

            //post and user information
            if (!post.titleAstuce.isNullOrEmpty()) {
                postTitle.text = post.titleAstuce
                postTitle.visibility = View.VISIBLE
            } else {
                postTitle.visibility = View.GONE
            }

            if (!post.descriptionAstuce.isNullOrEmpty()) {
                postContent.text = post.descriptionAstuce
                postContent.visibility = View.VISIBLE
                shimmer.stopShimmer()
                shimmer.hideShimmer()
            } else {
                postContent.visibility = View.GONE
            }

            if (!post.urlPhoto.isNullOrEmpty()) {
                postImage.visibility = View.VISIBLE
                GlideUtils.loadPhotoWithGlideUrl(post.urlPhoto, shimmer, postImage)
                postImage.setOnClickListener {
                    listener.onClickImageListener(post.urlPhoto)
                }
            } else {
                postImage.visibility = View.GONE
            }

            UserHelper.getUser(post.userUid)?.get()?.addOnCompleteListener { task ->
                if (task.result?.isEmpty==false) {
                    if (task.result?.documents?.isNotEmpty()==true) {
                        val user: User? =
                            task.result!!.documents[0].toObject(User::class.java)
                        username.text = user?.firstname
                        GlideUtils.loadPhotoWithGlideCircleCropUrl(user?.photoUrl, profileImage)
                    }
                }
            }?.addOnFailureListener {}

            post.postId?.let { it ->
                PostHelper.getPost(it)?.get()?.addOnCompleteListener { task ->
                    if (task.result?.isEmpty==false) {
                        if (task.result?.documents?.isNotEmpty()==true) {
                            val currentPost: Post? =
                                task.result!!.documents[0].toObject(Post::class.java)
                            handleLikeButtonColor(currentPost, likeButton)

                            if (currentPost?.postType.equals(
                                    App.resource().getString(R.string.social_media_post_type_photo)
                                )
                            ) {
                                handleLikeTextPhotoPost(currentPost, likeText, post)
                            } else if (currentPost?.postType.equals(
                                    App.resource().getString(R.string.social_media_post_type_tips)
                                )
                            ) {
                                handleLikeTextTipsPost(currentPost, likeText, post)
                            }
                        }
                    }
                }?.addOnFailureListener {
                    Log.e(
                        "firebase",
                        "Problem during the post show"
                    )
                }
            }

            //like button clicklistener
            likeButton.setOnLikeListener(object : OnLikeListener {
                override fun liked(likeButton: LikeButton) {
                    handlePostLikeNumberIncrease(post)
                }

                override fun unLiked(likeButton: LikeButton) {
                    handlePostLikeNumberDecrease(post)
                }
            })


            //delete button clicklistener
            moreButton.setOnClickListener {
                moreButton.startAnimation(domain.animation())

                val popup = PopupMenu(App.appContext, moreButton)
                //inflating menu from xml resource
                popup.inflate(R.menu.popup_menu_social_media)
                //adding click listener
                popup.setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.popupMenuUpdate -> {
                            updatePost(post)
                            true
                        }
                        R.id.popupMenuDelete -> {
                            deletePost(post)
                            true
                        }
                        else -> {
                           false
                        }
                    }
                }
                //displaying the popup
                popup.show()
            }

        }

    }

    override fun onDataChanged() {
        super.onDataChanged()
        this.listener.onDataChanged()
    }

    //update post from popup menu
    fun updatePost(post: Post){
        if (post.postType.equals(
                App.resource().getString(R.string.social_media_post_type_photo)
            )
        ) {
            post.postId?.let { it1 ->
                listener.onClickListener(
                    3,
                    it1
                )
            }
        } else if (post.postType.equals(
                App.resource().getString(R.string.social_media_post_type_tips)
            )
        ) {
            post.postId?.let { it1 ->
                listener.onClickListener(
                    2,
                    it1
                )
            }
        }
    }

    //delete post from popup menu
    fun deletePost(post: Post){
        post.postId?.let { it1 ->
            listener.onClickListener(
                1,
                it1
            )
        }
    }

    fun handlePostLikeNumberIncrease(post: Post) {
        //the post is not in my favorites, I increase the value in PostHelper, I add the post in my favorites
        post.postId?.let { it1 ->
            FirebaseAuth.getInstance().currentUser?.uid?.let { it2 ->
                FavoritePostHelper.createUserFavoritePost(
                    it2,
                    it1,
                    Calendar.getInstance().time
                )
            }
        }
        post.postId?.let { it ->
            PostHelper.getPost(it)?.get()?.addOnCompleteListener { task ->
                if (task.result?.isEmpty==false) {
                    if (task.result?.documents?.isNotEmpty()==true) {
                        val currentPost: Post? =
                            task.result!!.documents[0].toObject(Post::class.java)
                        val newValue: Int?
                        newValue = currentPost?.likeNumber?.plus(1)
                        PostHelper.updateLikeNumber(newValue, post.postId)
                       }
                }
            }
        }?.addOnFailureListener {}
    }

    fun handlePostLikeNumberDecrease(post: Post) {
        //The post is in my favorites, I decrease the value in PostHelper, I remove the post from my favorite

        post.postId?.let { it1 ->
            FirebaseAuth.getInstance().currentUser?.uid?.let { it2 ->
                FavoritePostHelper.deleteFavoritePost(
                    it2,
                    it1
                )
            }
        }

        post.postId?.let { it ->
            PostHelper.getPost(it)?.get()?.addOnCompleteListener { task ->
                if (task.result?.isEmpty==false) {
                    if (task.result?.documents?.isNotEmpty()==true) {
                        val currentPost: Post? =
                            task.result!!.documents[0].toObject(Post::class.java)
                        val newValue: Int?
                        newValue = if (currentPost?.likeNumber != 0) {
                            currentPost?.likeNumber?.minus(1)
                        } else {
                            0
                        }
                        PostHelper.updateLikeNumber(newValue, post.postId)
                      }
                }
            }
        }?.addOnFailureListener { }
    }

    fun handleLikeButtonColor(currentPost: Post?, likeButton: LikeButton) {
        //Change like button color according to value of like
        FavoritePostHelper.isThisPostIsFavorite(
            FirebaseAuth.getInstance().currentUser?.uid,
            currentPost?.postId
        )?.get()
            ?.addOnCompleteListener { task ->
                if (task.result?.isEmpty==false) {
                    if (task.result?.documents?.isNotEmpty()!!) {
                        //The post is in my favorites
                        likeButton.isLiked = true
                    }
                }else{
                    likeButton.isLiked = false
                }
            }
            ?.addOnFailureListener { }
    }

    // handle the text a person found it great
    fun handleLikeTextPhotoPost(currentPost: Post?, likeText: TextView, post: Post) {
        when (currentPost?.likeNumber) {
            0 -> {
                likeText.visibility = View.GONE
            }
            1 -> {
                FavoritePostHelper.isThisPostIsFavorite(
                    FirebaseAuth.getInstance().currentUser?.uid,
                    post.postId
                )?.get()
                    ?.addOnCompleteListener { task ->
                        if (task.result?.isEmpty == false) {
                            if (task.result?.documents?.isNotEmpty() == true) {
                                //The post is in my favorites
                                likeText.visibility = View.VISIBLE
                                likeText.text = App.resource().getString(
                                    R.string.social_media_like_number_photo_one_person_you
                                )
                            }
                        } else {
                            //the post is not in my favorites, I increase the value in PostHelper, I add the post in my favorites
                            likeText.visibility = View.VISIBLE
                            likeText.text = App.resource().getString(
                                R.string.social_media_like_number_photo_one_person,
                                currentPost.likeNumber
                            )
                        }
                    }
                    ?.addOnFailureListener { }
            }
            else -> {
                FavoritePostHelper.isThisPostIsFavorite(
                    FirebaseAuth.getInstance().currentUser?.uid,
                    post.postId
                )?.get()
                    ?.addOnCompleteListener { task ->
                        if (task.result?.isEmpty==false) {
                            if (task.result?.documents?.isNotEmpty()==true) {
                                //The post is in my favorites
                                likeText.visibility = View.VISIBLE
                                likeText.text = App.resource().getString(
                                    R.string.social_media_like_number_photo_you_and_other,
                                    currentPost?.likeNumber?.minus(1)
                                )
                            }
                        }else {
                            //the post is not in my favorites, I increase the value in PostHelper, I add the post in my favorites
                            likeText.visibility = View.VISIBLE
                            likeText.text = App.resource().getString(
                                R.string.social_media_like_number_photo,
                                currentPost?.likeNumber
                            )
                        }
                    }
                    ?.addOnFailureListener { }
            }
        }
    }

    // handle the text a person found it useful
    fun handleLikeTextTipsPost(currentPost: Post?, likeText: TextView, post: Post) {
        when (currentPost?.likeNumber) {
            0 -> {
                likeText.visibility = View.GONE
            }
            1 -> {

                FavoritePostHelper.isThisPostIsFavorite(
                    FirebaseAuth.getInstance().currentUser?.uid,
                    post.postId
                )?.get()
                    ?.addOnCompleteListener { task ->
                        if (task.result?.isEmpty == false) {
                            if (task.result?.documents?.isNotEmpty() == true) {
                                //The post is in my favorites
                                likeText.visibility = View.VISIBLE
                                likeText.text = App.resource().getString(
                                    R.string.social_media_like_number_tips_one_person_you
                                )
                            }
                        } else {
                            //the post is not in my favorites, I increase the value in PostHelper, I add the post in my favorites
                            likeText.visibility = View.VISIBLE
                            likeText.text = App.resource().getString(
                                R.string.social_media_like_number_tips_one_person,
                                currentPost.likeNumber
                            )

                        }
                    }
                    ?.addOnFailureListener { }

            }
            else -> {

                FavoritePostHelper.isThisPostIsFavorite(
                    FirebaseAuth.getInstance().currentUser?.uid,
                    post.postId
                )?.get()
                    ?.addOnCompleteListener { task ->
                        if (task.result?.isEmpty==false) {
                            if (task.result?.documents?.isNotEmpty()==true) {
                                //The post is in my favorites
                                likeText.visibility = View.VISIBLE
                                likeText.text = App.resource().getString(
                                    R.string.social_media_like_number_tips_you_and_other,
                                    currentPost?.likeNumber?.minus(1)
                                )
                            }
                        }else {
                            //the post is not in my favorites, I increase the value in PostHelper, I add the post in my favorites
                            likeText.visibility = View.VISIBLE
                            likeText.text = App.resource().getString(
                                R.string.social_media_like_number_tips,
                                currentPost?.likeNumber
                            )

                        }
                    }
                    ?.addOnFailureListener { }
            }
        }
    }

}


