package com.softminesol.propertysurvey.survey.common.view.presenter;

import android.widget.ArrayAdapter;

import com.pchmn.materialchips.ChipView;
import com.softminesol.propertysurvey.survey.common.model.formData.FloorDetailsItem;

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

        void setLicenceStatus(ArrayAdapter customAdapter);

        void setNoofOwner(String owner);

    }

    public interface Presenter extends IPresenter<View> {
        public void onNextClick();

        public void onAddOwnerClick();

    }
}
