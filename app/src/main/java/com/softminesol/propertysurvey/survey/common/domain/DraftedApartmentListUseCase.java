package com.softminesol.propertysurvey.survey.common.domain;

import com.softminesol.propertysurvey.survey.common.model.apartment.SaveApartmentRequest;

import java.util.List;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

public class DraftedApartmentListUseCase extends UseCase<List<SaveApartmentRequest>> {


    @Override
    public Observable<List<SaveApartmentRequest>> createObservable(RequestParams requestParams) {
        return null;
    }
}
