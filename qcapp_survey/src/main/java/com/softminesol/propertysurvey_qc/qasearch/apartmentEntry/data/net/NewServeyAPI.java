package com.softminesol.propertysurvey_qc.qasearch.apartmentEntry.data.net;


import com.softminesol.survey_framework.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.survey_framework.survey.common.model.property.GetPropertySaveResponse;

import frameworks.network.model.DataResponse;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by sandeep on 13/5/18.
 */
public interface NewServeyAPI {

    @PUT(NewServeyURL.updateApartmentSurveyAPI)
    Observable<Response<DataResponse<GetPropertySaveResponse>>> submitNewApartment(@Path("id") String id, @Body SaveApartmentRequest formData);
}
