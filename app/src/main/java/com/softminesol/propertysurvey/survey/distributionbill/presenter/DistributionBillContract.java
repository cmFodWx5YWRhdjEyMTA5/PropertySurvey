package com.softminesol.propertysurvey.survey.distributionbill.presenter;

import android.widget.ArrayAdapter;

import java.util.List;

import frameworks.basemvp.IPresenter;
import frameworks.basemvp.IView;
import frameworks.customadapter.CustomAdapterModel;

/**
 * Created by sandeepgoyal on 10/05/18.
 */

public interface DistributionBillContract {
    public interface View extends IView {
        public String getEdtPropertyId();

        public void setEdtPropertyId(String edtPropertyId);

        public String getEdtName();

        public void setEdtName(String edtName);

        public String getEdtAddress();

        public void setEdtAddress(String edtAddress);

        public String getEdtPhNo();

        public void setEdtPhNo(String edtPhNo);

        public String getEdtStatus();

        public void setEdtStatus(String edtStatus);

        public String getEdtPicId();

        public void setEdtPicId(String edtPicId);

        public void setOldPropertyIDAdapter(List<CustomAdapterModel> propertyIdList);

        public void setStatusOptions(ArrayAdapter arrayAdapter);
    }

    public interface Presenter extends IPresenter<View> {
        public void onUploadPickClick();

        public void onOldPropertyChange(String oldPropertyChange);

        void onPropertyIDSelected(String oldpropertyuid);

        void onUploadBillClick();
    }
}
