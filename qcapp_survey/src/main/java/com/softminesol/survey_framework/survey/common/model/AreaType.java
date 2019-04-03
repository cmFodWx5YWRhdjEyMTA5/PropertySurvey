package com.softminesol.survey_framework.survey.common.model;

import java.util.List;

public class AreaType {
    private List<AreaTypeItem> areaType;

    public List<AreaTypeItem> getAreaType() {
        return areaType;
    }

    public void setAreaType(List<AreaTypeItem> areaType) {
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