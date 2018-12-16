package com.softminesol.propertysurvey.cachehandler.data.repository.datasource;

import com.softminesol.propertysurvey.cachehandler.data.net.CacheGetterAPI;

import javax.inject.Inject;

import frameworks.appsession.SessionValue;
import frameworks.network.usecases.RequestParams;
import rx.Observable;

/**
 * Created by sandeep on 5/5/18.
 */
public class CacheDataFactory {

    private final CacheLocalDataStore cacheLocalDataStore;
    CacheGetterAPI cacheGetterAPI;
    @Inject
    public CacheDataFactory(CacheGetterAPI cacheGetterAPI,CacheLocalDataStore cacheLocalDataStore) {
        this.cacheGetterAPI = cacheGetterAPI;
        this.cacheLocalDataStore = cacheLocalDataStore;
    }

    public CacheCloudDataStore getCacheCloudDataSource() {
         return new CacheCloudDataStore(cacheGetterAPI);
    }

    public CacheLocalDataStore getCacheLocalDataSource() {
        return cacheLocalDataStore;
    }
}
