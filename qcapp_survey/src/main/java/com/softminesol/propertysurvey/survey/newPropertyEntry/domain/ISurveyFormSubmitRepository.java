package com.softminesol.propertysurvey.survey.newPropertyEntry.domain;

import com.softminesol.propertysurvey.survey.common.model.formData.FormData;

import frameworks.network.model.BaseResponse;
import rx.Observable;

/**
 * Created by sandeep on 13/5/18.
 */
public interface ISurveyFormSubmitRepository {
    public Observable<BaseResponse> submitNewProperty(FormData formData) ;
    public Observable<BaseResponse> submitCloudNewProperty(FormData formData);
}
