package com.softminesol.propertysurvey.survey.common.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsageList {

    @SerializedName("usage")
    private List<UsageItem> usage;

    public List<UsageItem> getUsage() {
        return usage;
    }

    public void setUsage(List<UsageItem> usage) {
        this.usage = usage;
    }

    @Override
    public String toString() {
        return
                "UsageList{" +
                        "usage = '" + usage + '\'' +
                        "}";
    }
}