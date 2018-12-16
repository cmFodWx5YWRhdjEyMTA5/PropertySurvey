package com.softminesol.propertysurvey.survey.common.realm.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class MeasurementUnitListModel extends RealmObject {

    @SerializedName("measurementUnit")
    private RealmList<MeasurementUnitItemModel> measurementUnit;

    public RealmList<MeasurementUnitItemModel> getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(RealmList<MeasurementUnitItemModel> measurementUnit) {
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