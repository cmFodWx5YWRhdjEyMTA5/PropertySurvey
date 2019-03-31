package com.softminesol.propertysurvey.survey.common.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FloorsList {

    @SerializedName("floors")
    private List<FloorsItem> floors;

    public List<FloorsItem> getFloors() {
        return floors;
    }

    public void setFloors(List<FloorsItem> floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return
                "FloorsList{" +
                        "floors = '" + floors + '\'' +
                        "}";
    }
}