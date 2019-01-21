package com.softminesol.propertysurvey.survey.newPropertyEntry.domain;

import com.softminesol.propertysurvey.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.propertysurvey.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.propertysurvey.survey.common.model.property.SavePropertyRequest;

import java.util.List;

import rx.Observable;

/**
 * Created by sandeep on 13/5/18.
 */
public interface ISurveyFormSaveRepository {
    public Observable<GetPropertySaveResponse> submitCloudNewProperty(SavePropertyRequest formData);
    public Observable<GetPropertySaveResponse> submitCacheNewProperty(SavePropertyRequest formData);
    public Observable<List<SavePropertyRequest>> getDraftedSaveProperties();

}
