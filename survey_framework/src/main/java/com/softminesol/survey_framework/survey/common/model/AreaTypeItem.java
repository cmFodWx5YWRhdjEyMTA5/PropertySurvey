package com.softminesol.survey_framework.survey.common.model;

import frameworks.customadapter.CustomAdapterModel;

public class AreaTypeItem extends CustomAdapterModel {
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

    @Override
    public String getText() {
        return areatype;
    }
}
