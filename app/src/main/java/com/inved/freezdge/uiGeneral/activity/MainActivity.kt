package com.inved.freezdge.uiGeneral.activity

import android.content.Context
import android.content.Intent
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
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.inved.freezdge.R
import com.inved.freezdge.R.id
import com.inved.freezdge.onboarding.OnboardingActivity
import com.inved.freezdge.socialmedia.firebase.User
import com.inved.freezdge.socialmedia.firebase.UserHelper
import com.inved.freezdge.uiGeneral.fragment.BaseFragment
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.GlideUtils
import com.inved.freezdge.utils.LoaderListener


class MainActivity : BaseActivity(), LoaderListener {

    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }

    }

    private val navController by lazy { findNavController(id.navHost) }
    private val bottomNavigationView by lazy { findViewById<BottomNavigationView>(id.activity_main_bottom_navigation) }
    private lateinit var toolbar: Toolbar
    private var loader: FrameLayout? = null
    private lateinit var appBarConfiguration: AppBarConfiguration
    //NavigationDrawer
    private val drawerLayout by lazy { findViewById<DrawerLayout>(id.activity_main_drawer_layout)}
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val id: Int = intent.getIntExtra("BACKPRESS", 0)

        initNavigationView()
        initProfil()
        initToolbar(navController)
        loader=findViewById(R.id.loader)
        setUpNavigationBottom(navController, id)
        val drawerListener = CustomDrawer()
        drawerLayout?.addDrawerListener(drawerListener)

    }

    //link in the navigation drawer
    private fun initNavigationView(){
        navigationView = findViewById(id.activity_main_nav_view)
        navigationView.menu.findItem(id.menu_logout).setOnMenuItemClickListener {
            signOut()
            true
        }
        navigationView.menu.findItem(id.menu_info).setOnMenuItemClickListener {
            startActivity(Intent(this, OnboardingActivity::class.java))
            true
        }
    }

    // retrieve user information to show in the navigation drawer
    private fun initProfil() {
        UserHelper.getUser(FirebaseAuth.getInstance().currentUser?.uid)?.get()
            ?.addOnCompleteListener { task ->
                if (task.result != null) {
                    if (task.result?.documents?.isNotEmpty()==true) {
                        val imageHeader: ImageView = navigationView.findViewById(id.nav_header_profile_image)
                        val firstnameHeader:TextView = navigationView.findViewById(id.nav_header_FirstName)
                        val user: User? =
                            task.result!!.documents[0].toObject(User::class.java)
                        firstnameHeader.text = user?.firstname
                        //to show a photo from Firebase storage
                        GlideUtils.loadPhotoWithGlideCircleCropUrl(user?.photoUrl, imageHeader)
                        hideLoader()
                    }
                }
            }?.addOnFailureListener {
                hideLoader()
                Log.e(
                    "firebase",
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
                id.all_recipes_fragment,
                id.my_recipes_fragment,
                id.social_media_fragment
            ),drawerLayout

        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navigationView.setupWithNavController(navController)
    }

    override fun onBackPressed() {
        if (drawerLayout?.isDrawerOpen(GravityCompat.START)==true) {
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
        if (id == 2) {
            bottomNavigationView.menu.findItem(R.id.action_to_my_recipes_fragment).isChecked = true
            navController.navigate(R.id.my_recipes_fragment)
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

    // launch alert dialog before the user sign out
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

    override fun showLoader() {
        loader?.visibility = View.VISIBLE
        bottomNavigationView.isClickable=false
        bottomNavigationView.isEnabled=false
    }

    override fun hideLoader() {
        loader?.visibility = View.GONE
        bottomNavigationView.isClickable=true
        bottomNavigationView.isEnabled=true
    }

    inner class CustomDrawer : DrawerLayout.DrawerListener{

        override fun onDrawerStateChanged(newState: Int) {
        }

        override fun onDrawerSlide(drawerView: View, slideOffset: Float) {

        }

        override fun onDrawerClosed(drawerView: View) {

        }

        override fun onDrawerOpened(drawerView: View) {
           // refresh profil on drawer open in case of update
            initProfil()
        }
    }



}
