package com.inved.freezdge

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import com.inved.freezdge.utils.NetworkUtils
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows
import org.robolectric.annotation.Config
import org.robolectric.annotation.LooperMode
import org.robolectric.shadows.ShadowConnectivityManager
import org.robolectric.shadows.ShadowNetworkInfo
import java.io.IOException

@RunWith(RobolectricTestRunner::class)
@LooperMode(LooperMode.Mode.PAUSED)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class InternetConnexionTest {
 /*   private var shadowConnectivityManager: ShadowConnectivityManager? = null

    @Before
    @Throws(IOException::class)
    fun setUp() {
        val connectivityManager = connectivityManager
        shadowConnectivityManager = Shadows.shadowOf(connectivityManager)
    }

    @Test
    fun availableConnexionTest() {
        val networkInfo: NetworkInfo = ShadowNetworkInfo.newInstance(
            NetworkInfo.DetailedState.CONNECTED,
            ConnectivityManager.TYPE_WIFI,
            0,
            true,
            NetworkInfo.State.CONNECTED
        )
        shadowConnectivityManager?.setActiveNetworkInfo(networkInfo)
        Assert.assertTrue(NetworkUtils.isInternetAvailable(RuntimeEnvironment.systemContext))
    }

    @Test
    fun noAvailableConnexionTest() {
        val networkInfo: NetworkInfo = ShadowNetworkInfo.newInstance(
            NetworkInfo.DetailedState.DISCONNECTED,
            ConnectivityManager.TYPE_WIFI,
            0,
            false,
            NetworkInfo.State.DISCONNECTED
        )
        shadowConnectivityManager?.setActiveNetworkInfo(networkInfo)
        Assert.assertFalse(NetworkUtils.isInternetAvailable(RuntimeEnvironment.systemContext))
    }

    private val connectivityManager: ConnectivityManager
        private get() = RuntimeEnvironment.systemContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager*/
}