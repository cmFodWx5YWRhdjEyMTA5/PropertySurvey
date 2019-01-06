package com.softminesol.locations.locationmanager.repository;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.softminesol.locations.locationmanager.data.ReverseGeoCodeAddress;
import com.softminesol.locations.locationmanager.domain.PlaceRepository;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;


public class PlaceDataRepository implements PlaceRepository {
    private final PlaceDataStoreFactory placeDataStoreFactory;

    public PlaceDataRepository(PlaceDataStoreFactory placeDataStoreFactory) {
        this.placeDataStoreFactory = placeDataStoreFactory;
    }



    @Override
    public Observable<ReverseGeoCodeAddress> getAddressFromGoogleAPI(final String key, final String address) {
        return placeDataStoreFactory.createCloudPlaceDataStore()
                .getAddressFromGoogleAPI(key, address).map(new Func1<JsonObject, ReverseGeoCodeAddress>() {
                    @Override
                    public ReverseGeoCodeAddress call(JsonObject jsonObject) {
                        JsonArray jsonElements = jsonObject.getAsJsonArray("results");
                        ReverseGeoCodeAddress reverseGeoCodeAddress = new ReverseGeoCodeAddress();
                        if (jsonElements != null && jsonElements.size() > 0) {
                            Gson gson = new Gson();
                            reverseGeoCodeAddress = (ReverseGeoCodeAddress) gson.fromJson(jsonElements.get(0), ReverseGeoCodeAddress.class);
                        }

                        return reverseGeoCodeAddress;
                    }
                });
    }


}
