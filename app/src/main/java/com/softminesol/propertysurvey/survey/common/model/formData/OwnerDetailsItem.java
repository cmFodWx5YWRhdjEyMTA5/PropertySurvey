package com.softminesol.propertysurvey.survey.common.model.formData;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OwnerDetailsItem implements Serializable {

    @SerializedName("relationName")
    private String relationName;

    @SerializedName("gender")
    private String gender;

    @SerializedName("relationWith")
    private String relationWith;

    @SerializedName("mobileNumber")
    private String mobileNumber;

    @SerializedName("name")
    private String name;

    @SerializedName("addressLine1")
    private String addressLine1;

    @SerializedName("emailID")
    private String emailID;

    @SerializedName("ownershipShare")
    private String ownershipShare;

    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRelationWith() {
        return relationWith;
    }

    public void setRelationWith(String relationWith) {
        this.relationWith = relationWith;
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

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getOwnershipShare() {
        return ownershipShare;
    }

    public void setOwnershipShare(String ownershipShare) {
        this.ownershipShare = ownershipShare;
    }

    @Override
    public String toString() {
        return
                "OwnerDetailsItem{" +
                        "relationName = '" + relationName + '\'' +
                        ",gender = '" + gender + '\'' +
                        ",relationWith = '" + relationWith + '\'' +
                        ",mobileNumber = '" + mobileNumber + '\'' +
                        ",name = '" + name + '\'' +
                        ",addressLine1 = '" + addressLine1 + '\'' +
                        ",emailID = '" + emailID + '\'' +
                        ",ownershipShare = '" + ownershipShare + '\'' +
                        "}";
    }

}