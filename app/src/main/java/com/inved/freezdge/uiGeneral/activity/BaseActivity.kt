package com.inved.freezdge.uiGeneral.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.inved.freezdge.R
import com.inved.freezdge.injection.Injection
import com.inved.freezdge.recipes.viewmodel.RecipeViewModel
import com.inved.freezdge.utils.App


abstract class BaseActivity:AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    lateinit var recipeViewModel: RecipeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutContentViewID())
        initViewModel()
    }

    protected abstract fun getLayoutContentViewID(): Int

    protected fun initToolbarBaseActivity(id:Int){
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(id)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    //INITIALIZATION
    private fun initViewModel() {
        val viewModelFactory = Injection.providesViewModelFactory(App.ObjectBox.boxStore)
        recipeViewModel = ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(RecipeViewModel::class.java)
    }

    // --------------------
    // UTILS
    // --------------------
    protected open fun getCurrentUser(): FirebaseUser? {
        return FirebaseAuth.getInstance().currentUser
    }

    protected open fun getFirebaseAuth(): FirebaseAuth? {
        return FirebaseAuth.getInstance()
    }

    protected open fun isCurrentUserLogged(): Boolean {
        return getCurrentUser() != null
    }
}