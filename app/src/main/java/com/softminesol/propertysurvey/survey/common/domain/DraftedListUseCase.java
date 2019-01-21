package com.softminesol.propertysurvey.survey.common.domain;

import com.softminesol.propertysurvey.survey.common.model.property.SavePropertyRequest;

import java.util.List;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

public class DraftedListUseCase extends UseCase<List<SavePropertyRequest>> {


    @Override
    public Observable<List<SavePropertyRequest>> createObservable(RequestParams requestParams) {
        return null;
    }
}
