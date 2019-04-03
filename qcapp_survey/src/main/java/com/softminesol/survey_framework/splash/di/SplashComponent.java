package com.softminesol.survey_framework.splash.di;

import com.softminesol.survey_framework.splash.view.SplashActivity;

import dagger.Component;
import frameworks.di.component.BaseAppComponent;

@SplashScope
@Component(dependencies = BaseAppComponent.class)
public interface SplashComponent {
    void inject(SplashActivity splashActivity);
}