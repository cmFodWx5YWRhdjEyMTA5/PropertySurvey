package com.softminesol.propertysurvey.survey.common.domain;

import com.softminesol.propertysurvey.survey.common.model.RebateList;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

/**
 * Created by sandeep on 6/5/18.
 */
public class SurveyRebateUseCase extends UseCase<RebateList> {

    ISurveyOptionRepository repository;

    @Inject
    public SurveyRebateUseCase(ISurveyOptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<RebateList> createObservable(RequestParams requestParams) {
        return repository.getPropertyRebateList();
    }
}
