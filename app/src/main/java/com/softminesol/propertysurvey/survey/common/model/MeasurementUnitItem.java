package com.softminesol.propertysurvey.survey.common.model;

import com.google.gson.annotations.SerializedName;

import frameworks.customadapter.CustomAdapterModel;

public class MeasurementUnitItem extends CustomAdapterModel {

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

    @Override
    public String getText() {
        return measurementunit;
    }
}