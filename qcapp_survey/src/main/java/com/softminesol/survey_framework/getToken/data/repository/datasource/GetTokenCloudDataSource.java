package com.softminesol.survey_framework.getToken.data.repository.datasource;

import com.softminesol.survey_framework.getToken.data.net.LoginAPI;
import com.softminesol.survey_framework.getToken.model.LoginResponse;

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
public class GetTokenCloudDataSource {
    private final AppSessionManager appSessionManager;
    private LoginAPI loginAPI;

    @Inject
    public GetTokenCloudDataSource(LoginAPI loginAPI, AppSessionManager appSessionManager) {
        this.loginAPI = loginAPI;
        this.appSessionManager = appSessionManager;
    }

    public Observable<SessionValue> getToken(RequestParams requestParams) {
        return loginAPI.login(requestParams.getParameters()).map(new Func1<Response<DataResponse<LoginResponse>>, LoginResponse>() {
            @Override
            public LoginResponse call(Response<DataResponse<LoginResponse>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        }).map(new Func1<LoginResponse, SessionValue>() {
            @Override
            public SessionValue call(LoginResponse loginResponse) {
                SessionValue sessionValue = new SessionValue();
                sessionValue.setApi_key(loginResponse.getAuthToken());
                sessionValue.setUserInfo(loginResponse.getEmployeeDetails());
                return sessionValue;
            }
        }).doOnNext(saveSession());
    }

    private Action1<? super SessionValue> saveSession() {
        return new Action1<SessionValue>() {
            @Override
            public void call(SessionValue sessionValue) {
                appSessionManager.saveSession(sessionValue);
            }
        };
    }
}
