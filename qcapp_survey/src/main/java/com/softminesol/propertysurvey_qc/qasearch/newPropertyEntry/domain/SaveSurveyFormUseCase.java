package com.softminesol.propertysurvey_qc.qasearch.newPropertyEntry.domain;


import com.softminesol.survey_framework.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.survey_framework.survey.common.model.property.SavePropertyRequest;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;


/**
 * Created by sandeep on 13/5/18.
 */
public class SaveSurveyFormUseCase extends UseCase<GetPropertySaveResponse> {

    ISurveyFormSaveRepository surveyFormSubmitRepository;

    @Inject
    public SaveSurveyFormUseCase(ISurveyFormSaveRepository surveyFormSubmitRepository) {
        this.surveyFormSubmitRepository = surveyFormSubmitRepository;
    }


    public RequestParams createRequestParams(SavePropertyRequest savePropertyRequest) {
        RequestParams requestParams = RequestParams.create();
        requestParams.putObject("formdata",savePropertyRequest);
        return requestParams;
    }
    @Override
    public Observable<GetPropertySaveResponse> createObservable(final RequestParams requestParams) {

        final SavePropertyRequest formData = (SavePropertyRequest) requestParams.getObject("formdata");
        return surveyFormSubmitRepository.submitCloudNewProperty(formData);
      }

}
