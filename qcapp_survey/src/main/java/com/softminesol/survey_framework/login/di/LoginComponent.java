package com.softminesol.survey_framework.login.di;

import com.softminesol.survey_framework.getToken.di.GetTokenModule;
import com.softminesol.survey_framework.login.view.LoginActivity;

import dagger.Component;
import frameworks.di.component.BaseAppComponent;

/**
 * Created by sandeepgoyal on 03/05/18.
 */
@LoginScope
@Component(modules = {GetTokenModule.class, LoginModule.class}, dependencies = BaseAppComponent.class)
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
