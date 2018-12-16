package com.softminesol.propertysurvey.survey.common.realm.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class RebateItemModel extends RealmObject {

    @SerializedName("rebateid")
    private int rebateid;

    @SerializedName("rebatedescription")
    private String rebatedescription;

    public int getRebateid() {
        return rebateid;
    }

    public void setRebateid(int rebateid) {
        this.rebateid = rebateid;
    }

    public String getRebatedescription() {
        return rebatedescription;
    }

    public void setRebatedescription(String rebatedescription) {
        this.rebatedescription = rebatedescription;
    }

    @Override
    public String toString() {
        return
                getText();
    }

    public String getText() {
        return rebatedescription;
    }
}