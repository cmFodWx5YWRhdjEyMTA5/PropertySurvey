package com.softmine.imageupload.presenter;

import java.util.List;

import frameworks.basemvp.IActivityView;
import frameworks.basemvp.IPresenter;

public interface IUploadImageContractor {
    interface View extends IActivityView {

        void initVariables();
        public String getURL();

        public String getParamName() ;
    }
    interface Presenter extends IPresenter<View>{
        public void uploadImages(List<String> fileUris);
    }
}
