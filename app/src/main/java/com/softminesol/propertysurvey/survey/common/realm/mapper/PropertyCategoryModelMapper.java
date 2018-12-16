package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.PropertyCategory;
import com.softminesol.propertysurvey.survey.common.realm.model.PropertyCategoryModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class PropertyCategoryModelMapper {

    public PropertyCategoryModel transformToRealmDb(PropertyCategory propertyCategory) {
        PropertyCategoryModel propertyCategoryModel = null;
        if (propertyCategory != null) {
            propertyCategoryModel = new PropertyCategoryModel();
            propertyCategoryModel.setPropertycategoryid(propertyCategory.getPropertycategoryid());
            propertyCategoryModel.setCategory(propertyCategory.getCategory());
        }
        return propertyCategoryModel;
    }

    public RealmList<PropertyCategoryModel> transformToRealmDb(List<PropertyCategory> propertyCategoryList) {
        RealmList<PropertyCategoryModel> realmList = null;
        if (propertyCategoryList != null) {
            realmList = new RealmList<>();
            for (PropertyCategory propertyCategory : propertyCategoryList) {
                realmList.add(transformToRealmDb(propertyCategory));
            }
        }
        return realmList;
    }

    public PropertyCategory transformToViewModel(PropertyCategoryModel propertyCategoryModel) {
        PropertyCategory propertyCategory = null;
        if (propertyCategoryModel != null) {
            propertyCategory = new PropertyCategory();
            propertyCategory.setPropertycategoryid(propertyCategoryModel.getPropertycategoryid());
            propertyCategory.setCategory(propertyCategoryModel.getCategory());
        }
        return propertyCategory;
    }

    public List<PropertyCategory> transformToViewModel(List<PropertyCategoryModel> propertyCategoryModelList) {
        List<PropertyCategory> propertyCategoryList = null;
        if (propertyCategoryModelList != null) {
            propertyCategoryList = new ArrayList<>();
            for (PropertyCategoryModel ownershipItemModel : propertyCategoryModelList) {
                propertyCategoryList.add(transformToViewModel(ownershipItemModel));
            }
        }
        return propertyCategoryList;
    }

}
