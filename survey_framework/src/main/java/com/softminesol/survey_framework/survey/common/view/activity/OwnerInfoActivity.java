package com.softminesol.propertysurvey.survey.common.view.activity;

import android.content.Context;
import android.content.Intent;

import com.softminesol.survey_framework.survey.common.model.apartment.Owner;
import com.softminesol.survey_framework.survey.common.view.activity.onMenuClick;
import com.softminesol.survey_framework.survey.common.view.fragment.PersonalInfoFragment;

import frameworks.customlayout.ActivitySingleFragment;


/**
 * Created by sandeepgoyal on 11/05/18.
 */

public class OwnerInfoActivity extends ActivitySingleFragment<PersonalInfoFragment> implements onMenuClick {
    PersonalInfoFragment fragment;
    public static String OWNER_DETAIL_KEY = "OWNER_DETAIL_KEY";

    @Override
    protected PersonalInfoFragment getFragment() {
        fragment = PersonalInfoFragment.newInstance((Owner) getIntent().getSerializableExtra(OWNER_DETAIL_KEY));
        return fragment;
    }

    @Override
    protected void initInjector() {

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

    public static Intent getIntent(Context context, Owner ownerDetailsItem) {
        Intent i = new Intent(context,OwnerInfoActivity.class);
        i.putExtra(OWNER_DETAIL_KEY,ownerDetailsItem);
        return i;
    }
}
