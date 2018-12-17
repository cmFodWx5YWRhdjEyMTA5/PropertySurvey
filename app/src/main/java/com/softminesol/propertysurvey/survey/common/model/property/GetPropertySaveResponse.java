package com.softminesol.propertysurvey.survey.common.model.property;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetPropertySaveResponse {
    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private PropertySave data;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PropertySave getData() {
        return data;
    }

    public void setData(PropertySave data) {
        this.data = data;
    }

}
