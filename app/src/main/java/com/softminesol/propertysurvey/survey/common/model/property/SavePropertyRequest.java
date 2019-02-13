package com.softminesol.propertysurvey.survey.common.model.property;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
public class SavePropertyRequest implements Serializable{
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @SerializedName("map_id")
    @Expose
    private String mapId;
    @SerializedName("parcel_id")
    @Expose
    private String parcelId;

/*    @SerializedName("oldProperty_id")
    @Expose
    private String oldPropertyId;*/

    @SerializedName("property_type")
    @Expose
    private String propertyType;
    @SerializedName("property_usage")
    @Expose
    private String propertyUsage;
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
    @SerializedName("rain_harvesting_system")
    @Expose
    private String rainHarvestingSystem;
    @SerializedName("building_status")
    @Expose
    private String buildingStatus;
    @SerializedName("plot_area")
    @Expose
    private String plotArea;
    @SerializedName("lift_facility")
    @Expose
    private String liftFacility;
    @SerializedName("parking_facility")
    @Expose
    private String parkingFacility;
    @SerializedName("age_of_property")
    @Expose
    private String ageOfProperty;
    @SerializedName("total_floor")
    @Expose
    private String totalFloor;
    @SerializedName("fire_fighting")
    @Expose
    private String fireFighting;
    @SerializedName("road_width")
    @Expose
    private String roadWidth;
    @SerializedName("image")
    private List<String> imagesList = new ArrayList<>();

    private List<String> imagePathList = new ArrayList<>();

    @SerializedName("lattitude")
    @Expose
    private String lattitude;

    @SerializedName("longitude")
    @Expose
    private String longitude;

    private boolean idDrafted;

    public boolean isIdDrafted() {
        return idDrafted;
    }

    public void setIdDrafted(boolean idDrafted) {
        this.idDrafted = idDrafted;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
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

    public String getRainHarvestingSystem() {
        return rainHarvestingSystem;
    }

    public void setRainHarvestingSystem(String rainHarvestingSystem) {
        this.rainHarvestingSystem = rainHarvestingSystem;
    }

    public String getBuildingStatus() {
        return buildingStatus;
    }

    public void setBuildingStatus(String buildingStatus) {
        this.buildingStatus = buildingStatus;
    }

    public String getPlotArea() {
        return plotArea;
    }

    public void setPlotArea(String plotArea) {
        this.plotArea = plotArea;
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

    public String getFireFighting() {
        return fireFighting;
    }

    public void setFireFighting(String fireFighting) {
        this.fireFighting = fireFighting;
    }


    public String getRoadWidth() {
        return roadWidth;
    }

    public void setRoadWidth(String roadWidth) {
        this.roadWidth = roadWidth;
    }

    public List<String> getImagesList() {
        if (imagesList == null) {
            imagesList = new ArrayList<>();
        }
        return imagesList;
    }

    /*public String getOldPropertyId() {
        return oldPropertyId;
    }

    public void setOldPropertyId(String oldPropertyId) {
        this.oldPropertyId = oldPropertyId;
    }*/

    public void setImagesList(List<String> imagesList) {
        this.imagesList = imagesList;
        if (imagesList == null) {
            imagesList = new ArrayList<>();
        }
    }

    public List<String> getImagePathList() {
        if(imagePathList == null) {
            imagePathList = new ArrayList<>();
        }
        return imagePathList;
    }

    public void setImagePathList(List<String> imagePathList) {
        this.imagePathList = imagePathList;
        if(imagePathList == null) {
            imagePathList = new ArrayList<>();
        }
    }
}
