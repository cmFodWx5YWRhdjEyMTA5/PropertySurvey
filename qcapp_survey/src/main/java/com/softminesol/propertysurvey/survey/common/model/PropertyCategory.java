package com.softminesol.propertysurvey.survey.common.model;

import com.google.gson.annotations.SerializedName;

import frameworks.customadapter.CustomAdapterModel;

public class PropertyCategory extends CustomAdapterModel {

    @SerializedName("category")
    private String mCategory;
    @SerializedName("propertycategoryid")
    private Long mPropertycategoryid;

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
    }

    public Long getPropertycategoryid() {
        return mPropertycategoryid;
    }

    public void setPropertycategoryid(Long propertycategoryid) {
        mPropertycategoryid = propertycategoryid;
    }

    @Override
    public String toString() {
        return getText();
    }

    @Override
    public String getText() {
        return mCategory;
    }


}
