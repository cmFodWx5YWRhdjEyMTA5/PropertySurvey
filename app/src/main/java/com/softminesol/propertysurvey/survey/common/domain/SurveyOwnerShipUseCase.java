package com.softminesol.propertysurvey.survey.common.domain;

import com.softminesol.propertysurvey.survey.common.model.OwnerShipList;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

/**
 * Created by sandeepgoyal on 13/05/18.
 */

public class SurveyOwnerShipUseCase extends UseCase<OwnerShipList> {
    ISurveyOptionRepository repository;

    @Inject
    public SurveyOwnerShipUseCase(ISurveyOptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<OwnerShipList> createObservable(RequestParams requestParams) {
        return repository.getOwnerShipList();
    }
}
