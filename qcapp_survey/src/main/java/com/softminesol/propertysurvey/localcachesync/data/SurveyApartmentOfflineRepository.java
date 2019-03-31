package com.softminesol.propertysurvey.localcachesync.data;

import android.content.Context;

import com.softminesol.propertysurvey.roomDb.PropertySurveyDB;
import com.softminesol.propertysurvey.survey.common.model.apartment.SaveApartmentRequest;

import java.util.List;

import javax.inject.Inject;

import frameworks.di.qualifier.ApplicationContext;

public class SurveyApartmentOfflineRepository {
    PropertySurveyDB propertySurveyDB;

    @Inject
    public SurveyApartmentOfflineRepository(@ApplicationContext Context context) {
        propertySurveyDB = PropertySurveyDB.getInstance(context);
    }

    public List<SaveApartmentRequest> getGISApartments() {
       return propertySurveyDB.getApartmentDao().getApartments();
    }

    public void deleteSavedApartment(SaveApartmentRequest saveApartmentRequest) {
         propertySurveyDB.getApartmentDao().delete(saveApartmentRequest);
    }
}
