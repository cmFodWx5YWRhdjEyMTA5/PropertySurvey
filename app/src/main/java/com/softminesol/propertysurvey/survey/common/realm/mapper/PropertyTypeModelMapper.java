package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.PropertyType;
import com.softminesol.propertysurvey.survey.common.realm.model.PropertyTypeModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class PropertyTypeModelMapper {

    public PropertyTypeModel transformToRealmDb(PropertyType propertyType) {
        PropertyTypeModel propertyTypeModel = null;
        if (propertyType != null) {
            propertyTypeModel = new PropertyTypeModel();
            propertyTypeModel.setPropertytypeid(propertyType.getPropertytypeid());
            propertyTypeModel.setPropertType(propertyType.getPropertType());
        }
        return propertyTypeModel;
    }

    public RealmList<PropertyTypeModel> transformToRealmDb(List<PropertyType> propertyTypeList) {
        RealmList<PropertyTypeModel> realmList = null;
        if (propertyTypeList != null) {
            realmList = new RealmList<>();
            for (PropertyType propertyType : propertyTypeList) {
                realmList.add(transformToRealmDb(propertyType));
            }
        }
        return realmList;
    }

    public PropertyType transformToViewModel(PropertyTypeModel propertySubCategoryItemModel) {
        PropertyType propertySubCategoryItem = null;
        if (propertySubCategoryItemModel != null) {
            propertySubCategoryItem = new PropertyType();
            propertySubCategoryItem.setPropertytypeid(propertySubCategoryItemModel.getPropertytypeid());
            propertySubCategoryItem.setPropertType(propertySubCategoryItemModel.getPropertType());
        }
        return propertySubCategoryItem;
    }

    public List<PropertyType> transformToViewModel(List<PropertyTypeModel> propertyTypeModelList) {
        List<PropertyType> propertyTypeList = null;
        if (propertyTypeModelList != null) {
            propertyTypeList = new ArrayList<>();
            for (PropertyTypeModel propertyTypeModel : propertyTypeModelList) {
                propertyTypeList.add(transformToViewModel(propertyTypeModel));
            }
        }
        return propertyTypeList;
    }

}
