package com.inved.freezdge.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

class NetworkUtils {

    companion object {

        fun isWifiAvailable(context: Context): Boolean {
            val wifi =
                context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
            return wifi.isWifiEnabled
        }

        fun isInternetAvailable(context: Context): Boolean {
            val connectivityManager =
                context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = connectivityManager.activeNetworkInfo
            return activeNetwork != null && activeNetwork.isConnected
        }

        fun typeNetworkConnection(context: Context): TypeConnection {
            val wifiConnection = isWifiAvailable(context)
            val internetConnection = isInternetAvailable(context)
            return when {
                !internetConnection -> TypeConnection.NONE
                !wifiConnection && internetConnection -> TypeConnection.DATA
                wifiConnection -> TypeConnection.WIFI
                else -> TypeConnection.NONE
            }
        }

        enum class TypeConnection {
            WIFI,
            DATA,
            NONE
        }
    }


}