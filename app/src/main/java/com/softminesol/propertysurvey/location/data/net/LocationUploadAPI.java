package com.softminesol.propertysurvey.location.data.net;

import com.softminesol.propertysurvey.location.model.LatLongUpload;

import frameworks.network.model.BaseResponse;
import frameworks.network.model.DataResponse;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by sandeepgoyal on 13/05/18.
 */

public interface LocationUploadAPI {
    @POST(LocationUploadURL.locationUpload)
    Observable<Response<DataResponse<BaseResponse>>> locationUpdate(@Body LatLongUpload latLongUpload);
}
