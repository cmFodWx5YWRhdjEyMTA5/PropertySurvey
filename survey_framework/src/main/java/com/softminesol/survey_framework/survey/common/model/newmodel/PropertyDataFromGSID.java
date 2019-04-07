package com.softminesol.survey_framework.survey.common.model.newmodel;

import com.google.gson.annotations.SerializedName;
import com.softminesol.survey_framework.survey.common.model.property.SavePropertyRequest;

public class PropertyDataFromGSID {
    @SerializedName("PropertyDetails")
    SavePropertyRequest savePropertyRequest;

    public SavePropertyRequest getSavePropertyRequest() {
        return savePropertyRequest;
    }

    public void setSavePropertyRequest(SavePropertyRequest savePropertyRequest) {
        this.savePropertyRequest = savePropertyRequest;
    }
}
