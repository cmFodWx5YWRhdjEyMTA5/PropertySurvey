package com.softminesol.propertysurvey_qc.survey.newPropertyEntry.view.presenter;

import com.softminesol.survey_framework.survey.common.view.presenter.PropertyLocationContract;

/**
 * Created by sandeep on 13/5/18.
 */
public interface NewPropertyInforFragmentContract {
    public interface View extends PropertyLocationContract.View {
        void showMessage(String message);
    }

    public interface Presenter extends PropertyLocationContract.Presenter<View> {
    }
}
