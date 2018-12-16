package com.softminesol.propertysurvey.survey.common.domain;

import com.softminesol.propertysurvey.survey.common.model.UsageList;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

/**
 * Created by sandeep on 6/5/18.
 */
public class SurveyUsageListUseCase extends UseCase<UsageList> {

    ISurveyOptionRepository repository;

    @Inject
    public SurveyUsageListUseCase(ISurveyOptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<UsageList> createObservable(RequestParams requestParams) {
        return repository.getUsageList();
    }
}
