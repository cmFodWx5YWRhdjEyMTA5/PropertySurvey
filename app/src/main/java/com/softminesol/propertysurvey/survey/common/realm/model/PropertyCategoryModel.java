package com.softminesol.propertysurvey.survey.common.realm.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class PropertyCategoryModel extends RealmObject {

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

    public String getText() {
        return mCategory;
    }


}
