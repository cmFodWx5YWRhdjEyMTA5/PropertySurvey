package com.softminesol.propertysurvey.survey.common.realm.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class PropertySubCategoryItemModel extends RealmObject {

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

    public String getText() {
        return subCategory;
    }
}