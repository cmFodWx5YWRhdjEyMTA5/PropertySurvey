package com.softminesol.propertysurvey.survey.common.model.apartment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Owner implements Serializable{
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("unique_id")
    @Expose
    private String uniqueId;
    @SerializedName("mobile_no")
    @Expose
    private String mobileNo;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("building_name")
    @Expose
    private String buildingName;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("colony")
    @Expose
    private String colony;
    @SerializedName("pincode")
    @Expose
    private String pincode;
    @SerializedName("ward_no")
    @Expose
    private String wardNo;
    @SerializedName("circle_no")
    @Expose
    private String circleNo;
    @SerializedName("revenue_circle")
    @Expose
    private String revenueCircle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getColony() {
        return colony;
    }

    public void setColony(String colony) {
        this.colony = colony;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getWardNo() {
        return wardNo;
    }

    public void setWardNo(String wardNo) {
        this.wardNo = wardNo;
    }

    public String getCircleNo() {
        return circleNo;
    }

    public void setCircleNo(String circleNo) {
        this.circleNo = circleNo;
    }

    public String getRevenueCircle() {
        return revenueCircle;
    }

    public void setRevenueCircle(String revenueCircle) {
        this.revenueCircle = revenueCircle;
    }

}
