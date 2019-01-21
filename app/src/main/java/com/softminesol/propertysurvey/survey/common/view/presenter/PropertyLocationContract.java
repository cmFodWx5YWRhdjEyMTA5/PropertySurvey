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
    }

    public interface Presenter<T extends View> extends IPresenter<T> {
        public void onSubmitClick();

        public void onAddressClick();

        void onUploadImageClick();

        void onSaveToDraft();

    }
}
