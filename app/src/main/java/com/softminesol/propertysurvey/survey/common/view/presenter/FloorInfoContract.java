package com.softminesol.propertysurvey.survey.common.view.presenter;

import android.widget.ArrayAdapter;

import com.pchmn.materialchips.ChipView;
import com.softminesol.propertysurvey.survey.common.model.formData.FloorDetailsItem;

import frameworks.basemvp.IPresenter;
import frameworks.basemvp.IView;

/**
 * Created by sandeep on 6/5/18.
 */
public interface FloorInfoContract {
    public interface View extends IView {

        public FloorDetailsItem getFloorDetailItem();

        public void setfloorTypeError(String error);
        public String getSelectFloorId();

        public String getEdtCoveredArea();

        public String getEdtUsageId();

        public String getSelectRebateId();


        public String getSelectTypeOfConstruction();

        public String getEdtYearOfConstruction();

        public String getCoveredAreaMeasurementUnit();

        public String getPropertyCategory();

        public String getBuisnessType();

        public String getTitleOfBuilding();

        public String getEdtPropertyType();

        public String getPropertySubtype();

        public String getYearOfEstablishment();

        public String getTradeLicenceNo();

        public String getTradleLicenceIssueDate();

        public String getPropertyImageId();

        public String getYearOfOccupying();

        public String isBPL();

        public String getBPLNo();

        public String getOwnerShipType();

        public String getNoOfOwners();

        public String getOccupierName();

        public void setSelectFloorId(String text);

        public void setEdtCoveredArea(String text);

        public void setEdtUsageId(String text);

        public void setSelectRebateId(String text);


        public void setSelectTypeOfConstruction(String text);

        public void setEdtYearOfConstruction(String text);

        public void setCoveredAreaMeasurementUnit(String text);

        public void setPropertyCategory(String text);

        public void setBuisnessType(String text);

        public void setTitleOfBuilding(String text);

        public void setEdtPropertyType(String text);

        public void setPropertySubtype(String text);

        public void setYearOfEstablishment(String text);

        public void setTradeLicenceNo(String text);

        public void setTradleLicenceIssueDate(String text);

        public void setPropertyImageId(String text);

        public void setYearOfOccupying(String text);

        public void setisBPL(String text);

        public void setBPLNo(String text);

        public void setOwnerShipType(String text);

        public void setNoOfOwners(String text);

        public void setOccupierName(String text);

        void addChipView(ChipView chipView);

        void setFloorList(ArrayAdapter customAdapter);

        void setMeasurementUnit(ArrayAdapter customAdapter);

        void setUsageType(ArrayAdapter customeAdapter);

        void setRebateIdList(ArrayAdapter customeAdapter);

        void setPropertyCategoryList(ArrayAdapter customAdapter);

        void setPropertyType(ArrayAdapter customAdapter);

        void setSubPropertyType(ArrayAdapter customAdapter);

        void setConstructionType(ArrayAdapter customAdapter);

        void setBPLOption(ArrayAdapter customAdapter);

        void setImageURIPath(String imageURIPath);

        void setOwnderShipType(ArrayAdapter customAdapter);

        void setNoofOwner(String owner);

        void clearChips();

        void removeChip(ChipView chipView);
    }

    public interface Presenter extends IPresenter<View> {
        public void onNextClick();

        public void onAddApartmentClick();

        void onPropertyCategorySelect(String i);

        void onPropertyTypeSelect(String i);

        void onPropertyImageClick();
    }
}
