package com.softminesol.propertysurvey.survey.newPropertyEntry.data.net;

import com.softminesol.survey_framework.survey.common.model.formData.FormData;
import com.softminesol.survey_framework.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.survey_framework.survey.common.model.property.SavePropertyRequest;

import frameworks.network.model.BaseResponse;
import frameworks.network.model.DataResponse;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by sandeep on 13/5/18.
 */
public interface NewServeyAPI {

    @POST(NewServeyURL.submitSurveyAPI)
    Observable<Response<DataResponse<BaseResponse>>> submitNewProperty(@Body FormData formData);

    @PUT(NewServeyURL.savePropertySurveyAPI)
    Observable<Response<DataResponse<GetPropertySaveResponse>>> submitNewProperty(@Path ("id")String id,@Body SavePropertyRequest formData);


}
