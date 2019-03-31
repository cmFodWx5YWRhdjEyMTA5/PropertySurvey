package com.softminesol.propertysurvey.location.di;

import com.softminesol.propertysurvey.location.LocationUploadManager;

import dagger.Component;
import frameworks.di.component.BaseAppComponent;

@LocationUpdateScope
@Component(modules = {LocationUploadModule.class}, dependencies = BaseAppComponent.class)
public interface LocationUploadComponent {
    public void inject(LocationUploadManager locationUploadManager);
}