package com.softminesol.propertysurvey.cachehandler.data.net;

import com.softminesol.propertysurvey.cachehandler.model.BillCacheResponse;
import com.softminesol.propertysurvey.cachehandler.model.PropertyCacheResponse;

import frameworks.network.model.DataResponse;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by sandeepgoyal on 03/05/18.
 */

public interface CacheGetterAPI {

    @GET(CacheAPIURL.getAssignedData)
    public Observable<Response<DataResponse<PropertyCacheResponse>>> getAssignedData(@Path("id") int id);


    @GET(CacheAPIURL.getBillAssisgned)
    public Observable<Response<DataResponse<BillCacheResponse>>> getBills(@Path("id") int id);
}
