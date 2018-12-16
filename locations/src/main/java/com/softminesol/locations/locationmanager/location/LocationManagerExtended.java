package com.softminesol.locations.locationmanager.location;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.Task;
import com.softminesol.locations.locationmanager.LocationManagerService;
import com.softminesol.locations.locationmanager.location.helper.GACHelperInterface;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.LOCATION_SERVICE;


/**
 * Created by naveen on 09/06/2016.
 */
public class LocationManagerExtended implements GACHelperInterface {
    private static final String TAG = "LocationManagerExtended";
    /**
     * Stores parameters for requests to the FusedLocationProviderApi.
     */
    protected LocationRequest mLocationRequest;
    /**
     * Stores the types of location services the client is interested in using. Used for checking
     * settings to determine if the device has optimal location settings.
     */
    protected LocationSettingsRequest mLocationSettingsRequest;

    /**
     * Provides the entry point to Google Play services.
     */
    LocationManager locationManager;


    /**
     * Store Device Location Single Instance for full application
     */
    protected Location mCurrentLocation = null;

    /**
     * Constant used in the location settings dialog.
     */

    /**
     * The desired interval for location updates. Inexact. Updates may be more or less frequent.
     */
    public static final long UPDATE_INTERVAL_IN_MILLISECONDS = 10000;
    // The minimum distance to change Updates in meters
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters

    /**
     * The fastest rate for active location updates. Exact. Updates will never be more frequent
     * than this value.
     */
    public static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS =
            UPDATE_INTERVAL_IN_MILLISECONDS / 2;


    protected static final int REQUEST_CHECK_SETTINGS = 0x1;
    protected Activity mActivity = null;
    private static LocationManagerExtended mLocationManagerInstance = null;
    public static final int ACCESS_LOCATION = 201;
    List<LocationAndSettingChangeUpdates> mLocationandSettingChangeObserver = new ArrayList<>();
    int locationPriority = LocationRequest.PRIORITY_HIGH_ACCURACY;
    String locationProvider = LocationManager.GPS_PROVIDER;

    protected LocationManagerExtended() {

    }

    private LocationManagerExtended(Activity context) {
        mActivity = context;
    }

    public static LocationManagerExtended getmLocationManagerInstance(Activity activity) {
        if (mLocationManagerInstance == null) {
            mLocationManagerInstance = new LocationManagerExtended(activity);
        }
        mLocationManagerInstance.mActivity = activity;
        return mLocationManagerInstance;// mLocationManagerInstance;
    }


    public void initLocationManager() {
        if (locationManager == null) {
            locationManager = (LocationManager) mActivity.getSystemService(LOCATION_SERVICE);
        }
        onConnected();
    }


    public void onConnected() {
        if (ActivityCompat.checkSelfPermission(mActivity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mActivity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, ACCESS_LOCATION);
            return;
        } else {
            if (!LocationManagerService.getInstance().isLocationSettingDenied())
                checkLocationSettings();
        }
    }


    /**
     * Sets up the location request. Android has two location request settings:
     * {@code ACCESS_COARSE_LOCATION} and {@code ACCESS_FINE_LOCATION}. These settings control
     * the accuracy of the current location. This sample uses ACCESS_FINE_LOCATION, as defined in
     * the AndroidManifest.xml.
     * <p/>
     * When the ACCESS_FINE_LOCATION setting is specified, combined with a fast update
     * interval (5 seconds), the Fused Location Provider API returns location updates that are
     * accurate to within a few feet.
     * <p/>
     * These settings are appropriate for mapping applications that show real-time location
     * updates.
     */
    protected void createLocationRequest() {
        mLocationRequest = new LocationRequest();

        // Sets the desired interval for active location updates. This interval is
        // inexact. You may not receive updates at all if no location sources are available, or
        // you may receive them slower than requested. You may also receive updates faster than
        // requested if other applications are requesting location at a faster interval.
        mLocationRequest.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS);

        // Sets the fastest rate for active location updates. This interval is exact, and your
        // application will never receive updates faster than this value.
        mLocationRequest.setFastestInterval(FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS);

        mLocationRequest.setPriority(locationPriority);
    }

    /**
     * Check if the device's location settings are adequate for the app's needs using the
     * {@link com.google.android.gms.location.SettingsApi#checkLocationSettings(GoogleApiClient,
     * LocationSettingsRequest)} method, with the results provided through a {@code PendingResult}.
     */
    protected void checkLocationSettings() {
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(mLocationRequest);
        builder.setAlwaysShow(true);
        SettingsClient client = LocationServices.getSettingsClient(mActivity);
        Task<LocationSettingsResponse> task = client.checkLocationSettings(builder.build());
        task.addOnSuccessListener(mActivity, this);
        task.addOnFailureListener(mActivity,this);
    }


    public void setLocationandSettingChangeObserver(LocationAndSettingChangeUpdates observer) {
        mLocationandSettingChangeObserver.add(observer);
    }

    public void removeLocationandSettingChangeObserver(LocationAndSettingChangeUpdates observer) {
        mLocationandSettingChangeObserver.remove(observer);
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.e(TAG, "onLocation Changed called");
        mCurrentLocation = location;
        for (LocationAndSettingChangeUpdates observer : mLocationandSettingChangeObserver) {
            observer.onLocationChanged(location);
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }


    public void setLocationPriority(int locationPriority) {
        this.locationPriority = locationPriority;
        createLocationRequest();
        getmCurrentLocation();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            // Check for the integer request code originally supplied to startResolutionForResult().
            case REQUEST_CHECK_SETTINGS:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        Log.i(TAG, "User agreed to make required location settings changes.");
                        for (LocationAndSettingChangeUpdates observer : mLocationandSettingChangeObserver) {
                            observer.onLocationSettingEnabled();
                        }
                        initCurrentLocation();
                        //startLocationUpdates();
                        break;
                    case Activity.RESULT_CANCELED:
                        for (LocationAndSettingChangeUpdates observer : mLocationandSettingChangeObserver) {
                            observer.onLocationSettingEnableDenied();
                        }
                        Log.i(TAG, "User chose not to make required location settings changes.");
                        break;
                }
                break;
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case ACCESS_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (!LocationManagerService.getInstance().isLocationSettingDenied())
                        checkLocationSettings();
                    for (LocationAndSettingChangeUpdates observer : mLocationandSettingChangeObserver) {
                        observer.onLocationPermissionGranted();
                    }
                } else {
                    for (LocationAndSettingChangeUpdates observer : mLocationandSettingChangeObserver) {
                        observer.onLocationPermissionDenied();
                    }
                }
                break;
        }
    }

    void initCurrentLocation() {
        try {

            mCurrentLocation = locationManager.getLastKnownLocation(locationProvider);
            startLocationUpdates();
        } catch (SecurityException e) {
            //startLocationUpdates();
        }
    }

    public void startLocationUpdates() {
        try {
            locationManager = (LocationManager) mActivity
                    .getSystemService(LOCATION_SERVICE);

            // getting GPS status
            boolean isGPSEnabled = locationManager
                    .isProviderEnabled(LocationManager.GPS_PROVIDER);

            // getting network status
            boolean isNetworkEnabled = locationManager
                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!isGPSEnabled && !isNetworkEnabled) {
                // no network provider is enabled
            } else {
                // First get location from Network Provider
                if (isNetworkEnabled) {
                    locationManager.requestLocationUpdates(
                            LocationManager.NETWORK_PROVIDER,
                            FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                    Log.d("Network", "Network");
                    if (locationManager != null) {
                        mCurrentLocation = locationManager
                                .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    }
                }
                // if GPS Enabled get lat/long using GPS Services
                if (isGPSEnabled) {
                    if (mCurrentLocation == null) {
                        locationManager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        Log.d("GPS Enabled", "GPS Enabled");
                        if (locationManager != null) {
                            mCurrentLocation = locationManager
                                    .getLastKnownLocation(LocationManager.GPS_PROVIDER);

                        }
                    }
                }
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
        broadCastCurrentLocation();
    }

    public void broadCastCurrentLocation() {
        if (mCurrentLocation != null) {
           onLocationChanged(mCurrentLocation);
        }
    }


    public Location getmCurrentLocation() {
        if (mCurrentLocation == null) {
            initCurrentLocation();
        }
        return mCurrentLocation;
    }

    @Override
    public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
        createLocationRequest();
        initCurrentLocation();

    }

    @Override
    public void onFailure(@NonNull Exception e) {
        if (e instanceof ResolvableApiException) {
            try {
                ResolvableApiException resolvable = (ResolvableApiException) e;
                resolvable.startResolutionForResult(mActivity,
                        REQUEST_CHECK_SETTINGS);
            } catch (IntentSender.SendIntentException sendEx) {
            }
        }

        for (LocationAndSettingChangeUpdates observer : mLocationandSettingChangeObserver) {
            observer.onLocationSettingEnableDenied();
        }
    }

    public void releaseLocationManager() {
        locationManager.removeUpdates(this);
    }



    @Override
    public void onResult(@NonNull LocationSettingsResult locationSettingsResult) {

    }

    interface LocationSettingUpdates {
        void onLocationPermissionGranted();

        void onLocationPermissionDenied();

        void onLocationSettingEnabled();

        void onLocationSettingEnableDenied();
    }

    interface LocationChangeObserver {
        void onLocationChanged(Location location);
    }

    public interface LocationAndSettingChangeUpdates extends LocationManagerExtended.LocationSettingUpdates, LocationManagerExtended.LocationChangeObserver {

    }
}
