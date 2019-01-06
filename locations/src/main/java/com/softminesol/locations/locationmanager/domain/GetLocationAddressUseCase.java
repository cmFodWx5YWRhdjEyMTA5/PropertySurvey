package com.softminesol.locations.locationmanager.domain;


import com.softminesol.locations.locationmanager.data.ReverseGeoCodeAddress;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

public class GetLocationAddressUseCase extends UseCase<ReverseGeoCodeAddress> {
    private final PlaceRepository placeRepository;
    public static String PARAM_LATITUDE = "latitude";
    public static String PARAM_LONGITUDE = "longitude";
    public static final String PARAM_KEY = "key";

    @Inject
    public GetLocationAddressUseCase(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }


    public RequestParams createRequestParams(String latitude,String longitude,String key) {
        RequestParams requestParams = RequestParams.create();
        requestParams.putString(PARAM_LATITUDE, latitude);
        requestParams.putString(PARAM_LONGITUDE, longitude);
        requestParams.putString(PARAM_LONGITUDE, key);
        return requestParams;
    }

    @Override
    public Observable<ReverseGeoCodeAddress> createObservable(RequestParams requestParams) {
        String address = requestParams.getString(PARAM_LATITUDE, "")
                + "," + requestParams.getString(PARAM_LONGITUDE, "");

        String key = requestParams.getString(PARAM_KEY, "");

        return placeRepository.getAddressFromGoogleAPI(key, address);
    }
}
