package com.softminesol.propertysurvey.survey.common.model;

import com.google.gson.annotations.SerializedName;

import frameworks.customadapter.CustomAdapterModel;

public class FloorsItem extends CustomAdapterModel {

    @SerializedName("floorid")
    private int floorid;

    @SerializedName("floor")
    private String floor;

    public int getFloorid() {
        return floorid;
    }

    public void setFloorid(int floorid) {
        this.floorid = floorid;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return
                getFloor();
    }

    @Override
    public String getText() {
        return floor;
    }
}