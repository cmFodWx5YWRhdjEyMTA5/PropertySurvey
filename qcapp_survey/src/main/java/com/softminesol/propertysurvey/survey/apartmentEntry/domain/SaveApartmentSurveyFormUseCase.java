package com.softminesol.propertysurvey.survey.apartmentEntry.domain;

import com.softmine.imageupload.domain.ImageUploadUseCase;
import com.softminesol.propertysurvey.CommonBaseUrl;
import com.softminesol.propertysurvey.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.propertysurvey.survey.common.model.property.GetPropertySaveResponse;

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


    public RequestParams createRequestParams(String id, SaveApartmentRequest data) {
        RequestParams requestParams = RequestParams.create();
        requestParams.putString("id",id);
        requestParams.putObject("formdata",data);
        return requestParams;
    }
    @Override
    public Observable<GetPropertySaveResponse> createObservable(final RequestParams requestParams) {
        final SaveApartmentRequest formData = (SaveApartmentRequest) requestParams.getObject("formdata");
        return iApartmentSurveyFormSaveRepository.submitCloudNewApartment(requestParams.getString("id",""),formData);
    }

    public RequestParams createRequestParams(SaveApartmentRequest saveApartmentRequest) {
        RequestParams requestParams = RequestParams.create();
        requestParams.putObject("formdata",saveApartmentRequest);
        return requestParams;
    }
}
