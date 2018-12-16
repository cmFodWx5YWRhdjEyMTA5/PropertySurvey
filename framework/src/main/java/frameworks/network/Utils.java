package frameworks.network;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import frameworks.AppBaseApplication;

public class Utils {
    public static boolean isInternetOn() {
        try {
            ConnectivityManager cm = (ConnectivityManager) AppBaseApplication.getApplication()
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                return true;
            }
        }
        catch (Exception e){
            return false;
        }
        return false;
    }
}
