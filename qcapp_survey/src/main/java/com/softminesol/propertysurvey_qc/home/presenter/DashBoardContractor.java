package com.softminesol.propertysurvey_qc.home.presenter;


import frameworks.basemvp.IPresenter;
import frameworks.basemvp.IView;

/**
 * Created by sandeepgoyal on 10/05/18.
 */

public interface DashBoardContractor {
    public interface View extends IView {
    }

    public interface Presenter extends IPresenter<View> {
        public void onPropertySearchClick();

    }
}

