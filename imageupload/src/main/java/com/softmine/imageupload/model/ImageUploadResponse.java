package com.softmine.imageupload.model;

import com.google.gson.annotations.SerializedName;

public class ImageUploadResponse {
    @SerializedName("data")
    private ImageUploadResponseData uploadResponseData;
    @SerializedName("message")
    private String message;
    @SerializedName("statusCode")
    private String statusCode;

    public ImageUploadResponseData getUploadResponseData() {
        return uploadResponseData;
    }

    public void setUploadResponseData(ImageUploadResponseData uploadResponseData) {
        this.uploadResponseData = uploadResponseData;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setStatusCode(String statusCode){
        this.statusCode = statusCode;
    }

    public String getStatusCode(){
        return statusCode;
    }

    @Override
    public String toString(){
        return
                "ForgotPasswordResponse{" +
                        "data = '" + uploadResponseData + '\'' +
                        ",message = '" + message + '\'' +
                        ",statusCode = '" + statusCode + '\'' +
                        "}";
    }
}