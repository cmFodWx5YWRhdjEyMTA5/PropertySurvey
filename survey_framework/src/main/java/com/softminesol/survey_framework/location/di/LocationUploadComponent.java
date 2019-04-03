package com.softminesol.survey_framework.location.di;

import com.softminesol.survey_framework.location.LocationUploadManager;

import dagger.Component;
import frameworks.di.component.BaseAppComponent;

@LocationUpdateScope
@Component(modules = {LocationUploadModule.class}, dependencies = BaseAppComponent.class)
public interface LocationUploadComponent {
    public void inject(LocationUploadManager locationUploadManager);
}