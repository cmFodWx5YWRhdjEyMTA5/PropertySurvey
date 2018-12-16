package com.softminesol.propertysurvey.survey.common.model.formData;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FormData {

    @SerializedName("totalAreaMeasurementUnit")
    private String totalAreaMeasurementUnit;

    @SerializedName("wardNo")
    private String wardNo;

    @SerializedName("lattitude")
    private double lattitude;

    @SerializedName("longitutue")
    private double longitutue;



    @SerializedName("districtCode")
    private String districtCode;

    @SerializedName("floorcount")
    private String floorcount;

    @SerializedName("streetCode")
    private String streetCode;

    @SerializedName("floorDetails")
    private List<FloorDetailsItem> floorDetails;

    @SerializedName("colonyName")
    private String colonyName;

    @SerializedName("measurementUnit")
    private String measurementUnit;

    @SerializedName("propertyUID")
    private String propertyUID;


    @SerializedName("zone")
    private String zone;

    @SerializedName("locationID")
    private String locationID;

    @SerializedName("areaType")
    private String areaType;

    @SerializedName("basePlotSizeWidth")
    private String basePlotSizeWidth;

    @SerializedName("addressLine1")
    private String addressLine1;

    @SerializedName("stateCode")
    private String stateCode;

    @SerializedName("basePlotSizeLength")
    private String basePlotSizeLength;

    @SerializedName("yearOfSeverageConnection")
    private String yearOfSeverageConnection;

    @SerializedName("severageConnection")
    private String severageConnection;

    @SerializedName("oldPropertyUID")
    private String oldPropertyUID;

    @SerializedName("propertyNumber")
    private String propertyNumber;

    @SerializedName("totalArea")
    private String totalArea;

    @SerializedName("waterConnection")
    private String waterConnection;

    @SerializedName("mccCode")
    private String MCCOde;

    @SerializedName("msmo")
    private String MSMO;
    @SerializedName("remarks")
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

    public List<FloorDetailsItem> getFloorDetails() {
        return floorDetails;
    }

    public void setFloorDetails(List<FloorDetailsItem> floorDetails) {
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

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public double getLongitutue() {
        return longitutue;
    }

    public void setLongitutue(double longitutue) {
        this.longitutue = longitutue;
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
}