package com.inved.freezdge.utils

import android.util.Log
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.inved.freezdge.R
import com.inved.freezdge.socialmedia.firebase.UserHelper

class LoginUtils {

    private var getCurrentUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser

    //handle Snackbar messages
    fun showSnackBar(
        coordinatorLayout: CoordinatorLayout,
        message: String
    ) {
        Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_SHORT).show()
    }

    fun successFacebookSnackBar(coordinatorLayout: CoordinatorLayout) {
        showSnackBar(coordinatorLayout, App.resource().getString(R.string.connection_succeed))
    }

    fun errorFacebookSnackBar(coordinatorLayout: CoordinatorLayout) {
        showSnackBar(coordinatorLayout, App.resource().getString(R.string.facebook_sign_in))
    }

    fun cancelFacebookSnackBar(coordinatorLayout: CoordinatorLayout) {
        showSnackBar(
            coordinatorLayout,
            App.resource().getString(R.string.error_authentication_canceled)
        )
    }

    //check if user exist in firebase before to create a new user
    fun isUserExistInFirebase() {

        UserHelper.getUser(getCurrentUser?.uid)?.get()
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (task.result != null) {
                        if (task.result?.documents?.size == 0) {
                            getCurrentUser?.uid?.let {
                                UserHelper.createUser(
                                    it,
                                    getCurrentUser?.displayName,
                                    "",
                                    getCurrentUser?.photoUrl.toString()
                                )
                            }

                        }
                    }
                }
            }?.addOnFailureListener {
                Log.e(
                    "firebase",
                    "Problem during the user creation"
                )
            }
    }


}