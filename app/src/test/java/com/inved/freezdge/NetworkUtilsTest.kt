@file:Suppress("DEPRECATION")

package com.inved.freezdge

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities.*
import android.net.NetworkInfo
import android.os.Build
import com.inved.freezdge.utils.NetworkUtils
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowConnectivityManager
import org.robolectric.shadows.ShadowNetworkCapabilities
import org.robolectric.shadows.ShadowNetworkInfo
import java.io.IOException


@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
open class NetworkUtilsTest {

    private var shadowConnectivityManager: ShadowConnectivityManager? = null

    @Before
    @Throws(IOException::class)
    fun setUp() {
        val connectivityManager = getConnectivityManager()
        shadowConnectivityManager = shadowOf(connectivityManager)
       }

    @Test
    fun availableConnexionTest() {
        val networkCapabilities = ShadowNetworkCapabilities.newInstance()
        shadowOf(networkCapabilities).addTransportType(TRANSPORT_WIFI)
        shadowOf(networkCapabilities).addTransportType(TRANSPORT_CELLULAR)
           val networkInfo = ShadowNetworkInfo.newInstance(
            NetworkInfo.DetailedState.CONNECTED,
            ConnectivityManager.TYPE_WIFI,
            0,
            true,
            NetworkInfo.State.CONNECTED
        )
        shadowConnectivityManager?.setActiveNetworkInfo(networkInfo)

        Assert.assertTrue(NetworkUtils.isNetworkAvailable(RuntimeEnvironment.systemContext))

    }

    @Test
    fun noAvailableConnexionTest() {
        val networkCapabilities = ShadowNetworkCapabilities.newInstance()
        shadowOf(networkCapabilities).removeTransportType(TRANSPORT_WIFI)
        shadowOf(networkCapabilities).removeTransportType(TRANSPORT_CELLULAR)
        shadowOf(networkCapabilities).removeTransportType(TRANSPORT_ETHERNET)

        val networkInfo = ShadowNetworkInfo.newInstance(
            NetworkInfo.DetailedState.DISCONNECTED,
            ConnectivityManager.TYPE_WIFI,
            0,
            false,
            NetworkInfo.State.DISCONNECTED
        )
        shadowConnectivityManager?.setActiveNetworkInfo(networkInfo)


        Assert.assertFalse(NetworkUtils.isNetworkAvailable(RuntimeEnvironment.systemContext))
    }

    private fun getConnectivityManager(): ConnectivityManager {
        return RuntimeEnvironment.systemContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    @Test
    @Throws(Exception::class)
    open fun hasTransport_shouldReturnAsPerAssignedTransportTypes() {
        val networkCapabilities = ShadowNetworkCapabilities.newInstance()

        // Assert default false state.
        assertFalse(networkCapabilities.hasTransport(TRANSPORT_WIFI))
        shadowOf(networkCapabilities).addTransportType(TRANSPORT_WIFI)
        shadowOf(networkCapabilities).addTransportType(TRANSPORT_CELLULAR)
        assertTrue(networkCapabilities.hasTransport(TRANSPORT_WIFI))
        assertTrue(networkCapabilities.hasTransport(TRANSPORT_CELLULAR))
        shadowOf(networkCapabilities).removeTransportType(TRANSPORT_WIFI)
        assertFalse(networkCapabilities.hasTransport(TRANSPORT_WIFI))
        assertTrue(networkCapabilities.hasTransport(TRANSPORT_CELLULAR))

    }

}