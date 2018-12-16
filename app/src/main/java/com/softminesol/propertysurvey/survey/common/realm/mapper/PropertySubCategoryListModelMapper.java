package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.PropertySubCategoryList;
import com.softminesol.propertysurvey.survey.common.realm.model.PropertySubCategoryListModel;

public class PropertySubCategoryListModelMapper {

    public PropertySubCategoryListModel transformToRealmDb(PropertySubCategoryList propertySubCategoryList) {
        PropertySubCategoryListModel propertySubCategoryListModel = null;
        if (propertySubCategoryList != null) {
            propertySubCategoryListModel = new PropertySubCategoryListModel();
            propertySubCategoryListModel.setPropertySubCategory(new PropertySubCategoryItemModelMapper().transformToRealmDb(propertySubCategoryList.getPropertySubCategory()));
        }
        return propertySubCategoryListModel;
    }

    public PropertySubCategoryList transformToViewModel(PropertySubCategoryListModel propertySubCategoryListModel) {
        PropertySubCategoryList propertySubCategoryList = null;
        if (propertySubCategoryListModel != null) {
            propertySubCategoryList = new PropertySubCategoryList();
            propertySubCategoryList.setPropertySubCategory(new PropertySubCategoryItemModelMapper().transformToViewModel(propertySubCategoryListModel.getPropertySubCategory()));
        }
        return propertySubCategoryList;
    }

}
