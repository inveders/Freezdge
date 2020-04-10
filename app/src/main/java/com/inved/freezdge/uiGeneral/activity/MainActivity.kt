package com.inved.freezdge.uiGeneral.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.inved.freezdge.R

class MainActivity : BaseActivity() {

    private val navController by lazy { findNavController(R.id.navHost) }
    private val bottomNavigationView by lazy { findViewById<BottomNavigationView>(R.id.activity_main_bottom_navigation) }
    private lateinit var toolbar:Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initToolbar(navController)
        setUpNavigationBottom(navController)

    }

    override fun getLayoutContentViewID(): Int {
        return R.layout.activity_main
    }

    //INITIALIZATION


    fun initToolbar(navController: NavController){

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.my_ingredients_list_fragment,
                R.id.my_recipes_fragment,
                R.id.all_recipes_fragment
            )
        )

        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration)

    }

    private fun setUpNavigationBottom(navController: NavController) {

        NavigationUI.setupWithNavController(bottomNavigationView,navController)
        bottomNavigationView.menu.findItem(R.id.action_to_my_recipes_fragment).isChecked = true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }



}
