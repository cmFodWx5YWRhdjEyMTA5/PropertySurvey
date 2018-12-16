package com.softminesol.locations.locationmanager.location;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.softminesol.permissions.apppermission.PermissionActivity;

/**
 * Created by naveen on 10/06/2016.
 */
public abstract class BaseLocationActivity extends PermissionActivity implements LocationManagerExtended.LocationAndSettingChangeUpdates {
    protected LocationManagerExtended mLocationManager = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isLocationNeeded()) {
            mLocationManager = LocationManagerExtended.getmLocationManagerInstance(this);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (isLocationNeeded()) {
            mLocationManager.initLocationManager();
            mLocationManager.setLocationandSettingChangeObserver(this);
        }
    }

    public Location getCurrentLocation() {
        return mLocationManager.getmCurrentLocation();
    }

    @Override
    protected void onStop() {
        if (isLocationNeeded()) {
            mLocationManager.releaseLocationManager();
            mLocationManager.removeLocationandSettingChangeObserver(this);
        }
        super.onStop();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (isLocationNeeded()) {
            mLocationManager.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (isLocationNeeded()) {
            mLocationManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public boolean isLocationNeeded() {
        return false;
    }
}
