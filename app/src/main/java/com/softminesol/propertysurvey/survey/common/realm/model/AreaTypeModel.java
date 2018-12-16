package com.softminesol.propertysurvey.survey.common.realm.model;

import io.realm.RealmList;
import io.realm.RealmObject;

public class AreaTypeModel extends RealmObject {
    private RealmList<AreaTypeItemModel> areaType;

    public RealmList<AreaTypeItemModel> getAreaType() {
        return areaType;
    }

    public void setAreaType(RealmList<AreaTypeItemModel> areaType) {
        this.areaType = areaType;
    }

    @Override
    public String toString() {
        return
                "AreaType{" +
                        "areaType = '" + areaType + '\'' +
                        "}";
    }
}