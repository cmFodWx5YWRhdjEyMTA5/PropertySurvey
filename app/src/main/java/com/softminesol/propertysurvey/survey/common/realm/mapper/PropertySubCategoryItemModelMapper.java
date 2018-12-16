package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.PropertySubCategoryItem;
import com.softminesol.propertysurvey.survey.common.realm.model.PropertySubCategoryItemModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class PropertySubCategoryItemModelMapper {

    public PropertySubCategoryItemModel transformToRealmDb(PropertySubCategoryItem propertySubCategoryItem) {
        PropertySubCategoryItemModel propertySubCategoryItemModel = null;
        if (propertySubCategoryItem != null) {
            propertySubCategoryItemModel = new PropertySubCategoryItemModel();
            propertySubCategoryItemModel.setPropertysubcategoryid(propertySubCategoryItem.getPropertysubcategoryid());
            propertySubCategoryItemModel.setSubCategory(propertySubCategoryItem.getSubCategory());
        }
        return propertySubCategoryItemModel;
    }

    public RealmList<PropertySubCategoryItemModel> transformToRealmDb(List<PropertySubCategoryItem> propertySubCategoryItemList) {
        RealmList<PropertySubCategoryItemModel> realmList = null;
        if (propertySubCategoryItemList != null) {
            realmList = new RealmList<>();
            for (PropertySubCategoryItem propertySubCategoryItem : propertySubCategoryItemList) {
                realmList.add(transformToRealmDb(propertySubCategoryItem));
            }
        }
        return realmList;
    }

    public PropertySubCategoryItem transformToViewModel(PropertySubCategoryItemModel propertySubCategoryItemModel) {
        PropertySubCategoryItem propertySubCategoryItem = null;
        if (propertySubCategoryItemModel != null) {
            propertySubCategoryItem = new PropertySubCategoryItem();
            propertySubCategoryItem.setPropertysubcategoryid(propertySubCategoryItemModel.getPropertysubcategoryid());
            propertySubCategoryItem.setSubCategory(propertySubCategoryItemModel.getSubCategory());
        }
        return propertySubCategoryItem;
    }

    public List<PropertySubCategoryItem> transformToViewModel(List<PropertySubCategoryItemModel> propertySubCategoryItemModelList) {
        List<PropertySubCategoryItem> propertySubCategoryItemList = null;
        if (propertySubCategoryItemModelList != null) {
            propertySubCategoryItemList = new ArrayList<>();
            for (PropertySubCategoryItemModel propertySubCategoryItemModel : propertySubCategoryItemModelList) {
                propertySubCategoryItemList.add(transformToViewModel(propertySubCategoryItemModel));
            }
        }
        return propertySubCategoryItemList;
    }

}
