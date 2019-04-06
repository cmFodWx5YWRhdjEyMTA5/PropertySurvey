package com.softminesol.propertysurvey.survey.ownerEntry.view.activity;

import android.content.Context;
import android.content.Intent;

import com.softminesol.propertysurvey.survey.ownerEntry.view.fragment.NewPersonalInfoFragment;
import com.softminesol.survey_framework.survey.common.model.apartment.Owner;
import com.softminesol.survey_framework.survey.common.model.formData.OwnerDetailsItem;
import com.softminesol.survey_framework.survey.common.view.activity.onMenuClick;
import com.softminesol.survey_framework.survey.common.view.fragment.PersonalInfoFragment;

import frameworks.customlayout.ActivitySingleFragment;


/**
 * Created by sandeepgoyal on 11/05/18.
 */

public class NewOwnerInfoActivity extends ActivitySingleFragment<PersonalInfoFragment> implements onMenuClick {
    PersonalInfoFragment fragment;
    public static String OWNER_DETAIL_KEY = "OWNER_DETAIL_KEY";

    @Override
    protected PersonalInfoFragment getFragment() {
        fragment = NewPersonalInfoFragment.newInstance((Owner) getIntent().getSerializableExtra(OWNER_DETAIL_KEY));
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

    public static Intent getIntent(Context context, OwnerDetailsItem ownerDetailsItem) {
        Intent i = new Intent(context, NewOwnerInfoActivity.class);
        i.putExtra(OWNER_DETAIL_KEY,ownerDetailsItem);
        return i;
    }
}
