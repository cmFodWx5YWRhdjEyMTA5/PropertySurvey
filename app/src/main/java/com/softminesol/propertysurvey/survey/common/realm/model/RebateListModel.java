package com.softminesol.propertysurvey.survey.common.realm.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class RebateListModel extends RealmObject {

    @SerializedName("rebate")
    private RealmList<RebateItemModel> rebate;

    public RealmList<RebateItemModel> getRebate() {
        return rebate;
    }

    public void setRebate(RealmList<RebateItemModel> rebate) {
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