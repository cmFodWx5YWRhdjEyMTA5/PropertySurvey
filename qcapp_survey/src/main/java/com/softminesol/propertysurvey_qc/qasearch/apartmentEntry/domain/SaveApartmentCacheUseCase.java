package com.softminesol.propertysurvey_qc.qasearch.apartmentEntry.domain;

import com.softmine.imageupload.domain.ImageUploadUseCase;
import com.softminesol.survey_framework.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.survey_framework.survey.common.model.property.GetPropertySaveResponse;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import rx.Observable;

public class SaveApartmentCacheUseCase extends SaveApartmentSurveyFormUseCase {

    @Inject
    public SaveApartmentCacheUseCase(IApartmentSurveyFormSaveRepository iApartmentSurveyFormSaveRepository, ImageUploadUseCase imageUploadUseCase) {
        super(iApartmentSurveyFormSaveRepository, imageUploadUseCase);

    }

    @Override
    public Observable<GetPropertySaveResponse> createObservable(final RequestParams requestParams) {
        final SaveApartmentRequest formData = (SaveApartmentRequest) requestParams.getObject("formdata");
        return iApartmentSurveyFormSaveRepository.submitCacheNewApartment(formData);
    }
}
