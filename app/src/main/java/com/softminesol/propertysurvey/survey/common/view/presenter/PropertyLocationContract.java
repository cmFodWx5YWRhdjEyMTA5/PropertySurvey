package com.softminesol.propertysurvey.survey.common.view.presenter;

import android.widget.ArrayAdapter;

import com.pchmn.materialchips.ChipView;

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


        void setMsmo(ArrayAdapter customAdapte);

        public void setSewageConnectoion(ArrayAdapter customAdapter);

        public void setTypeOfProperty(ArrayAdapter customAdapter);

        public void setPropertyUsage(ArrayAdapter customAdapter);

        public void setTypeOfNonesProperty(ArrayAdapter customAdapter);

        public void setRainWaterHarvesting(ArrayAdapter customAdapter);

        public void setLiftFacility(ArrayAdapter customAdapter);

        public void setPowerBackup(ArrayAdapter customAdapter);

        public void setParkingFacility(ArrayAdapter customAdapter);

        public void setFireFighting(ArrayAdapter customAdapter);

        public void setWaterConnection(ArrayAdapter customAdapter);

        public void setSourceOfWater(ArrayAdapter customAdapter);

        void addChipView(ChipView chipView);

        void setAreaMeasurementUnit(ArrayAdapter customAdapte);

        void setLengthWidthMeasuremntUnit(ArrayAdapter customAdapte);

        void setFloorCount(String count);

        void clearChips();

        void setLatLng(String s);

        void removeChip(ChipView chiptView);

         void showMessage(String message);

        void setBuidlingStatus(ArrayAdapter buildingStatus);
        void setRoadWidth(ArrayAdapter customAdapter);
    }

    public interface Presenter<T extends View> extends IPresenter<T> {
        public void onSubmitClick();

        public void onAddressClick();

        void onAddFloorCLicked();


        void onUploadImageClick();
    }
}
