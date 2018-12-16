package com.softminesol.propertysurvey.survey.common.realm.model;

import io.realm.RealmList;
import io.realm.RealmObject;

public class FloorDetailsItemModel extends RealmObject {

    private String tradeLicesenceNumber;
    private String constructionType;
    private String propertySubType;
    private String coveredArea;
    private String isBPL;
    private String floorType;
    private String yearOfConstruction;
    private String occupierName;
    private String propertyOwnerType;
    private String titleOfBuilding;
    private String propertyOwnerCount;
    private String bplNumber;
    private RealmList<OwnerDetailsItemModel> ownerDetails;
    private String coveredAreaMeasurementUnit;
    private String propertyType;
    private String propertyImageID;
    private String propertyImagePath;
    private String yearOfEstablishment;
    private String licesenceIssueDate;
    private String typeOfBusiness;
    private String propertyCategory;
    private String rebateID;
    private String usageType;
    private String yearOfOccupying;

    public String getPropertyImagePath() {
        return propertyImagePath;
    }

    public void setPropertyImagePath(String propertyImagePath) {
        this.propertyImagePath = propertyImagePath;
    }

    public String getYearOfOccupying() {
        return yearOfOccupying;
    }

    public void setYearOfOccupying(String yearOfOccupying) {
        this.yearOfOccupying = yearOfOccupying;
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
        return propertyOwnerCount;
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

    public RealmList<OwnerDetailsItemModel> getOwnerDetails() {
        return ownerDetails;
    }

    public void setOwnerDetails(RealmList<OwnerDetailsItemModel> ownerDetails) {
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
