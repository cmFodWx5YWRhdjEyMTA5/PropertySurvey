package com.softminesol.survey_framework.getToken.di;

import com.softminesol.survey_framework.getToken.data.interceptor.GetTokenInterceptor;
import com.softminesol.survey_framework.getToken.data.net.LoginAPI;
import com.softminesol.survey_framework.getToken.data.net.LoginAPIURL;
import com.softminesol.survey_framework.getToken.data.repository.GetTokenDataRepository;
import com.softminesol.survey_framework.getToken.data.repository.datasource.GetTokenCloudDataSource;
import com.softminesol.survey_framework.getToken.data.repository.datasource.GetTokenDataFactory;
import com.softminesol.survey_framework.getToken.domain.IGetTokenRepository;

import dagger.Module;
import dagger.Provides;
import frameworks.appsession.AppSessionManager;
import frameworks.network.interceptor.ErrorResponseInterceptor;
import frameworks.network.model.BaseResponseError;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * Created by sandeep on 5/5/18.
 */
@Module
public class GetTokenModule {
    @Provides
    LoginAPI provideLoginApi(Retrofit retrofit) {
        return retrofit.create(LoginAPI.class);
    }

    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient,
                             Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder.baseUrl(LoginAPIURL.BASE_URL).client(okHttpClient).build();
    }

    @Provides
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(new GetTokenInterceptor())
                .addInterceptor(new ErrorResponseInterceptor(BaseResponseError.class))
                .build();
    }

    @Provides
    IGetTokenRepository getTokenRepository(GetTokenDataFactory getTokenDataFactory) {
        return new GetTokenDataRepository(getTokenDataFactory);
    }

    @Provides
    GetTokenDataFactory getTokenDataFactory(GetTokenCloudDataSource getTokenCloudDataSource) {
        return new GetTokenDataFactory(getTokenCloudDataSource);
    }

    @Provides
    GetTokenCloudDataSource getTokenCloudDataSource(LoginAPI loginAPI, AppSessionManager appSessionManager) {
        return new GetTokenCloudDataSource(loginAPI, appSessionManager);
    }


}
