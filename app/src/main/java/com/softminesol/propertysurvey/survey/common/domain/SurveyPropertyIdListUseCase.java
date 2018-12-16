package com.softminesol.propertysurvey.survey.common.domain;

import com.softminesol.propertysurvey.survey.common.model.OLDPropertyUIDS;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

/**
 * Created by sandeepgoyal on 10/05/18.
 */

public class SurveyPropertyIdListUseCase extends UseCase<OLDPropertyUIDS> {
    private final ISurveyOptionRepository repository;

    @Inject
    public SurveyPropertyIdListUseCase(ISurveyOptionRepository repository) {
        this.repository = repository;
    }


    @Override
    public Observable<OLDPropertyUIDS> createObservable(RequestParams requestParams) {
        return repository.getPropertyIdList(requestParams.getString("query", ""));
    }
}
