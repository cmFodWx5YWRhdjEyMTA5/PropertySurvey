package com.softminesol.propertysurvey.survey.common.model;

import com.google.gson.annotations.SerializedName;

import frameworks.customadapter.CustomAdapterModel;

public class OldPropertyUIDItem extends CustomAdapterModel {
    @SerializedName("gis_id")
    private String oldpropertyuid;

    public String getOldpropertyuid() {
        return oldpropertyuid;
    }

    public void setOldpropertyuid(String oldpropertyuid) {
        this.oldpropertyuid = oldpropertyuid;
    }

    @Override
    public String toString() {
        return
                getText();
    }

    @Override
    public String getText() {
        return getOldpropertyuid();
    }
}
