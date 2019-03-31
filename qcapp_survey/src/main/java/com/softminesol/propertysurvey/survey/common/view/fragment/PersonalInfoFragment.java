package com.softminesol.propertysurvey.survey.common.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.softminesol.propertysurvey.R;
import com.softminesol.propertysurvey.SurveyAppApplication;
import com.softminesol.propertysurvey.survey.common.di.DaggerSurveyComponent;
import com.softminesol.propertysurvey.survey.common.di.SurveyComponent;
import com.softminesol.propertysurvey.survey.common.model.apartment.Owner;
import com.softminesol.propertysurvey.survey.common.model.formData.OwnerDetailsItem;
import com.softminesol.propertysurvey.survey.common.view.activity.onMenuClick;
import com.softminesol.propertysurvey.survey.common.view.presenter.PersonalInfoContract;
import com.softminesol.propertysurvey.survey.common.view.presenter.PersonalInfoPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import frameworks.basemvp.AppBaseFragment;

/**
 * Created by sandeep on 5/5/18.
 */
public class PersonalInfoFragment extends AppBaseFragment<PersonalInfoContract.Presenter> implements PersonalInfoContract.View {

    SurveyComponent surveyComponent;

    @Inject
    PersonalInfoPresenter presenter;
    onMenuClick onMenuClick;
    public static String OWNER_DETAIL_KEY = "OWNER_DETAIL_KEY";
    @BindView(R.id.edt_respondentName)
    EditText edtRespondentName;
    @BindView(R.id.edt_respondentAadharId)
    EditText edtRespondentAadharId;
    @BindView(R.id.edt_respondent_mobileNo)
    EditText edtRespondentMobileNo;
    @BindView(R.id.edt_respondent_email)
    EditText edtRespondentEmail;
    @BindView(R.id.edt_apartment_building_name)
    EditText edtApartmentBuildingName;
    @BindView(R.id.edt_street_name)
    EditText edtStreetName;
    @BindView(R.id.edt_colony_code)
    EditText edtColonyCode;
    @BindView(R.id.edt_pin_code)
    EditText edtPinCode;
    @BindView(R.id.edt_ward_no)
    EditText edtWardNo;
    @BindView(R.id.edt_zone_id)
    EditText edtZoneId;
    Unbinder unbinder;


    public static PersonalInfoFragment newInstance(Owner ownerDetailsItem) {
        PersonalInfoFragment fragment = new PersonalInfoFragment();
        Bundle arguments = new Bundle();
        arguments.putSerializable(OWNER_DETAIL_KEY, ownerDetailsItem);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    protected void initInjector() {
        surveyComponent = DaggerSurveyComponent.builder().baseAppComponent(((SurveyAppApplication) getActivity().getApplication()).getBaseAppComponent()).build();
        surveyComponent.inject(this);
    }

    @Override
    public View getView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personalinfo, container, false);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onMenuClick = (onMenuClick) context;

    }

    @Override
    public PersonalInfoContract.Presenter getPresenter() {
        return presenter;
    }

    public String getTitle() {
        return "Personal Info";
    }


    @Override
    public String getOwnerName() {
        return edtRespondentName.getText().toString();
    }

    @Override
    public String getAdharId() {
        return edtRespondentAadharId.getText().toString();
    }

    @Override
    public String getBuildingName() {
        return edtApartmentBuildingName.getText().toString();
    }

    @Override
    public String getStreet() {
        return edtStreetName.getText().toString();
    }

    @Override
    public String getColony() {
        return edtColonyCode.getText().toString();
    }

    @Override
    public String getPincode() {
        return edtPinCode.getText().toString();
    }

    @Override
    public String getWardNumber() {
        return edtWardNo.getText().toString();

    }

    @Override
    public String getZondeid() {
        return edtZoneId.getText().toString();
    }


    @Override
    public String getMobileNo() {
        return edtRespondentMobileNo.getText().toString();
    }

    @Override
    public String getEmail() {
        return edtRespondentEmail.getText().toString();
    }


    @Override
    public void setOwnerName(String text) {
        edtRespondentName.setText(text);
    }

    @Override
    public void setAdharId(String text) {
        edtRespondentAadharId.setText(text);
    }


    @Override
    public void setMobileNo(String text) {
        edtRespondentMobileNo.setText(text);
    }

    @Override
    public void setEmail(String text) {
        edtRespondentEmail.setText(text);
    }

    @Override
    public void setBuildingName(String text) {
        edtApartmentBuildingName.setText(text);
    }

    @Override
    public void setStreet(String text) {
        edtStreetName.setText(text);
    }

    @Override
    public void setColony(String text) {
        edtColonyCode.setText(text);
    }

    @Override
    public void setPincode(String text) {
        edtPinCode.setText(text);
    }

    @Override
    public void setWardNumber(String text) {
        edtWardNo.setText(text);
    }

    @Override
    public void setZoneId(String text) {
        edtZoneId.setText(text);
    }


    @Override
    public Owner getOwnerDetailItem() {
        return (Owner) getArguments().getSerializable(OWNER_DETAIL_KEY);
    }

    @Override
    public void setGenderAdapter(ArrayAdapter<CharSequence> genderAdapter) {

    }

    @Override
    public void setIsRespondantIsOwnerAdapter(ArrayAdapter<CharSequence> yesNoAdapter) {

    }

    @Override
    public void setRelationShipAdapter(ArrayAdapter<CharSequence> relationShipAdapter) {

    }

    @Override
    public void setOwnerNameError(String error) {

    }

    @Override
    public void setMobileNumberError(String s) {
        edtRespondentMobileNo.setError(s);
        edtRespondentMobileNo.requestFocus();
    }

    @Override
    public void setAdharNumberError(String s) {
        edtRespondentAadharId.setError(s);
        edtRespondentAadharId.requestFocus();
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        setRightText("Done  ");
        setLeftText("  Cancel");
        setLeftMenuEnable(true);
        setRightMenuEnable(true);
    }

    @Override
    public boolean onRightMenuClick() {
        super.onRightMenuClick();
        onMenuClick.onNextClick();
        getPresenter().onNextClick();
        return true;
    }

    @Override
    public boolean onLeftMenuClick() {
        super.onLeftMenuClick();
        onMenuClick.onBackClick();
        finish();
        return true;
    }

    @OnClick(R.id.upload_registry)
    public void onUploadRegisryClick() {
        getPresenter().onUploadRegistryClick();
    }


}
