package com.softminesol.propertysurvey.survey.common.model;

import com.google.gson.annotations.SerializedName;

import frameworks.customadapter.CustomAdapterModel;

public class OwnershipItem extends CustomAdapterModel {

    @SerializedName("ownershipid")
    private int ownershipid;

    @SerializedName("ownership")
    private String ownership;

    public int getOwnershipid() {
        return ownershipid;
    }

    public void setOwnershipid(int ownershipid) {
        this.ownershipid = ownershipid;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    @Override
    public String toString() {
        return
                getText();
    }

    @Override
    public String getText() {
        return ownership;
    }
}