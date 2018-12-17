package com.softminesol.propertysurvey.home.presenter;


import frameworks.basemvp.IPresenter;
import frameworks.basemvp.IView;

/**
 * Created by sandeepgoyal on 10/05/18.
 */

public interface DashBoardContractor {
    public interface View extends IView {
        public void setDistributorInvisible();
        public void setNewPropertyInvisible();
        public void setUpdatePropertyInvisible();
    }

    public interface Presenter extends IPresenter<View> {
        public void onDistributionClick();

        public void onNewPropertInfoClick();

        public void onOldPropertyInfoClick();

        public void onAddApartmentClick();

    }
}

