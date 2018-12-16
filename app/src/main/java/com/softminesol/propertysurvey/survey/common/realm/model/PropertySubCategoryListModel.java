package com.softminesol.propertysurvey.survey.common.realm.model;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Nonnull;

import io.realm.RealmList;
import io.realm.RealmObject;

public class PropertySubCategoryListModel extends RealmObject{

    @SerializedName("propertySubCategory")
    private RealmList<PropertySubCategoryItemModel> propertySubCategory;
    @Nonnull
    private String dbId;

    public RealmList<PropertySubCategoryItemModel> getPropertySubCategory() {
        return propertySubCategory;
    }

    public void setPropertySubCategory(RealmList<PropertySubCategoryItemModel> propertySubCategory) {
        this.propertySubCategory = propertySubCategory;
    }

    @Override
    public String toString() {
        return
                "PropertySubCategoryList{" +
                        "propertySubCategory = '" + propertySubCategory + '\'' +
                        "}";
    }

    @Nonnull
    public String getDbId() {
        return dbId;
    }

    public void setDbId(@Nonnull String dbId) {
        this.dbId = dbId;
    }
}