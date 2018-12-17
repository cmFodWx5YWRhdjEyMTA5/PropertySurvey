package com.softminesol.propertysurvey.survey.common.model.apartment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SaveApartmentRequest implements Serializable {

    @SerializedName("gis_id")
    @Expose
    private String gisId;
    @SerializedName("floor")
    @Expose
    private String floor;
    @SerializedName("property_usage")
    @Expose
    private String propertyUsage;
    @SerializedName("non_residential_code")
    @Expose
    private String nonResidentialCode;
    @SerializedName("non_residential_category")
    @Expose
    private String nonResidentialCategory;
    @SerializedName("shop_name")
    @Expose
    private String shopName;
    @SerializedName("business_type")
    @Expose
    private String businessType;
    @SerializedName("business_code")
    @Expose
    private String businessCode;
    @SerializedName("license_status")
    @Expose
    private String licenseStatus;
    @SerializedName("license_number")
    @Expose
    private String licenseNumber;
    @SerializedName("license_validity")
    @Expose
    private String licenseValidity;
    @SerializedName("business_built_area")
    @Expose
    private String businessBuiltArea;
    @SerializedName("respodent_status")
    @Expose
    private String respodentStatus;
    @SerializedName("respodent_name")
    @Expose
    private String respodentName;
    @SerializedName("occupency_status")
    @Expose
    private String occupencyStatus;
    @SerializedName("electricity_connection_status")
    @Expose
    private String electricityConnectionStatus;
    @SerializedName("electricity_connection")
    @Expose
    private String electricityConnection;
    @SerializedName("sewerage_status")
    @Expose
    private String sewerageStatus;
    @SerializedName("source_water")
    @Expose
    private String sourceWater;
    @SerializedName("construction_type")
    @Expose
    private String constructionType;
    @SerializedName("self_occupied")
    @Expose
    private String selfOccupied;
    @SerializedName("tenanted")
    @Expose
    private String tenanted;
    @SerializedName("power_backup")
    @Expose
    private String powerBackup;
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
    @SerializedName("ownerCount")
    @Expose
    private String ownerCount;
    @SerializedName("owners")
    @Expose
    private List<Owner> owners = null;

    public String getGisId() {
        return gisId;
    }

    public void setGisId(String gisId) {
        this.gisId = gisId;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getPropertyUsage() {
        return propertyUsage;
    }

    public void setPropertyUsage(String propertyUsage) {
        this.propertyUsage = propertyUsage;
    }

    public String getNonResidentialCode() {
        return nonResidentialCode;
    }

    public void setNonResidentialCode(String nonResidentialCode) {
        this.nonResidentialCode = nonResidentialCode;
    }

    public String getNonResidentialCategory() {
        return nonResidentialCategory;
    }

    public void setNonResidentialCategory(String nonResidentialCategory) {
        this.nonResidentialCategory = nonResidentialCategory;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getBusinessType() {
        return businessType;
    }

    public String getRespodentName() {
        return respodentName;
    }

    public void setRespodentName(String respodentName) {
        this.respodentName = respodentName;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getLicenseStatus() {
        return licenseStatus;
    }

    public void setLicenseStatus(String licenseStatus) {
        this.licenseStatus = licenseStatus;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseValidity() {
        return licenseValidity;
    }

    public void setLicenseValidity(String licenseValidity) {
        this.licenseValidity = licenseValidity;
    }

    public String getBusinessBuiltArea() {
        return businessBuiltArea;
    }

    public void setBusinessBuiltArea(String businessBuiltArea) {
        this.businessBuiltArea = businessBuiltArea;
    }

    public String getRespodentStatus() {
        return respodentStatus;
    }

    public void setRespodentStatus(String respodentStatus) {
        this.respodentStatus = respodentStatus;
    }

    public String getOccupencyStatus() {
        return occupencyStatus;
    }

    public void setOccupencyStatus(String occupencyStatus) {
        this.occupencyStatus = occupencyStatus;
    }

    public String getElectricityConnectionStatus() {
        return electricityConnectionStatus;
    }

    public void setElectricityConnectionStatus(String electricityConnectionStatus) {
        this.electricityConnectionStatus = electricityConnectionStatus;
    }

    public String getElectricityConnection() {
        return electricityConnection;
    }

    public void setElectricityConnection(String electricityConnection) {
        this.electricityConnection = electricityConnection;
    }

    public String getSewerageStatus() {
        return sewerageStatus;
    }

    public void setSewerageStatus(String sewerageStatus) {
        this.sewerageStatus = sewerageStatus;
    }

    public String getSourceWater() {
        return sourceWater;
    }

    public void setSourceWater(String sourceWater) {
        this.sourceWater = sourceWater;
    }

    public String getConstructionType() {
        return constructionType;
    }

    public void setConstructionType(String constructionType) {
        this.constructionType = constructionType;
    }

    public String getSelfOccupied() {
        return selfOccupied;
    }

    public void setSelfOccupied(String selfOccupied) {
        this.selfOccupied = selfOccupied;
    }

    public String getTenanted() {
        return tenanted;
    }

    public void setTenanted(String tenanted) {
        this.tenanted = tenanted;
    }

    public String getPowerBackup() {
        return powerBackup;
    }

    public void setPowerBackup(String powerBackup) {
        this.powerBackup = powerBackup;
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

    public String getOwnerCount() {
        return ownerCount;
    }

    public void setOwnerCount(String ownerCount) {
        this.ownerCount = ownerCount;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }
}