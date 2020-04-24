package com.inved.freezdge.ingredientslist.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.inved.freezdge.R
import com.inved.freezdge.uiGeneral.activity.BaseActivity
import com.inved.freezdge.uiGeneral.activity.MainActivity


class SearchIngredientsActivity : BaseActivity() {

    private val navController by lazy { findNavController(R.id.navHostIngredient) }
    private val bottomNavigationView by lazy { findViewById<BottomNavigationView>(R.id.activity_search_ingredient_bottom_navigation) }
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbar(navController)
        setUpNavigationBottom(navController)
        initToolbarBaseActivity(R.string.toolbar_search_ingredients)
    }

    //INITIALIZATION


    private fun initToolbar(navController: NavController){

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        setupActionBarWithNavController(this, navController)
        setupWithNavController(bottomNavigationView, navController)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("BACKPRESS", 1)
        startActivity(intent)
    }

    private fun setUpNavigationBottom(navController: NavController) {

        setupWithNavController(bottomNavigationView,navController)

        /*R.id.fragment_cream -> bottomNavigationView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCream))
        R.id.fragment_fruits_vegetables -> bottomNavigationView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorVegetables))
        R.id.fragment_epicerie -> bottomNavigationView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorEpicerie))
        R.id.fragment_fish -> bottomNavigationView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorFish))
        R.id.fragment_meat -> bottomNavigationView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorMeat))*/

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.search_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun getLayoutContentViewID(): Int {
        return R.layout.activity_search_ingredients
    }

}