package com.softminesol.survey_framework.survey.common.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PropertyTypes {

    @SerializedName("PropertyTypes")
    private List<PropertyType> mPropertyTypes;

    public List<PropertyType> getPropertyTypes() {
        return mPropertyTypes;
    }

    public void setPropertyTypes(List<PropertyType> propertyTypes) {
        mPropertyTypes = propertyTypes;
    }

}
