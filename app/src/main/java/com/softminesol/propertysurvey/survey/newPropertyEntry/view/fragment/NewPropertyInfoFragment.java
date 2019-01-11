package com.softminesol.propertysurvey.survey.newPropertyEntry.view.fragment;

import com.softminesol.propertysurvey.SurveyAppApplication;
import com.softminesol.propertysurvey.survey.common.view.fragment.PropertyInfoFragment;
import com.softminesol.propertysurvey.survey.newPropertyEntry.di.DaggerNewSurveyComponent;
import com.softminesol.propertysurvey.survey.newPropertyEntry.di.NewSurveyComponent;
import com.softminesol.propertysurvey.survey.newPropertyEntry.view.presenter.NewPropertyInfoPresenter;
import com.softminesol.propertysurvey.survey.newPropertyEntry.view.presenter.NewPropertyInforFragmentContract;

import javax.inject.Inject;

/**
 * Created by sandeep on 5/5/18.
 */
public class NewPropertyInfoFragment extends PropertyInfoFragment implements NewPropertyInforFragmentContract.View {

    @Inject
    NewPropertyInfoPresenter presenter;
    NewSurveyComponent surveyComponent;

    public static NewPropertyInfoFragment newInstance() {
        NewPropertyInfoFragment fragment = new NewPropertyInfoFragment();
        return fragment;
    }

    @Override
    public NewPropertyInfoPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void initInjector() {
        super.initInjector();
        surveyComponent = DaggerNewSurveyComponent.builder().baseAppComponent(((SurveyAppApplication) getActivity().getApplication()).getBaseAppComponent()).build();
        surveyComponent.inject(this);
    }


}
