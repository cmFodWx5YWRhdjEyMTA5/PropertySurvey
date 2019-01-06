package com.softminesol.locations.locationmanager.domain;


import com.softminesol.locations.locationmanager.data.ReverseGeoCodeAddress;

import rx.Observable;

public interface PlaceRepository {

    Observable<ReverseGeoCodeAddress> getAddressFromGoogleAPI(String key, String address);


}
