package com.softminesol.propertysurvey.cachehandler.data.net;

import com.softminesol.propertysurvey.cachehandler.model.BillCacheResponse;
import com.softminesol.propertysurvey.cachehandler.model.PropertyCacheResponse;
import com.softminesol.propertysurvey.survey.common.model.formData.FormData;
import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetail;
import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetails;

import java.util.List;
import java.util.Map;

import frameworks.network.model.DataResponse;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
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
