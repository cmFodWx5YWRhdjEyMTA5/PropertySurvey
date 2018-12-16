package com.softminesol.propertysurvey.survey.common.realm.model;

import io.realm.RealmObject;

public class OldPropertyUIDItemModel extends RealmObject {
    private String oldpropertyuid;

    public String getOldpropertyuid() {
        return oldpropertyuid;
    }

    public void setOldpropertyuid(String oldpropertyuid) {
        this.oldpropertyuid = oldpropertyuid;
    }

    @Override
    public String toString() {
        return
                getText();
    }

    public String getText() {
        return getOldpropertyuid();
    }
}
