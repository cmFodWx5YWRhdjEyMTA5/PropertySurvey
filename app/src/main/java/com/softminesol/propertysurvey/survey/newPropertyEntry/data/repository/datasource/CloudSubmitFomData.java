package com.softminesol.propertysurvey.survey.newPropertyEntry.data.repository.datasource;

import com.softminesol.propertysurvey.survey.common.model.formData.FormData;
import com.softminesol.propertysurvey.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.propertysurvey.survey.common.model.property.SavePropertyRequest;
import com.softminesol.propertysurvey.survey.newPropertyEntry.data.net.NewServeyAPI;

import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
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

    public Observable<BaseResponse> submitFormData(FormData formData) {
        return newServeyAPI.submitNewProperty(formData).map(new Func1<Response<DataResponse<BaseResponse>>, BaseResponse>() {
            @Override
            public BaseResponse call(Response<DataResponse<BaseResponse>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }
    public Observable<GetPropertySaveResponse> submitCloudNewProperty(SavePropertyRequest formData) {
        return newServeyAPI.submitNewProperty(formData).map(new Func1<Response<DataResponse<GetPropertySaveResponse>>, GetPropertySaveResponse>() {
            @Override
            public GetPropertySaveResponse call(Response<DataResponse<GetPropertySaveResponse>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }

}
