package com.softminesol.propertysurvey.survey.updatePropertyEntry.data.repository;

import com.softminesol.propertysurvey.survey.cloudsync.SyncManager;
import com.softminesol.propertysurvey.survey.common.model.formData.FormData;
import com.softminesol.propertysurvey.survey.updatePropertyEntry.data.repository.datasource.UpdateFormDataFactory;
import com.softminesol.propertysurvey.survey.updatePropertyEntry.domain.ISurveyFormUpdateRepository;

import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by sandeep on 13/5/18.
 */
public class UpdateFormSubmitRepository implements ISurveyFormUpdateRepository {
    UpdateFormDataFactory updateFormDataFactory;

    @Inject
    public UpdateFormSubmitRepository(UpdateFormDataFactory updateFormDataFactory) {
        this.updateFormDataFactory = updateFormDataFactory;
    }

    @Override
    public Observable<BaseResponse> updateProperty(FormData formData){
        // // Will be added in sycning
        formData.setState("UPDATE");
        if(updateFormDataFactory.getCacheUpdateFormData().updateFormData(formData)) {
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("Submitted Successfully to Cache");
            return Observable.just(baseResponse);
        }else {
            return Observable.error(new Throwable("There is some problem please try again"));
        }
    }

    @Override
    public Observable<BaseResponse> updatePropertyOnCloud(final FormData formdata) {
        return updateFormDataFactory.getCloudSubmitFomData().updateFormData(formdata).doOnError(new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                updateProperty(formdata);
            }
        }).doOnNext(new Action1<BaseResponse>() {
            @Override
            public void call(BaseResponse baseResponse) {
                formdata.setState("");
                updateFormDataFactory.getCacheUpdateFormData().updateFormData(formdata);
            }
        });
    }
}
