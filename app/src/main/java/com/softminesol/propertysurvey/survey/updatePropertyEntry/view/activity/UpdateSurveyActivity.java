package com.softminesol.propertysurvey.survey.updatePropertyEntry.view.activity;

import android.support.v4.app.FragmentPagerAdapter;

import com.softminesol.propertysurvey.survey.common.view.activity.SurveyActivity;
import com.softminesol.propertysurvey.survey.updatePropertyEntry.view.adapter.UpdateSurveyAdapter;

/**
 * Created by sandeepgoyal on 11/05/18.
 */

public class UpdateSurveyActivity extends SurveyActivity {
    @Override
    public FragmentPagerAdapter getAdapter() {
        return new UpdateSurveyAdapter(getSupportFragmentManager());
    }
}
