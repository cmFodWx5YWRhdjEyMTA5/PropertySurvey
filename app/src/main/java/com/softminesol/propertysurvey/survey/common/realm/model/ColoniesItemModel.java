package com.softminesol.propertysurvey.survey.common.realm.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class ColoniesItemModel extends RealmObject {

    @SerializedName("colonyname")
    private String colonyname;

    @SerializedName("colonyid")
    private int colonyid;

    public String getColonyname() {
        return colonyname;
    }

    public void setColonyname(String colonyname) {
        this.colonyname = colonyname;
    }

    public int getColonyid() {
        return colonyid;
    }

    public void setColonyid(int colonyid) {
        this.colonyid = colonyid;
    }

    @Override
    public String toString() {
        return
                "ColoniesItem{" +
                        "colonyname = '" + colonyname + '\'' +
                        ",colonyid = '" + colonyid + '\'' +
                        "}";
    }

    public String getText() {
        return colonyname;
    }
}