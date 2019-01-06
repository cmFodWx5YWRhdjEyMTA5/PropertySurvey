package com.softminesol.propertysurvey.survey.common.view.activity;

import android.content.Context;
import android.content.Intent;

import com.softminesol.propertysurvey.survey.common.view.fragment.ApartmentInfoFragment;

import frameworks.customlayout.ActivitySingleFragment;

public class ApartmentInfoActivity  extends ActivitySingleFragment<ApartmentInfoFragment> implements onMenuClick {
    ApartmentInfoFragment fragment;

    public static final String APARTMENT_DETAIL_KEY = "apartmentDetails";
    public static final String APARTMENT_DETAIL_TEMP_KEY = "apartmentTempDetails";


    @Override
    protected void initInjector() {

    }

    public static Intent createIntent(Context context, String gisCode) {
        Intent i = new Intent(context,ApartmentInfoActivity.class);
        i.putExtra(APARTMENT_DETAIL_KEY,gisCode);
        return i;
    }

    public static Intent createIntent(Context context, long tempid) {
        Intent i = new Intent(context,ApartmentInfoActivity.class);
        i.putExtra(APARTMENT_DETAIL_KEY,tempid);
        return i;
    }

    @Override
    protected ApartmentInfoFragment getFragment() {
        fragment = ApartmentInfoFragment.newInstance(getIntent().getStringExtra(APARTMENT_DETAIL_KEY));
        return fragment;
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
