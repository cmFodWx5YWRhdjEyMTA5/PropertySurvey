package com.softminesol.propertysurvey.survey.apartmentEntry.domain;

import com.softminesol.survey_framework.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.survey_framework.survey.common.model.property.GetPropertySaveResponse;

import java.util.List;

import rx.Observable;

/**
 * Created by sandeep on 13/5/18.
 */
public interface IApartmentSurveyFormSaveRepository {
    public Observable<GetPropertySaveResponse> submitCloudNewApartment(SaveApartmentRequest formData);
    public Observable<GetPropertySaveResponse> submitCacheNewApartment(SaveApartmentRequest formData);
    public Observable<List<SaveApartmentRequest>> getDraftedApartmentItems();
}
