package com.softminesol.propertysurvey_qc.survey.apartmentEntry.data.repository.datasource;

import android.content.Context;

import com.softminesol.survey_framework.roomDb.PropertySurveyDB;
import com.softminesol.survey_framework.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.survey_framework.survey.common.model.property.GetPropertySaveResponse;

import java.util.List;

import javax.inject.Inject;

import frameworks.di.qualifier.ApplicationContext;
import rx.Observable;

public class CacheSubmitFormData {
    private final PropertySurveyDB propertySurveyDB;

    @Inject
    public CacheSubmitFormData(@ApplicationContext Context context) {
        this.propertySurveyDB = PropertySurveyDB.getInstance(context);
    }


    public Observable<GetPropertySaveResponse> submitFormData(SaveApartmentRequest formData) {
        if(formData.getTempId() != 0) {
            propertySurveyDB.getApartmentDao().update(formData);
        }else {
            propertySurveyDB.getApartmentDao().insert(formData);
        }
        return Observable.just(new GetPropertySaveResponse());
    }

    public Observable<List<SaveApartmentRequest>> getDraftedApartments() {
        return Observable.just(propertySurveyDB.getApartmentDao().getDraftedApartments());
    }
}