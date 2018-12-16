package com.softminesol.propertysurvey.survey.common.realm.model;

import io.realm.RealmList;
import io.realm.RealmObject;

public class OldPropertyUIDSModel extends RealmObject {
    private RealmList<OldPropertyUIDItemModel> oldPropertyUID;

    public RealmList<OldPropertyUIDItemModel> getOldPropertyUID() {
        return oldPropertyUID;
    }

    public void setOldPropertyUID(RealmList<OldPropertyUIDItemModel> oldPropertyUID) {
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