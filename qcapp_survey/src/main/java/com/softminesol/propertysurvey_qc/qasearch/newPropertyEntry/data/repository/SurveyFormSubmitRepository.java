package com.softminesol.propertysurvey_qc.qasearch.newPropertyEntry.data.repository;

import com.softminesol.propertysurvey_qc.qasearch.newPropertyEntry.data.repository.datasource.SubmitFormDataFactory;
import com.softminesol.propertysurvey_qc.qasearch.newPropertyEntry.domain.ISurveyFormSaveRepository;
import com.softminesol.survey_framework.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.survey_framework.survey.common.model.property.SavePropertyRequest;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by sandeep on 13/5/18.
 */
public class SurveyFormSubmitRepository implements  ISurveyFormSaveRepository {
    SubmitFormDataFactory submitFormDataFactory;

    @Inject
    public SurveyFormSubmitRepository(SubmitFormDataFactory surveyFormSubmitRepository) {
        this.submitFormDataFactory = surveyFormSubmitRepository;
    }

    public Observable<GetPropertySaveResponse> submitCacheNewProperty(final SavePropertyRequest formData) {
        return submitFormDataFactory.getCacheSubmitFormData().submitFormData(formData);
    }

    public Observable<GetPropertySaveResponse> submitCLoudOldProperty(String id,final SavePropertyRequest formData) {
        if (formData.getImagePathList() != null && formData.getImagePathList().size() > 0) {
            return submitCacheNewProperty(formData);
        } else {
            return submitFormDataFactory.getCloudSubmitFomData().submitOldProperty(id,formData).doOnError(new Action1<Throwable>() {
                @Override
                public void call(Throwable throwable) {
                    submitFormDataFactory.getCacheSubmitFormData().submitFormData(formData);
                }
            });
        }

    }
}
