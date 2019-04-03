package com.softminesol.survey_framework.survey.common.model.apartment;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SaveApartmentRequest implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private long tempId;

    private long tempPropertyApartmentId;


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

    @SerializedName("sewerage_connection_number")
    @Expose
    private String sewerageConnectionNumber;
    @SerializedName("source_water")
    @Expose
    private String sourceWater;
    @SerializedName("construction_type")
    @Expose
    private String constructionType;
    @SerializedName("self_occupied_area")
    @Expose
    private String selfOccupiedArea;
    @SerializedName("tenanted_carpet_area")
    @Expose
    private String tenantedCarpetArea;
    @SerializedName("power_backup")
    @Expose
    private String powerBackup;


    @SerializedName("ownerCount")
    @Expose
    private String ownerCount;
    @SerializedName("owners")
    @Expose
    private List<Owner> owners = null;

    @Expose
    @SerializedName("image")
    private List<String> apartmentImage= new ArrayList<>();

    private boolean idDrafted;

    public boolean isIdDrafted() {
        return idDrafted;
    }

    public void setIdDrafted(boolean idDrafted) {
        this.idDrafted = idDrafted;
    }

    public List<String> getApartmentImagepath() {
        return apartmentImagepath;
    }

    public void setApartmentImagepath(List<String> apartmentImagepath) {
        this.apartmentImagepath = apartmentImagepath;
        if(this.apartmentImagepath == null) {
            this.apartmentImagepath = new ArrayList<>();
        }
    }

    private List<String> apartmentImagepath = new ArrayList<>();

    private boolean updatedToServer;

    public boolean isUpdatedToServer() {
        return updatedToServer;
    }

    public void setUpdatedToServer(boolean updatedToServer) {
        this.updatedToServer = updatedToServer;
    }

    public List<String> getApartmentImage() {
        return apartmentImage;
    }

    public void setApartmentImage(List<String> apartmentImage) {
        this.apartmentImage = apartmentImage;
        if(this.apartmentImage == null) {
            this.apartmentImage = new ArrayList<>();
        }
    }

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

    public String getRespodentName() {
        return respodentName;
    }

    public void setRespodentName(String respodentName) {
        this.respodentName = respodentName;
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

    public String getSewerageConnectionNumber() {
        return sewerageConnectionNumber;
    }

    public void setSewerageConnectionNumber(String sewerageConnectionNumber) {
        this.sewerageConnectionNumber = sewerageConnectionNumber;
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

    public String getSelfOccupiedArea() {
        return selfOccupiedArea;
    }

    public void setSelfOccupiedArea(String selfOccupiedArea) {
        this.selfOccupiedArea = selfOccupiedArea;
    }

    public String getTenantedCarpetArea() {
        return tenantedCarpetArea;
    }

    public void setTenantedCarpetArea(String tenantedCarpetArea) {
        this.tenantedCarpetArea = tenantedCarpetArea;
    }

    public String getPowerBackup() {
        return powerBackup;
    }

    public void setPowerBackup(String powerBackup) {
        this.powerBackup = powerBackup;
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

    public long getTempId() {
        return tempId;
    }

    public void setTempId(long tempId) {
        this.tempId = tempId;
    }

    public long getTempPropertyApartmentId() {
        return tempPropertyApartmentId;
    }

    public void setTempPropertyApartmentId(long tempPropertyApartmentId) {
        this.tempPropertyApartmentId = tempPropertyApartmentId;
    }
}