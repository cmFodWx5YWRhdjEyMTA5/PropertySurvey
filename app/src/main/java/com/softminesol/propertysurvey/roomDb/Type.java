package com.softminesol.propertysurvey.roomDb;

import android.arch.persistence.room.Entity;

@Entity
public class Type {
    String type;
    String json;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
