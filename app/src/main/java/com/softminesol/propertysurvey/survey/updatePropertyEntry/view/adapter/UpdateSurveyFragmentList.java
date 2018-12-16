package com.softminesol.propertysurvey.survey.updatePropertyEntry.view.adapter;

import android.support.v4.app.Fragment;

import com.softminesol.propertysurvey.survey.updatePropertyEntry.view.fragment.UpdatePropertyInfoFragment;

import frameworks.basemvp.AppBaseFragment;

/**
 * Created by sandeepgoyal on 10/05/18.
 */

public class UpdateSurveyFragmentList {
    public enum Fragments {
        //  SURVEYPERSONALINFO(UpdatePersonalInfoFragment.getTitle(), UpdatePersonalInfoFragment.newInstance()),
        //   SURVEYPROPERTYINFO(UpdateFloorInfoFragment.getTitle(), UpdateFloorInfoFragment.newInstance()),
        SURVEYPROPERTYLOCATIONINFO(UpdatePropertyInfoFragment.newInstance());

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
