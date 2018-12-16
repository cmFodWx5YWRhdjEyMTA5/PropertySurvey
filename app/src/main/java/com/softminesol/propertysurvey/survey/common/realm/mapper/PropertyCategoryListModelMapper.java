package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.PropertyCategoryList;
import com.softminesol.propertysurvey.survey.common.realm.model.PropertyCategoryListModel;

public class PropertyCategoryListModelMapper {

    public PropertyCategoryListModel transformToRealmDb(PropertyCategoryList propertyCategoryList) {
        PropertyCategoryListModel propertyCategoryListModel = null;
        if (propertyCategoryList != null) {
            propertyCategoryListModel = new PropertyCategoryListModel();
            propertyCategoryListModel.setPropertyCategories(new PropertyCategoryModelMapper().transformToRealmDb(propertyCategoryList.getPropertyCategories()));
        }
        return propertyCategoryListModel;
    }

    public PropertyCategoryList transformToViewModel(PropertyCategoryListModel propertyCategoryListModel) {
        PropertyCategoryList propertyCategoryList = null;
        if (propertyCategoryListModel != null) {
            propertyCategoryList = new PropertyCategoryList();
            propertyCategoryList.setPropertyCategories(new PropertyCategoryModelMapper().transformToViewModel(propertyCategoryListModel.getPropertyCategories()));
        }
        return propertyCategoryList;
    }

}
