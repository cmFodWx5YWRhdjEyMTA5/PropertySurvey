package com.softminesol.propertysurvey.survey.cloudsync.domain;

import com.softminesol.propertysurvey.survey.common.model.formData.FormData;
import com.softminesol.propertysurvey.survey.newPropertyEntry.domain.ISurveyFormSubmitRepository;

import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

public class SubmitCloudUseCase extends UseCase<BaseResponse>{
    ISurveyFormSubmitRepository iSurveyFormSubmitRepository;


    @Inject
    public SubmitCloudUseCase(ISurveyFormSubmitRepository iSurveyFormSubmitRepository) {
        this.iSurveyFormSubmitRepository = iSurveyFormSubmitRepository;
    }

    @Override
    public Observable<BaseResponse> createObservable(RequestParams requestParams)  {
        return iSurveyFormSubmitRepository.submitCloudNewProperty((FormData) requestParams.getObject("formData"));
    }
}
