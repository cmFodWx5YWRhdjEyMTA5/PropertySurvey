package com.softminesol.propertysurvey.survey.common.view.activity;

import android.support.v4.app.FragmentPagerAdapter;

import com.softminesol.propertysurvey.survey.updatePropertyEntry.view.adapter.UpdateSurveyAdapter;

/**
 * Created by sandeepgoyal on 10/05/18.
 */

public class OldSurveyActivity extends SurveyActivity {
    @Override
    public FragmentPagerAdapter getAdapter() {
        return new UpdateSurveyAdapter(getSupportFragmentManager());
    }
}
