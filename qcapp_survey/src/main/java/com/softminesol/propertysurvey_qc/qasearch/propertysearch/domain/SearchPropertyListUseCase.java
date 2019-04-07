package com.softminesol.propertysurvey_qc.qasearch.propertysearch.domain;

import com.softminesol.survey_framework.survey.common.model.apartment.SaveApartmentRequest;

import java.util.List;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

public class SearchPropertyListUseCase extends UseCase<List<SaveApartmentRequest>> {


    @Override
    public Observable<List<SaveApartmentRequest>> createObservable(RequestParams requestParams) {
        return null;
    }
}
