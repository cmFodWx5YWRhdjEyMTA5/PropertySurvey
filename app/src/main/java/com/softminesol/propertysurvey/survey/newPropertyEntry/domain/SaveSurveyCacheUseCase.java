package com.softminesol.propertysurvey.survey.newPropertyEntry.domain;

import com.softminesol.propertysurvey.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.propertysurvey.survey.common.model.property.SavePropertyRequest;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
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
