package com.softminesol.survey_framework.splash.presenter;

import android.content.Intent;

import com.softminesol.survey_framework.login.view.LoginActivity;

import javax.inject.Inject;

import frameworks.appsession.AppSessionManager;
import frameworks.basemvp.AppBasePresenter;
import routers.IHomeRouter;
import routers.IRouterProducer;

import static frameworks.AppBaseApplication.getApplication;

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
            IHomeRouter homeRouter = ((IRouterProducer)(getApplication())).getHomeRouter();
            getView().startActivity(homeRouter.getHomeIntent(getView().getContext()));
        } else {
            getView().startActivity(new Intent(getView().getContext(), LoginActivity.class));
        }
        getView().finish();
    }


}
