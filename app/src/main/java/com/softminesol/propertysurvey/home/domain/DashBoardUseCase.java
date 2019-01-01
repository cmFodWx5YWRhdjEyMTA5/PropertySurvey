package com.softminesol.propertysurvey.home.domain;

import com.softminesol.propertysurvey.cachehandler.domain.BillCacheUseCase;
import com.softminesol.propertysurvey.cachehandler.domain.CacheCreateUseCase;
import com.softminesol.propertysurvey.rolebase.domain.RoleBaseUseCase;
import com.softminesol.propertysurvey.rolebase.model.RoleData;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;
import rx.functions.Func1;

public class DashBoardUseCase extends UseCase<RoleData>{

    private final BillCacheUseCase billCacheUseCase;
    RoleBaseUseCase roleBaseUseCase;
    CacheCreateUseCase cacheCreateUseCase;

    @Inject
    public DashBoardUseCase(CacheCreateUseCase cacheCreateUseCase, RoleBaseUseCase roleBaseUseCase, BillCacheUseCase billCacheUseCase) {
        this.roleBaseUseCase = roleBaseUseCase;
        this.cacheCreateUseCase = cacheCreateUseCase;
        this.billCacheUseCase = billCacheUseCase;
    }

    @Override
    public Observable<RoleData> createObservable(final RequestParams requestParams) {
        return cacheCreateUseCase.createObservable(requestParams).flatMap(new Func1<Boolean, Observable<Boolean>>() {
            @Override
            public Observable<Boolean> call(Boolean aBoolean) {
                return billCacheUseCase.createObservable(requestParams);
            }
        }).flatMap(new Func1<Boolean, Observable<RoleData>>() {
            @Override
            public Observable<RoleData> call(Boolean aBoolean) {
                return roleBaseUseCase.createObservable(requestParams);
            }
        });

    }
}
