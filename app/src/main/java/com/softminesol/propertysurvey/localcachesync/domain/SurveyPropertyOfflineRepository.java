package com.softminesol.propertysurvey.localcachesync.domain;

import android.content.Context;

import com.softminesol.propertysurvey.roomDb.PropertySurveyDB;
import com.softminesol.propertysurvey.roomDb.SurveyApartmentDao;
import com.softminesol.propertysurvey.survey.common.model.property.SavePropertyRequest;

import java.util.List;

import javax.inject.Inject;

import frameworks.di.qualifier.ApplicationContext;

public class SurveyPropertyOfflineRepository {
    PropertySurveyDB propertySurveyDB;
    SurveyApartmentDao surveyApartmentDao;

    @Inject
    public SurveyPropertyOfflineRepository(@ApplicationContext Context context) {
        propertySurveyDB = PropertySurveyDB.getInstance(context);
    }

    public List<SavePropertyRequest> getSaveProperty() {
        return propertySurveyDB.getPropertyDao().getAll();
    }

    public void deleteProeprtyrRequest(SavePropertyRequest savePropertyRequest) {
        propertySurveyDB.getPropertyDao().delete(savePropertyRequest);
    }

    public void updateGSID(long tid,String gsid) {
        propertySurveyDB.getApartmentDao().updateTour(tid,gsid);
    }
}
