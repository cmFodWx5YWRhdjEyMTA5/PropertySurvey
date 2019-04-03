package com.softminesol.survey_framework.location.domain;

import com.softminesol.survey_framework.location.model.LatLongUpload;

import frameworks.network.model.BaseResponse;
import rx.Observable;

/**
 * Created by sandeepgoyal on 13/05/18.
 */

public interface ILocationUploadRepository {
    public Observable<BaseResponse> locationUpdate(LatLongUpload latLongUpload);
}
