package com.softminesol.propertysurvey.survey.newPropertyEntry.view.activity;

import android.support.v4.app.FragmentPagerAdapter;

import com.softminesol.propertysurvey.survey.common.view.activity.SurveyActivity;
import com.softminesol.propertysurvey.survey.newPropertyEntry.view.adapter.SurveyFormAdapter;

/**
 * Created by sandeepgoyal on 10/05/18.
 */

public class NewSurveyActivity extends SurveyActivity {
    @Override
    public FragmentPagerAdapter getAdapter() {
        return new SurveyFormAdapter(getSupportFragmentManager());
    }
}
