package com.softminesol.survey_framework.survey.common.model;

import com.google.gson.annotations.SerializedName;

import frameworks.customadapter.CustomAdapterModel;

public class PropertySubCategoryItem extends CustomAdapterModel {

    @SerializedName("sub_category")
    private String subCategory;

    @SerializedName("propertysubcategoryid")
    private int propertysubcategoryid;

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public int getPropertysubcategoryid() {
        return propertysubcategoryid;
    }

    public void setPropertysubcategoryid(int propertysubcategoryid) {
        this.propertysubcategoryid = propertysubcategoryid;
    }

    @Override
    public String toString() {
        return
                getText();
    }

    @Override
    public String getText() {
        return subCategory;
    }
}