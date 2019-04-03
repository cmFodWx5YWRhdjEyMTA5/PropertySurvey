package com.softminesol.propertysurvey.survey.apartmentEntry.domain;

import com.softmine.imageupload.domain.ImageUploadUseCase;
import com.softminesol.survey_framework.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.survey_framework.survey.common.model.property.GetPropertySaveResponse;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

/**
 * Created by sandeep on 13/5/18.
 */
public class SaveApartmentSurveyFormUseCase extends UseCase<GetPropertySaveResponse> {

    private final ImageUploadUseCase imageUploadUseCase;
    IApartmentSurveyFormSaveRepository iApartmentSurveyFormSaveRepository;

    @Inject
    public SaveApartmentSurveyFormUseCase(IApartmentSurveyFormSaveRepository iApartmentSurveyFormSaveRepository, ImageUploadUseCase imageUploadUseCase) {
        this.iApartmentSurveyFormSaveRepository = iApartmentSurveyFormSaveRepository;
        this.imageUploadUseCase = imageUploadUseCase;
    }

    @Override
    public Observable<GetPropertySaveResponse> createObservable(final RequestParams requestParams) {
        final SaveApartmentRequest formData = (SaveApartmentRequest) requestParams.getObject("formdata");
        return iApartmentSurveyFormSaveRepository.submitCloudNewApartment(formData);
    }

    public RequestParams createRequestParams(SaveApartmentRequest saveApartmentRequest) {
        RequestParams requestParams = RequestParams.create();
        requestParams.putObject("formdata",saveApartmentRequest);
        return requestParams;
    }
}
