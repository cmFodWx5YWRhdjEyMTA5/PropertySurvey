package com.softminesol.locations.locationmanager.repository;


import com.softminesol.locations.locationmanager.data.source.CloudPlaceDataStore;
import com.softminesol.locations.locationmanager.data.source.api.PlaceApi;

import javax.inject.Inject;

public class PlaceDataStoreFactory {
    private final PlaceApi placeApi;

    @Inject
    public PlaceDataStoreFactory(PlaceApi placeApi) {
        this.placeApi = placeApi;
    }

    public PlaceDataStore createCloudPlaceDataStore(){
        return new CloudPlaceDataStore(this.placeApi);
    }
}
