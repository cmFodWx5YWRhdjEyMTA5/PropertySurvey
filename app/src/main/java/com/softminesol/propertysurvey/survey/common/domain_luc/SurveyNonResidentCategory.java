package com.softminesol.propertysurvey.survey.common.domain_luc;

import com.softminesol.propertysurvey.survey.common.domain.ISurveyOptionRepository;
import com.softminesol.propertysurvey.survey.common.model.PropertyType;
import com.softminesol.propertysurvey.survey.common.model.newmodel.NonResidentalCategory;
import com.tokopedia.usecase.RequestParams;
import com.tokopedia.usecase.UseCase;

import rx.Observable;

public class SurveyNonResidentCategory extends UseCase<NonResidentalCategory> {
    ISurveyOptionRepository repository;
    public SurveyNonResidentCategory(ISurveyOptionRepository repository) {
        this.repository = repository;
    }
    @Override
    public Observable<NonResidentalCategory> createObservable(RequestParams requestParams) {
        return repository.getNonResidentalCategory();
    }
}
