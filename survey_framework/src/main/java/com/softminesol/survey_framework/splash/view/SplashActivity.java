package com.softminesol.survey_framework.splash.view;

import android.location.Location;

import com.softminesol.survey_framework.R;
import com.softminesol.survey_framework.SurveyAppApplication;
import com.softminesol.survey_framework.splash.di.DaggerSplashComponent;
import com.softminesol.survey_framework.splash.di.SplashComponent;
import com.softminesol.survey_framework.splash.presenter.SplashContract;
import com.softminesol.survey_framework.splash.presenter.SplashPresenter;

import javax.inject.Inject;

import frameworks.basemvp.AppBaseActivity;

/**
 * Created by sandeep on 6/5/18.
 */
public class SplashActivity extends AppBaseActivity<SplashContract.Presenter> implements SplashContract.View {


    @Inject
    SplashPresenter presenter;

    @Override
    protected void initInjector() {
        SplashComponent splashComponent = DaggerSplashComponent.builder().baseAppComponent(((SurveyAppApplication) getApplication()).getBaseAppComponent()).build();
        splashComponent.inject(this);
    }

    @Override
    public int getViewToCreate() {
        return R.layout.activity_splash_layout;
    }

    @Override
    public SplashContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    public boolean isLocationNeeded() {
        return false;
    }

    @Override
    public void onLocationPermissionGranted() {

    }

    @Override
    public void onLocationPermissionDenied() {

    }

    @Override
    public void onLocationSettingEnabled() {

    }

    @Override
    public void onLocationSettingEnableDenied() {

    }

    @Override
    public void onLocationChanged(Location location) {

    }
}
