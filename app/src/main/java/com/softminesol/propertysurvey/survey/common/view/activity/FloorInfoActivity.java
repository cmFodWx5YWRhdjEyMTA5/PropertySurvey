package com.softminesol.propertysurvey.survey.common.view.activity;

import android.content.Context;
import android.content.Intent;

import com.softminesol.propertysurvey.survey.common.model.formData.FloorDetailsItem;
import com.softminesol.propertysurvey.survey.common.view.fragment.FloorInfoFragment;

import frameworks.customlayout.ActivitySingleFragment;


/**
 * Created by sandeepgoyal on 11/05/18.
 */

public class FloorInfoActivity extends ActivitySingleFragment<FloorInfoFragment> implements onMenuClick {
    FloorInfoFragment fragment;

    public static final String FLOOR_DETAIL_KEY = "floorDetails";
    public static Intent getFloorInfoIntet(Context context,FloorDetailsItem floorDetailsItem) {
        Intent i = new Intent(context,FloorInfoActivity.class);
        if(floorDetailsItem !=null) {
            i.putExtra(FLOOR_DETAIL_KEY, floorDetailsItem);
        }
        return i;
    }
    @Override
    protected FloorInfoFragment getFragment() {
        fragment = FloorInfoFragment.newInstance((FloorDetailsItem) getIntent().getSerializableExtra(FLOOR_DETAIL_KEY));
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
}
