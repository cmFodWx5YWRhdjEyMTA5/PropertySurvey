package com.softminesol.propertysurvey.survey.common.domain_luc;

import com.softminesol.propertysurvey.survey.common.domain.ISurveyOptionRepository;
import com.softminesol.propertysurvey.survey.common.model.PropertyType;
import com.softminesol.propertysurvey.survey.common.model.PropertyTypes;
import com.tokopedia.usecase.RequestParams;
import com.tokopedia.usecase.UseCase;

import rx.Observable;

public class SurveyPropertyType extends UseCase<PropertyTypes> {
    ISurveyOptionRepository repository;
    public SurveyPropertyType(ISurveyOptionRepository repository) {
        this.repository = repository;
    }
    @Override
    public Observable<PropertyTypes> createObservable(RequestParams requestParams) {
        return repository.getPropertyType();
    }
}
