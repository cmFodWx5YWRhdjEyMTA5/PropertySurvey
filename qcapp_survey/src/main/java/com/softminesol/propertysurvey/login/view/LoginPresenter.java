package com.softminesol.propertysurvey.login.view;

import android.content.Intent;

import com.softminesol.propertysurvey.home.view.DashBoardActivity;
import com.softminesol.propertysurvey.login.domain.LoginEmailUseCase;

import javax.inject.Inject;

import frameworks.appsession.SessionValue;
import frameworks.basemvp.AppBasePresenter;
import frameworks.network.Utils;
import frameworks.network.model.ResponseException;
import frameworks.network.usecases.RequestParams;
import rx.Subscriber;

/**
 * Created by sandeepgoyal on 03/05/18.
 */

public class LoginPresenter extends AppBasePresenter<ILoginViewContractor.View> implements ILoginViewContractor.Presenter {

    LoginEmailUseCase loginEmailUseCase;

    @Inject
    public LoginPresenter(LoginEmailUseCase loginEmailUseCase) {
        this.loginEmailUseCase = loginEmailUseCase;
    }

    @Override
    public void onLoginClick() {
        String userId = getView().getUserId();
        String password = getView().getPassword();
        RequestParams requestParams = LoginEmailUseCase.createRequestParams(userId, password);

        if(!Utils.isInternetOn()) {
            getView().showToast("Internet Not Available! Try Again");
            return;
        }
        getView().showProgressBar();
        loginEmailUseCase.execute(requestParams, new Subscriber<SessionValue>() {
            @Override
            public void onCompleted() {
                Intent i = new Intent(getView().getContext(), DashBoardActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_CLEAR_TASK |
                        Intent.FLAG_ACTIVITY_NEW_TASK);
                getView().startActivity(i);
                getView().hideProgressBar();
                getView().finish();
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                getView().hideProgressBar();
                if (e instanceof ResponseException) {
                    getView().showToast(e.getMessage());
                }
            }

            @Override
            public void onNext(SessionValue sessionValue) {

            }
        });
    }


}
