package com.softminesol.survey_framework.survey.common.domain_luc;

import com.softminesol.survey_framework.survey.common.domain.ISurveyOptionRepository;
import com.softminesol.survey_framework.survey.common.model.newmodel.NonResidentalCategory;
import com.tokopedia.usecase.RequestParams;
import com.tokopedia.usecase.UseCase;

import javax.inject.Inject;

import rx.Observable;

public class SurveyNonResidentCategory extends UseCase<NonResidentalCategory> {
    ISurveyOptionRepository repository;
    @Inject
    public SurveyNonResidentCategory(ISurveyOptionRepository repository) {
        this.repository = repository;
    }
    @Override
    public Observable<NonResidentalCategory> createObservable(RequestParams requestParams) {
        return repository.getNonResidentalCategory();
    }
}
