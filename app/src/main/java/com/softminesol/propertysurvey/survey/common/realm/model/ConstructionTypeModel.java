package com.softminesol.propertysurvey.survey.common.realm.model;

import io.realm.RealmList;
import io.realm.RealmObject;

public class ConstructionTypeModel extends RealmObject {
    private RealmList<ConstructionTypeItemModel> constructionType;

    public RealmList<ConstructionTypeItemModel> getConstructionType() {
        return constructionType;
    }

    public void setConstructionType(RealmList<ConstructionTypeItemModel> constructionType) {
        this.constructionType = constructionType;
    }

    @Override
    public String toString() {
        return
                "ConstructionType{" +
                        "constructionType = '" + constructionType + '\'' +
                        "}";
    }
}