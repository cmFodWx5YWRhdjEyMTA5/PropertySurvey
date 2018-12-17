package com.softminesol.propertysurvey.survey.common.view.fragment;


import android.content.Context;
import android.content.Intent;
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
import android.widget.LinearLayout;

import com.softminesol.propertysurvey.R;
import com.softminesol.propertysurvey.SurveyAppApplication;
import com.softminesol.propertysurvey.home.view.DashBoardActivity;
import com.softminesol.propertysurvey.survey.common.di.DaggerSurveyComponent;
import com.softminesol.propertysurvey.survey.common.di.SurveyComponent;
import com.softminesol.propertysurvey.survey.common.model.apartment.Owner;
import com.softminesol.propertysurvey.survey.common.model.formData.ApartmentDetailsItem;
import com.softminesol.propertysurvey.survey.common.view.activity.onMenuClick;
import com.softminesol.propertysurvey.survey.common.view.presenter.ApartmentInfoContract;
import com.softminesol.propertysurvey.survey.common.view.presenter.ApartmentInfoPresenter;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

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

    List<Owner> owners=new ArrayList<>();
    public static final String APARTMENT_DETAIL_KEY = "apartmentDetails";
    SurveyComponent surveyComponent;
    @Inject
    ApartmentInfoPresenter apartmentInfoPresenter;
    @BindView(R.id.edt_Floor_deatil_Id)
    EditText edtFloorDeatilId;
    @BindView(R.id.edt_propertyFloorId)
    EditText edtPropertyFloorId;
    @BindView(R.id.spPropertyUsage)
    MaterialBetterSpinner spPropertyUsage;
    @BindView(R.id.edt_non_resdental_code)
    EditText edtNonResdentalCode;
    @BindView(R.id.edt_shop_name)
    EditText edtShopName;
    @BindView(R.id.edt_buisness_code)
    EditText edtBuisnessCode;
    @BindView(R.id.edt_respondentName)
    EditText edtRespondentName;
    @BindView(R.id.spn_respondent_status)
    MaterialBetterSpinner spnRespondentStatus;
    @BindView(R.id.spn_occupency_status)
    MaterialBetterSpinner spnOccupencyStatus;
    @BindView(R.id.edt_connection_no)
    EditText edtConnectionNo;
    @BindView(R.id.edt_sewerage_con_status)
    EditText edtSewerageConStatus;
    @BindView(R.id.spSourceOfWater)
    MaterialBetterSpinner spSourceOfWater;
    @BindView(R.id.spConstructiontype)
    MaterialBetterSpinner spConstructiontype;
    @BindView(R.id.edt_self_occupied)
    EditText edtSelfOccupied;
    @BindView(R.id.edt_tenanted)
    EditText edtTenanted;
    @BindView(R.id.spPowerBackup)
    MaterialBetterSpinner spPowerBackup;
    @BindView(R.id.spFireFighting)
    MaterialBetterSpinner spFireFighting;
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
    @BindView(R.id.btn_add_owner)
    Button btnAddOwner;
    @BindView(R.id.owner_values)
    LinearLayout ownerValues;
    Unbinder unbinder1;
    @BindView(R.id.edt_Floor_No)
    EditText edtFloorNo;
    @BindView(R.id.spNonRegCategory)
    MaterialBetterSpinner spNonRegCategory;
    @BindView(R.id.edt_buisness_built_area)
    EditText edtBuisnessBuiltArea;
    @BindView(R.id.spElectronicConnectionStatus)
    MaterialBetterSpinner spElectronicConnectionStatus;
    @BindView(R.id.spsewerage_con_status)
    MaterialBetterSpinner spsewerageConStatus;
    Unbinder unbinder2;

    public static ApartmentInfoFragment newInstance(ApartmentDetailsItem apartmentDetailsItem) {
        ApartmentInfoFragment fragment = new ApartmentInfoFragment();
        Bundle args = new Bundle();
        args.putSerializable(APARTMENT_DETAIL_KEY, apartmentDetailsItem);
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
    public void setPropertyUsage(ArrayAdapter customAdapter) {
        spPropertyUsage.setAdapter(customAdapter);
    }

    @Override
    public void setRespondentStatus(ArrayAdapter customAdapter) {
        spnRespondentStatus.setAdapter(customAdapter);
    }

    @Override
    public void setOccupencyStatus(ArrayAdapter customAdapter) {
        spnOccupencyStatus.setAdapter(customAdapter);
    }

    @Override
    public void setSourceOfWater(ArrayAdapter customAdapter) {
        spSourceOfWater.setAdapter(customAdapter);
    }

    @Override
    public void setConstructionType(ArrayAdapter customAdapter) {
        spConstructiontype.setAdapter(customAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onMenuClick = (onMenuClick) context;

    }


    public void gotoHome(){
        Intent intent=new Intent(getActivity(), DashBoardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    @Override
    public String getGisCode() {
        return edtFloorDeatilId.getText().toString();
    }

    @Override
    public String getFloorCount() {
        return edtFloorNo.getText().toString();
    }

    @Override
    public String getPropertyUsage() {
        return spPropertyUsage.getText().toString();
    }

    @Override
    public String getNonResidentialCode() {
        return edtNonResdentalCode.getText().toString();

    }

    @Override
    public String getNonRegCategory() {
        return spNonRegCategory.getText().toString();
    }

    @Override
    public String getShopName() {
        return edtShopName.getText().toString();

    }

    @Override
    public String getBusinessType() {
        return edtBusinessIndustryType.getText().toString();
    }

    @Override
    public String getBusinessCode() {
        return edtBuisnessCode.getText().toString();

    }

    @Override
    public String getLicenceCode() {
        return edtLicenceNo.getText().toString();

    }

    @Override
    public String getBusinessBuiltArea() {
        return edtBuisnessBuiltArea.getText().toString();

    }

    @Override
    public String getRespondentName() {
        return edtRespondentName.getText().toString();

    }

    @Override
    public String getRespondentStatus() {
        return spnRespondentStatus.getText().toString();

    }

    @Override
    public String getOccupencyStatus() {
        return spnOccupencyStatus.getText().toString();

    }

    @Override
    public String getElectronicConnectionStatus() {
        return spElectronicConnectionStatus.getText().toString();

    }

    @Override
    public String getElectronicConnectionNumber() {
        return edtElectionConnectionNo.getText().toString();

    }

    @Override
    public String getSewerageStatus() {
        return spsewerageConStatus.getText().toString();

    }

    @Override
    public String getSourceWater() {
        return spSourceOfWater.getText().toString();

    }

    @Override
    public String getCunstructionType() {
        return spConstructiontype.getText().toString();

    }

    @Override
    public String getSelfOccupied() {
        return edtSelfOccupied.getText().toString();

    }

    @Override
    public String getTenanted() {
        return edtTenanted.getText().toString();

    }

    @Override
    public String getPowerBackUp() {
        return spPowerBackup.getText().toString();

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
    public String getCircleNumber() {
        return edtCircleNo.getText().toString();

    }

    @Override
    public String getRevenueCircle() {
        return edtCircleRevenue.getText().toString();

    }

    @Override
    public String getOwnerCount() {
        return ""+owners.size();
    }

    @Override
    public List<Owner> getOwners() {
        return owners;
    }

    @Override
    public void setOwner(Owner owner) {
        owners.add(owner);
    }

    @Override
    public String getEdtCoveredArea() {
        return edtCoveredArea.getText().toString();
    }

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
        return edtBusinessIndustryType.getText().toString();
    }

    @Override
    public String getEdtLicenceNo() {
        return edtLicenceNo.getText().toString();
    }

    @Override
    public String getEdtApartmentShopArea() {
        return edtApartmentShopArea.getText().toString();
    }

    @Override
    public String getEdtLicenceValidity() {
        return edtLicenceValidity.getText().toString();
    }

    @Override
    public String getEdtNoOwner() {
        return edtNoOwner.getText().toString();
    }

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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder2 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder2.unbind();
    }
}
