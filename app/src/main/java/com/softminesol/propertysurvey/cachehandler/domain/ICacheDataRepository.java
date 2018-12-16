package com.softminesol.propertysurvey.cachehandler.domain;

import frameworks.appsession.SessionValue;
import frameworks.network.usecases.RequestParams;
import rx.Observable;

/**
 * Created by sandeep on 5/5/18.
 */
public interface ICacheDataRepository {
    public Observable<Boolean> getCacheandSave(RequestParams requestParams,int page);
    public Observable<Boolean> getBillDetailandSave(int page);
}
