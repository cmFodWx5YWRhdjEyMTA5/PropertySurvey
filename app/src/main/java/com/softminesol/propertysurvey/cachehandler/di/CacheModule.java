package com.softminesol.propertysurvey.cachehandler.di;

import com.softminesol.propertysurvey.cachehandler.data.net.CacheGetterAPI;
import com.softminesol.propertysurvey.cachehandler.data.repository.CacheDataRepository;
import com.softminesol.propertysurvey.cachehandler.data.repository.datasource.CacheDataFactory;
import com.softminesol.propertysurvey.cachehandler.domain.ICacheDataRepository;

import dagger.Module;
import dagger.Provides;
import frameworks.appsession.AppSessionManager;
import retrofit2.Retrofit;

/**
 * Created by sandeep on 5/5/18.
 */
@Module
public class CacheModule {
    @Provides
    CacheGetterAPI provideLoginApi(Retrofit retrofit) {
        return retrofit.create(CacheGetterAPI.class);
    }

    @Provides
    ICacheDataRepository getTokenRepository(CacheDataFactory getTokenDataFactory, AppSessionManager sessionValue) {
        return new CacheDataRepository(getTokenDataFactory,sessionValue);
    }

}
