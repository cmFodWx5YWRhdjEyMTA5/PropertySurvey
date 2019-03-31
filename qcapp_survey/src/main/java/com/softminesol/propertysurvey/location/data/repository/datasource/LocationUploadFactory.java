package com.softminesol.propertysurvey.location.data.repository.datasource;

import com.softminesol.propertysurvey.location.model.LatLongUpload;

import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import rx.Observable;

/**
 * Created by sandeepgoyal on 13/05/18.
 */

public class LocationUploadFactory {
    CloudLocationUploader cloudImageUploader;

    @Inject
    public LocationUploadFactory(CloudLocationUploader cloudImageUploader) {
        this.cloudImageUploader = cloudImageUploader;
    }

    public Observable<BaseResponse> locationUpdate(LatLongUpload latLongUpload) {
        return cloudImageUploader.locationUpdate(latLongUpload);
    }
}
