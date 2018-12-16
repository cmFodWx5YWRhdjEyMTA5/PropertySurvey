package com.softminesol.propertysurvey.survey.updatePropertyEntry.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by sandeepgoyal on 11/05/18.
 */

public class UpdateSurveyAdapter extends FragmentPagerAdapter {
    UpdateSurveyFragmentList.Fragments[] fragments = null;

    public UpdateSurveyAdapter(FragmentManager fm) {
        super(fm);
        fragments = UpdateSurveyFragmentList.Fragments.values();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position].getFragment();
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments[position].getTitle();
    }
}
