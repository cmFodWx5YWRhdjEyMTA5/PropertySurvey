package com.softminesol.propertysurvey_qc.qasearch.newPropertyEntry.domain;

import com.softminesol.survey_framework.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.survey_framework.survey.common.model.property.SavePropertyRequest;

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
