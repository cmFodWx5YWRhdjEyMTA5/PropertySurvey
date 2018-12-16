package com.softminesol.propertysurvey.survey.common.realm.model;

import javax.annotation.Nonnull;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class BillDetailsModel extends RealmObject {

    private String mobileNumber;
    private String name;
    private String addressLine1;
    private String emailID;
    @PrimaryKey
    private String oldPropertyUID;
    @Nonnull
    private String dbId;
    private String imageID;
    private String status;
    private String state;
    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Nonnull
    public String getDbId() {
        return dbId;
    }

    public void setDbId(@Nonnull String dbId) {
        this.dbId = dbId;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}