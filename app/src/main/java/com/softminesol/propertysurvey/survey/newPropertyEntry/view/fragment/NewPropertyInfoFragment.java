package com.softminesol.propertysurvey.survey.newPropertyEntry.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.softminesol.propertysurvey.R;
import com.softminesol.propertysurvey.SurveyAppApplication;
import com.softminesol.propertysurvey.survey.common.model.property.SavePropertyRequest;
import com.softminesol.propertysurvey.survey.common.view.fragment.PropertyInfoFragment;
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


    public void setOldPropertyId(String oldPropertyId){
        edt_OldPropertyId.setText(oldPropertyId);
    }

    @Override
    public void setStreet(String street) {
        edtStreetCode.setText(street);
    }

    @Override
    public void setColony(String colony) {
        edtColonyCode.setText(colony);
    }

    @Override
    public void setPincode(String pincode) {
        edtPinCode.setText(pincode);
    }

    @Override
    public void setWardNo(String wardNo) {
        edtWardNo.setText(wardNo);
    }

    @Override
    public void setZoneId(String zoneId) {
        edtZone.setText(zoneId);
    }

    @Override
    public void setRainHarvestingSystem(String rainHarvestingSystem) {
        spRainWaterHarvesting.setText(rainHarvestingSystem);
    }

    @Override
    public void setBuildingStatus(String buildingStatus) {
        spBuildingStatus.setText(buildingStatus);
    }

    @Override
    public void setPlotArea(String plotArea) {
        edtPropertyArea.setText(plotArea);
    }

    @Override
    public void setLiftFacilityItem(String liftFacility) {
        spLiftFacility.setText(liftFacility);
    }

    @Override
    public void setParkingFacilityItem(String parkingFacility) {
        spParkingFacility.setText(parkingFacility);
    }

    @Override
    public void setAgeOfProperty(String ageOfProperty) {
        edtAgeOfBuilding.setText(ageOfProperty);
    }

    @Override
    public void setFireFightingItem(String fireFighting) {
        spFireFighting.setText(fireFighting);
    }

    @Override
    public void setRoadWidthItem(String roadWidth) {
        spRoadWidth.setText(roadWidth);
    }
}
