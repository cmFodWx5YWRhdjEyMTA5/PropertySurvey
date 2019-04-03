package com.softminesol.survey_framework.location.di;

import com.softminesol.survey_framework.location.data.net.LocationUploadAPI;
import com.softminesol.survey_framework.location.data.repository.LocationUploadRepository;
import com.softminesol.survey_framework.location.data.repository.datasource.LocationUploadFactory;
import com.softminesol.survey_framework.location.domain.ILocationUploadRepository;
import com.softminesol.survey_framework.survey.common.net.SurveyAPIURL;

import dagger.Module;
import dagger.Provides;
import frameworks.network.interceptor.AppAuthInterceptor;
import frameworks.network.interceptor.ErrorResponseInterceptor;
import frameworks.network.model.BaseResponseError;
import frameworks.utils.GsonFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sandeepgoyal on 13/05/18.
 */
@Module
public class LocationUploadModule {
    @Provides
    LocationUploadAPI provideLoginApi(Retrofit retrofit) {
        return retrofit.create(LocationUploadAPI.class);
    }

    @Provides
    ILocationUploadRepository getLocationUpdateRepository(LocationUploadFactory imageUploadFactory) {
        return new LocationUploadRepository(imageUploadFactory);
    }

    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient,
                             Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder.baseUrl(SurveyAPIURL.BASE_URL).addConverterFactory(GsonConverterFactory.create(GsonFactory.getGson())).client(okHttpClient).build();
    }

    @Provides
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, AppAuthInterceptor appAuthInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(appAuthInterceptor)
                .addInterceptor(new ErrorResponseInterceptor(BaseResponseError.class))
                .build();
    }
}
