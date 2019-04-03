package com.softminesol.survey_framework.location.data.repository;

import com.softminesol.survey_framework.location.data.repository.datasource.LocationUploadFactory;
import com.softminesol.survey_framework.location.domain.ILocationUploadRepository;
import com.softminesol.survey_framework.location.model.LatLongUpload;

import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import rx.Observable;

/**
 * Created by sandeepgoyal on 13/05/18.
 */

public class LocationUploadRepository implements ILocationUploadRepository {
    LocationUploadFactory imageUploadFactory;

    @Inject
    public LocationUploadRepository(LocationUploadFactory imageUploadFactory) {
        this.imageUploadFactory = imageUploadFactory;
    }

    @Override
    public Observable<BaseResponse> locationUpdate(LatLongUpload latLongUpload) {
        return imageUploadFactory.locationUpdate(latLongUpload);
    }
}
