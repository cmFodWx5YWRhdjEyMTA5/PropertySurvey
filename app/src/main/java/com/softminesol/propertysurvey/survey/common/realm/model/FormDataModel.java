package com.softminesol.propertysurvey.survey.common.realm.model;

import javax.annotation.Nonnull;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FormDataModel extends RealmObject {

    private String totalAreaMeasurementUnit;
    private String wardNo;
    private String districtCode;
    private String floorcount;
    private String streetCode;
    private RealmList<FloorDetailsItemModel> floorDetails;
    private String colonyName;
    private String measurementUnit;
    @PrimaryKey
    private String propertyUID;
    @Nonnull
    private String dbId;
    private String zone;
    private String locationID;
    private String areaType;
    private String basePlotSizeWidth;
    private String addressLine1;
    private String stateCode;
    private String basePlotSizeLength;
    private String yearOfSeverageConnection;
    private String severageConnection;
    private String oldPropertyUID;
    private String propertyNumber;
    private String totalArea;
    private String waterConnection;
    private String MCCOde;
    private String MSMO;
    private String remarks;
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMSMO() {
        return MSMO;
    }

    public void setMSMO(String MSMO) {
        this.MSMO = MSMO;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getMCCOde() {
        return MCCOde;
    }

    public void setMCCOde(String MCCOde) {
        this.MCCOde = MCCOde;
    }

    public String getTotalAreaMeasurementUnit() {
        return totalAreaMeasurementUnit;
    }

    public void setTotalAreaMeasurementUnit(String totalAreaMeasurementUnit) {
        this.totalAreaMeasurementUnit = totalAreaMeasurementUnit;
    }

    public String getWardNo() {
        return wardNo;
    }

    public void setWardNo(String wardNo) {
        this.wardNo = wardNo;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getFloorcount() {
        return floorcount;
    }

    public void setFloorcount(String floorcount) {
        this.floorcount = floorcount;
    }

    public String getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(String streetCode) {
        this.streetCode = streetCode;
    }

    public RealmList<FloorDetailsItemModel> getFloorDetails() {
        return floorDetails;
    }

    public void setFloorDetails(RealmList<FloorDetailsItemModel> floorDetails) {
        this.floorDetails = floorDetails;
    }

    public String getColonyName() {
        return colonyName;
    }

    public void setColonyName(String colonyName) {
        this.colonyName = colonyName;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public String getPropertyUID() {
        return propertyUID;
    }

    public void setPropertyUID(String propertyUID) {
        this.propertyUID = propertyUID;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public String getBasePlotSizeWidth() {
        return basePlotSizeWidth;
    }

    public void setBasePlotSizeWidth(String basePlotSizeWidth) {
        this.basePlotSizeWidth = basePlotSizeWidth;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getBasePlotSizeLength() {
        return basePlotSizeLength;
    }

    public void setBasePlotSizeLength(String basePlotSizeLength) {
        this.basePlotSizeLength = basePlotSizeLength;
    }

    public String getYearOfSeverageConnection() {
        return yearOfSeverageConnection;
    }

    public void setYearOfSeverageConnection(String yearOfSeverageConnection) {
        this.yearOfSeverageConnection = yearOfSeverageConnection;
    }

    public String getSeverageConnection() {
        return severageConnection;
    }

    public void setSeverageConnection(String severageConnection) {
        this.severageConnection = severageConnection;
    }

    public String getOldPropertyUID() {
        return oldPropertyUID;
    }

    public void setOldPropertyUID(String oldPropertyUID) {
        this.oldPropertyUID = oldPropertyUID;
    }

    public String getPropertyNumber() {
        return propertyNumber;
    }

    public void setPropertyNumber(String propertyNumber) {
        this.propertyNumber = propertyNumber;
    }

    public String getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(String totalArea) {
        this.totalArea = totalArea;
    }

    public String getWaterConnection() {
        return waterConnection;
    }

    public void setWaterConnection(String waterConnection) {
        this.waterConnection = waterConnection;
    }

    @Override
    public String toString() {
        return
                "FormData{" +
                        "totalAreaMeasurementUnit = '" + totalAreaMeasurementUnit + '\'' +
                        ",wardNo = '" + wardNo + '\'' +
                        ",severageConnection = '" + severageConnection + '\'' +
                        ",districtCode = '" + districtCode + '\'' +
                        ",floorcount = '" + floorcount + '\'' +
                        ",streetCode = '" + streetCode + '\'' +
                        ",floorDetails = '" + floorDetails + '\'' +
                        ",colonyName = '" + colonyName + '\'' +
                        ",measurementUnit = '" + measurementUnit + '\'' +
                        ",propertyUID = '" + propertyUID + '\'' +
                        ",mccCode = '" + MCCOde + '\'' +
                        ",zone = '" + zone + '\'' +
                        ",locationID = '" + locationID + '\'' +
                        ",areaType = '" + areaType + '\'' +
                        ",basePlotSizeWidth = '" + basePlotSizeWidth + '\'' +
                        ",addressLine1 = '" + addressLine1 + '\'' +
                        ",stateCode = '" + stateCode + '\'' +
                        ",basePlotSizeLength = '" + basePlotSizeLength + '\'' +
                        ",yearOfSeverageConnection = '" + yearOfSeverageConnection + '\'' +
                        ",oldPropertyUID = '" + oldPropertyUID + '\'' +
                        ",propertyNumber = '" + propertyNumber + '\'' +
                        ",totalArea = '" + totalArea + '\'' +
                        ",waterConnection = '" + waterConnection + '\'' +
                        "}";
    }

    @Nonnull
    public String getDbId() {
        return dbId;
    }

    public void setDbId(@Nonnull String dbId) {
        this.dbId = dbId;
    }
}