package com.softminesol.propertysurvey.survey.newPropertyEntry.view.fragment;

import android.os.Bundle;

import com.softminesol.propertysurvey.survey.newPropertyEntry.di.NewSurveyComponent;
import com.softminesol.propertysurvey.survey.newPropertyEntry.di.DaggerNewSurveyComponent;
import com.softminesol.survey_framework.SurveyAppApplication;
import com.softminesol.survey_framework.survey.common.model.apartment.Owner;
import com.softminesol.survey_framework.survey.common.view.fragment.PersonalInfoFragment;
import com.softminesol.survey_framework.survey.common.view.presenter.PersonalInfoContract;

/**
 * Created by sandeep on 5/5/18.
 */
public class NewPersonalInfoFragment extends PersonalInfoFragment implements PersonalInfoContract.View {

    NewSurveyComponent surveyComponent;
    @Override
    protected void initInjector() {
        surveyComponent = DaggerNewSurveyComponent.builder().baseAppComponent(((SurveyAppApplication) getActivity().getApplication()).getBaseAppComponent()).build();
        surveyComponent.inject(this);
    }

    public static PersonalInfoFragment newInstance(Owner ownerDetailsItem) {
        PersonalInfoFragment fragment = new NewPersonalInfoFragment();
        Bundle arguments = new Bundle();
        arguments.putSerializable(OWNER_DETAIL_KEY, ownerDetailsItem);
        fragment.setArguments(arguments);
        return fragment;
    }
}
