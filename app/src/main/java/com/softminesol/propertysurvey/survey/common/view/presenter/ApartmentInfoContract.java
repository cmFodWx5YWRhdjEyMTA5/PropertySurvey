package com.softminesol.propertysurvey.survey.common.view.presenter;

import android.widget.ArrayAdapter;

import com.pchmn.materialchips.ChipView;
import com.softminesol.propertysurvey.survey.common.model.apartment.Owner;
import com.softminesol.propertysurvey.survey.common.model.formData.FloorDetailsItem;

import java.util.List;

import frameworks.basemvp.IPresenter;
import frameworks.basemvp.IView;

public interface ApartmentInfoContract {
    public interface View extends IView {



        public String getEdtCoveredArea();

        public String getEdtElectionConnectionNo();

        public String getEdtShopApartmentNo();

        public String getEdtBusinessIndustryType();

        public String getEdtLicenceNo();

        public String getEdtApartmentShopArea();

        public String getEdtLicenceValidity();

        public String getEdtNoOwner();

        public String getEdtSignature();

        public String getLicenceStatus();

        public String getGisCode();

        public void gotoHome();

        public String getFloorCount();

        public String getPropertyUsage();

        public String getNonResidentialCode();

        public String getNonRegCategory();

        public String getShopName();

        public String getBusinessType();

        public String getBusinessCode();

        public String getLicenceCode();

        public String getBusinessBuiltArea();

        public String getRespondentName();

        public String getRespondentStatus();

        public String getOccupencyStatus();

        public String getElectronicConnectionStatus();

        public String getElectronicConnectionNumber();

        public String getSewerageStatus();

        public String getSourceWater();

        public String getCunstructionType();

        public String getSelfOccupied();

        public String getTenanted();

        public String getPowerBackUp();

        public String getBuildingName();

        public String getStreet();

        public String getColony();

        public String getPincode();

        public String getWardNumber();

        public String getCircleNumber();

        public String getRevenueCircle();

        public String getOwnerCount();

        public List<Owner> getOwners();

        public void setOwner(Owner owner);

        public void setPropertyUsage(ArrayAdapter customAdapter);

        public void setRespondentStatus(ArrayAdapter customAdapter) ;

        public void setOccupencyStatus(ArrayAdapter customAdapter) ;

        public void setSourceOfWater(ArrayAdapter customAdapter) ;

        public void setConstructionType(ArrayAdapter customAdapter) ;

        public void setEdtCoveredArea(String text);

        public void setEdtElectionConnectionNo(String text);

        public void setEdtShopApartmentNo(String text);

        public void setEdtBusinessIndustryType(String text);

        public void setEdtLicenceNo(String text);

        public void setEdtApartmentShopArea(String text);

        public void setEdtLicenceValidity(String text);

        public void setEdtSignature(String text);

        void setNonRegCategory(ArrayAdapter customAdapter);

        void setLicenceStatus(ArrayAdapter customAdapter);

        void setSpPowerBackup(ArrayAdapter customAdapter);

        void setSpElectricityConnStatus(ArrayAdapter customAdapter);

        void setSpSewerageConnStatus(ArrayAdapter customAdapter);



        void setNoofOwner(String owner);

    }

    public interface Presenter extends IPresenter<View> {
        public void onNextClick();

        public void onAddOwnerClick();

        void addApartmentPic();
    }
}
