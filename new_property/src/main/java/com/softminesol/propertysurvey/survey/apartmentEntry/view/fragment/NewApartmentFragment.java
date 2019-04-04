package com.softminesol.propertysurvey.survey.apartmentEntry.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import com.softminesol.propertysurvey.home.view.DashBoardActivity;
import com.softminesol.propertysurvey.survey.apartmentEntry.view.presenter.NewApartmentContract;
import com.softminesol.propertysurvey.survey.newPropertyEntry.view.fragment.NewApartmentInfoFragment;
import com.softminesol.survey_framework.SurveyAppApplication;
import com.softminesol.survey_framework.survey.common.di.SurveyComponent;
import com.softminesol.survey_framework.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.survey_framework.survey.common.view.fragment.ApartmentInfoFragment;

public class NewApartmentFragment extends ApartmentInfoFragment implements NewApartmentContract.View {


    SurveyComponent surveyComponent;
    public static ApartmentInfoFragment newInstance(String  string) {
        ApartmentInfoFragment fragment = new NewApartmentFragment();
        Bundle args = new Bundle();
        args.putString(APARTMENT_DETAIL_KEY, string);
        fragment.setArguments(args);
        return fragment;
    }

    public static ApartmentInfoFragment newInstance(long  string) {
        ApartmentInfoFragment fragment = new NewApartmentFragment();
        Bundle args = new Bundle();
        args.putLong(APARTMENT_TEMP_KEY, string);
        fragment.setArguments(args);
        return fragment;
    }
    public static ApartmentInfoFragment newIntance(SaveApartmentRequest savePropertyRequest) {
        ApartmentInfoFragment fragment = new NewApartmentFragment();
        Bundle args = new Bundle();
        args.putSerializable(APARTMENT_DETAIL, savePropertyRequest);
        fragment.setArguments(args);
        return fragment;

    }
    @Override
    protected void initInjector() {
        surveyComponent = DaggerNewSurveyComponent.builder().baseAppComponent(((SurveyAppApplication) getActivity().getApplication()).getBaseAppComponent()).build();
        surveyComponent.inject(this);
    }

    @Override
    public void gotoHome() {
        Intent intent = new Intent(getActivity(), DashBoardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
