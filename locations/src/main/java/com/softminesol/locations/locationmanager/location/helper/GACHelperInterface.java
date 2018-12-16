package com.softminesol.locations.locationmanager.location.helper;

import android.location.LocationListener;

import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

/**
 * Created by naveen on 09/06/2016.
 */
public interface GACHelperInterface extends LocationListener,OnSuccessListener<LocationSettingsResponse>,OnFailureListener, ResultCallback<LocationSettingsResult> {
}
