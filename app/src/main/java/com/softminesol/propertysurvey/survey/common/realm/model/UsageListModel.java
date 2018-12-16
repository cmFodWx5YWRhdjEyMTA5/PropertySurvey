package com.softminesol.propertysurvey.survey.common.realm.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class UsageListModel extends RealmObject {

    @SerializedName("usage")
    private RealmList<UsageItemModel> usage;

    public RealmList<UsageItemModel> getUsage() {
        return usage;
    }

    public void setUsage(RealmList<UsageItemModel> usage) {
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