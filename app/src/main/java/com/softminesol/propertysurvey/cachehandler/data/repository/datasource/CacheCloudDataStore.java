package com.softminesol.propertysurvey.cachehandler.data.repository.datasource;

import com.softminesol.propertysurvey.cachehandler.data.net.CacheGetterAPI;
import com.softminesol.propertysurvey.cachehandler.model.BillCacheResponse;
import com.softminesol.propertysurvey.cachehandler.model.PropertyCacheResponse;
import com.softminesol.propertysurvey.survey.common.model.formData.FormData;
import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetail;
import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetails;

import java.util.List;

import javax.inject.Inject;

import frameworks.appsession.AppSessionManager;
import frameworks.appsession.SessionValue;
import frameworks.network.model.DataResponse;
import frameworks.network.usecases.RequestParams;
import retrofit2.Response;
import rx.Observable;
import rx.functions.Action1;
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
