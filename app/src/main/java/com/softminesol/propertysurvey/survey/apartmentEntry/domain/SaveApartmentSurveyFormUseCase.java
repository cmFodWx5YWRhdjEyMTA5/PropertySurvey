package com.softminesol.propertysurvey.survey.apartmentEntry.domain;

import com.softminesol.propertysurvey.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.propertysurvey.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.propertysurvey.survey.common.model.property.SavePropertyRequest;
import com.softminesol.propertysurvey.survey.newPropertyEntry.domain.ISurveyFormSaveRepository;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

/**
 * Created by sandeep on 13/5/18.
 */
public class SaveApartmentSurveyFormUseCase extends UseCase<GetPropertySaveResponse> {

    IApartmentSurveyFormSaveRepository iApartmentSurveyFormSaveRepository;

    @Inject
    public SaveApartmentSurveyFormUseCase(IApartmentSurveyFormSaveRepository iApartmentSurveyFormSaveRepository) {
        this.iApartmentSurveyFormSaveRepository = iApartmentSurveyFormSaveRepository;
    }

    @Override
    public Observable<GetPropertySaveResponse> createObservable(RequestParams requestParams) {
        SaveApartmentRequest formData = (SaveApartmentRequest) requestParams.getObject("formdata");
                return iApartmentSurveyFormSaveRepository.submitCloudNewApartment(formData);

        }

}
