package com.softminesol.propertysurvey.survey.common.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RebateList {

    @SerializedName("rebate")
    private List<RebateItem> rebate;

    public List<RebateItem> getRebate() {
        return rebate;
    }

    public void setRebate(List<RebateItem> rebate) {
        this.rebate = rebate;
    }

    @Override
    public String toString() {
        return
                "RebateList{" +
                        "rebate = '" + rebate + '\'' +
                        "}";
    }
}