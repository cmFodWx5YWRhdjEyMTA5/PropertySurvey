package com.softminesol.propertysurvey.getToken.data.net;

import com.softminesol.propertysurvey.getToken.model.LoginResponse;

import java.util.Map;

import frameworks.network.model.DataResponse;
import retrofit2.Response;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by sandeepgoyal on 03/05/18.
 */

public interface LoginAPI {
    @FormUrlEncoded
    @POST(LoginAPIURL.Login_API)
    public Observable<Response<DataResponse<LoginResponse>>> login(@FieldMap Map<String, Object> params);
}
