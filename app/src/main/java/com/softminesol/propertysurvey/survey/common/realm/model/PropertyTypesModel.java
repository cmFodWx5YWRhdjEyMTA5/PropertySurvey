package com.softminesol.propertysurvey.survey.common.realm.model;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Nonnull;

import io.realm.RealmList;
import io.realm.RealmObject;

public class PropertyTypesModel extends RealmObject {

    @SerializedName("propertyTypes")
    private RealmList<PropertyTypeModel> mPropertyTypes;


    @Nonnull
    private String dbId;

    public RealmList<PropertyTypeModel> getPropertyTypes() {
        return mPropertyTypes;
    }

    public void setPropertyTypes(RealmList<PropertyTypeModel> propertyTypes) {
        mPropertyTypes = propertyTypes;
    }


    @Nonnull
    public String getDbId() {
        return dbId;
    }

    public void setDbId(@Nonnull String dbId) {
        this.dbId = dbId;
    }
}
