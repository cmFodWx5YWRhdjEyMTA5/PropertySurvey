package com.softminesol.propertysurvey.cachehandler.data.repository.datasource;

import com.softminesol.propertysurvey.cachehandler.data.net.CacheGetterAPI;
import com.softminesol.propertysurvey.cachehandler.model.BillCacheResponse;
import com.softminesol.propertysurvey.cachehandler.model.PropertyCacheResponse;

import javax.inject.Inject;

import frameworks.network.model.DataResponse;
import retrofit2.Response;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by sandeep on 5/5/18.
 */
public class CacheCloudDataStore {
    private CacheGetterAPI cacheGetterAPI;

    @Inject
    public CacheCloudDataStore(CacheGetterAPI cacheGetterAPI) {
        this.cacheGetterAPI = cacheGetterAPI;
    }

    public Observable<PropertyCacheResponse> getAssignedData(int id) {
        return cacheGetterAPI.getAssignedData(id).map(new Func1<Response<DataResponse<PropertyCacheResponse>>, PropertyCacheResponse>() {
            @Override
            public PropertyCacheResponse call(Response<DataResponse<PropertyCacheResponse>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }
    public Observable<BillCacheResponse> getAssignedDistributionData(int id) {
        return cacheGetterAPI.getBills(id).map(new Func1<Response<DataResponse<BillCacheResponse>>, BillCacheResponse>() {
            @Override
            public BillCacheResponse call(Response<DataResponse<BillCacheResponse>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }

}
