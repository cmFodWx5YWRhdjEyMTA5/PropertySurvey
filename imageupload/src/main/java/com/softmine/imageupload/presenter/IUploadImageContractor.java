package com.softmine.imageupload.presenter;

import frameworks.basemvp.IActivityView;
import frameworks.basemvp.IPresenter;

public interface IUploadImageContractor {
    interface View extends IActivityView {

        void initVariables();
    }
    interface Presenter extends IPresenter<View>{

    }
}
