package com.softminesol.propertysurvey.cachehandler.domain;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

public class BillCacheUseCase extends UseCase<Boolean> {

    ICacheDataRepository getTokenRepository;

    @Inject
    public BillCacheUseCase(ICacheDataRepository getTokenRepository) {
        this.getTokenRepository = getTokenRepository;
    }

    @Override
    public Observable<Boolean> createObservable(RequestParams requestParams) {
        return getTokenRepository.getBillDetailandSave(1);
    }
}
