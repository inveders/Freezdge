package com.inved.freezdge.utils

import android.app.Application
import android.content.Context
import android.content.res.Resources
import com.inved.freezdge.MyObjectBox
import io.objectbox.BoxStore

open class App:Application() {

    companion object {
        lateinit var appContext: Context

        fun applicationContext() : Context {
            return appContext.applicationContext
        }

        fun resource() : Resources {
            return appContext.resources
        }
    }

    override fun onCreate() {
        super.onCreate()
        // initialize for any
        ObjectBox.init(this)
        appContext=this

    }

    object ObjectBox {
        lateinit var boxStore: BoxStore
            private set

        fun init(context: Context) {
            boxStore = MyObjectBox.builder()
                .androidContext(context.applicationContext)
                .build()
        }
    }

}