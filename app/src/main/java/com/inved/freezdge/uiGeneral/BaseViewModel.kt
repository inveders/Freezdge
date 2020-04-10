package com.inved.freezdge.uiGeneral

import androidx.lifecycle.ViewModel
import io.objectbox.reactive.DataSubscription


abstract class BaseViewModel : ViewModel() {

    override fun onCleared() {
        super.onCleared()
        for (subscription in mSubscriptions) {
            if (!subscription?.isCanceled!!) {
                subscription?.cancel()
            }
        }
    }


    companion object{

        private val mSubscriptions: MutableList<DataSubscription?>


        fun addSubscription(subscription: DataSubscription?) {
            mSubscriptions.add(subscription)
        }

        init {
            mSubscriptions = ArrayList()
        }
    }
}