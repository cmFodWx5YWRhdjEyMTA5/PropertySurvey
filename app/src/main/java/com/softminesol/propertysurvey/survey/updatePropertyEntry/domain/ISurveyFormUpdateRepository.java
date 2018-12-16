package com.softminesol.propertysurvey.survey.updatePropertyEntry.domain;

import com.softminesol.propertysurvey.survey.common.model.formData.FormData;

import frameworks.network.model.BaseResponse;
import rx.Observable;

/**
 * Created by sandeep on 13/5/18.
 */
public interface ISurveyFormUpdateRepository {
    Observable<BaseResponse> updateProperty(FormData formdata) ;
    Observable<BaseResponse> updatePropertyOnCloud(FormData formdata) ;
}
