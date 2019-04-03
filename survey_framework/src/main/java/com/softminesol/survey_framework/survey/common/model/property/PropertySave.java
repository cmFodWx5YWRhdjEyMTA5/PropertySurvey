package com.softminesol.survey_framework.survey.common.model.property;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PropertySave {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("gis_id")
    @Expose
    private String gisId;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getGisId() {
        return gisId;
    }

    public void setGisId(String gisId) {
        this.gisId = gisId;
    }
}
