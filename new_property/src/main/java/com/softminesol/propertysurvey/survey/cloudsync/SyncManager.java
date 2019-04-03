package com.softminesol.propertysurvey.survey.cloudsync;


import com.softminesol.survey_framework.localcachesync.domain.NewApartmentUseCase;
import com.softminesol.survey_framework.localcachesync.domain.NewProperySyncUseCase;
import com.softminesol.survey_framework.survey.common.model.property.GetPropertySaveResponse;

import java.util.List;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;
import rx.functions.Func1;

public class SyncManager  extends UseCase<List<GetPropertySaveResponse>>{


    NewApartmentUseCase newApartmentUseCase;
    NewProperySyncUseCase newProperySyncUseCase;
    @Inject
    public SyncManager(NewApartmentUseCase newApartmentUseCase,
                       NewProperySyncUseCase newProperySyncUseCase) {
        this.newApartmentUseCase = newApartmentUseCase;
        this.newProperySyncUseCase = newProperySyncUseCase;
    }

    @Override
    public Observable<List<GetPropertySaveResponse>> createObservable(RequestParams requestParams) {
        return newProperySyncUseCase.createObservable(RequestParams.EMPTY).flatMap(new Func1<List<String>, Observable<List<GetPropertySaveResponse>>>() {
            @Override
            public Observable<List<GetPropertySaveResponse>> call(List<String> strings) {
                return newApartmentUseCase.createObservable(RequestParams.EMPTY);
            }
        });
    }
}
