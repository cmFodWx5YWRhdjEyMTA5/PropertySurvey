package com.softminesol.propertysurvey.survey.newPropertyEntry.view.adapter;

import android.support.v4.app.Fragment;

import com.softminesol.propertysurvey.survey.newPropertyEntry.view.fragment.NewPropertyInfoFragment;

import frameworks.basemvp.AppBaseFragment;

/**
 * Created by sandeep on 6/5/18.
 */
public class NewSurveyFragmentList {
    public enum Fragments {

        // SURVEYPERSONALINFO(NewPersonalInfoFragment.getTitle(), PersonalInfoFragment.newInstance()),
        //  SURVEYPROPERTYINFO(NewFloorInfoFragment.getTitle(), FloorInfoFragment.newInstance()),
        SURVEYPROPERTYLOCATIONINFO(NewPropertyInfoFragment.newInstance());

        private AppBaseFragment mFragment;

        Fragments(AppBaseFragment fragment) {
            this.mFragment = fragment;
        }

        public String getTitle() {
            return mFragment.getTitle();
        }

        public Fragment getFragment() {
            return mFragment;
        }
    }
}
