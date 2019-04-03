package com.softminesol.survey_framework.survey.common.domain;

import com.softminesol.survey_framework.survey.common.model.ConstructionType;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

/**
 * Created by sandeep on 7/5/18.
 */
public class SurveyConstructionTypeUseCase extends UseCase<ConstructionType> {
    ISurveyOptionRepository repository;

    @Inject
    public SurveyConstructionTypeUseCase(ISurveyOptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<ConstructionType> createObservable(RequestParams requestParams) {
        return Observable.just(new ConstructionType());
    }
}
