package com.softminesol.survey_framework.survey.common.model;

import frameworks.customadapter.CustomAdapterModel;

public class ConstructionTypeItem extends CustomAdapterModel {
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

    @Override
    public String getText() {
        return constructiontype;
    }
}
