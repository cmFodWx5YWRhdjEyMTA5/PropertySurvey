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
import com.softminesol.propertysurvey.survey.common.model.formData.OwnerDetailsItem;
import com.softminesol.propertysurvey.survey.common.view.activity.onMenuClick;
import com.softminesol.propertysurvey.survey.common.view.presenter.PersonalInfoContract;
import com.softminesol.propertysurvey.survey.common.view.presenter.PersonalInfoPresenter;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import javax.inject.Inject;

import butterknife.BindView;
import frameworks.basemvp.AppBaseFragment;

/**
 * Created by sandeep on 5/5/18.
 */
public class PersonalInfoFragment extends AppBaseFragment<PersonalInfoContract.Presenter> implements PersonalInfoContract.View {
    @BindView(R.id.edt_ownerName)
    EditText edtOwnerName;
    @BindView(R.id.edt_fatherName)
    EditText edtFatherName;
    @BindView(R.id.select_gender)
    MaterialBetterSpinner selectGender;
    @BindView(R.id.edt_currentAddress)
    EditText edtCurrentAddress;
    @BindView(R.id.edt_mobileNo)
    EditText edtMobileNo;
    @BindView(R.id.edt_email)
    EditText edtEmail;
    @BindView(R.id.edt_ownerShipShare)
    EditText edtOwnerShipShare;
    SurveyComponent surveyComponent;

    @Inject
    PersonalInfoPresenter presenter;
    @BindView(R.id.relation_type)
    MaterialBetterSpinner relationType;
    onMenuClick onMenuClick;
    public static String OWNER_DETAIL_KEY = "OWNER_DETAIL_KEY";

    public static PersonalInfoFragment newInstance(OwnerDetailsItem ownerDetailsItem) {
        PersonalInfoFragment fragment = new PersonalInfoFragment();
        Bundle arguments = new Bundle();
        arguments.putSerializable(OWNER_DETAIL_KEY,ownerDetailsItem);
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
        return edtOwnerName.getText().toString();
    }

    @Override
    public String getFatherName() {
        return edtFatherName.getText().toString();
    }

    @Override
    public String getSelectGender() {
        return selectGender.getText().toString();
    }

    @Override
    public String getCurrentAddress() {
        return edtCurrentAddress.getText().toString();
    }


    @Override
    public String getMobileNo() {
        return edtMobileNo.getText().toString();
    }

    @Override
    public String getEmail() {
        return edtEmail.getText().toString();
    }

    @Override
    public String getOwnerShipShare() {
        return edtOwnerShipShare.getText().toString();
    }

    @Override
    public String getRelationType() {
        return relationType.getText().toString();
    }

    @Override
    public void setOwnerName(String text) {
        edtOwnerName.setText(text);
    }

    @Override
    public void setFatherName(String text) {
        edtFatherName.setText(text);
    }

    @Override
    public void setSelectGender(String text) {
        selectGender.setText(text);
    }

    @Override
    public void setCurrentAddress(String text) {
        edtCurrentAddress.setText(text);
    }

    @Override
    public void setMobileNo(String text) {
        edtMobileNo.setText(text);
    }

    @Override
    public void setEmail(String text) {
        edtEmail.setText(text);
    }

    @Override
    public void setOwnerShipShare(String text) {
        edtOwnerShipShare.setText(text);
    }

    @Override
    public void setRelationType(String text) {
        relationType.setText(text);
    }

    @Override
    public OwnerDetailsItem getOwnerDetailItem() {
        return (OwnerDetailsItem) getArguments().getSerializable(OWNER_DETAIL_KEY);
    }


    @Override
    public void setGenderAdapter(ArrayAdapter<CharSequence> genderAdapter) {
        selectGender.setAdapter(genderAdapter);
    }

    @Override
    public void setRelationShipAdapter(ArrayAdapter<CharSequence> relationShipAdapter) {
        relationType.setAdapter(relationShipAdapter);
    }

    @Override
    public void setOwnerNameError(String error) {
        edtOwnerName.setError(error);
        edtOwnerName.requestFocus();
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



}
