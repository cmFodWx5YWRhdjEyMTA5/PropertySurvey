package com.softminesol.propertysurvey.survey.common.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OLDPropertyUIDS {
    @SerializedName("Properties")
    private List<OldPropertyUIDItem> oldPropertyUID;

    public List<OldPropertyUIDItem> getOldPropertyUID() {
        return oldPropertyUID;
    }

    public void setOldPropertyUID(List<OldPropertyUIDItem> oldPropertyUID) {
        this.oldPropertyUID = oldPropertyUID;
    }

    @Override
    public String toString() {
        return
                "OLDPropertyUIDS{" +
                        "oldPropertyUID = '" + oldPropertyUID + '\'' +
                        "}";
    }
}