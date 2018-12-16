package com.softminesol.propertysurvey.survey.common.realm.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class FloorsListModel extends RealmObject {

    @SerializedName("floors")
    private RealmList<FloorsItemModel> floors;

    public RealmList<FloorsItemModel> getFloors() {
        return floors;
    }

    public void setFloors(RealmList<FloorsItemModel> floors) {
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