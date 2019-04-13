package com.softminesol.propertysurvey_qc.qasearch.newPropertyEntry.data.repository.datasource;

import com.softminesol.propertysurvey_qc.qasearch.newPropertyEntry.data.net.NewServeyAPI;
import com.softminesol.survey_framework.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.survey_framework.survey.common.model.property.SavePropertyRequest;

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


    public Observable<GetPropertySaveResponse> submitOldProperty(String id,SavePropertyRequest formData) {
        return newServeyAPI.submitOldProperty(id,formData).map(new Func1<Response<DataResponse<GetPropertySaveResponse>>, GetPropertySaveResponse>() {
            @Override
            public GetPropertySaveResponse call(Response<DataResponse<GetPropertySaveResponse>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }

}
