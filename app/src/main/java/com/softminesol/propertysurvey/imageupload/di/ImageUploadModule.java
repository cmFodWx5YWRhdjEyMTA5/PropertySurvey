package com.softminesol.propertysurvey.imageupload.di;

import com.softminesol.propertysurvey.imageupload.data.net.ImageUploadAPI;
import com.softminesol.propertysurvey.imageupload.data.repository.ImageUploadRepository;
import com.softminesol.propertysurvey.imageupload.data.repository.datasource.ImageUploadFactory;
import com.softminesol.propertysurvey.imageupload.domain.IImageUploadRepository;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by sandeepgoyal on 13/05/18.
 */
@Module
public class ImageUploadModule {
    @Provides
    ImageUploadAPI provideLoginApi(Retrofit retrofit) {
        return retrofit.create(ImageUploadAPI.class);
    }

    @Provides
    IImageUploadRepository getImageUploadRepository(ImageUploadFactory imageUploadFactory) {
        return new ImageUploadRepository(imageUploadFactory);
    }
}
