package com.softminesol.propertysurvey.survey.common.view.presenter;

import android.widget.ArrayAdapter;

import com.softminesol.propertysurvey.survey.common.model.formData.OwnerDetailsItem;

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

        public void setFatherName(String text);

        public void setSelectGender(String text);

        public void setCurrentAddress(String text);


        public void setMobileNo(String text);

        public void setEmail(String text);

        public void setOwnerShipShare(String text);

        public void setRelationType(String text);

        public OwnerDetailsItem getOwnerDetailItem();
        public void setGenderAdapter(ArrayAdapter<CharSequence> genderAdapter);

        public void setIsRespondantIsOwnerAdapter(ArrayAdapter<CharSequence> yesNoAdapter);

        public void setRelationShipAdapter(ArrayAdapter<CharSequence> relationShipAdapter);

        public void setOwnerNameError(String error);
    }

    public interface Presenter extends IPresenter<View> {
        public void onNextClick();

        void onUploadRegistryClick();

    }
}
