package com.softminesol.propertysurvey.survey.apartmentEntry.data.repository.datasource;

import android.content.Context;

import com.softminesol.propertysurvey.survey.common.model.formData.FormData;
import com.softminesol.propertysurvey.survey.common.realm.RealmPropertyDataMapper;

import javax.inject.Inject;

import frameworks.di.qualifier.ApplicationContext;

public class CacheSubmitFormData {
    private final RealmPropertyDataMapper realmPropertyDataMapper;

    @Inject
    public CacheSubmitFormData(@ApplicationContext Context context) {
        this.realmPropertyDataMapper = RealmPropertyDataMapper.getInstance(context);
    }


    public boolean submitFormData(FormData formData) {
        return realmPropertyDataMapper.addPropertyData(formData);
    }
}
