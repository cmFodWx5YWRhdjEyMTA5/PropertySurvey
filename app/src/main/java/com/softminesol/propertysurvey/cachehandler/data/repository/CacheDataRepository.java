package com.softminesol.propertysurvey.cachehandler.data.repository;

import com.softminesol.propertysurvey.cachehandler.data.repository.datasource.CacheDataFactory;
import com.softminesol.propertysurvey.cachehandler.domain.ICacheDataRepository;
import com.softminesol.propertysurvey.cachehandler.model.BillCacheResponse;
import com.softminesol.propertysurvey.cachehandler.model.PropertyCacheResponse;
import com.softminesol.propertysurvey.survey.common.model.formData.FormData;
import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetails;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import frameworks.appsession.AppSessionManager;
import frameworks.appsession.SessionValue;
import frameworks.network.Utils;
import frameworks.network.usecases.RequestParams;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by sandeep on 4/5/18.
 */
public class CacheDataRepository implements ICacheDataRepository {

    private final AppSessionManager sessionValue;
    CacheDataFactory getTokenDataFactory;

    @Inject
    public CacheDataRepository(CacheDataFactory getTokenDataFactory, AppSessionManager sessionValue) {
        this.getTokenDataFactory = getTokenDataFactory;
        this.sessionValue = sessionValue;

    }


    @Override
    public Observable<Boolean> getCacheandSave(final RequestParams requestParams, final int page) {
        return getTokenDataFactory.getCacheLocalDataSource().isDataExist().flatMap(new Func1<Boolean, Observable<Boolean>>() {
            @Override
            public Observable<Boolean> call(Boolean aBoolean) {
                if(aBoolean.booleanValue()) {
                    return Observable.just(aBoolean);
                }
                return getCacheandSave(page);
            }
        });
    }

    public Observable<Boolean> getCacheandSave(final int page) {
        return getTokenDataFactory.getCacheCloudDataSource().getAssignedData(page).doOnNext(new Action1<PropertyCacheResponse>() {
            @Override
            public void call(PropertyCacheResponse propertyCacheResponse) {
                saveData(propertyCacheResponse.getProperty());
            }
        }).flatMap(new Func1<PropertyCacheResponse, Observable<Boolean>>() {
            @Override
            public Observable<Boolean> call(PropertyCacheResponse formData) {
                if (formData.getPageCount() > page) {
                    int i = page + 1;
                    return CacheDataRepository.this.getCacheandSave(i);
                } else
                    return Observable.just(true);
            }
        }).onErrorResumeNext(new Func1<Throwable, Observable<Boolean>>() {
            @Override
            public Observable<Boolean> call(Throwable throwable) {
                if (Utils.isInternetOn()) {
                    if (sessionValue.isRunningSession()) {
                        getTokenDataFactory.getCacheLocalDataSource().clearCache();
                        return getCacheandSave(page).delay(5, TimeUnit.SECONDS);
                    }
                    return Observable.error(new Throwable("Please Login Again"));
                } else {
                    return Observable.error(new Throwable("Internet Not Available Try Again"));
                }
            }
        });
    }


    @Override
    public Observable<Boolean> getBillDetailandSave(final int page) {
        return getTokenDataFactory.getCacheLocalDataSource().isBillingDetailExist().flatMap(new Func1<Boolean, Observable<Boolean>>() {
            @Override
            public Observable<Boolean> call(Boolean aBoolean) {
                if(aBoolean.booleanValue() && sessionValue.getSession() != null) {
                    return Observable.just(aBoolean);
                }
              return getBillDetailAndSavePage(page);
            }
        });
    }

    public Observable<Boolean> getBillDetailAndSavePage(final int page) {
        return getTokenDataFactory.getCacheCloudDataSource().getAssignedDistributionData(page).doOnNext(new Action1<BillCacheResponse>() {
            @Override
            public void call(BillCacheResponse billCacheResponse) {
                saveBillDetails(billCacheResponse.getBillDetails());
            }
        }).flatMap(new Func1<BillCacheResponse, Observable<Boolean>>() {
            @Override
            public Observable<Boolean> call(BillCacheResponse cacheDataRepository) {
                if(cacheDataRepository.getPageCount()> page) {
                    int i  = page +1;
                    return CacheDataRepository.this.getBillDetailAndSavePage(i);
                }
                return Observable.just(true);
            }
        }).onErrorResumeNext(new Func1<Throwable, Observable<Boolean>>() {
            @Override
            public Observable<Boolean> call(Throwable throwable) {
                if (Utils.isInternetOn()) {
                    if (sessionValue.isRunningSession()) {
                        getTokenDataFactory.getCacheLocalDataSource().clearCache();
                        return getBillDetailAndSavePage(page).delay(5, TimeUnit.SECONDS);
                    }
                    return Observable.error(new Throwable("Please Login Again"));
                } else {
                    return Observable.error(new Throwable("Internet Not Available, Try Again"));
                }

            }
        });

    }



    private Boolean saveBillDetails(List<BillDetails> billDetail) {
        return getTokenDataFactory.getCacheLocalDataSource().saveBillingDetails(billDetail);
    }

    Boolean saveData(List<FormData> formData) {
        return getTokenDataFactory.getCacheLocalDataSource().saveDataStore(formData);
    }
}
