package com.softminesol.propertysurvey.survey.common.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;

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
import butterknife.ButterKnife;
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
    @BindView(R.id.edt_respondentUniqueId)
    EditText edtRespondentUniqueId;
    @BindView(R.id.edt_respondentUniqueIdType)
    EditText edtRespondentUniqueIdType;
    @BindView(R.id.respondent_relation_type)
    MaterialBetterSpinner respondentRelationType;
    @BindView(R.id.edt_respondent_fatherName)
    EditText edtRespondentFatherName;
    @BindView(R.id.respondent_select_gender)
    MaterialBetterSpinner respondentSelectGender;
    @BindView(R.id.edt_respondentCurrentAddress)
    EditText edtRespondentCurrentAddress;
    @BindView(R.id.edt_respondent_mobileNo)
    EditText edtRespondentMobileNo;
    @BindView(R.id.edt_respondent_email)
    EditText edtRespondentEmail;
    @BindView(R.id.edt_respondentShipShare)
    EditText edtRespondentShipShare;
    @BindView(R.id.spnRespondentIsRespondent)
    MaterialBetterSpinner spnRespondentIsRespondent;
    @BindView(R.id.edt_ownerName)
    EditText edtOwnerName;
    @BindView(R.id.edt_uniqueId)
    EditText edtUniqueId;
    @BindView(R.id.edt_uniqueIdType)
    EditText edtUniqueIdType;
    @BindView(R.id.relation_type)
    MaterialBetterSpinner relationType;
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
    @BindView(R.id.llOwner)
    LinearLayout llOwner;
    Unbinder unbinder;
    @BindView(R.id.edt_personal_detail_id)
    EditText edtPersonalDetailId;
    @BindView(R.id.edt_apartment_building_name)
    EditText edtApartmentBuildingName;
    @BindView(R.id.edt_house_no)
    EditText edtHouseNo;
    @BindView(R.id.edt_street_name)
    EditText edtStreetName;
    @BindView(R.id.edt_colony_code)
    EditText edtColonyCode;
    @BindView(R.id.edt_pin_code)
    EditText edtPinCode;
    @BindView(R.id.edt_ward_no)
    EditText edtWardNo;
    @BindView(R.id.edt_circle_no)
    EditText edtCircleNo;
    @BindView(R.id.edt_circle_revenue)
    EditText edtCircleRevenue;
    @BindView(R.id.textILayout_respondent_currentAddress)
    TextInputLayout textILayoutRespondentCurrentAddress;
    @BindView(R.id.textILayout_respondentShipShare)
    TextInputLayout textILayoutRespondentShipShare;
    @BindView(R.id.textILayout_ownerName)
    TextInputLayout textILayoutOwnerName;
    @BindView(R.id.textILayout_uniqueId)
    TextInputLayout textILayoutUniqueId;
    @BindView(R.id.textILayout_uniqueIdType)
    TextInputLayout textILayoutUniqueIdType;
    @BindView(R.id.textILayout_fatherName)
    TextInputLayout textILayoutFatherName;
    @BindView(R.id.textILayout_currentAddress)
    TextInputLayout textILayoutCurrentAddress;
    @BindView(R.id.textILayout_mobileNo)
    TextInputLayout textILayoutMobileNo;
    @BindView(R.id.textILayout_email)
    TextInputLayout textILayoutEmail;
    @BindView(R.id.textILayout_ownerShipShare)
    TextInputLayout textILayoutOwnerShipShare;
    Unbinder unbinder1;

    public static PersonalInfoFragment newInstance(OwnerDetailsItem ownerDetailsItem) {
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
    public void setIsRespondantIsOwnerAdapter(ArrayAdapter<CharSequence> genderAdapter) {
        spnRespondentIsRespondent.setAdapter(genderAdapter);
        spnRespondentIsRespondent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (spnRespondentIsRespondent.getText().toString().equals("No")) {
                    llOwner.setVisibility(View.VISIBLE);
                } else {
                    llOwner.setVisibility(View.GONE);
                }
            }
        });
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder1.unbind();
    }
}
