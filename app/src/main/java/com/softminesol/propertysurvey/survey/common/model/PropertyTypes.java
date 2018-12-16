package com.softminesol.propertysurvey.survey.common.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PropertyTypes {

    @SerializedName("propertyTypes")
    private List<PropertyType> mPropertyTypes;

    public List<PropertyType> getPropertyTypes() {
        return mPropertyTypes;
    }

    public void setPropertyTypes(List<PropertyType> propertyTypes) {
        mPropertyTypes = propertyTypes;
    }

}
