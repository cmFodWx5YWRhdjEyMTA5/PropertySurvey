package com.softminesol.survey_framework.getToken.data.repository.datasource;

import javax.inject.Inject;

import frameworks.appsession.SessionValue;
import frameworks.network.usecases.RequestParams;
import rx.Observable;

/**
 * Created by sandeep on 5/5/18.
 */
public class GetTokenDataFactory {

    GetTokenCloudDataSource getTokenCloudDataSource;

    @Inject
    public GetTokenDataFactory(GetTokenCloudDataSource getTokenCloudDataSource) {
        this.getTokenCloudDataSource = getTokenCloudDataSource;
    }

    public Observable<SessionValue> getToken(RequestParams requestParams) {
        return getTokenCloudDataSource.getToken(requestParams);
    }

}
