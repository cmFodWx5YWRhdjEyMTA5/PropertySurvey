package com.softminesol.survey_framework.survey.common.domain;

import com.softminesol.survey_framework.survey.common.model.PropertySubCategoryList;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

/**
 * Created by sandeep on 6/5/18.
 */
public class SurveyGetSubCategoryUseCase extends UseCase<PropertySubCategoryList> {

    ISurveyOptionRepository repository;

    @Inject
    public SurveyGetSubCategoryUseCase(ISurveyOptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<PropertySubCategoryList> createObservable(RequestParams requestParams) {
        return Observable.just(new PropertySubCategoryList());
    }
}
