package com.softminesol.survey_framework.survey.common.model.formData;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class FloorDetailsItem implements Serializable {

    @SerializedName("tradeLicesenceNumber")
    private String tradeLicesenceNumber;

    @SerializedName("constructionType")
    private String constructionType;

    @SerializedName("propertySubType")
    private String propertySubType;

    @SerializedName("coveredArea")
    private String coveredArea;

    @SerializedName("isBPL")
    private String isBPL;

    @SerializedName("floorType")
    private String floorType;

    @SerializedName("yearOfConstruction")
    private String yearOfConstruction;

    @SerializedName("occupierName")
    private String occupierName;

    @SerializedName("propertyOwnerType")
    private String propertyOwnerType;

    @SerializedName("titleOfBuilding")
    private String titleOfBuilding;

    @SerializedName("propertyOwnerCount")
    private String propertyOwnerCount;

    @SerializedName("bplNumber")
    private String bplNumber;

    @SerializedName("ownerDetails")
    private List<OwnerDetailsItem> ownerDetails;

    @SerializedName("coveredAreaMeasurementUnit")
    private String coveredAreaMeasurementUnit;

    @SerializedName("propertyType")
    private String propertyType;

    @SerializedName("propertyImageID")
    private String propertyImageID;

    @SerializedName("yearOfEstablishment")
    private String yearOfEstablishment;

    @SerializedName("licesenceIssueDate")
    private String licesenceIssueDate;

    @SerializedName("typeOfBusiness")
    private String typeOfBusiness;

    @SerializedName("propertyCategory")
    private String propertyCategory;

    @SerializedName("rebateID")
    private String rebateID;

    @SerializedName("usageType")
    private String usageType;
    private String yearOfOccupying;

    private boolean isPicSynced;

    public boolean isPicSynced() {
        return isPicSynced;
    }

    public String state;

    public String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPicSynced(boolean picSynced) {
        isPicSynced = picSynced;
    }

    public String getYearOfOccupying() {
        return yearOfOccupying;
    }

    public String getTradeLicesenceNumber() {
        return tradeLicesenceNumber;
    }

    public void setTradeLicesenceNumber(String tradeLicesenceNumber) {
        this.tradeLicesenceNumber = tradeLicesenceNumber;
    }

    public String getConstructionType() {
        return constructionType;
    }

    public void setConstructionType(String constructionType) {
        this.constructionType = constructionType;
    }

    public String getPropertySubType() {
        return propertySubType;
    }

    public void setPropertySubType(String propertySubType) {
        this.propertySubType = propertySubType;
    }

    public String getCoveredArea() {
        return coveredArea;
    }

    public void setCoveredArea(String coveredArea) {
        this.coveredArea = coveredArea;
    }

    public String getIsBPL() {
        return isBPL;
    }

    public void setIsBPL(String isBPL) {
        this.isBPL = isBPL;
    }

    public String getFloorType() {
        return floorType;
    }

    public void setFloorType(String floorType) {
        this.floorType = floorType;
    }

    public String getYearOfConstruction() {
        return yearOfConstruction;
    }

    public void setYearOfConstruction(String yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }

    public String getOccupierName() {
        return occupierName;
    }

    public void setOccupierName(String occupierName) {
        this.occupierName = occupierName;
    }

    public String getPropertyOwnerType() {
        return propertyOwnerType;
    }

    public void setPropertyOwnerType(String propertyOwnerType) {
        this.propertyOwnerType = propertyOwnerType;
    }

    public String getTitleOfBuilding() {
        return titleOfBuilding;
    }

    public void setTitleOfBuilding(String titleOfBuilding) {
        this.titleOfBuilding = titleOfBuilding;
    }

    public String getPropertyOwnerCount() {
        if(propertyOwnerCount == null)
            return propertyOwnerCount;
        else {
            return ownerDetails.size()+"";
        }
    }

    public void setPropertyOwnerCount(String propertyOwnerCount) {
        this.propertyOwnerCount = propertyOwnerCount;
    }

    public String getBplNumber() {
        return bplNumber;
    }

    public void setBplNumber(String bplNumber) {
        this.bplNumber = bplNumber;
    }

    public List<OwnerDetailsItem> getOwnerDetails() {
        return ownerDetails;
    }

    public void setOwnerDetails(List<OwnerDetailsItem> ownerDetails) {
        this.ownerDetails = ownerDetails;
    }

    public String getCoveredAreaMeasurementUnit() {
        return coveredAreaMeasurementUnit;
    }

    public void setCoveredAreaMeasurementUnit(String coveredAreaMeasurementUnit) {
        this.coveredAreaMeasurementUnit = coveredAreaMeasurementUnit;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getPropertyImageID() {
        return propertyImageID;
    }

    public void setPropertyImageID(String propertyImageID) {
        this.propertyImageID = propertyImageID;
    }

    public String getYearOfEstablishment() {
        return yearOfEstablishment;
    }

    public void setYearOfEstablishment(String yearOfEstablishment) {
        this.yearOfEstablishment = yearOfEstablishment;
    }

    public String getLicesenceIssueDate() {
        return licesenceIssueDate;
    }

    public void setLicesenceIssueDate(String licesenceIssueDate) {
        this.licesenceIssueDate = licesenceIssueDate;
    }

    public String getTypeOfBusiness() {
        return typeOfBusiness;
    }

    public void setTypeOfBusiness(String typeOfBusiness) {
        this.typeOfBusiness = typeOfBusiness;
    }

    public String getPropertyCategory() {
        return propertyCategory;
    }

    public void setPropertyCategory(String propertyCategory) {
        this.propertyCategory = propertyCategory;
    }

    public String getRebateID() {
        return rebateID;
    }

    public void setRebateID(String rebateID) {
        this.rebateID = rebateID;
    }

    public String getUsageType() {
        return usageType;
    }

    public void setUsageType(String usageType) {
        this.usageType = usageType;
    }



    @Override
    public String toString() {
        return
                "FloorDetailsItem{" +
                        "tradeLicesenceNumber = '" + tradeLicesenceNumber + '\'' +
                        ",constructionType = '" + constructionType + '\'' +
                        ",propertySubType = '" + propertySubType + '\'' +
                        ",coveredArea = '" + coveredArea + '\'' +
                        ",isBPL = '" + isBPL + '\'' +
                        ",floorType = '" + floorType + '\'' +
                        ",yearOfConstruction = '" + yearOfConstruction + '\'' +
                        ",occupierName = '" + occupierName + '\'' +
                        ",propertyOwnerType = '" + propertyOwnerType + '\'' +
                        ",titleOfBuilding = '" + titleOfBuilding + '\'' +
                        ",propertyOwnerCount = '" + propertyOwnerCount + '\'' +
                        ",bplNumber = '" + bplNumber + '\'' +
                        ",ownerDetails = '" + ownerDetails + '\'' +
                        ",coveredAreaMeasurementUnit = '" + coveredAreaMeasurementUnit + '\'' +
                        ",propertyType = '" + propertyType + '\'' +
                        ",propertyImageID = '" + propertyImageID + '\'' +
                        ",yearOfEstablishment = '" + yearOfEstablishment + '\'' +
                        ",licesenceIssueDate = '" + licesenceIssueDate + '\'' +
                        ",typeOfBusiness = '" + typeOfBusiness + '\'' +
                        ",propertyCategory = '" + propertyCategory + '\'' +
                        ",rebateID = '" + rebateID + '\'' +
                        ",usageType = '" + usageType + '\'' +
                        "}";
    }

    public void setOccupyingYear(String yearOfOccupying) {
        this.yearOfOccupying = yearOfOccupying;
    }


}