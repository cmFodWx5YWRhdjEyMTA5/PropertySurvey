package com.softminesol.propertysurvey.survey.common.domain_luc;

import com.softminesol.propertysurvey.survey.common.domain.ISurveyOptionRepository;
import com.softminesol.propertysurvey.survey.common.model.PropertyType;
import com.softminesol.propertysurvey.survey.common.model.newmodel.PropertyUsage;
import com.tokopedia.usecase.RequestParams;
import com.tokopedia.usecase.UseCase;

import rx.Observable;

public class SurveyPropertyUsage extends UseCase<PropertyUsage> {
    ISurveyOptionRepository repository;
    public SurveyPropertyUsage(ISurveyOptionRepository repository) {
        this.repository = repository;
    }
    @Override
    public Observable<PropertyUsage> createObservable(RequestParams requestParams) {
        return repository.getPropertyUsage();
    }
}
