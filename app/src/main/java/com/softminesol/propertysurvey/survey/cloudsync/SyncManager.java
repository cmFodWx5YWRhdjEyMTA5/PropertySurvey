package com.softminesol.propertysurvey.survey.cloudsync;


import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;
import rx.functions.Func1;

public class SyncManager  extends UseCase<BaseResponse>{

    NewFormSync newFormSync;
    OldFormSync oldFormSync;
    DistributionFormSync distributionFormSync;

    @Inject
    public SyncManager(NewFormSync newFormSync, OldFormSync oldFormSync, DistributionFormSync distributionFormSync) {
        this.newFormSync = newFormSync;
        this.oldFormSync = oldFormSync;
        this.distributionFormSync = distributionFormSync;
    }

    @Override
    public Observable<BaseResponse> createObservable(RequestParams requestParams) {
        return newFormSync.createObservable(RequestParams.EMPTY).flatMap(new Func1<BaseResponse, Observable<BaseResponse>>() {
            @Override
            public Observable<BaseResponse> call(BaseResponse baseResponse) {
                return oldFormSync.createObservable(RequestParams.EMPTY).flatMap(new Func1<BaseResponse, Observable<BaseResponse>>() {
                    @Override
                    public Observable<BaseResponse> call(BaseResponse baseResponse) {
                        return distributionFormSync.createObservable(RequestParams.EMPTY).map(new Func1<BaseResponse, BaseResponse>() {
                            @Override
                            public BaseResponse call(BaseResponse baseResponse) {
                                return baseResponse;
                            }
                        });
                    }
                });
            }
        });
    }
}
