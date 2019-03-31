package com.softminesol.propertysurvey.survey.common.model;

import java.util.List;

public class ConstructionType {
    private List<ConstructionTypeItem> constructionType;

    public List<ConstructionTypeItem> getConstructionType() {
        return constructionType;
    }

    public void setConstructionType(List<ConstructionTypeItem> constructionType) {
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