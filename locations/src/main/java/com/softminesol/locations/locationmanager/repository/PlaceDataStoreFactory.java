package com.softminesol.locations.locationmanager.repository;


import com.tuktukride.common.place.data.source.CloudPlaceDataStore;
import com.tuktukride.common.place.data.source.api.PlaceApi;

public class PlaceDataStoreFactory {
    private final PlaceApi placeApi;

    public PlaceDataStoreFactory(PlaceApi placeApi) {
        this.placeApi = placeApi;
    }

    public PlaceDataStore createCloudPlaceDataStore(){
        return new CloudPlaceDataStore(this.placeApi);
    }
}
