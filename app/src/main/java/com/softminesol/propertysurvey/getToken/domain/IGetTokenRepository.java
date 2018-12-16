package com.softminesol.propertysurvey.getToken.domain;

import frameworks.appsession.SessionValue;
import frameworks.network.usecases.RequestParams;
import rx.Observable;

/**
 * Created by sandeep on 5/5/18.
 */
public interface IGetTokenRepository {
    public Observable<SessionValue> getToken(RequestParams requestParams);
}
