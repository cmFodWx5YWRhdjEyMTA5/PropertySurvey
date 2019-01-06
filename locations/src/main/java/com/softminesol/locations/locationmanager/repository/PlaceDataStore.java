package com.softminesol.locations.locationmanager.repository;

import com.google.gson.JsonObject;


import rx.Observable;

public interface PlaceDataStore {

    Observable<JsonObject> getAddressFromGoogleAPI(String key, String address);


}
