package com.inved.freezdge.uiGeneral.activity

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.inved.freezdge.R
import com.inved.freezdge.R.id
import com.inved.freezdge.socialmedia.firebase.User
import com.inved.freezdge.socialmedia.firebase.UserHelper
import com.inved.freezdge.uiGeneral.fragment.BaseFragment
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.LoaderListener


class MainActivity : BaseActivity(), LoaderListener,NavigationView.OnNavigationItemSelectedListener {

    private val navController by lazy { findNavController(id.navHost) }
    private val bottomNavigationView by lazy { findViewById<BottomNavigationView>(id.activity_main_bottom_navigation) }
    private lateinit var toolbar: Toolbar
    private var loader: FrameLayout? = null
    private lateinit var appBarConfiguration: AppBarConfiguration

    //NavigationDrawer
    private var drawerLayout: DrawerLayout? = null
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val id: Int = intent.getIntExtra("BACKPRESS", 0)
        drawerLayout = findViewById(R.id.activity_main_drawer_layout)

        navigationView = findViewById(R.id.activity_main_nav_view)
        navigationView.menu.findItem(R.id.menu_logout).setOnMenuItemClickListener {
            signOut()
            true
        }
        initProfil()

        initToolbar(navController)
        loader=findViewById(R.id.animation_view_container)
        setUpNavigationBottom(navController, id)

    }

    private fun initProfil() {

        UserHelper.getUser(FirebaseAuth.getInstance().currentUser?.uid)?.get()
            ?.addOnCompleteListener { task ->
                if (task.result != null) {
                    if (task.result!!.documents.isNotEmpty()) {

                        val imageHeader: ImageView = navigationView.findViewById(id.nav_header_profile_image)
                        val firstnameHeader:TextView = navigationView.findViewById(id.nav_header_FirstName)

                        val user: User =
                            task.result!!.documents[0].toObject(User::class.java)!!

                        firstnameHeader.text = user.firstname

                        //to upload a photo on Firebase storage
                        if (user.photoUrl.isNullOrEmpty()) {
                            imageHeader.let {
                                this.let { it1 ->
                                    Glide.with(it1)
                                        .load(user.photoUrl)
                                        .apply(RequestOptions.circleCropTransform())
                                        .listener(object : RequestListener<Drawable?> {
                                            override fun onLoadFailed(
                                                e: GlideException?,
                                                model: Any,
                                                target: Target<Drawable?>,
                                                isFirstResource: Boolean
                                            ): Boolean {
                                                Log.e("debago", "Exception is : $e")
                                                return false
                                            }

                                            override fun onResourceReady(
                                                resource: Drawable?,
                                                model: Any,
                                                target: Target<Drawable?>,
                                                dataSource: DataSource,
                                                isFirstResource: Boolean
                                            ): Boolean {
                                                hideLoader()
                                                return false
                                            }
                                        })
                                        .placeholder(R.drawable.ic_anon_user_48dp)
                                        .into(it)
                                }
                            }
                        }

                    }
                }
            }?.addOnFailureListener {
                hideLoader()
                Log.e(
                    "debago",
                    "Problem during the user creation"

                )
            }
    }


    override fun onAttachFragment(fragment: Fragment) {
        BaseFragment.setLoaderListener(this)

    }

    override fun getLayoutContentViewID(): Int {
        return R.layout.activity_main
    }

    //INITIALIZATION
    private fun initToolbar(navController: NavController) {

        toolbar = findViewById(id.toolbar)
        setSupportActionBar(toolbar)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                id.my_ingredients_list_fragment,
                id.my_recipes_fragment,
                id.all_recipes_fragment,
                id.social_media_fragment
            ),drawerLayout

        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navigationView.setupWithNavController(navController)
    }

    override fun onBackPressed() {
        if (drawerLayout?.isDrawerOpen(GravityCompat.START)!!) {
            drawerLayout?.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun setUpNavigationBottom(navController: NavController, id: Int) {
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
        if (id == 1) {
            bottomNavigationView.menu.findItem(R.id.action_to_all_recipes_fragment).isChecked = true
            navController.navigate(R.id.action_to_all_recipes_fragment)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.search_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
         if(item.itemId== id.menu_logout){
            signOut()
        }
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    private fun signOut() {

            val builder = MaterialAlertDialogBuilder(this)
            builder.setTitle(
                App.resource().getString(R.string.button_logout)
            )
            builder.setMessage(
                App.resource().getString(R.string.button_logout_message_dialog)
            )

            builder.setPositiveButton(App.resource().getString(R.string.Yes)) { _, _ ->
                startActivity(LoginActivity.getLaunchIntent(this))
                FirebaseAuth.getInstance().signOut()
            }

            builder.setNegativeButton(android.R.string.no) { dialog, _ ->
                dialog.dismiss()
            }

            builder.show()

    }

    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        //TODO where do we use it?
        var currentPage:Int?=0
    }

    override fun showLoader() {
        loader?.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        loader?.visibility = View.GONE
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }

    //TODO see if we need it
   /* override fun onNavigationItemSelected(item: MenuItem): Boolean {
         if(item.itemId==id.menu_logout){
          signOut()
      }
        return true
    }*/

}
