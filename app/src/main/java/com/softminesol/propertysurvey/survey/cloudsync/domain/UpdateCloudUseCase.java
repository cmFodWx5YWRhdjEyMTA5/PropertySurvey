package com.softminesol.propertysurvey.survey.cloudsync.domain;

import com.softminesol.propertysurvey.survey.common.model.formData.FormData;
import com.softminesol.propertysurvey.survey.updatePropertyEntry.domain.ISurveyFormUpdateRepository;

import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

public class UpdateCloudUseCase extends UseCase<BaseResponse> {
    ISurveyFormUpdateRepository iSurveyFormUpdateRepository;

    @Inject
    public UpdateCloudUseCase(ISurveyFormUpdateRepository iSurveyFormUpdateRepository) {
        this.iSurveyFormUpdateRepository = iSurveyFormUpdateRepository;
    }

    @Override
    public Observable<BaseResponse> createObservable(RequestParams requestParams)  {
        return iSurveyFormUpdateRepository.updatePropertyOnCloud((FormData) requestParams.getObject("formData"));
    }
}
