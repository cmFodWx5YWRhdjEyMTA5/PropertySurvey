package com.softmine.imageupload.di;

import com.softmine.imageupload.service.ImagesUploadService;
import com.softmine.imageupload.view.ImageUploadActivity;

import dagger.Component;
import frameworks.di.component.BaseAppComponent;

@ImageUploadScope
@Component(modules = {ImageUploadModule.class}, dependencies = BaseAppComponent.class)
public interface ImageUploadComponent {


    void inject(ImageUploadActivity imageUploadActivity);
    void inject(ImagesUploadService imagesUploadService);
}
