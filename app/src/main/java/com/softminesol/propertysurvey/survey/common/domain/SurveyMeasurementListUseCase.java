package com.softminesol.propertysurvey.survey.common.domain;

import com.softminesol.propertysurvey.survey.common.model.MeasurementUnitList;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

/**
 * Created by sandeep on 6/5/18.
 */
public class SurveyMeasurementListUseCase extends UseCase<MeasurementUnitList> {
    ISurveyOptionRepository repository;

    @Inject
    public SurveyMeasurementListUseCase(ISurveyOptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<MeasurementUnitList> createObservable(RequestParams requestParams) {
        return repository.getMeasurementList();
    }
}
