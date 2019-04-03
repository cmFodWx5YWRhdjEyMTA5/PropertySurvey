package com.softminesol.survey_framework.login.view;

import android.location.Location;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.softminesol.propertysurvey.R;
import com.softminesol.propertysurvey.SurveyAppApplication;
import com.softminesol.survey_framework.login.di.DaggerLoginComponent;
import com.softminesol.survey_framework.login.di.LoginComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import frameworks.basemvp.AppBaseActivity;
import frameworks.di.component.HasComponent;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppBaseActivity<ILoginViewContractor.Presenter> implements ILoginViewContractor.View, HasComponent<LoginComponent> {
    @Inject
    LoginPresenter presenter;


    @BindView(R.id.email)
    AutoCompleteTextView email;
    @BindView(R.id.password)
    EditText password;
    LoginComponent loginComponent;


    @Override
    protected void initInjector() {
        loginComponent = DaggerLoginComponent.builder().baseAppComponent(((SurveyAppApplication) getApplication()).getBaseAppComponent()).build();
        loginComponent.inject(this);
    }

    @Override
    public int getViewToCreate() {
        return R.layout.activity_login;
    }

    @Override
    public ILoginViewContractor.Presenter getPresenter() {
        return presenter;
    }

    @Override
    public String getUserId() {
        return email.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }


    @OnClick(R.id.email_sign_in_button)
    public void onViewClicked() {
        getPresenter().onLoginClick();
    }

    @Override
    public LoginComponent getComponent() {
        if (loginComponent == null)
            initInjector();
        return loginComponent;
    }

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

