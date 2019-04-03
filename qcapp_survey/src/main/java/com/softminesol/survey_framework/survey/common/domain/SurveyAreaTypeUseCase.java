package com.softminesol.survey_framework.survey.common.domain;

import com.softminesol.survey_framework.survey.common.model.AreaType;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

/**
 * Created by sandeep on 7/5/18.
 */
public class SurveyAreaTypeUseCase extends UseCase<AreaType> {
    private final ISurveyOptionRepository repository;

    @Inject
    public SurveyAreaTypeUseCase(ISurveyOptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<AreaType> createObservable(RequestParams requestParams) {
        return Observable.just(new AreaType());
    }
}
