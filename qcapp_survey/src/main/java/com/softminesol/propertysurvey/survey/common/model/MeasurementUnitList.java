package com.softminesol.propertysurvey.survey.common.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MeasurementUnitList {

    @SerializedName("measurementUnit")
    private List<MeasurementUnitItem> measurementUnit;

    public List<MeasurementUnitItem> getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(List<MeasurementUnitItem> measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    @Override
    public String toString() {
        return
                "MeasurementUnitList{" +
                        "measurementUnit = '" + measurementUnit + '\'' +
                        "}";
    }
}