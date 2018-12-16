package com.softminesol.propertysurvey.survey.common.realm.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class OwnerShipListModel extends RealmObject {

    @SerializedName("ownership")
    private RealmList<OwnershipItemModel> ownership;

    public RealmList<OwnershipItemModel> getOwnership() {
        return ownership;
    }

    public void setOwnership(RealmList<OwnershipItemModel> ownership) {
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