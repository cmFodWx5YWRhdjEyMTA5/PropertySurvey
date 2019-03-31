package com.softminesol.propertysurvey.survey.common.model.formData;

import com.google.gson.annotations.SerializedName;

public class PropertyDetails {
    @SerializedName("propertyDetails")
    FormData formData;

    public FormData getFormData() {
        return formData;
    }

    public void setFormData(FormData formData) {
        this.formData = formData;
    }
}
