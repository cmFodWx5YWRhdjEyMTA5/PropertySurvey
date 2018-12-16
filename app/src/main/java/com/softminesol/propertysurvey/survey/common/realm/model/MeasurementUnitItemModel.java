package com.softminesol.propertysurvey.survey.common.realm.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class MeasurementUnitItemModel extends RealmObject {

    @SerializedName("measurementid")
    private String measurementid;

    @SerializedName("measurementunit")
    private String measurementunit;

    public String getMeasurementid() {
        return measurementid;
    }

    public void setMeasurementid(String measurementid) {
        this.measurementid = measurementid;
    }

    public String getMeasurementunit() {
        return measurementunit;
    }

    public void setMeasurementunit(String measurementunit) {
        this.measurementunit = measurementunit;
    }

    @Override
    public String toString() {
        return
                getText();
    }

    public String getText() {
        return measurementunit;
    }
}