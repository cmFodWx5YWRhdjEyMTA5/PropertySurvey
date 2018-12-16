package com.softminesol.propertysurvey.survey.common.realm.model;

import io.realm.RealmObject;

public class ConstructionTypeItemModel extends RealmObject {
    private int constructiontypeid;
    private String constructiontype;

    public int getConstructiontypeid() {
        return constructiontypeid;
    }

    public void setConstructiontypeid(int constructiontypeid) {
        this.constructiontypeid = constructiontypeid;
    }

    public String getConstructiontype() {
        return constructiontype;
    }

    public void setConstructiontype(String constructiontype) {
        this.constructiontype = constructiontype;
    }

    @Override
    public String toString() {
        return
                getText();
    }

    public String getText() {
        return constructiontype;
    }
}
