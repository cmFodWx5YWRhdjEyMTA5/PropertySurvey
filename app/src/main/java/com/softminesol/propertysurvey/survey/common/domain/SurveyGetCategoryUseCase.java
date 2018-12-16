package com.softminesol.propertysurvey.survey.common.domain;

import com.softminesol.propertysurvey.survey.common.model.PropertyCategoryList;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

/**
 * Created by sandeep on 6/5/18.
 */
public class SurveyGetCategoryUseCase extends UseCase<PropertyCategoryList> {
    ISurveyOptionRepository repository;

    @Inject
    public SurveyGetCategoryUseCase(ISurveyOptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<PropertyCategoryList> createObservable(RequestParams requestParams) {
        return repository.getPropertyCategory();
    }
}
