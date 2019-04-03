package com.softminesol.survey_framework.getToken.data.repository
        ;

import com.softminesol.survey_framework.getToken.data.repository.datasource.GetTokenDataFactory;
import com.softminesol.survey_framework.getToken.domain.IGetTokenRepository;

import javax.inject.Inject;

import frameworks.appsession.SessionValue;
import frameworks.network.usecases.RequestParams;
import rx.Observable;

/**
 * Created by sandeep on 4/5/18.
 */
public class GetTokenDataRepository implements IGetTokenRepository {

    GetTokenDataFactory getTokenDataFactory;

    @Inject
    public GetTokenDataRepository(GetTokenDataFactory getTokenDataFactory) {
        this.getTokenDataFactory = getTokenDataFactory;
    }


    @Override
    public Observable<SessionValue> getToken(RequestParams requestParams) {
        return getTokenDataFactory.getToken(requestParams);
    }
}
