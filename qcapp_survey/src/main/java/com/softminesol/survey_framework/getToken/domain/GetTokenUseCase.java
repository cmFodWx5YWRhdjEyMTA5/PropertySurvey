package com.softminesol.survey_framework.getToken.domain;

import javax.inject.Inject;

import frameworks.appsession.SessionValue;
import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

/**
 * Created by sandeepgoyal on 04/05/18.
 */

public class GetTokenUseCase extends UseCase<SessionValue> {

    IGetTokenRepository getTokenRepository;

    @Inject
    public GetTokenUseCase(IGetTokenRepository getTokenRepository) {
        this.getTokenRepository = getTokenRepository;
    }

    @Override
    public Observable<SessionValue> createObservable(RequestParams requestParams) {
        return getTokenRepository.getToken(requestParams);
    }
}
