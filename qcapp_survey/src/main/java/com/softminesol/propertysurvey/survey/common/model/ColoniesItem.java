package com.softminesol.propertysurvey.survey.common.model;

import com.google.gson.annotations.SerializedName;

import frameworks.customadapter.CustomAdapterModel;

public class ColoniesItem extends CustomAdapterModel {

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

    @Override
    public String getText() {
        return colonyname;
    }
}