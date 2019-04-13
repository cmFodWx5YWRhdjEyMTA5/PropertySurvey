package com.softminesol.propertysurvey.survey.newPropertyEntry.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.softminesol.survey_framework.SurveyAppApplication;
import com.softminesol.survey_framework.survey.common.model.property.SavePropertyRequest;
import com.softminesol.survey_framework.survey.common.view.fragment.PropertyInfoFragment;
import com.softminesol.propertysurvey.survey.newPropertyEntry.di.DaggerNewSurveyComponent;
import com.softminesol.propertysurvey.survey.newPropertyEntry.di.NewSurveyComponent;
import com.softminesol.propertysurvey.survey.newPropertyEntry.view.presenter.NewPropertyInfoPresenter;
import com.softminesol.propertysurvey.survey.newPropertyEntry.view.presenter.NewPropertyInforFragmentContract;

import javax.inject.Inject;

import static com.softminesol.propertysurvey.survey.newPropertyEntry.view.activity.NewSurveyActivity.PROPERTY_DETAILS;

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
    public static NewPropertyInfoFragment newInstance(Bundle bundle) {
        NewPropertyInfoFragment fragment = new NewPropertyInfoFragment();
        fragment.setArguments(bundle);
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


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments() != null) {
            getPresenter().setPropertyRequest((SavePropertyRequest) getArguments().getSerializable(PROPERTY_DETAILS));
        }
    }

    @Override
    public void setMapId(String mapId) {
        edtMapId.setText(mapId);
    }

    @Override
    public void setParcelId(String parcelId) {
        edtParcelId.setText(parcelId);
    }

    @Override
    public void setPropertyType(String propertyType) {
        spTypeOfProperty.setText(propertyType);
    }

    @Override
    public void setPropertyUsageItem(String propertyUsage) {
        spPropertyUsage.setText(propertyUsage);
    }

    @Override
    public void setBuildingName(String buildingName) {
        edtApartmentBuildingName.setText(buildingName);
    }


}
