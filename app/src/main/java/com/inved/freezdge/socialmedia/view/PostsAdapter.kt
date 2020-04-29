package com.inved.freezdge.socialmedia.view

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.facebook.shimmer.ShimmerFrameLayout
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.inved.freezdge.R
import com.inved.freezdge.socialmedia.firebase.*
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.GlideApp

class PostsAdapter(
    options: FirestoreRecyclerOptions<Post?>,
    private val listener: ClickListener
) : FirestoreRecyclerAdapter<Post, PostsAdapter.PostViewHolder>(options) {

    interface ClickListener {
        fun onClickListener(value: Int, postId: String)
        fun onDataChanged()
    }

    //FOR DATA
    private val glide: RequestManager? = null

    override fun onBindViewHolder(
        postViewHolder: PostViewHolder,
        position: Int,
        post: Post
    ) {
        postViewHolder.updateWithPosts(post, glide, listener)
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
        private var profileImage: ImageView = view.findViewById(R.id.profile_image)
        private var postImage: ImageView = view.findViewById(R.id.image)
        private var deleteButton: ImageView = view.findViewById(R.id.delete_button)
        private var updateButton: ImageView = view.findViewById(R.id.update_button)
        private var likeButton: ImageView = view.findViewById(R.id.like_number_image)
        private var shimmer: ShimmerFrameLayout = view.findViewById(R.id.shimmer_view_container)
        fun updateWithPosts(post: Post, glide: RequestManager?, listener: ClickListener) {

            Log.d("debago","in update post")
            if (post.userUid.equals(FirebaseAuth.getInstance().currentUser?.uid)) {
                deleteButton.visibility = View.VISIBLE
                updateButton.visibility = View.VISIBLE
            } else {
                deleteButton.visibility = View.INVISIBLE
                updateButton.visibility = View.INVISIBLE
            }

            if (post.titleAstuce != null) {
                postTitle.text = post.titleAstuce
                postTitle.visibility = View.VISIBLE
            } else {
                postTitle.visibility = View.GONE
            }

            if (post.descriptionAstuce != null) {
                postContent.text = post.descriptionAstuce
                postContent.visibility = View.VISIBLE
            } else {
                postContent.visibility = View.GONE
            }

            if (post.urlPhoto != null) {
                postImage.visibility = View.VISIBLE
                GlideApp.with(App.applicationContext())
                    .load(post.urlPhoto)
                    .apply(RequestOptions.centerCropTransform())
                    .into(postImage)
            } else {
                postImage.visibility = View.GONE
            }

            UserHelper.getUser(post.userUid)?.get()?.addOnCompleteListener { task ->
                if (task.result != null) {
                    if (task.result!!.documents.isNotEmpty()) {
                        val user: User =
                            task.result!!.documents[0].toObject(User::class.java)!!

                        username.text = user.firstname

                        if (user.photoUrl != null) {
                            GlideApp.with(App.applicationContext())
                                .load(user.photoUrl)
                                .apply(RequestOptions.circleCropTransform())
                                .into(profileImage)
                        } else {
                            glide?.load(R.drawable.ic_anon_user_48dp)
                                ?.apply(RequestOptions.circleCropTransform())
                                ?.into(profileImage)
                        }


                    }
                }
            }?.addOnFailureListener {
                Log.e(
                    "debago",
                    "Problem during the user post check"
                )
            }

            post.postId?.let { it ->
                PostHelper.getPost(it)?.get()?.addOnCompleteListener { task ->
                    if (task.result != null) {
                        if (task.result!!.documents.isNotEmpty()) {
                            val currentPost: Post =
                                task.result!!.documents[0].toObject(Post::class.java)!!
                            shimmer.stopShimmer()
                            shimmer.hideShimmer()
                            //Change like button color according to value of like
                            if (currentPost.likeNumber != 0) {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                    likeButton.backgroundTintList =
                                        ColorStateList.valueOf(Color.parseColor("#c56000"))
                                } else {
                                    val drawable: Drawable? =
                                        ContextCompat.getDrawable(
                                            App.applicationContext(),
                                            R.drawable.ic_like_enable
                                        )?.let {
                                            DrawableCompat.wrap(it)
                                        }

                                    // We can now set a tint
                                    drawable?.let { DrawableCompat.setTint(it, Color.BLUE) }
                                    // ...or a tint list
                                    drawable?.let {
                                        DrawableCompat.setTintList(
                                            it,
                                            ColorStateList.valueOf(Color.parseColor("#c56000"))
                                        )
                                    }
                                    // ...and a different tint mode
                                    drawable?.let {
                                        DrawableCompat.setTintMode(
                                            it,
                                            PorterDuff.Mode.SRC_OVER
                                        )
                                    }
                                }

                            }

                            if (currentPost.postType.equals(
                                    App.resource().getString(R.string.social_media_post_type_photo)
                                )
                            ) {
                                when (currentPost.likeNumber) {
                                    0 -> {
                                        likeText.visibility = View.GONE
                                    }
                                    1 -> {
                                        likeText.text = App.resource().getString(
                                            R.string.social_media_like_number_photo_one_person,
                                            currentPost.likeNumber
                                        )
                                    }
                                    else -> {
                                        likeText.text = App.resource().getString(
                                            R.string.social_media_like_number_photo,
                                            currentPost.likeNumber
                                        )
                                    }
                                }
                            } else if (currentPost.postType.equals(
                                    App.resource().getString(R.string.social_media_post_type_tips)
                                )
                            ) {
                                when (currentPost.likeNumber) {
                                    0 -> {
                                        likeText.visibility = View.GONE
                                    }
                                    1 -> {
                                        likeText.text = App.resource().getString(
                                            R.string.social_media_like_number_tips_one_person,
                                            currentPost.likeNumber
                                        )
                                    }
                                    else -> {
                                        likeText.text = App.resource().getString(
                                            R.string.social_media_like_number_tips,
                                            currentPost.likeNumber
                                        )
                                    }
                                }
                            }
                        }
                    }
                }?.addOnFailureListener {
                    Log.e(
                        "debago",
                        "Problem during the user post check"
                    )
                }
            }

            likeButton.setOnClickListener {

                FavoritePostHelper.isThisPostIsFavorite(
                    FirebaseAuth.getInstance().currentUser?.uid,
                    post.postId
                )?.get()
                    ?.addOnCompleteListener { task ->
                        if (task.result != null) {
                            if (task.result!!.documents.isNotEmpty()) {
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
                                        if (task.result != null) {
                                            if (task.result!!.documents.isNotEmpty()) {
                                                val currentPost: Post =
                                                    task.result!!.documents[0].toObject(Post::class.java)!!
                                                val newValue: Int?
                                                newValue = if (currentPost.likeNumber != 0) {
                                                    currentPost.likeNumber?.minus(1)
                                                } else {
                                                    0
                                                }
                                                PostHelper.updateLikeNumber(newValue, post.postId!!)
                                            }
                                        }
                                    }
                                }?.addOnFailureListener { }
                            } else {

                                //the post is not in my favorites, I increase the value in PostHelper, I add the post in my favorites
                                post.postId?.let { it1 ->
                                    FirebaseAuth.getInstance().currentUser?.uid?.let { it2 ->
                                        FavoritePostHelper.createUserFavoritePost(
                                            it2,
                                            it1
                                        )
                                    }
                                }
                                post.postId?.let { it ->
                                    PostHelper.getPost(it)?.get()?.addOnCompleteListener { task ->
                                        if (task.result != null) {
                                            if (task.result!!.documents.isNotEmpty()) {
                                                val currentPost: Post =
                                                    task.result!!.documents[0].toObject(Post::class.java)!!
                                                val newValue: Int?
                                                newValue = currentPost.likeNumber?.plus(1)
                                                PostHelper.updateLikeNumber(newValue, post.postId!!)
                                            }
                                        }
                                    }
                                }?.addOnFailureListener {
                                    Log.e(
                                        "debago",
                                        "Problem during the like number decrease"
                                    )
                                }

                            }
                        }


                    }

                    ?.addOnFailureListener { }
            }

            updateButton.setOnClickListener {

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
            deleteButton.setOnClickListener {
                post.postId?.let { it1 ->
                    listener.onClickListener(
                        1,
                        it1
                    )
                }
            }
        }

    }

    override fun onDataChanged() {
        super.onDataChanged()
        this.listener.onDataChanged()
    }

}


