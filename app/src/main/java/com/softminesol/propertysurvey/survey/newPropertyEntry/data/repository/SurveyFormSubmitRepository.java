package com.softminesol.propertysurvey.survey.newPropertyEntry.data.repository;

import com.softminesol.propertysurvey.survey.common.model.formData.FormData;
import com.softminesol.propertysurvey.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.propertysurvey.survey.common.model.property.SavePropertyRequest;
import com.softminesol.propertysurvey.survey.newPropertyEntry.data.repository.datasource.SubmitFormDataFactory;
import com.softminesol.propertysurvey.survey.newPropertyEntry.domain.ISurveyFormSaveRepository;
import com.softminesol.propertysurvey.survey.newPropertyEntry.domain.ISurveyFormSubmitRepository;

import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by sandeep on 13/5/18.
 */
public class SurveyFormSubmitRepository implements ISurveyFormSubmitRepository,ISurveyFormSaveRepository {
    SubmitFormDataFactory submitFormDataFactory;

    @Inject
    public SurveyFormSubmitRepository(SubmitFormDataFactory surveyFormSubmitRepository) {
        this.submitFormDataFactory = surveyFormSubmitRepository;
    }

    @Override
    public Observable<BaseResponse> submitNewProperty(FormData formData) {
       return null;//turn Observable.error(new Throwable("There is some problem please try again"));
    }

    public Observable<BaseResponse> submitCloudNewProperty(final FormData formData) {
        return  submitFormDataFactory.getCloudSubmitFomData().submitFormData(formData).doOnError(new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                submitNewProperty(formData);
            }
        }).doOnNext(new Action1<BaseResponse>() {
            @Override
            public void call(BaseResponse baseResponse) {
                formData.setState("");

            }
        }); // Will be added in sycning

    }


    public Observable<GetPropertySaveResponse> submitCloudNewProperty(final SavePropertyRequest formData) {
        if(formData.getImagePathList()!= null && formData.getImagePathList().size()>0) {
            return submitFormDataFactory.getCacheSubmitFormData().submitFormData(formData);
        }else {
            return submitFormDataFactory.getCloudSubmitFomData().submitCloudNewProperty(formData).onErrorResumeNext(new Func1<Throwable, Observable<GetPropertySaveResponse>>() {
                @Override
                public Observable<GetPropertySaveResponse> call(Throwable throwable) {
                    return submitFormDataFactory.getCacheSubmitFormData().submitFormData(formData);
                }
            });
        }

    }
}
