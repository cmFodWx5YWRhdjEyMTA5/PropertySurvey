package com.softminesol.survey_framework.survey.common.view.presenter;

import android.widget.ArrayAdapter;

import com.softminesol.survey_framework.survey.common.model.apartment.Owner;

import frameworks.basemvp.IPresenter;
import frameworks.basemvp.IView;

/**
 * Created by sandeep on 6/5/18.
 */
public interface PersonalInfoContract {
    public interface View extends IView {


        public String getOwnerName();
        public String getAdharId();
        public String getMobileNo();
        public String getEmail();
        public String getBuildingName();

        public String getStreet();

        public String getColony();

        public String getPincode();

        public String getWardNumber();

        public String getZondeid();




        public void setOwnerName(String text);

        public void setAdharId(String text);

        public void setMobileNo(String text);

        public void setEmail(String text);


        public void setBuildingName(String text);

        public void setStreet(String text);

        public void setColony(String text);

        public void setPincode(String text);
        public void setWardNumber(String text);
        public void setZoneId(String text);

        public Owner getOwnerDetailItem();
        public void setGenderAdapter(ArrayAdapter<CharSequence> genderAdapter);

        public void setIsRespondantIsOwnerAdapter(ArrayAdapter<CharSequence> yesNoAdapter);

        public void setRelationShipAdapter(ArrayAdapter<CharSequence> relationShipAdapter);

        public void setOwnerNameError(String error);
        public void setMobileNumberError(String s) ;
        public void setAdharNumberError(String s) ;
    }

    public interface Presenter extends IPresenter<View> {
        public void onNextClick();

        void onUploadRegistryClick();

    }
}
