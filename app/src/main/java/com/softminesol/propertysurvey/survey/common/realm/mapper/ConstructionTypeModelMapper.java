package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.ConstructionType;
import com.softminesol.propertysurvey.survey.common.realm.model.ConstructionTypeModel;

public class ConstructionTypeModelMapper {

    public ConstructionTypeModel transformToRealmDb(ConstructionType constructionType) {
        ConstructionTypeModel constructionTypeModel = null;
        if (constructionType != null) {
            constructionTypeModel = new ConstructionTypeModel();
            constructionTypeModel.setConstructionType(new ConstructionTypeItemModelMapper().transformToRealmDb(constructionType.getConstructionType()));
        }
        return constructionTypeModel;
    }

    public ConstructionType transformToViewModel(ConstructionTypeModel constructionTypeModel) {
        ConstructionType constructionType = null;
        if (constructionTypeModel != null) {
            constructionType = new ConstructionType();
            constructionType.setConstructionType(new ConstructionTypeItemModelMapper().transformToViewModel(constructionTypeModel.getConstructionType()));
        }
        return constructionType;
    }

}
