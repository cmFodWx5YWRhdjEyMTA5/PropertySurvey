package com.softminesol.propertysurvey.survey.common.realm.model;

import io.realm.RealmObject;

/**
 * Created by madhurigupta on 31/10/17.
 */

public class RealmString extends RealmObject {
    private String value;

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
