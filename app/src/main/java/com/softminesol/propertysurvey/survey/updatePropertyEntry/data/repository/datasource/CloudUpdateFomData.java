package com.softminesol.propertysurvey.survey.updatePropertyEntry.data.repository.datasource;

import com.softminesol.propertysurvey.survey.common.model.formData.FormData;
import com.softminesol.propertysurvey.survey.updatePropertyEntry.data.net.UpdateServeyAPI;

import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import frameworks.network.model.DataResponse;
import retrofit2.Response;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by sandeep on 13/5/18.
 */
public class CloudUpdateFomData {
    UpdateServeyAPI updateServeyAPI;

    @Inject
    public CloudUpdateFomData(UpdateServeyAPI updateServeyAPI) {
        this.updateServeyAPI = updateServeyAPI;
    }

    public Observable<BaseResponse> updateFormData(FormData formData) {
        return updateServeyAPI.updateProperty(formData.getOldPropertyUID(),formData).map(new Func1<Response<DataResponse<BaseResponse>>, BaseResponse>() {
            @Override
            public BaseResponse call(Response<DataResponse<BaseResponse>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }
}
