package com.softminesol.propertysurvey.survey.common.domain;

import com.softminesol.propertysurvey.survey.common.model.formData.FormData;
import com.softminesol.propertysurvey.survey.common.model.property.SavePropertyRequest;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

/**
 * Created by sandeepgoyal on 14/05/18.
 */

public class GetPropertyInfoUseCase extends UseCase<SavePropertyRequest> {
    ISurveyOptionRepository repository;

    @Inject
    public GetPropertyInfoUseCase(ISurveyOptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<SavePropertyRequest> createObservable(RequestParams requestParams) {
        return repository.getSavePropertyRequestData(requestParams.getString("query", ""));
    }
}
