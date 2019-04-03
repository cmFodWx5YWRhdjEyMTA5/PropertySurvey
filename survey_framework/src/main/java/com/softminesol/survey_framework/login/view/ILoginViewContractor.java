package com.softminesol.survey_framework.login.view;


import frameworks.basemvp.IPresenter;
import frameworks.basemvp.IView;

/**
 * Created by sandeepgoyal on 02/05/18.
 */

public interface ILoginViewContractor {
    interface View extends IView {
        String getUserId();

        String getPassword();
    }

    interface Presenter extends IPresenter<View> {
        void onLoginClick();
    }

}
