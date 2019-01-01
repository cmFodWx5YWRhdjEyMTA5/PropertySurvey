package com.softminesol.propertysurvey.cachehandler.domain;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

/**
 * Created by sandeepgoyal on 04/05/18.
 */

public class CacheCreateUseCase extends UseCase<Boolean> {

    ICacheDataRepository getTokenRepository;

    @Inject
    public CacheCreateUseCase(ICacheDataRepository getTokenRepository) {
        this.getTokenRepository = getTokenRepository;
    }

    @Override
    public Observable<Boolean> createObservable(RequestParams requestParams) {
        return getTokenRepository.getCacheandSave(requestParams,1);
    }
}
