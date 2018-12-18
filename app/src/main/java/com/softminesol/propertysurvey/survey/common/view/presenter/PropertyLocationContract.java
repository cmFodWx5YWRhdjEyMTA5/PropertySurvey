package com.softminesol.propertysurvey.survey.common.view.presenter;

import android.view.View;
import android.widget.ArrayAdapter;

import com.pchmn.materialchips.ChipView;

import frameworks.basemvp.IPresenter;
import frameworks.basemvp.IView;

/**
 * Created by sandeep on 6/5/18.
 */
public interface PropertyLocationContract {
    public interface View extends IView {
        public String getEdtDistCode();

        public String getEdtMcCode();

        public String getEdtColonyCode();

        public String getEdtWardNo();

        public String getEdtZone();

        public String getEdtStreetCode();

        public String getAreaType();

        void setAreaType(ArrayAdapter customAdapte);

        public String getOwnershipType();

        public String getEdtPhotoId();

        public String getEdtMapId();

        public String getEdtHouseNo();

        public String getEdtOldPropertyNo();

        public String getEdtPropertyArea();

        public String getAreaMeasUnit();

        public String getEdtYearOfOccBuilding();

        public String getEdtLength();

        public String getEdtWidth();

        public String getLengthWidthUnit();

        public String getEdtWCon();

        public String getEdtSewCon();

        public String getEdtSewConYear();

        public String getEdtYearOfEstabl();

        public String getEdtTradeLicNo();

        public String getEdtTradeLicYear();

        public String getMsmo();

        void setMsmo(ArrayAdapter customAdapte);

        public String getEdtRemark();

        public String getEdtPropertyId();

        public String getStateCode();
        public String getPincode();
        public String getWardNumber();
        public String getCircleNumber();
        public String getRevenueCircle();
        public String getPropertyUsage();

        public String getEdtCurrentAddress();

        public String getEdtNoFloors();

        public String getFloorCount();

        public String getTypeOfProperty();

        public String getTypeOfNonResProperty();

        public String getGisId();

        public String getParcelId();

        public String getEdtSourceOfWater();

        public String getEdtApartmentBuildingName();

        public String getLiftFacility();

        public String getParkingFacility();

        public String getEdtAgeOfBuilding();

        public String getFireFighting();
        public String getEdtIndvStatus();

        public String getRainWaterHarvesting();

        public String getPowerBackup();


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

    }

    public interface Presenter<T extends View> extends IPresenter<T> {
        public void onSubmitClick();

        public void onAddressClick();

        void onAddFloorCLicked();


    }
}
