package com.softminesol.propertysurvey.survey.newPropertyEntry.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by sandeep on 6/5/18.
 */
public class SurveyFormAdapter extends FragmentPagerAdapter {
    NewSurveyFragmentList.Fragments[] fragments = null;

    public SurveyFormAdapter(FragmentManager fm) {
        super(fm);
        fragments = NewSurveyFragmentList.Fragments.values();
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
