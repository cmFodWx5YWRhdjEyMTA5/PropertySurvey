package com.softminesol.survey_framework.survey.common.model;

import com.google.gson.annotations.SerializedName;

import frameworks.customadapter.CustomAdapterModel;

public class RebateItem extends CustomAdapterModel {

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

    @Override
    public String getText() {
        return rebatedescription;
    }
}