package com.softminesol.propertysurvey.survey.common.realm.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class UsageItemModel extends RealmObject {

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

    public String getText() {
        return usagedescription;
    }
}