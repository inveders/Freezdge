package com.inved.freezdge.socialmedia.view

import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.firebase.auth.FirebaseAuth
import com.inved.freezdge.R
import com.inved.freezdge.socialmedia.firebase.*
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.Domain
import com.inved.freezdge.utils.GlideUtils
import com.inved.freezdge.utils.eventbus.RefreshEvent
import com.inved.freezdge.utils.eventbus.SocialLikedPostDeleteEvent
import com.inved.freezdge.utils.eventbus.SocialLikedPostUpdateEvent
import com.like.LikeButton
import com.like.OnLikeListener
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import org.greenrobot.eventbus.EventBus
import java.util.*

class LikedPostItem : AbstractItem<LikedPostItem.ViewHolder>() {

    var post:Post?=null

    override val layoutRes: Int
        get() = R.layout.item_social_media

    override val type: Int
        get() = R.id.recipe_list_database_row_id

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(val view: View) : FastAdapter.ViewHolder<LikedPostItem>(view) {

        var domain= Domain()
        private var postTitle: TextView = view.findViewById(R.id.title)
        private var username: TextView = view.findViewById(R.id.username)
        private var postContent: TextView = view.findViewById(R.id.description)
        private var likeText: TextView = view.findViewById(R.id.like_number)
        private var profileImage: ImageView = view.findViewById(R.id.photoProfile)
        var postImage: ImageView = view.findViewById(R.id.image)
        var moreButton: ImageButton = view.findViewById(R.id.more_button)
        var likeButton: LikeButton = view.findViewById(R.id.like_number_image2)
        private var shimmer: ShimmerFrameLayout = view.findViewById(R.id.shimmer_view_container)

        override fun bindView(item: LikedPostItem, payloads: MutableList<Any>) {
            item.post?.let { updateWithPosts(it) }
        }


        override fun unbindView(item: LikedPostItem) {

        }

        private fun updateWithPosts(post: Post) {

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
                    EventBus.getDefault().post(RefreshEvent())
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

        //update post from popup menu
        private fun updatePost(post: Post){
            EventBus.getDefault().post(SocialLikedPostUpdateEvent(post))
        }

        //delete post from popup menu
        private fun deletePost(post: Post){
            EventBus.getDefault().post(SocialLikedPostDeleteEvent(post))
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

        private fun handleLikeButtonColor(currentPost: Post?, likeButton: LikeButton) {
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
        private fun handleLikeTextPhotoPost(currentPost: Post?, likeText: TextView, post: Post) {
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
        private fun handleLikeTextTipsPost(currentPost: Post?, likeText: TextView, post: Post) {
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
}