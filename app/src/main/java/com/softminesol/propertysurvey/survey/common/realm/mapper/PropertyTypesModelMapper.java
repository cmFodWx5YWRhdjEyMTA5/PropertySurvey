package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.PropertyTypes;
import com.softminesol.propertysurvey.survey.common.realm.model.PropertyTypesModel;

public class PropertyTypesModelMapper {

    public PropertyTypesModel transformToRealmDb(PropertyTypes propertyTypes) {
        PropertyTypesModel propertyTypesModel = null;
        if (propertyTypes != null) {
            propertyTypesModel = new PropertyTypesModel();
            propertyTypesModel.setPropertyTypes(new PropertyTypeModelMapper().transformToRealmDb(propertyTypes.getPropertyTypes()));
        }
        return propertyTypesModel;
    }

    public PropertyTypes transformToViewModel(PropertyTypesModel propertyTypesModel) {
        PropertyTypes propertyTypes = null;
        if (propertyTypesModel != null) {
            propertyTypes = new PropertyTypes();
            propertyTypes.setPropertyTypes(new PropertyTypeModelMapper().transformToViewModel(propertyTypesModel.getPropertyTypes()));
        }
        return propertyTypes;
    }

}
