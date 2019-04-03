package com.softminesol.survey_framework.survey.common.domain_luc;

import com.softminesol.survey_framework.survey.common.domain.ISurveyOptionRepository;
import com.softminesol.survey_framework.survey.common.model.PropertyTypes;
import com.tokopedia.usecase.RequestParams;
import com.tokopedia.usecase.UseCase;

import javax.inject.Inject;

import rx.Observable;

public class SurveyPropertyType extends UseCase<PropertyTypes> {
    ISurveyOptionRepository repository;
    @Inject
    public SurveyPropertyType(ISurveyOptionRepository repository) {
        this.repository = repository;
    }
    @Override
    public Observable<PropertyTypes> createObservable(RequestParams requestParams) {
        return repository.getPropertyType();
    }
}
