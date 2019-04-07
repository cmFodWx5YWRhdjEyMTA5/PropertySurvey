package com.softminesol.propertysurvey_qc.survey.apartmentEntry.data.repository.datasource;

import com.softminesol.propertysurvey_qc.survey.apartmentEntry.data.net.NewServeyAPI;
import com.softminesol.survey_framework.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.survey_framework.survey.common.model.property.GetPropertySaveResponse;

import javax.inject.Inject;

import frameworks.network.model.DataResponse;
import retrofit2.Response;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by sandeep on 13/5/18.
 */
public class CloudSubmitFomData {
    NewServeyAPI newServeyAPI;

    @Inject
    public CloudSubmitFomData(NewServeyAPI newServeyAPI) {
        this.newServeyAPI = newServeyAPI;
    }

    public Observable<GetPropertySaveResponse> submitCloudNewApartment(SaveApartmentRequest formData) {
        return newServeyAPI.submitNewApartment(formData).map(new Func1<Response<DataResponse<GetPropertySaveResponse>>, GetPropertySaveResponse>() {
            @Override
            public GetPropertySaveResponse call(Response<DataResponse<GetPropertySaveResponse>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }
}
