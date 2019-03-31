package com.softminesol.propertysurvey.survey.common.domain_luc;

import com.softminesol.propertysurvey.survey.common.domain.ISurveyOptionRepository;
import com.softminesol.propertysurvey.survey.common.model.PropertyType;
import com.softminesol.propertysurvey.survey.common.model.newmodel.Floors;
import com.tokopedia.usecase.RequestParams;
import com.tokopedia.usecase.UseCase;

import javax.inject.Inject;

import rx.Observable;

public class SurveyFloor extends UseCase<Floors> {
    ISurveyOptionRepository repository;
    @Inject
    public SurveyFloor(ISurveyOptionRepository repository) {
        this.repository = repository;
    }
    @Override
    public Observable<Floors> createObservable(RequestParams requestParams) {
        return repository.getFloors();
    }
}
