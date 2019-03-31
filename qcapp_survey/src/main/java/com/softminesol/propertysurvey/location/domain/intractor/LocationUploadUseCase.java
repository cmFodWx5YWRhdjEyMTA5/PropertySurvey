package com.softminesol.propertysurvey.location.domain.intractor;

import com.softminesol.propertysurvey.location.domain.ILocationUploadRepository;
import com.softminesol.propertysurvey.location.model.LatLongUpload;

import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

/**
 * Created by sandeepgoyal on 13/05/18.
 */

public class LocationUploadUseCase extends UseCase<BaseResponse> {
    public static String LOCATION_OBJECT = "LOCATION_OBJECT";
    ILocationUploadRepository repository;

    @Inject
    public LocationUploadUseCase(ILocationUploadRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<BaseResponse> createObservable(RequestParams requestParams) {
        return repository.locationUpdate((LatLongUpload) requestParams.getObject(LOCATION_OBJECT));
    }

}
