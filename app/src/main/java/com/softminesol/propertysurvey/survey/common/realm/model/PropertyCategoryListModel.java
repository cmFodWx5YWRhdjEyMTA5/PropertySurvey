package com.softminesol.propertysurvey.survey.common.realm.model;

import io.realm.RealmList;
import io.realm.RealmObject;

public class PropertyCategoryListModel extends RealmObject {
    private RealmList<PropertyCategoryModel> mPropertyCategories;

    public RealmList<PropertyCategoryModel> getPropertyCategories() {
        return mPropertyCategories;
    }

    public void setPropertyCategories(RealmList<PropertyCategoryModel> propertyCategories) {
        mPropertyCategories = propertyCategories;
    }
}
