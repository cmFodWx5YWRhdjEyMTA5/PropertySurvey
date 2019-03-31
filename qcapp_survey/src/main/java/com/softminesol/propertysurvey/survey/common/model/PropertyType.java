package com.softminesol.propertysurvey.survey.common.model;

import com.google.gson.annotations.SerializedName;

import frameworks.customadapter.CustomAdapterModel;

public class PropertyType extends CustomAdapterModel {

    @SerializedName("property_type")
    private String mPropertType;
    @SerializedName("property_type_id")
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

    @Override
    public String getText() {
        return mPropertType;
    }
}
