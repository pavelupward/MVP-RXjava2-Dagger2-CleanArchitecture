package pavel.bogrecov.omertex.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import pavel.bogrecov.omertex.presentation.app.AppClass;

public class NetworkUtils {


    public static boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) AppClass.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
