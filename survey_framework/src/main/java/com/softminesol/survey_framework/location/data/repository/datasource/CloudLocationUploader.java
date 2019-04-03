package com.softminesol.survey_framework.location.data.repository.datasource;

import com.softminesol.survey_framework.location.data.net.LocationUploadAPI;
import com.softminesol.survey_framework.location.model.LatLongUpload;

import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import frameworks.network.model.DataResponse;
import retrofit2.Response;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by sandeepgoyal on 13/05/18.
 */

public class CloudLocationUploader {
    LocationUploadAPI locationUploadAPI;

    @Inject
    public CloudLocationUploader(LocationUploadAPI locationUploadAPI) {
        this.locationUploadAPI = locationUploadAPI;
    }

    public Observable<BaseResponse> locationUpdate(LatLongUpload latLongUpload) {
        return locationUploadAPI.locationUpdate(latLongUpload).map(new Func1<Response<DataResponse<BaseResponse>>, BaseResponse>() {
            @Override
            public BaseResponse call(Response<DataResponse<BaseResponse>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }
}
