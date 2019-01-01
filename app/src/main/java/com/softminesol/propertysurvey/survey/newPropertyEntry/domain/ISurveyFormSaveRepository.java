package com.softminesol.propertysurvey.survey.newPropertyEntry.domain;

import com.softminesol.propertysurvey.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.propertysurvey.survey.common.model.property.SavePropertyRequest;

import rx.Observable;

/**
 * Created by sandeep on 13/5/18.
 */
public interface ISurveyFormSaveRepository {
    public Observable<GetPropertySaveResponse> submitCloudNewProperty(SavePropertyRequest formData);
}
