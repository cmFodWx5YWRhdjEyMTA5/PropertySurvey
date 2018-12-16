package com.softminesol.propertysurvey.survey.common.realm.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class FloorsItemModel extends RealmObject {

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

    public String getText() {
        return floor;
    }
}