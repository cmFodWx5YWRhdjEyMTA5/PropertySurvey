package com.softminesol.propertysurvey.survey.distributionbill.domain;

import com.softminesol.propertysurvey.survey.common.domain.ISurveyOptionRepository;
import com.softminesol.propertysurvey.survey.common.model.OLDPropertyUIDS;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

public class BillDistributionPropertyIdListUseCase extends UseCase<OLDPropertyUIDS> {
    private final ISurveyOptionRepository repository;

    @Inject
    public BillDistributionPropertyIdListUseCase(ISurveyOptionRepository repository) {
        this.repository = repository;
    }


    @Override
    public Observable<OLDPropertyUIDS> createObservable(RequestParams requestParams) {
        return Observable.just(new OLDPropertyUIDS());
    }
}