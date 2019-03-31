package com.softminesol.propertysurvey.survey.common.model.property;

import com.google.gson.annotations.SerializedName;

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
