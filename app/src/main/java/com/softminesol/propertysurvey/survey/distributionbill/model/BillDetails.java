package com.softminesol.propertysurvey.survey.distributionbill.model;

import com.google.gson.annotations.SerializedName;

public class BillDetails {

    @SerializedName("mobileNumber")
    private String mobileNumber;

    @SerializedName("name")
    private String name;

    @SerializedName("addressLine1")
    private String addressLine1;

    @SerializedName("emailID")
    private Object emailID;



    @SerializedName("oldPropertyUID")
    private String oldPropertyUID;
    private String imageID;
    private String status;

    private String imagePath;

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public Object getEmailID() {
        return emailID;
    }

    public void setEmailID(Object emailID) {
        this.emailID = emailID;
    }

    public String getOldPropertyUID() {
        return oldPropertyUID;
    }

    public void setOldPropertyUID(String oldPropertyUID) {
        this.oldPropertyUID = oldPropertyUID;
    }

    @Override
    public String toString() {
        return
                "BillDetails{" +
                        "mobileNumber = '" + mobileNumber + '\'' +
                        ",name = '" + name + '\'' +
                        ",addressLine1 = '" + addressLine1 + '\'' +
                        ",emailID = '" + emailID + '\'' +
                        ",oldPropertyUID = '" + oldPropertyUID + '\'' +
                        "}";
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageID() {
        return imageID;
    }

    public String getStatus() {
        return status;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}