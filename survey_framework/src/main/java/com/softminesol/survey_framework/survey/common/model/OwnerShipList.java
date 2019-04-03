package com.softminesol.survey_framework.survey.common.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OwnerShipList {

    @SerializedName("ownership")
    private List<OwnershipItem> ownership;

    public List<OwnershipItem> getOwnership() {
        return ownership;
    }

    public void setOwnership(List<OwnershipItem> ownership) {
        this.ownership = ownership;
    }

    @Override
    public String toString() {
        return
                "OwnerShipList{" +
                        "ownership = '" + ownership + '\'' +
                        "}";
    }
}