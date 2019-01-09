package com.softminesol.locations.locationmanager.data.source;

import com.google.gson.JsonObject;
import com.softminesol.locations.locationmanager.data.source.api.PlaceApi;
import com.softminesol.locations.locationmanager.repository.PlaceDataStore;

import java.util.Map;

import rx.Observable;

public class CloudPlaceDataStore implements PlaceDataStore {
    private final PlaceApi placeApi;

    public CloudPlaceDataStore(PlaceApi placeApi) {
        this.placeApi = placeApi;
    }


    @Override
    public Observable<JsonObject> getAddressFromGoogleAPI(String key, String address) {
        return this.placeApi.getAddressFromGoogleAPI(key, address);
    }

}
