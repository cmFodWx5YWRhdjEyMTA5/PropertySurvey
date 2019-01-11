package com.softminesol.propertysurvey;

import android.content.Intent;
import android.location.Location;
import android.support.multidex.MultiDex;

import com.crashlytics.android.Crashlytics;
import com.softmine.imageupload.data.net.ImageUploadURL;
import com.softminesol.propertysurvey.location.LocationUploadManager;
import com.softminesol.propertysurvey.location.model.LatLongUpload;
import com.softminesol.propertysurvey.login.view.LoginActivity;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import frameworks.AppBaseApplication;
import frameworks.appsession.AppSessionManager;
import frameworks.basemvp.AppBaseActivity;
import frameworks.routers.ILocationRouter;
import frameworks.routers.ILoginInterceptor;
import io.fabric.sdk.android.Fabric;
import io.realm.RealmConfiguration;

/**
 * Created by sandeepgoyal on 12/05/18.
 */

public class SurveyAppApplication extends AppBaseApplication implements ILoginInterceptor, ILocationRouter {
    private RealmConfiguration propertyDataConfig;
    AppSessionManager sessionValue;
    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        Fabric.with(this, new Crashlytics());
        sessionValue = new AppSessionManager(this);
        initURLS();
    }

    @Override
    public void startLogin() {
        Intent i = new Intent(mApplication.getBaseContext(), LoginActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_CLEAR_TASK |
                Intent.FLAG_ACTIVITY_NEW_TASK);
        mApplication.getBaseContext().startActivity(i);
    }

    public void initURLS() {
        ImageUploadURL.BASE_URL = CommonBaseUrl.BASE_URL;
    }

    @Override
    public void logout() {
        //TODO clear cache
        sessionValue.clearSession();
        startLogin();
    }


    @Override
    public void onLocationChanged(Location location, AppBaseActivity appBaseActivity) {
        //TODO move code to location framework itself
        LatLongUpload latLongUpload = new LatLongUpload();
        latLongUpload.setLatitude(location.getLatitude());
        latLongUpload.setLongitude(location.getLongitude());

        DateTime dateTime = new DateTime(location.getTime());
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy:MM:dd HH:mm:ss");
        latLongUpload.setDateTime(dateTime.toString(fmt));
        latLongUpload.setTrackingType("L");

        LocationUploadManager.getInstance(this).uploadLocation(latLongUpload);

    }




}
