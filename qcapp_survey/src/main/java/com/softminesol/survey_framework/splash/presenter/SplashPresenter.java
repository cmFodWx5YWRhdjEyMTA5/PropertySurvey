package com.softminesol.survey_framework.splash.presenter;

import android.content.Intent;

import com.softminesol.propertysurvey.home.view.DashBoardActivity;
import com.softminesol.survey_framework.login.view.LoginActivity;

import javax.inject.Inject;

import frameworks.appsession.AppSessionManager;
import frameworks.basemvp.AppBasePresenter;

/**
 * Created by sandeep on 6/5/18.
 */
public class SplashPresenter extends AppBasePresenter<SplashContract.View> implements SplashContract.Presenter {
    AppSessionManager appSessionManager;

    @Inject
    public SplashPresenter(AppSessionManager appSessionManager) {
        this.appSessionManager = appSessionManager;
    }

    @Override
    public void attachView(SplashContract.View view) {
        super.attachView(view);
        if (appSessionManager.isRunningSession()) {
            getView().startActivity(new Intent(getView().getContext(), DashBoardActivity.class));
        } else {
            getView().startActivity(new Intent(getView().getContext(), LoginActivity.class));
        }
        getView().finish();
    }


}
