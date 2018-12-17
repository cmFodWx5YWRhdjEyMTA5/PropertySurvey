package com.softminesol.propertysurvey.login.domain;

import com.softminesol.propertysurvey.getToken.domain.GetTokenUseCase;

import javax.inject.Inject;

import frameworks.appsession.SessionValue;
import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

/**
 * Created by sandeepgoyal on 04/05/18.
 */

public class LoginEmailUseCase extends UseCase<SessionValue> {

    public static final String USERID = "userid";
    public static final String PASSWORD = "password";

    GetTokenUseCase getTokenUseCase;

    @Inject
    public LoginEmailUseCase(GetTokenUseCase getTokenUseCase) {
        this.getTokenUseCase = getTokenUseCase;
    }

    public static RequestParams createRequestParams(String userId, String password) {
        RequestParams requestParams = RequestParams.create();
        requestParams.putString(USERID, userId);
        requestParams.putString(PASSWORD, password);
        return requestParams;
    }

    @Override
    public Observable<SessionValue> createObservable(RequestParams requestParams) {
        return getTokenUseCase.createObservable(requestParams);
    }
}
