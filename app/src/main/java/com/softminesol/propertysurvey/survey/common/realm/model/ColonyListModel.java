package com.softminesol.propertysurvey.survey.common.realm.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class ColonyListModel extends RealmObject {

    @SerializedName("colonies")
    private RealmList<ColoniesItemModel> colonies;

    public RealmList<ColoniesItemModel> getColonies() {
        return colonies;
    }

    public void setColonies(RealmList<ColoniesItemModel> colonies) {
        this.colonies = colonies;
    }

    @Override
    public String toString() {
        return
                "ColonyList{" +
                        "colonies = '" + colonies + '\'' +
                        "}";
    }
}