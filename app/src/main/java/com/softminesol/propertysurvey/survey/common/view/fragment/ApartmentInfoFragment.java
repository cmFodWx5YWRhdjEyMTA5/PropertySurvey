package com.softminesol.propertysurvey.survey.common.view.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.softminesol.propertysurvey.R;
import com.softminesol.propertysurvey.SurveyAppApplication;
import com.softminesol.propertysurvey.home.view.DashBoardActivity;
import com.softminesol.propertysurvey.survey.common.di.DaggerSurveyComponent;
import com.softminesol.propertysurvey.survey.common.di.SurveyComponent;
import com.softminesol.propertysurvey.survey.common.model.OldPropertyUIDItem;
import com.softminesol.propertysurvey.survey.common.model.apartment.Owner;
import com.softminesol.propertysurvey.survey.common.model.apartment.SaveApartmentRequest;
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
    @BindView(R.id.edt_TempId)
    EditText edtTempId;
    @BindView(R.id.edt_connection_no)
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

    List<Owner> owners = new ArrayList<>();
    public static final String APARTMENT_DETAIL_KEY = "apartmentDetails";
    public static final String APARTMENT_TEMP_KEY = "apartmentTempDetails";
    public static final String APARTMENT_DETAIL = "apartmentDetail";

    SurveyComponent surveyComponent;
    @Inject
    ApartmentInfoPresenter apartmentInfoPresenter;
    @BindView(R.id.edt_GSId)
    EditText edtGSID;
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
    @BindView(R.id.edt_sewerage_con_status)
    EditText edtSewerageConStatus;
    @BindView(R.id.spSourceOfWater)
    MaterialBetterSpinner spSourceOfWater;
    @BindView(R.id.spConstructiontype)
    MaterialBetterSpinner spConstructiontype;
    @BindView(R.id.edt_self_occupied)
    EditText edtSelfOccupiedArea;
    @BindView(R.id.edt_tenanted)
    EditText edtTenantedArea;
    @BindView(R.id.spPowerBackup)
    MaterialBetterSpinner spPowerBackup;
    @BindView(R.id.spFireFighting)
    MaterialBetterSpinner spFireFighting;

    @BindView(R.id.btn_add_owner)
    Button btnAddOwner;
    @BindView(R.id.owner_values)
    LinearLayout ownerValues;
    Unbinder unbinder1;
    @BindView(R.id.edt_Floor_No)
    MaterialBetterSpinner edtFloorNo;
    @BindView(R.id.spNonRegCategory)
    MaterialBetterSpinner spNonRegCategory;
    @BindView(R.id.edt_buisness_built_area)
    EditText edtBuisnessBuiltArea;
    @BindView(R.id.spElectronicConnectionStatus)
    MaterialBetterSpinner spElectronicConnectionStatus;
    @BindView(R.id.spsewerage_con_status)
    MaterialBetterSpinner spsewerageConStatus;
    Unbinder unbinder2;
    @BindView(R.id.textILayout_GSId)
    TextInputLayout textILayouGSId;
    @BindView(R.id.textILayout_propertyFloorId)
    TextInputLayout textILayoutPropertyFloorId;
    @BindView(R.id.text_input_non_resdental_code)
    TextInputLayout textInputNonResdentalCode;
    @BindView(R.id.text_input_shop_name)
    TextInputLayout textInputShopName;
    @BindView(R.id.textIBusinessIndustryType)
    TextInputLayout textIBusinessIndustryType;
    @BindView(R.id.text_input_buisness_code)
    TextInputLayout textInputBuisnessCode;
    @BindView(R.id.textILicenceNo)
    TextInputLayout textILicenceNo;
    @BindView(R.id.textILicenceValidity)
    TextInputLayout textILicenceValidity;
    @BindView(R.id.textIBusinessBuiltArea)
    TextInputLayout textIBusinessBuiltArea;
    @BindView(R.id.textIApartmentShopArea)
    TextInputLayout textIApartmentShopArea;
    @BindView(R.id.textILayout_house_no)
    TextInputLayout textILayoutHouseNo;
    @BindView(R.id.textIAgeOfBuilding)
    TextInputLayout textIAgeOfBuilding;
    @BindView(R.id.textIShopApartmentNo)
    TextInputLayout textIShopApartmentNo;
    @BindView(R.id.textISignature)
    TextInputLayout textISignature;

    @BindView(R.id.edt_sewarage_connection_no)
    EditText edtSewerageConNo;

    public static ApartmentInfoFragment newInstance(String  string) {
        ApartmentInfoFragment fragment = new ApartmentInfoFragment();
        Bundle args = new Bundle();
        args.putString(APARTMENT_DETAIL_KEY, string);
        fragment.setArguments(args);
        return fragment;
    }

    public static ApartmentInfoFragment newInstance(long  string) {
        ApartmentInfoFragment fragment = new ApartmentInfoFragment();
        Bundle args = new Bundle();
        args.putLong(APARTMENT_TEMP_KEY, string);
        fragment.setArguments(args);
        return fragment;
    }

    public ApartmentInfoFragment() {
        // Required empty public constructor
    }

    public static ApartmentInfoFragment newIntance(SaveApartmentRequest savePropertyRequest) {
        ApartmentInfoFragment fragment = new ApartmentInfoFragment();
        Bundle args = new Bundle();
        args.putSerializable(APARTMENT_DETAIL, savePropertyRequest);
        fragment.setArguments(args);
        return fragment;

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


    public void gotoHome() {
        Intent intent = new Intent(getActivity(), DashBoardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }


    @Override
    public String getGsid() {
        return edtGSID.getText().toString() ;
    }

    public Long getTempId() {
        long tempId = 0;
        try{
            tempId = Long.valueOf(edtTempId.getText().toString());
        }catch (NumberFormatException e) {

        }
        return tempId;
    }

    @Override
    public String getFloorNumber() {
        return edtFloorNo.getText().toString();
    }

    @Override
    public String getPropertyUsage() {
        return spPropertyUsage.getText().toString();
    }

    @Override
    public String getNonResedentalCode() {
        return edtNonResdentalCode.getText().toString();
    }

    @Override
    public String getNonResidentalCategory() {
        return spNonRegCategory.getText().toString();
    }

    @Override
    public String getShopName() {
        return edtShopName.getText().toString();

    }

    @Override
    public String getBuisnessType() {
        return edtBusinessIndustryType.getText().toString();
    }

    @Override
    public String getBuisnessCode() {
        return edtBuisnessCode.getText().toString();
    }

    @Override
    public String getLiceceStatus() {
        return spnLicenceStatus.getText().toString();
    }

    @Override
    public String getLicenceNo() {
        return edtLicenceNo.getText().toString();
    }

    @Override
    public String getLicenceValidity() {
        return edtLicenceValidity.getText().toString();
    }

    @Override
    public String getBuisnessBuiltArea() {
        return edtBuisnessBuiltArea.getText().toString();
    }

    @Override
    public String getRespodentName() {
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
    public String getElectricityStatus() {
        return spElectronicConnectionStatus.getText().toString();
    }

    @Override
    public String getElectricConnectionNumber() {
        return edtElectionConnectionNo.getText().toString();
    }

    @Override
    public String getSewarageConnectionStatus() {
        return spsewerageConStatus.getText().toString();
    }

    @Override
    public String getSewarageConnectionNumber() {
        return edtSewerageConNo.getText().toString();
    }

    @Override
    public String getSourceOfWater() {
        return spSourceOfWater.getText().toString();
    }

    @Override
    public String getConstructionType() {
        return spConstructiontype.getText().toString();
    }

    @Override
    public String getSelfCarpetArea() {
        return edtSelfOccupiedArea.getText().toString();
    }

    @Override
    public String getTenantedCarpetArea() {
        return edtTenantedArea.getText().toString();
    }

    @Override
    public String getPowerBackup() {
        return spPowerBackup.getText().toString();
    }

    @Override
    public String getOwnerCount() {
        return "" + owners.size();
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
    public void setTempId(String tempId) {
        edtTempId.setText(tempId);
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
    public void setNonRegCategory(ArrayAdapter customAdapter) {
        spNonRegCategory.setAdapter(customAdapter);
        spNonRegCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               getPresenter().onNonRegCategorySelected(position);
            }
        });
    }

    @Override
    public void setSpPowerBackup(ArrayAdapter customAdapter) {
        spPowerBackup.setAdapter(customAdapter);
    }

    @Override
    public void setSpElectricityConnStatus(ArrayAdapter customAdapter) {
        spElectronicConnectionStatus.setAdapter(customAdapter);
    }

    @Override
    public void setSpSewerageConnStatus(ArrayAdapter customAdapter) {
        spsewerageConStatus.setAdapter(customAdapter);
    }

    @Override
    public void setFloorList(ArrayAdapter customAdapter) {
        edtFloorNo.setAdapter(customAdapter);
    }


    @Override
    public void setLicenceStatus(ArrayAdapter customAdapter) {
        spnLicenceStatus.setAdapter(customAdapter);
    }

    @Override
    public void setNoofOwner(String owner) {

    }

    @Override
    public void setGisId(String s) {
        edtGSID.setText(s);
    }

    @Override
    public void setFloorNumber(String floor) {
        edtFloorNo.setText(floor);
    }

    @Override
    public void setPropertyUsageItem(String propertyUsage) {
        spPropertyUsage.setText(propertyUsage);
    }

    @Override
    public void setNonResidentialCode(String nonResidentialCode) {
        edtNonResdentalCode.setText(nonResidentialCode);
    }

    @Override
    public void setNonResidentalCategory(String nonResidentialCategory) {
        spNonRegCategory.setText(nonResidentialCategory);
    }

    @Override
    public void setShopName(String shopName) {
        edtShopName.setText(shopName);
    }

    @Override
    public void setBusinessType(String businessType) {

    }

    @Override
    public void setBuisnessCode(String businessCode) {
        edtBuisnessCode.setText(businessCode);
    }

    @Override
    public void setLicenseValidity(String licenseValidity) {
        edtLicenceValidity.setText(licenseValidity);
    }

    @Override
    public void setLicenseStatus(String licenseStatus) {
        spnLicenceStatus.setText(licenseStatus);
    }

    @Override
    public void setBusinessBuiltArea(String businessBuiltArea) {
        edtBuisnessBuiltArea.setText(businessBuiltArea);
    }

    @Override
    public void setRespodentName(String respodentName) {
        edtRespondentName.setText(respodentName);
    }

    @Override
    public void setRespodentStatus(String respodentStatus) {
        spnRespondentStatus.setText(respodentStatus);
    }

    @Override
    public void setOccupencyStatusItem(String s) {
        spnOccupencyStatus.setText(s);
    }

    @Override
    public void setElectricityConnectionStatus(String s) {
        spElectronicConnectionStatus.setText(s);
    }

    @Override
    public void setElectricityConnection(String s) {
        edtElectionConnectionNo.setText(s);
    }

    @Override
    public void setSewerageStatus(String s) {
        edtSewerageConStatus.setText(s);
    }

    @Override
    public void setSewerageConnectionNumber(String s) {
        edtSewerageConNo.setText(s);
    }

    @Override
    public void setSourceWater(String s) {
        spSourceOfWater.setText(s);
    }

    @Override
    public void setConstructionTypeItem(String s) {
        spConstructiontype.setText(s);
    }

    @Override
    public void setSelfOccupiedArea(String s) {
        edtSelfOccupiedArea.setText(s);
    }

    @Override
    public void setTenantedCarpetArea(String s) {
        edtTenantedArea.setText(s);
    }

    @Override
    public void setPowerBackup(String s) {
        spPowerBackup.setText(s);
    }

    @Override
    public void setOwnerCount(String s) {
    }

    @Override
    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    @Override
    public void setElectricityConnectionError(String s) {
        edtElectionConnectionNo.setError(s);
        edtElectionConnectionNo.requestFocus();
    }



    @OnClick(R.id.btn_add_owner)
    public void onViewClicked() {
        getPresenter().onAddOwnerClick();
    }

    @OnClick(R.id.btn_add_apartment_pic)
    public void addApartmentPic() {
        getPresenter().addApartmentPic();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        setRightText("Done  ");
        setLeftText("  Cancel");
        setLeftMenuEnable(true);
        setRightMenuEnable(true);
        inflater.inflate(R.menu.savedraftmenu,menu);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.save_to_draft) {
            getPresenter().onSaveToDraft();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder2 = ButterKnife.bind(this, rootView);
        if(getArguments() != null ) {
            if(getArguments().getSerializable(APARTMENT_DETAIL) != null) {
                getPresenter().setApartmentData((SaveApartmentRequest) getArguments().getSerializable(APARTMENT_DETAIL));
            } if(getArguments().getString(APARTMENT_DETAIL_KEY) != null) {
                setGisCode(getArguments().getString(APARTMENT_DETAIL_KEY));
            }else {
                if(getArguments().getLong(APARTMENT_TEMP_KEY,0) != 0) {
                    setTempId(getArguments().getLong(APARTMENT_TEMP_KEY,0)+"");
                }
            }
        }
        return rootView;
    }

    private void setGisCode(String string) {
        edtGSID.setText(string);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder2.unbind();
    }
}
