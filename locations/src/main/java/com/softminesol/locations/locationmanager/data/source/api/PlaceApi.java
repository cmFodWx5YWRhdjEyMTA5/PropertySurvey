package com.softminesol.locations.locationmanager.data.source.api;


import com.google.gson.JsonObject;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by alvarisi on 3/18/17.
 */

public interface PlaceApi {

//
//    //@GET("https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyCRkgwGBe8ZxjcK07Cnl3Auf72BpgA6lLo")
    @GET("https://maps.googleapis.com/maps/api/geocode/json")
    Observable<JsonObject> getAddressFromGoogleAPI(@Query("key") String key, @Query("address") String address);


}