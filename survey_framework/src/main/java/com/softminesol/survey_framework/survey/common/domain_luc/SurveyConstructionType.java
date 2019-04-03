package com.softminesol.survey_framework.survey.common.domain_luc;

import com.softminesol.survey_framework.survey.common.domain.ISurveyOptionRepository;
import com.softminesol.survey_framework.survey.common.model.newmodel.ConstructionType;
import com.tokopedia.usecase.RequestParams;
import com.tokopedia.usecase.UseCase;

import javax.inject.Inject;

import rx.Observable;

public class SurveyConstructionType extends UseCase<ConstructionType> {
    ISurveyOptionRepository repository;
    @Inject
    public SurveyConstructionType(ISurveyOptionRepository repository) {
        this.repository = repository;
    }
    @Override
    public Observable<ConstructionType> createObservable(RequestParams requestParams) {
        return repository.getConstructionType();
    }
}
