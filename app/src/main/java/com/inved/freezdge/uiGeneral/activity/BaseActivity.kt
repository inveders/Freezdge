package com.inved.freezdge.uiGeneral.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.inved.freezdge.R
import com.inved.freezdge.recipes.viewmodel.RecipeModel


abstract class BaseActivity:AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    //Viewmodel
    lateinit var recipeModel: RecipeModel

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
        recipeModel = ViewModelProviders.of(this).get(RecipeModel::class.java)

    }

    // --------------------
    // ERROR HANDLER
    // --------------------
    protected open fun onFailureListener(): OnFailureListener? {
        return OnFailureListener { e: Exception? ->
            Toast.makeText(
                applicationContext,
                getString(R.string.error_unknown_error),
                Toast.LENGTH_LONG
            ).show()
        }
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