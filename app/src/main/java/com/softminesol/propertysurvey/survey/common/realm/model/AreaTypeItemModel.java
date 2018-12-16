package com.softminesol.propertysurvey.survey.common.realm.model;

import io.realm.RealmObject;

public class AreaTypeItemModel extends RealmObject {
    private int areatypeid;
    private String areatype;

    public int getAreatypeid() {
        return areatypeid;
    }

    public void setAreatypeid(int areatypeid) {
        this.areatypeid = areatypeid;
    }

    public String getAreatype() {
        return areatype;
    }

    public void setAreatype(String areatype) {
        this.areatype = areatype;
    }

    @Override
    public String toString() {
        return
                getText();
    }

    public String getText() {
        return areatype;
    }
}
