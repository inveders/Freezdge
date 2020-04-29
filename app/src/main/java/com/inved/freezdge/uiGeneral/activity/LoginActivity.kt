package com.inved.freezdge.uiGeneral.activity

import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.GoogleAuthProvider
import com.inved.freezdge.R
import com.inved.freezdge.socialmedia.firebase.UserHelper
import com.inved.freezdge.utils.Domain
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity: BaseActivity() {

    //FOR DATA
    val RC_SIGN_IN: Int = 1
    lateinit var mGoogleSignInClient: GoogleSignInClient
    lateinit var mGoogleSignInOptions: GoogleSignInOptions

    override fun getLayoutContentViewID(): Int {
        return R.layout.activity_login
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Progress bar
        progressBar.indeterminateDrawable.setColorFilter(
            getResources().getColor(R.color.colorPrimary),
            PorterDuff.Mode.MULTIPLY
        )

        configureGoogleSignIn()
        login_facebook_button.setOnClickListener{ onClickFacebookLoginButton() }
        login_google_button.setOnClickListener{ onClickGoogleLoginButton() }
    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        getFirebaseAuth()?.signInWithCredential(credential)?.addOnCompleteListener {
            if (it.isSuccessful) {
                Log.d("debago","in firebase auth with google")
                isUserExistInFirebase()
                startActivity(MainActivity.getLaunchIntent(this))
            } else {
                Toast.makeText(this, "Google sign in failed:(", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val user = getCurrentUser()
        if (user != null) {
            startActivity(MainActivity.getLaunchIntent(this))
            finish()
        }
    }

    private fun isUserExistInFirebase(){
        UserHelper.getUser(getCurrentUser()?.uid)?.get()?.addOnCompleteListener { task ->
            if (task.result != null) {
                if (task.result!!.documents.isEmpty()) {
                    getCurrentUser()?.uid?.let { UserHelper.createUser(it,getCurrentUser()?.displayName,"",getCurrentUser()?.photoUrl.toString()) }
                }
            }
        }?.addOnFailureListener { e ->
            Log.e(
                "debago",
                "Problem during the user creation"
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
          //  val response: IdpResponse = IdpResponse.fromResultIntent(data)

            if (resultCode == RESULT_OK) { // SUCCESS
                val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
                try {
                    val account = task.getResult(ApiException::class.java)
                    if (account != null) {
                        firebaseAuthWithGoogle(account)
                    }
                    // SUCCESS
                    showSnackBar(this.coordinatorLayout, getString(R.string.connection_succeed))
                } catch (e: ApiException) {
                    Toast.makeText(this, "Google sign in failed:(", Toast.LENGTH_LONG).show()
                }
            } /*else { // ERRORS
                if (response == null) {
                    showSnackBar(
                        this.coordinatorLayout,
                        getString(R.string.error_authentication_canceled)
                    )
                } else if (Objects.requireNonNull(response.getError())
                        .getErrorCode() !== ErrorCodes.NO_NETWORK
                ) {
                    if (response.getError().getErrorCode() === ErrorCodes.UNKNOWN_ERROR) {
                        showSnackBar(
                            this.coordinatorLayout,
                            getString(R.string.error_unknown_error)
                        )
                    }
                } else {
                    showSnackBar(this.coordinatorLayout, getString(R.string.error_no_internet))
                }
            }*/



        }
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    // --------------------
    // ACTIONS
    // --------------------

    private fun onClickFacebookLoginButton() {
        login_facebook_button.startAnimation(Domain.animation())
          //  startFacebookSignInActivity()
    }

    private fun onClickGoogleLoginButton() {
        login_google_button.startAnimation(Domain.animation())
        startGoogleSignInActivity()
    }

    // --------------------
    // NAVIGATION
    // --------------------
  /*  private fun startFacebookSignInActivity() {
        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setTheme(R.style.LoginTheme)
                .setAvailableProviders(listOf(FacebookBuilder().build())) // FACEBOOK
                .setIsSmartLockEnabled(false, true)
                .setLogo(R.drawable.ic_logo_go4lunch)
                .build(),
            RCSIGNIN
        )
    }*/

    private fun startGoogleSignInActivity() {
       /* startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setTheme(R.style.LoginTheme)
                .setAvailableProviders(listOf(GoogleBuilder().build())) //GOOGLE
                .setIsSmartLockEnabled(false, true)
                .setLogo(R.drawable.ic_logo_go4lunch)
                .build(),
            RCSIGNIN
        )*/

        val signInIntent: Intent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)

    }


    private fun configureGoogleSignIn() {
        mGoogleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, mGoogleSignInOptions)
    }

    // --------------------
    // UI
    // --------------------
    private fun showSnackBar(
        coordinatorLayout: CoordinatorLayout?,
        message: String
    ) {
        Snackbar.make(coordinatorLayout!!, message, Snackbar.LENGTH_SHORT).show()
    }

    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, LoginActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

}