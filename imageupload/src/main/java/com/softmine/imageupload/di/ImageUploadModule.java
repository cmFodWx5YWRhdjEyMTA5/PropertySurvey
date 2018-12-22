package com.softmine.imageupload.di;

import com.softmine.imageupload.data.net.ImageUploadAPI;
import com.softmine.imageupload.data.net.ImageUploadURL;
import com.softmine.imageupload.data.repository.ImageUploadRepository;
import com.softmine.imageupload.data.repository.datasource.ImageUploadFactory;
import com.softmine.imageupload.domain.IImageUploadRepository;

import dagger.Module;
import dagger.Provides;
import frameworks.network.interceptor.AppAuthInterceptor;
import frameworks.network.interceptor.AppBaseInterceptor;
import frameworks.network.interceptor.ErrorResponseInterceptor;
import frameworks.network.interceptor.UnsafeOkHttpClient;
import frameworks.network.model.BaseResponseError;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

@Module
public class ImageUploadModule {


    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient,
                             Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder.baseUrl(ImageUploadURL.BASE_URL).client(okHttpClient).build();
    }

    @Provides
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor,AppAuthInterceptor appAuthInterceptor) {
        return UnsafeOkHttpClient.getUnsafeOkHttpClient()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(new AppBaseInterceptor())
                .addInterceptor(appAuthInterceptor)
                .addInterceptor(new ErrorResponseInterceptor(BaseResponseError.class))
                .build();
    }



    @Provides
    @ImageUploadScope
    IImageUploadRepository getImageUploadRepository(ImageUploadFactory imageUploadFactory) {
        return new ImageUploadRepository(imageUploadFactory);
    }

    @Provides
    @ImageUploadScope
    ImageUploadAPI provideImageUploadApi(Retrofit retrofit) {
        return retrofit.create(ImageUploadAPI.class);
    }
}

