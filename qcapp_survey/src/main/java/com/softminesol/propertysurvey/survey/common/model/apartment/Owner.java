package com.softminesol.propertysurvey.survey.common.model.apartment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Owner implements Serializable{


    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("aadhar_id")
    @Expose
    private String aadharId;
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
    @SerializedName("zone_id")
    @Expose
    private String zoneId;

    @SerializedName("image")
    @Expose
    List<String> registryImage = new ArrayList<>();

    public List<String> getRegistryImagePath() {
        return registryImagePath;
    }

    private List<String> registryImagePath = new ArrayList<>();

    public List<String> getRegistryImage() {
        return registryImage;
    }

    public void setRegistryImage(List<String> registryImage) {
        this.registryImage = registryImage;
        if(this.registryImage == null) {
            this.registryImage = new ArrayList<>();
        }
    }


    public void setRegistryImagePath(List<String> registerImagePath) {
        this.registryImagePath = registerImagePath;
        if(this.registryImagePath == null) {
            this.registryImagePath = new ArrayList<>();
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAadharId() {
        return aadharId;
    }

    public void setAadharId(String aadharId) {
        this.aadharId = aadharId;
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

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }
}
