package com.softminesol.propertysurvey.survey.updatePropertyEntry.data.repository.datasource;

import android.content.Context;

import com.softminesol.propertysurvey.survey.common.model.formData.FormData;
import com.softminesol.propertysurvey.survey.common.realm.RealmPropertyDataMapper;

import javax.inject.Inject;

import frameworks.di.qualifier.ApplicationContext;

public class CacheUpdateFormData {
    private final RealmPropertyDataMapper realmPropertyDataMapper;

    @Inject
    public CacheUpdateFormData(@ApplicationContext Context context) {
        this.realmPropertyDataMapper = RealmPropertyDataMapper.getInstance(context);
    }


    public boolean updateFormData(FormData formData) {
        return realmPropertyDataMapper.updatePropertyData(formData);
    }
}
