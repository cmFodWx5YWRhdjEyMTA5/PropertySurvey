package com.softminesol.propertysurvey.survey.common.domain;

import com.softminesol.propertysurvey.survey.common.model.ColonyList;
import com.softminesol.propertysurvey.survey.common.model.FloorsList;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

/**
 * Created by sandeep on 8/5/18.
 */
public class SurveyFloorListUseCase extends UseCase<FloorsList> {

    ISurveyOptionRepository repository;

    @Inject
    public SurveyFloorListUseCase(ISurveyOptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<FloorsList> createObservable(RequestParams requestParams) {
        return Observable.just(new FloorsList());
    }
}
