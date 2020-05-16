package com.inved.freezdge.uiGeneral.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.GoogleAuthProvider
import com.inved.freezdge.R
import com.inved.freezdge.onboarding.OnboardingActivity
import com.inved.freezdge.onboarding.OnboardingActivity.Companion.PREF_NAME
import com.inved.freezdge.onboarding.OnboardingActivity.Companion.sharedPref
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.Domain
import com.inved.freezdge.utils.LoginUtils
import com.inved.freezdge.utils.NetworkUtils
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : BaseActivity() {

    //FOR DATA
    var domain = Domain()
    private val RC_SIGN_IN: Int = 1
    val loginUtils = LoginUtils()
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var mGoogleSignInOptions: GoogleSignInOptions
    private var callbackManager: CallbackManager = CallbackManager.Factory.create()
    override fun getLayoutContentViewID(): Int {
        return R.layout.activity_login
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureGoogleSignIn()

        login_facebook_button.setOnClickListener {
            if (!NetworkUtils.isNetworkAvailable(App.applicationContext())) {
                loginUtils.showSnackBar(
                    this.coordinatorLayout,
                    getString(R.string.error_no_internet)
                )
            } else {
                onClickFacebookLoginButton()
            }
        }
        login_google_button.setOnClickListener {
            if (!NetworkUtils.isNetworkAvailable(App.applicationContext())) {
                loginUtils.showSnackBar(
                    this.coordinatorLayout,
                    getString(R.string.error_no_internet)
                )
            } else {
                onClickGoogleLoginButton()
            }
        }

    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        getFirebaseAuth()?.signInWithCredential(credential)?.addOnCompleteListener {
            if (it.isSuccessful) {
                loginUtils.isUserExistInFirebase()
                handleStartActivityOrOnboarding()
            } else {
                loginUtils.showSnackBar(this.coordinatorLayout, getString(R.string.google_sign_in))
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

    private fun handleStartActivityOrOnboarding() {
        if (sharedPref.getBoolean(PREF_NAME, false)) {
            startActivity(MainActivity.getLaunchIntent(this))
        } else {
            startActivity(OnboardingActivity.getLaunchIntent(this))
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {

            if (resultCode == RESULT_OK) { // SUCCESS
                val task: Task<GoogleSignInAccount> =
                    GoogleSignIn.getSignedInAccountFromIntent(data)
                try {
                    val account = task.getResult(ApiException::class.java)
                    if (account != null) {
                        firebaseAuthWithGoogle(account)
                    }
                    // SUCCESS
                    loginUtils.showSnackBar(
                        this.coordinatorLayout,
                        getString(R.string.connection_succeed)
                    )
                } catch (e: ApiException) {
                    Toast.makeText(this, "Google sign in failed:(", Toast.LENGTH_LONG).show()
                    loginUtils.showSnackBar(
                        this.coordinatorLayout,
                        getString(R.string.google_sign_in)
                    )
                }
            }
        }
    }

    // --------------------
    // ACTIONS
    // --------------------

    private fun onClickFacebookLoginButton() {
        login_facebook_button.startAnimation(domain.animation())
        startFacebookSignInActivity()
    }

    private fun onClickGoogleLoginButton() {
        login_google_button.startAnimation(domain.animation())
        startGoogleSignInActivity()
    }

    // --------------------
    // NAVIGATION
    // --------------------
    private fun startFacebookSignInActivity() {

        LoginManager.getInstance().logInWithReadPermissions(this, listOf("email", "public_profile"))
        LoginManager.getInstance()
            .registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
                override fun onSuccess(loginResult: LoginResult) {
                    loginResult.accessToken?.let { handleFacebookAccessToken(it) }
                }

                override fun onCancel() {
                    Log.d("debago", "facebook:onCancel")
                    loginUtils.cancelFacebookSnackBar(coordinatorLayout)
                }

                override fun onError(error: FacebookException) {
                    Log.d("debago", "facebook:onError", error)
                    loginUtils.errorFacebookSnackBar(coordinatorLayout)
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

    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, LoginActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    private fun handleFacebookAccessToken(token: AccessToken) {
        val credential = FacebookAuthProvider.getCredential(token.token)
        getFirebaseAuth()?.signInWithCredential(credential)
            ?.addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    loginUtils.isUserExistInFirebase()
                    handleStartActivityOrOnboarding()
                    loginUtils.showSnackBar(
                        this.coordinatorLayout,
                        getString(R.string.connection_succeed)
                    )
                } else {
                    // If sign in fails, display a message to the user.
                    loginUtils.showSnackBar(
                        this.coordinatorLayout,
                        getString(R.string.facebook_sign_in)
                    )
                }
            }
    }

}