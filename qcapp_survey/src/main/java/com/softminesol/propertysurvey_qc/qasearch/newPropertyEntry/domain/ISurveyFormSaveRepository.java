package com.softminesol.propertysurvey_qc.qasearch.newPropertyEntry.domain;

import com.softminesol.survey_framework.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.survey_framework.survey.common.model.property.SavePropertyRequest;

import rx.Observable;

/**
 * Created by sandeep on 13/5/18.
 */
public interface ISurveyFormSaveRepository {
    public Observable<GetPropertySaveResponse> submitCLoudOldProperty(String id,SavePropertyRequest formData);
    public Observable<GetPropertySaveResponse> submitCacheNewProperty(SavePropertyRequest formData);

}
