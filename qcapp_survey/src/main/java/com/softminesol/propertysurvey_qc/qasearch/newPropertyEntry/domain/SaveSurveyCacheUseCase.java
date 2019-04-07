package com.softminesol.propertysurvey_qc.qasearch.newPropertyEntry.domain;

import com.softminesol.survey_framework.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.survey_framework.survey.common.model.property.SavePropertyRequest;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import rx.Observable;

public class SaveSurveyCacheUseCase  extends SaveSurveyFormUseCase {

    ISurveyFormSaveRepository surveyFormSubmitRepository;

    @Inject
    public SaveSurveyCacheUseCase(ISurveyFormSaveRepository surveyFormSubmitRepository) {
        super(surveyFormSubmitRepository);
        this.surveyFormSubmitRepository = surveyFormSubmitRepository;
    }


    @Override
    public Observable<GetPropertySaveResponse> createObservable(final RequestParams requestParams) {
        final SavePropertyRequest formData = (SavePropertyRequest) requestParams.getObject("formdata");
        return surveyFormSubmitRepository.submitCacheNewProperty(formData);
    }

}
