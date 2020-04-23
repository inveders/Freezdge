package com.inved.freezdge.ingredientslist.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.airbnb.lottie.LottieAnimationView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.inved.freezdge.R
import com.inved.freezdge.recipes.ui.AllRecipesFragment
import com.inved.freezdge.uiGeneral.activity.BaseActivity
import com.inved.freezdge.uiGeneral.activity.MainActivity
import kotlinx.android.synthetic.main.activity_search_ingredients.*


class SearchIngredientsActivity : BaseActivity() {

    private var loader: LottieAnimationView? = null
    private var loaderContainer: FrameLayout? = null

    private val navController by lazy { findNavController(R.id.navHostIngredient) }
    private val bottomNavigationView by lazy { findViewById<BottomNavigationView>(R.id.activity_search_bottom_navigation) }
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbar(navController)
        setUpNavigationBottom(navController)
        loader=findViewById(R.id.animation_view)
        loaderContainer=findViewById(R.id.animation_view_container)
        initToolbarBaseActivity(R.string.toolbar_search_ingredients)
         showLoadingIndicator()

    }

    //INITIALIZATION


    fun initToolbar(navController: NavController){

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        setupActionBarWithNavController(this, navController)
        setupWithNavController(bottomNavigationView, navController)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        Log.d("debago", "in navigation up")
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("BACKPRESS", 1)
        startActivity(intent)
    }

    private fun setUpNavigationBottom(navController: NavController) {

        NavigationUI.setupWithNavController(bottomNavigationView,navController)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.search_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun getLayoutContentViewID(): Int {
        return R.layout.activity_search_ingredients
    }




    fun showLoadingIndicator() {
        AllRecipesFragment.loader?.post {
            AllRecipesFragment.loader!!.playAnimation()
            AllRecipesFragment.loaderContainer?.visibility = View.VISIBLE
        }
    }

    fun hideLoadingIndicator() {
        AllRecipesFragment.loader?.post {
            AllRecipesFragment.loader!!.pauseAnimation()
            AllRecipesFragment.loaderContainer?.visibility = View.GONE
        }
    }

    fun setUpNavigation() {

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment?
        NavigationUI.setupWithNavController(
            activity_search_bottom_navigation,
            navHostFragment!!.navController
        )
    }
}