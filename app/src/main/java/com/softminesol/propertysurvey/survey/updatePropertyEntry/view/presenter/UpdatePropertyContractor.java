package com.softminesol.propertysurvey.survey.updatePropertyEntry.view.presenter;

import com.softminesol.propertysurvey.survey.common.view.presenter.PropertyLocationContract;

import java.util.List;

import frameworks.customadapter.CustomAdapterModel;

/**
 * Created by sandeepgoyal on 13/05/18.
 */

public interface UpdatePropertyContractor {
    public interface View extends PropertyLocationContract.View {
        public void setEdtDistCode(String text);

        public void setEdtMcCode(String text);

        public void setEdtColonyCode(String text);

        public void setEdtWardNo(String text);

        public void setEdtZone(String text);

        public void setEdtStreetCode(String text);

        public void setAreaType(String text);

        public void setOwnershipType(String text);

        public void setEdtPhotoId(String text);

        public void setEdtMapId(String text);

        public void setEdtHouseNo(String text);

        public void setEdtOldPropertyNo(String text);

        public void setEdtPropertyArea(String text);

        public void setAreaMeasUnit(String text);

        public void setEdtYearOfOccBuilding(String text);

        public void setEdtLength(String text);

        public void setEdtWidth(String text);

        public void setLengthWidthUnit(String text);

        public void setEdtWCon(String text);

        public void setEdtSewCon(String text);

        public void setEdtSewConYear(String text);


        public void setEdtYearOfEstabl(String text);

        public void setEdtTradeLicNo(String text);

        public void setEdtTradeLicYear(String text);

        public void setMsmo(String text);

        public void setEdtRemark(String text);

        public void setEdtPropertyId(String text);

        public void setStateCode(String text);

        public void setEdtCurrentAddress(String text);

        public void setEdtNoFloors(String text);

        public void setOldPropertyIDAdapter(List<CustomAdapterModel> IdListArrayAdapter);

    }

    public interface Presenter extends PropertyLocationContract.Presenter<View> {
        public void onOldPropertyChange(String oldPropertyChange);

        void onPropertyIDSelected(String propertyId);
    }
}
