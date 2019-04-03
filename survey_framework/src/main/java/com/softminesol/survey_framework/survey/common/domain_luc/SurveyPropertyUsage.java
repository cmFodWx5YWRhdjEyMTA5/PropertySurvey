package com.softminesol.survey_framework.survey.common.domain_luc;

import com.softminesol.survey_framework.survey.common.domain.ISurveyOptionRepository;
import com.softminesol.survey_framework.survey.common.model.newmodel.PropertyUsage;
import com.tokopedia.usecase.RequestParams;
import com.tokopedia.usecase.UseCase;

import javax.inject.Inject;

import rx.Observable;

public class SurveyPropertyUsage extends UseCase<PropertyUsage> {
    ISurveyOptionRepository repository;
    @Inject
    public SurveyPropertyUsage(ISurveyOptionRepository repository) {
        this.repository = repository;
    }
    @Override
    public Observable<PropertyUsage> createObservable(RequestParams requestParams) {
        return repository.getPropertyUsage();
    }
}
