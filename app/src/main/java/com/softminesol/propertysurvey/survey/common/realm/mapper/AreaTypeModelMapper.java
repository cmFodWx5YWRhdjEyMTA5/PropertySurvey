package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.AreaType;
import com.softminesol.propertysurvey.survey.common.realm.model.AreaTypeModel;

public class AreaTypeModelMapper {

    public AreaTypeModel transformToRealmDb(AreaType areaType) {
        AreaTypeModel areaTypeModel = null;
        if (areaType != null) {
            areaTypeModel = new AreaTypeModel();
            areaTypeModel.setAreaType(new AreaTypeItemModelMapper().transformToRealmDb(areaType.getAreaType()));
        }
        return areaTypeModel;
    }

    public AreaType transformToViewModel(AreaTypeModel areaTypeModel) {
        AreaType areaType = null;
        if (areaTypeModel != null) {
            areaType = new AreaType();
            areaType.setAreaType(new AreaTypeItemModelMapper().transformToViewModel(areaTypeModel.getAreaType()));
        }
        return areaType;
    }
}
