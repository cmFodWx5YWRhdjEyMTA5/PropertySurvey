package com.softminesol.propertysurvey.survey.common.realm.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class PropertyTypeModel extends RealmObject {

    @SerializedName("propert_type")
    private String mPropertType;
    @SerializedName("propertytypeid")
    private Long mPropertytypeid;

    public String getPropertType() {
        return mPropertType;
    }

    public void setPropertType(String propertType) {
        mPropertType = propertType;
    }

    public Long getPropertytypeid() {
        return mPropertytypeid;
    }

    public void setPropertytypeid(Long propertytypeid) {
        mPropertytypeid = propertytypeid;
    }

    @Override
    public String toString() {
        return getText();
    }

    public String getText() {
        return mPropertType;
    }
}
