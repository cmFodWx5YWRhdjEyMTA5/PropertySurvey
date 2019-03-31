package com.softminesol.propertysurvey.survey.common.domain;

import com.softminesol.propertysurvey.survey.common.model.ColonyList;
import com.softminesol.propertysurvey.survey.common.model.PropertyTypes;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

/**
 * Created by sandeep on 6/5/18.
 */
public class SurveyGetPropertyTypeUseCase extends UseCase<PropertyTypes> {
    ISurveyOptionRepository repository;

    @Inject
    public SurveyGetPropertyTypeUseCase(ISurveyOptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<PropertyTypes> createObservable(RequestParams requestParams) {
        return repository.getPropertyType();
    }
}
