package com.softminesol.propertysurvey.survey.common.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ColonyList {

    @SerializedName("colonies")
    private List<ColoniesItem> colonies;

    public List<ColoniesItem> getColonies() {
        return colonies;
    }

    public void setColonies(List<ColoniesItem> colonies) {
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