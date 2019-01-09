package com.softminesol.propertysurvey.survey.common.domain;

import com.softminesol.propertysurvey.survey.common.model.AreaType;
import com.softminesol.propertysurvey.survey.common.model.ColonyList;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

/**
 * Created by sandeep on 6/5/18.
 */
public class SurveyColonyListUseCase extends UseCase<ColonyList> {

    ISurveyOptionRepository repository;

    @Inject
    public SurveyColonyListUseCase(ISurveyOptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<ColonyList> createObservable(RequestParams requestParams) {
         return Observable.just(new ColonyList());
    }
}
