package com.inved.freezdge.utils

import android.app.Application
import android.content.Context

open class App:Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: App? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        // initialize for any
        val context: Context = applicationContext()
    }

}