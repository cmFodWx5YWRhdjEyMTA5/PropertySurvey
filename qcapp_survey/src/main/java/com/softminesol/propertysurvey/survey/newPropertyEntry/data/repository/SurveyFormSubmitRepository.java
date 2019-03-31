package com.softminesol.propertysurvey.survey.newPropertyEntry.data.repository;

import com.softminesol.propertysurvey.survey.common.model.formData.FormData;
import com.softminesol.propertysurvey.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.propertysurvey.survey.common.model.property.SavePropertyRequest;
import com.softminesol.propertysurvey.survey.newPropertyEntry.data.repository.datasource.SubmitFormDataFactory;
import com.softminesol.propertysurvey.survey.newPropertyEntry.domain.ISurveyFormSaveRepository;
import com.softminesol.propertysurvey.survey.newPropertyEntry.domain.ISurveyFormSubmitRepository;

import java.util.List;

import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by sandeep on 13/5/18.
 */
public class SurveyFormSubmitRepository implements ISurveyFormSubmitRepository, ISurveyFormSaveRepository {
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
        return submitFormDataFactory.getCloudSubmitFomData().submitFormData(formData).doOnError(new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                submitNewProperty(formData);
            }
        }).doOnNext(new Action1<BaseResponse>() {
            @Override
            public void call(BaseResponse baseResponse) {
                formData.setState("");

            }
        });

    }

    public Observable<GetPropertySaveResponse> submitCacheNewProperty(final SavePropertyRequest formData) {
        return submitFormDataFactory.getCacheSubmitFormData().submitFormData(formData);
    }

    @Override
    public Observable<List<SavePropertyRequest>> getDraftedSaveProperties() {
        return submitFormDataFactory.getCacheSubmitFormData().getDraftedProperties();
    }


    public Observable<GetPropertySaveResponse> submitCloudNewProperty(String id,final SavePropertyRequest formData) {
        if (formData.getImagePathList() != null && formData.getImagePathList().size() > 0) {
            return submitCacheNewProperty(formData);
        } else {
            return submitFormDataFactory.getCloudSubmitFomData().submitCloudNewProperty(id,formData).doOnError(new Action1<Throwable>() {
                @Override
                public void call(Throwable throwable) {
                    submitFormDataFactory.getCacheSubmitFormData().submitFormData(formData);
                }
            });
        }

    }
}
