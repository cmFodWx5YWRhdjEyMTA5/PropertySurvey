package com.softminesol.propertysurvey.survey.common.model.property;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SavePropertyRequest implements Serializable{
    @SerializedName("map_id")
    @Expose
    private String mapId;
    @SerializedName("parcel_id")
    @Expose
    private String parcelId;
    @SerializedName("property_type")
    @Expose
    private String propertyType;
    @SerializedName("property_usage")
    @Expose
    private String propertyUsage;
    @SerializedName("rain_harvesting_system")
    @Expose
    private String rainHarvestingSystem;
    @SerializedName("individual_building")
    @Expose
    private String individualBuilding;
    @SerializedName("lift_facility")
    @Expose
    private String liftFacility;
    @SerializedName("parking_facility")
    @Expose
    private String parkingFacility;
    @SerializedName("fire_fighting")
    @Expose
    private String fireFighting;
    @SerializedName("age_of_property")
    @Expose
    private String ageOfProperty;
    @SerializedName("total_floor")
    @Expose
    private String totalFloor;
    @SerializedName("plot_area")
    @Expose
    private String plotArea;
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

    @SerializedName("image")
    private List<String> imagesList;


    public List<String> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<String> imagesList) {
        this.imagesList = imagesList;
    }

    public String getMapId() {
        return mapId;
    }

    public void setMapId(String mapId) {
        this.mapId = mapId;
    }

    public String getParcelId() {
        return parcelId;
    }

    public void setParcelId(String parcelId) {
        this.parcelId = parcelId;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getPropertyUsage() {
        return propertyUsage;
    }

    public void setPropertyUsage(String propertyUsage) {
        this.propertyUsage = propertyUsage;
    }

    public String getRainHarvestingSystem() {
        return rainHarvestingSystem;
    }

    public void setRainHarvestingSystem(String rainHarvestingSystem) {
        this.rainHarvestingSystem = rainHarvestingSystem;
    }

    public String getIndividualBuilding() {
        return individualBuilding;
    }

    public void setIndividualBuilding(String individualBuilding) {
        this.individualBuilding = individualBuilding;
    }

    public String getLiftFacility() {
        return liftFacility;
    }

    public void setLiftFacility(String liftFacility) {
        this.liftFacility = liftFacility;
    }

    public String getParkingFacility() {
        return parkingFacility;
    }

    public void setParkingFacility(String parkingFacility) {
        this.parkingFacility = parkingFacility;
    }

    public String getFireFighting() {
        return fireFighting;
    }

    public void setFireFighting(String fireFighting) {
        this.fireFighting = fireFighting;
    }

    public String getAgeOfProperty() {
        return ageOfProperty;
    }

    public void setAgeOfProperty(String ageOfProperty) {
        this.ageOfProperty = ageOfProperty;
    }

    public String getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(String totalFloor) {
        this.totalFloor = totalFloor;
    }

    public String getPlotArea() {
        return plotArea;
    }

    public void setPlotArea(String plotArea) {
        this.plotArea = plotArea;
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
