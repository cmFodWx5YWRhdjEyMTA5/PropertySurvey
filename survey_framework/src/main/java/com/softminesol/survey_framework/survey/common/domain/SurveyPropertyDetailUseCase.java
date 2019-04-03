package com.softminesol.survey_framework.survey.common.domain;

import com.softminesol.survey_framework.survey.common.model.formData.FormData;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

/**
 * Created by sandeepgoyal on 10/05/18.
 */

public class SurveyPropertyDetailUseCase extends UseCase<FormData> {

    private final ISurveyOptionRepository repository;

    @Inject
    public SurveyPropertyDetailUseCase(ISurveyOptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<FormData> createObservable(RequestParams requestParams) {
        return null;
    }
}
