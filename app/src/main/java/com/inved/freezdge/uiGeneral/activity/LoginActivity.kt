package com.inved.freezdge.uiGeneral.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.GoogleAuthProvider
import com.inved.freezdge.R
import com.inved.freezdge.onboarding.OnboardingActivity
import com.inved.freezdge.onboarding.OnboardingActivity.Companion.PREF_NAME
import com.inved.freezdge.onboarding.OnboardingActivity.Companion.sharedPref
import com.inved.freezdge.socialmedia.firebase.UserHelper
import com.inved.freezdge.utils.Domain
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*


class LoginActivity: BaseActivity() {

    //FOR DATA
    private val RC_SIGN_IN: Int = 1
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var mGoogleSignInOptions: GoogleSignInOptions
    private var callbackManager: CallbackManager = CallbackManager.Factory.create()
    private val facebookLoginButton by lazy { findViewById<Button>(R.id.login_facebook_button) }
    override fun getLayoutContentViewID(): Int {
        return R.layout.activity_login
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureGoogleSignIn()
        facebookLoginButton.setOnClickListener{ onClickFacebookLoginButton() }
        login_google_button.setOnClickListener{ onClickGoogleLoginButton() }

    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        getFirebaseAuth()?.signInWithCredential(credential)?.addOnCompleteListener {
            if (it.isSuccessful) {
                isUserExistInFirebase()
                handleStartActivityOrOnboarding()
            } else {
                Toast.makeText(this, getString(R.string.google_sign_in), Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (isCurrentUserLogged()) {
           handleStartActivityOrOnboarding()
            finish()
        }
    }

    fun handleStartActivityOrOnboarding(){
        if (sharedPref.getBoolean(PREF_NAME, false)) {
            startActivity(MainActivity.getLaunchIntent(this))
        } else {
            startActivity(OnboardingActivity.getLaunchIntent(this))
        }
    }

    private fun isUserExistInFirebase(){
        UserHelper.getUser(getCurrentUser()?.uid)?.get()?.addOnCompleteListener { task ->
            if (task.result != null) {
                if (task.result!!.documents.isEmpty()) {
                    Log.d("debago","user not exist in firebase")
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
        callbackManager.onActivityResult(requestCode, resultCode, data)

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

    // --------------------
    // ACTIONS
    // --------------------

    private fun onClickFacebookLoginButton() {
        facebookLoginButton.startAnimation(Domain.animation())
            startFacebookSignInActivity()
    }

    private fun onClickGoogleLoginButton() {
        login_google_button.startAnimation(Domain.animation())
        startGoogleSignInActivity()
    }

    // --------------------
    // NAVIGATION
    // --------------------
    private fun startFacebookSignInActivity() {

        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email", "public_profile"))
        LoginManager.getInstance().registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                Log.d("debago", "facebook:onSuccess:$loginResult")
                loginResult?.accessToken?.let { handleFacebookAccessToken(it) }
            }

            override fun onCancel() {
                Log.d("debago", "facebook:onCancel")
                // ...
            }

            override fun onError(error: FacebookException) {
                Log.d("debago", "facebook:onError", error)
                // ...
            }
        })

    }

    private fun startGoogleSignInActivity() {
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

    private fun handleFacebookAccessToken(token: AccessToken) {
        Log.d("debago", "handleFacebookAccessToken:$token")

        val credential = FacebookAuthProvider.getCredential(token.token)
        getFirebaseAuth()?.signInWithCredential(credential)
            ?.addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("debago", "signInWithCredential:success")
                    isUserExistInFirebase()
                    handleStartActivityOrOnboarding()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("debago", "signInWithCredential:failure", task.exception)
                    Toast.makeText(this, getString(R.string.facebook_sign_in), Toast.LENGTH_LONG).show()
                }
            }
    }

}