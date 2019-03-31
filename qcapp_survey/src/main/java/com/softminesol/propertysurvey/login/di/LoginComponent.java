package com.softminesol.propertysurvey.login.di;

import com.softminesol.propertysurvey.getToken.di.GetTokenModule;
import com.softminesol.propertysurvey.login.view.LoginActivity;

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
