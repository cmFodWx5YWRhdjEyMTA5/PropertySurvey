package com.softminesol.propertysurvey.survey.common.model;

import java.util.List;

public class OLDPropertyUIDS {
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