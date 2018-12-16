package com.softminesol.propertysurvey.survey.common.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.softminesol.propertysurvey.R;
import com.softminesol.propertysurvey.SurveyAppApplication;
import com.softminesol.propertysurvey.survey.common.di.DaggerSurveyComponent;
import com.softminesol.propertysurvey.survey.common.di.SurveyComponent;
import com.softminesol.propertysurvey.survey.common.model.formData.ApartmentDetailsItem;
import com.softminesol.propertysurvey.survey.common.model.formData.FloorDetailsItem;
import com.softminesol.propertysurvey.survey.common.view.activity.onMenuClick;
import com.softminesol.propertysurvey.survey.common.view.presenter.ApartmentInfoContract;
import com.softminesol.propertysurvey.survey.common.view.presenter.ApartmentInfoPresenter;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import frameworks.basemvp.AppBaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ApartmentInfoFragment extends AppBaseFragment<ApartmentInfoContract.Presenter> implements ApartmentInfoContract.View {


    @BindView(R.id.edt_covered_area)
    EditText edtCoveredArea;
    @BindView(R.id.edt_election_connection_no)
    EditText edtElectionConnectionNo;
    @BindView(R.id.edt_shop_apartment_no)
    EditText edtShopApartmentNo;
    @BindView(R.id.edt_business_industry_type)
    EditText edtBusinessIndustryType;
    @BindView(R.id.spn_licence_status)
    MaterialBetterSpinner spnLicenceStatus;
    @BindView(R.id.edt_licence_no)
    EditText edtLicenceNo;
    @BindView(R.id.edt_apartment_shop_area)
    EditText edtApartmentShopArea;
    @BindView(R.id.edt_licence_validity)
    EditText edtLicenceValidity;
    @BindView(R.id.edt_noOwner)
    EditText edtNoOwner;

    @BindView(R.id.edt_signature)
    EditText edtSignature;
    Unbinder unbinder;
    onMenuClick onMenuClick;

    public static final String APARTMENT_DETAIL_KEY = "apartmentDetails";
    SurveyComponent surveyComponent;
    ApartmentInfoPresenter apartmentInfoPresenter;
    public static ApartmentInfoFragment newInstance(ApartmentDetailsItem apartmentDetailsItem) {
        ApartmentInfoFragment fragment = new ApartmentInfoFragment();
        Bundle args = new Bundle();
        args.putSerializable(APARTMENT_DETAIL_KEY,apartmentDetailsItem);
        fragment.setArguments(args);
        return fragment;
    }
    public ApartmentInfoFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initInjector() {
        surveyComponent = DaggerSurveyComponent.builder().baseAppComponent(((SurveyAppApplication) getActivity().getApplication()).getBaseAppComponent()).build();
        surveyComponent.inject(this);
    }

    @Override
    public View getView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_apartment_info, container, false);
        return view;
    }

    @Override
    public ApartmentInfoContract.Presenter getPresenter() {
        return apartmentInfoPresenter;
    }

    public String getTitle() {
        return "Apartment Info";
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onMenuClick = (onMenuClick) context;

    }
    @Override
    public String getEdtCoveredArea() {
        return edtCoveredArea.getText().toString();    }

    @Override
    public String getEdtElectionConnectionNo() {
        return edtElectionConnectionNo.getText().toString();
    }

    @Override
    public String getEdtShopApartmentNo() {
        return edtShopApartmentNo.getText().toString();
    }

    @Override
    public String getEdtBusinessIndustryType() {
        return edtBusinessIndustryType.getText().toString();    }

    @Override
    public String getEdtLicenceNo() {
        return edtLicenceNo.getText().toString();    }

    @Override
    public String getEdtApartmentShopArea() {
        return edtApartmentShopArea.getText().toString();    }

    @Override
    public String getEdtLicenceValidity() {
        return edtLicenceValidity.getText().toString();    }

    @Override
    public String getEdtNoOwner() {
        return edtNoOwner.getText().toString();    }

    @Override
    public String getEdtSignature() {
        return edtSignature.getText().toString();
    }

    @Override
    public String getLicenceStatus() {
        return spnLicenceStatus.getText().toString();
    }

    @Override
    public void setEdtCoveredArea(String text) {

    }

    @Override
    public void setEdtElectionConnectionNo(String text) {

    }

    @Override
    public void setEdtShopApartmentNo(String text) {

    }

    @Override
    public void setEdtBusinessIndustryType(String text) {

    }

    @Override
    public void setEdtLicenceNo(String text) {

    }

    @Override
    public void setEdtApartmentShopArea(String text) {

    }

    @Override
    public void setEdtLicenceValidity(String text) {

    }

    @Override
    public void setEdtSignature(String text) {

    }

    @Override
    public void setLicenceStatus(ArrayAdapter customAdapter) {

    }

    @Override
    public void setNoofOwner(String owner) {

    }

    @OnClick(R.id.btn_add_owner)
    public void onViewClicked() {
        getPresenter().onAddOwnerClick();
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
