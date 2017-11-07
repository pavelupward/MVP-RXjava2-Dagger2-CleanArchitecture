package pavel.bogrecov.omertex.utils

import android.content.Context
import android.net.ConnectivityManager
import pavel.bogrecov.omertex.presentation.app.AppClass

object NetworkUtils {


    val isNetworkAvailable: Boolean
        get() {
            val connectivityManager = AppClass.getContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnected
        }

}
