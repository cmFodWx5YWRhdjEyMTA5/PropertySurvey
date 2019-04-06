package com.softminesol.survey_framework.survey.common.view.presenter;

import android.widget.ArrayAdapter;
import com.pchmn.materialchips.ChipView;

import com.softminesol.survey_framework.survey.common.model.apartment.Owner;
import com.softminesol.survey_framework.survey.common.model.apartment.SaveApartmentRequest;

import java.util.List;

import frameworks.basemvp.IPresenter;
import frameworks.basemvp.IView;

public interface ApartmentInfoContract {
    public interface View extends IView {


        public Long getTempId() ;
        public String getGsid();
        public String getFloorNumber();
        public String getPropertyUsage();
        public String getNonResedentalCode();
        public String getNonResidentalCategory();
        public String getShopName();
        public String getBuisnessType();
        public String getBuisnessCode();
        public String getLiceceStatus();
        public String getLicenceNo();
        public String getLicenceValidity();
        public String getBuisnessBuiltArea();
        public String getRespodentName();
        public String getRespondentStatus();
        public String getOccupencyStatus();
        public String getElectricityStatus();
        public String getElectricConnectionNumber();
        public String getSewarageConnectionStatus();
        public String getSewarageConnectionNumber();
        public String getSourceOfWater();
        public String getConstructionType();
        public String getSelfCarpetArea();
        public String getTenantedCarpetArea();
        public String getPowerBackup();
        public void gotoHome();
        public String getOwnerCount();
        public List<Owner> getOwners();

        public void setOwner(Owner owner);
        public void setTempId(String tempId);

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

        void setFloorList(ArrayAdapter customAdapter);




        void setNoofOwner(String owner);

        void setGisId(String s);

        void setFloorNumber(String floor);

        void setPropertyUsageItem(String propertyUsage);

        void setNonResidentialCode(String nonResidentialCode);

        void setNonResidentalCategory(String nonResidentialCategory);

        void setShopName(String shopName);

        void setBusinessType(String businessType);

        void setBuisnessCode(String businessCode);

        void setLicenseValidity(String licenseValidity);

        void setLicenseStatus(String licenseStatus);

        void setBusinessBuiltArea(String businessBuiltArea);

        void setRespodentName(String respodentName);

        void setRespodentStatus(String respodentStatus);

        void setOccupencyStatusItem(String s);

        void setElectricityConnectionStatus(String s);

        void setElectricityConnection(String s);

        void setSewerageStatus(String s);

        void setSewerageConnectionNumber(String s);

        void setSourceWater(String s);

        void setConstructionTypeItem(String s);

        void setSelfOccupiedArea(String s);

        void setTenantedCarpetArea(String s);

        void setPowerBackup(String s);

        void setOwnerCount(String s);

        void setOwners(List<Owner> owners);

        void setElectricityConnectionError(String s);

        void clearChips();
        void inflateChips();
        void removeChip(ChipView chipView);
        void addOwner(Owner chipView);
        public void removeClickOwner();

    }

    public interface Presenter<T extends View> extends IPresenter<T> {
        public void onNextClick();

        public void onAddOwnerClick();

        void addApartmentPic();
        public void setApartmentData(SaveApartmentRequest saveApartmentRequest);

        void onSaveToDraft();

        void onNonRegCategorySelected(int position);
    }
}
