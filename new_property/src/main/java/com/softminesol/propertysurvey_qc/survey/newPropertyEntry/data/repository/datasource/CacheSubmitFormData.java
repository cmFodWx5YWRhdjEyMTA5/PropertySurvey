package com.softminesol.propertysurvey_qc.survey.newPropertyEntry.data.repository.datasource;

import android.content.Context;

import com.softminesol.survey_framework.roomDb.PropertySurveyDB;
import com.softminesol.survey_framework.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.survey_framework.survey.common.model.property.SavePropertyRequest;

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


    public Observable<GetPropertySaveResponse> submitFormData(SavePropertyRequest formData) {
        long id;
        if(formData.getId() != 0) {
            propertySurveyDB.getPropertyDao().update(formData);
            id = (long)formData.getId();
        }else {
            id = propertySurveyDB.getPropertyDao().insert(formData);
        }
        return Observable.just(new GetPropertySaveResponse(id));
    }

    public Observable<List<SavePropertyRequest>> getDraftedProperties() {
        return Observable.just(propertySurveyDB.getPropertyDao().getDraftedProperties());
    }
}
