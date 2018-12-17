package com.softminesol.propertysurvey.survey.apartmentEntry.domain;

import com.softminesol.propertysurvey.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.propertysurvey.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.propertysurvey.survey.common.model.property.SavePropertyRequest;

import rx.Observable;

/**
 * Created by sandeep on 13/5/18.
 */
public interface IApartmentSurveyFormSaveRepository {
    public Observable<GetPropertySaveResponse> submitCloudNewApartment(SaveApartmentRequest formData);
}
