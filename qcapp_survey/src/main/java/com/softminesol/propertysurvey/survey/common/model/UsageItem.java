package com.softminesol.propertysurvey.survey.common.model;

import com.google.gson.annotations.SerializedName;

import frameworks.customadapter.CustomAdapterModel;

public class UsageItem extends CustomAdapterModel {

    @SerializedName("usageid")
    private int usageid;

    @SerializedName("usagedescription")
    private String usagedescription;

    public int getUsageid() {
        return usageid;
    }

    public void setUsageid(int usageid) {
        this.usageid = usageid;
    }

    public String getUsagedescription() {
        return usagedescription;
    }

    public void setUsagedescription(String usagedescription) {
        this.usagedescription = usagedescription;
    }

    @Override
    public String toString() {
        return getText();
    }

    @Override
    public String getText() {
        return usagedescription;
    }
}