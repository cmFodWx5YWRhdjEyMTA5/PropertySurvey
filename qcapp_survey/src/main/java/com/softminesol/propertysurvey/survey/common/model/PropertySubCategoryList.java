package com.softminesol.propertysurvey.survey.common.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PropertySubCategoryList {

    @SerializedName("propertySubCategory")
    private List<PropertySubCategoryItem> propertySubCategory;

    public List<PropertySubCategoryItem> getPropertySubCategory() {
        return propertySubCategory;
    }

    public void setPropertySubCategory(List<PropertySubCategoryItem> propertySubCategory) {
        this.propertySubCategory = propertySubCategory;
    }

    @Override
    public String toString() {
        return
                "PropertySubCategoryList{" +
                        "propertySubCategory = '" + propertySubCategory + '\'' +
                        "}";
    }
}