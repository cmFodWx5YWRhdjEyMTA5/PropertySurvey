package com.softminesol.propertysurvey.survey.common.view.presenter;

import android.widget.ArrayAdapter;

import com.pchmn.materialchips.ChipView;
import com.softminesol.propertysurvey.survey.common.model.property.SavePropertyRequest;

import frameworks.basemvp.IPresenter;
import frameworks.basemvp.IView;

/**
 * Created by sandeep on 6/5/18.
 */
public interface PropertyLocationContract {
    public interface View extends IView {
        String getMapId();
        String getParcelId();
        String getPropertyType();
        String getPropertyUsage();
        String getBuildingName();
        String getStreetName();
        String getColonyName();
        String getPinCode();
        String getWardNo();
        String getZoneId();
        String getRainWaterHarvesting();
        String getBuildingStatus();
        String getPropetyArea();
        String getLiftFacility();
        String getParkingFacility();
        String getAgeOfBuilding();
        String getfloorCount();
        String getFireFighting();
        String getRoadWidth();
        String getOldPropertyId();




        public void setTypeOfProperty(ArrayAdapter customAdapter);

        public void setPropertyUsage(ArrayAdapter customAdapter);


        public void setRainWaterHarvesting(ArrayAdapter customAdapter);

        public void setLiftFacility(ArrayAdapter customAdapter);


        public void setParkingFacility(ArrayAdapter customAdapter);

        public void setFireFighting(ArrayAdapter customAdapter);

        void setFloorCount(String count);


        void setLatLng(String s);

        void setColonyName(String colonyName);
        void setPinCode(String pinCode);
        void setStreetName(String streetName);



        void setBuidlingStatus(ArrayAdapter buildingStatus);
        void setRoadWidth(ArrayAdapter customAdapter);

        void setMapId(String mapId);

        void setParcelId(String parcelId);

        void setPropertyType(String propertyType);

        void setPropertyUsageItem(String propertyUsage);

        void setBuildingName(String buildingName);

        void setStreet(String street);

        void setColony(String colony);

        void setPincode(String pincode);

        void setWardNo(String wardNo);

        void setZoneId(String zoneId);

        void setRainHarvestingSystem(String rainHarvestingSystem);

        void setBuildingStatus(String buildingStatus);

        void setPlotArea(String plotArea);

        void setLiftFacilityItem(String liftFacility);

        void setParkingFacilityItem(String parkingFacility);

        void setAgeOfProperty(String ageOfProperty);

        void setFireFightingItem(String fireFighting);

        void setRoadWidthItem(String roadWidth);
        void setOldPropertyId(String oldPropertyId);

        void setGisId(String gsid);
    }

    public interface Presenter<T extends View> extends IPresenter<T> {
        public void onSubmitClick();

        public void onAddressClick();

        void onUploadImageClick();

        void onSaveToDraft();
        public void setPropertyRequest(SavePropertyRequest savePropertyRequest);

    }
}
