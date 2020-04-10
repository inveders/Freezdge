package com.inved.freezdge.utils

import android.app.Application
import android.content.Context
import com.inved.freezdge.MyObjectBox
import io.objectbox.BoxStore

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
        ObjectBox.init(this)
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