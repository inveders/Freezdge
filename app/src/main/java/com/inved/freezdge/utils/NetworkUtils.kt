package com.inved.freezdge.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

class NetworkUtils {

    companion object{

        fun isWifiAvailable(context: Context): Boolean{
            val wifi = context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
            return  wifi.isWifiEnabled
        }

        fun isInternetAvailable(context: Context): Boolean{
            val connectivityManager = context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = connectivityManager.activeNetworkInfo
            return activeNetwork != null && activeNetwork.isConnected
        }

        fun isInternetAccessible(context: Context): Boolean {
            if (isWifiAvailable(context)) {
                try {

                    GlobalScope.async {
                        val urlc: HttpURLConnection =
                            URL("http://www.google.com").openConnection() as HttpURLConnection
                        urlc.setRequestProperty("User-Agent", "Test")
                        urlc.setRequestProperty("Connection", "close")
                         urlc.connectTimeout = 1500
                        urlc.connect()
                        return@async urlc.responseCode == 200
                    }

                } catch (e: IOException) {
                    Log.e("debago", "Couldn't check internet connection", e)
                }
            } else {
                Log.d("debago", "Internet not available!")
            }
            return false
        }

        fun typeNetworkConnection(context: Context): TypeConnection{
            val wifiConnection = isWifiAvailable(context)
            val internetConnection = isInternetAvailable(context)
            val internetConnected = isInternetAccessible(context)
             return when{
                !internetConnected -> TypeConnection.NONE
                !internetConnection -> TypeConnection.NONE
                !wifiConnection && internetConnection -> TypeConnection.DATA
                wifiConnection -> TypeConnection.WIFI
                else -> TypeConnection.NONE
            }
        }

        enum class TypeConnection{
            WIFI,
            DATA,
            NONE
        }
    }






}