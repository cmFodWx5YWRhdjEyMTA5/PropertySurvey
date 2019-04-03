package com.softminesol.survey_framework.survey.common.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PropertyCategoryList {

    @SerializedName("propertyCategories")
    private List<PropertyCategory> mPropertyCategories;

    public List<PropertyCategory> getPropertyCategories() {
        return mPropertyCategories;
    }

    public void setPropertyCategories(List<PropertyCategory> propertyCategories) {
        mPropertyCategories = propertyCategories;
    }

}
