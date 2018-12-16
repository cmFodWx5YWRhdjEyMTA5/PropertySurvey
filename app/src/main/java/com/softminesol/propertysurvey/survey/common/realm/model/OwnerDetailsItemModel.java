package com.softminesol.propertysurvey.survey.common.realm.model;

import io.realm.RealmObject;

public class OwnerDetailsItemModel extends RealmObject {
    private String relationName;
    private String gender;
    private String relationWith;
    private String mobileNumber;
    private String name;
    private String addressLine1;
    private String emailID;
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
