package com.softminesol.propertysurvey_qc.qasearch.newPropertyEntry.view.activity;

import android.content.Context;
import android.content.Intent;

import com.softminesol.propertysurvey_qc.qasearch.newPropertyEntry.view.fragment.NewPropertyInfoFragment;
import com.softminesol.survey_framework.survey.common.model.property.SavePropertyRequest;
import com.softminesol.survey_framework.survey.common.view.activity.onMenuClick;

import frameworks.customlayout.ActivitySingleFragment;

/**
 * Created by sandeepgoyal on 10/05/18.
 */

public class NewSurveyActivity extends ActivitySingleFragment<NewPropertyInfoFragment> implements onMenuClick {

    public static final String PROPERTY_DETAILS = "PROPERTY_Details";


    @Override
    protected NewPropertyInfoFragment getFragment() {
        return NewPropertyInfoFragment.newInstance(getIntent().getExtras());
    }

    @Override
    protected void initInjector() {

    }
    public static Intent createIntent(Context context,SavePropertyRequest savePropertyRequest) {
        Intent intent = new Intent(context,NewSurveyActivity.class);
        intent.putExtra(PROPERTY_DETAILS,savePropertyRequest);
        return intent;
    }

    @Override
    public void onNextClick() {
    }

    @Override
    public void onBackClick() {

    }

    @Override
    public void onFinishCLick() {

    }
}
