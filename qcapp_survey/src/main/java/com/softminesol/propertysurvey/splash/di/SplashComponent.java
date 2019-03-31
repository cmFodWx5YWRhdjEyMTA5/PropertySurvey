package com.softminesol.propertysurvey.splash.di;

import com.softminesol.propertysurvey.splash.view.SplashActivity;

import dagger.Component;
import frameworks.di.component.BaseAppComponent;

@SplashScope
@Component(dependencies = BaseAppComponent.class)
public interface SplashComponent {
    void inject(SplashActivity splashActivity);
}