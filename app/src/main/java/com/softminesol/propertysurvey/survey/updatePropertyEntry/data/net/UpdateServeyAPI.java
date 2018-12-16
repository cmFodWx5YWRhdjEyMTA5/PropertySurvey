package com.softminesol.propertysurvey.survey.updatePropertyEntry.data.net;

import com.softminesol.propertysurvey.survey.common.model.formData.FormData;

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
public interface UpdateServeyAPI {

    @PUT(UpdateServeyURL.updateSurveyAPI)
    Observable<Response<DataResponse<BaseResponse>>> updateProperty(@Path("id") String id,@Body FormData formData);
}
