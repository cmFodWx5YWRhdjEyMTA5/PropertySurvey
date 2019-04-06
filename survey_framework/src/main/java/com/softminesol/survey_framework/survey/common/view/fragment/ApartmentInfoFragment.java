package com.softminesol.survey_framework.survey.common.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
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

import com.pchmn.materialchips.ChipView;
import com.softminesol.survey_framework.R;
import com.softminesol.survey_framework.R2;
import com.softminesol.survey_framework.survey.common.model.apartment.Owner;
import com.softminesol.survey_framework.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.survey_framework.survey.common.view.activity.OwnerInfoActivity;
import com.softminesol.survey_framework.survey.common.view.activity.onMenuClick;
import com.softminesol.survey_framework.survey.common.view.presenter.ApartmentInfoContract;
import com.softminesol.survey_framework.survey.common.view.presenter.ApartmentInfoPresenter;
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
public abstract class ApartmentInfoFragment extends AppBaseFragment<ApartmentInfoContract.Presenter> implements ApartmentInfoContract.View {


    @BindView(R2.id.edt_covered_area)
    EditText edtCoveredArea;
    @BindView(R2.id.edt_TempId)
    EditText edtTempId;
    @BindView(R2.id.edt_connection_no)
    EditText edtElectionConnectionNo;
    @BindView(R2.id.edt_shop_apartment_no)
    EditText edtShopApartmentNo;
    @BindView(R2.id.edt_business_industry_type)
    EditText edtBusinessIndustryType;
    @BindView(R2.id.spn_licence_status)
    MaterialBetterSpinner spnLicenceStatus;
    @BindView(R2.id.edt_licence_no)
    EditText edtLicenceNo;
    @BindView(R2.id.edt_apartment_shop_area)
    EditText edtApartmentShopArea;
    @BindView(R2.id.edt_licence_validity)
    EditText edtLicenceValidity;
    @BindView(R2.id.edt_noOwner)
    EditText edtNoOwner;
    @BindView(R2.id.edt_signature)
    EditText edtSignature;
    Unbinder unbinder;
    onMenuClick onMenuClick;

    List<Owner> owners = new ArrayList<>();
    public static final String APARTMENT_DETAIL_KEY = "apartmentDetails";
    public static final String APARTMENT_TEMP_KEY = "apartmentTempDetails";
    public static final String APARTMENT_DETAIL = "apartmentDetail";


    @Inject
    ApartmentInfoPresenter apartmentInfoPresenter;

    @BindView(R2.id.edt_GSId)
    EditText edtGSID;
    @BindView(R2.id.edt_propertyFloorId)
    EditText edtPropertyFloorId;
    @BindView(R2.id.spPropertyUsage)
    MaterialBetterSpinner spPropertyUsage;
    @BindView(R2.id.edt_non_resdental_code)
    EditText edtNonResdentalCode;
    @BindView(R2.id.edt_shop_name)
    EditText edtShopName;
    @BindView(R2.id.edt_buisness_code)
    EditText edtBuisnessCode;
    @BindView(R2.id.edt_respondentName)
    EditText edtRespondentName;
    @BindView(R2.id.spn_respondent_status)
    MaterialBetterSpinner spnRespondentStatus;
    @BindView(R2.id.spn_occupency_status)
    MaterialBetterSpinner spnOccupencyStatus;
    @BindView(R2.id.edt_sewerage_con_status)
    EditText edtSewerageConStatus;
    @BindView(R2.id.spSourceOfWater)
    MaterialBetterSpinner spSourceOfWater;
    @BindView(R2.id.spConstructiontype)
    MaterialBetterSpinner spConstructiontype;
    @BindView(R2.id.edt_self_occupied)
    EditText edtSelfOccupiedArea;
    @BindView(R2.id.edt_tenanted)
    EditText edtTenantedArea;
    @BindView(R2.id.spPowerBackup)
    MaterialBetterSpinner spPowerBackup;
    @BindView(R2.id.spFireFighting)
    MaterialBetterSpinner spFireFighting;

    @BindView(R2.id.btn_add_owner)
    Button btnAddOwner;
    @BindView(R2.id.owner_values)
    LinearLayout ownerValues;
    Unbinder unbinder1;
    @BindView(R2.id.edt_Floor_No)
    MaterialBetterSpinner edtFloorNo;
    @BindView(R2.id.spNonRegCategory)
    MaterialBetterSpinner spNonRegCategory;
    @BindView(R2.id.edt_buisness_built_area)
    EditText edtBuisnessBuiltArea;
    @BindView(R2.id.spElectronicConnectionStatus)
    MaterialBetterSpinner spElectronicConnectionStatus;
    @BindView(R2.id.spsewerage_con_status)
    MaterialBetterSpinner spsewerageConStatus;
    Unbinder unbinder2;
    @BindView(R2.id.textILayout_GSId)
    TextInputLayout textILayouGSId;
    @BindView(R2.id.textILayout_propertyFloorId)
    TextInputLayout textILayoutPropertyFloorId;
    @BindView(R2.id.text_input_non_resdental_code)
    TextInputLayout textInputNonResdentalCode;
    @BindView(R2.id.text_input_shop_name)
    TextInputLayout textInputShopName;
    @BindView(R2.id.textIBusinessIndustryType)
    TextInputLayout textIBusinessIndustryType;
    @BindView(R2.id.text_input_buisness_code)
    TextInputLayout textInputBuisnessCode;
    @BindView(R2.id.textILicenceNo)
    TextInputLayout textILicenceNo;
    @BindView(R2.id.textILicenceValidity)
    TextInputLayout textILicenceValidity;
    @BindView(R2.id.textIBusinessBuiltArea)
    TextInputLayout textIBusinessBuiltArea;
    @BindView(R2.id.textIApartmentShopArea)
    TextInputLayout textIApartmentShopArea;
    @BindView(R2.id.textILayout_house_no)
    TextInputLayout textILayoutHouseNo;
    @BindView(R2.id.textIAgeOfBuilding)
    TextInputLayout textIAgeOfBuilding;
    @BindView(R2.id.textIShopApartmentNo)
    TextInputLayout textIShopApartmentNo;
    @BindView(R2.id.textISignature)
    TextInputLayout textISignature;

    @BindView(R2.id.edt_sewarage_connection_no)
    EditText edtSewerageConNo;



    public ApartmentInfoFragment() {
        // Required empty public constructor
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



    @OnClick(R2.id.btn_add_owner)
    public void onViewClicked() {
        getPresenter().onAddOwnerClick();
    }

    @OnClick(R2.id.btn_add_apartment_pic)
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
    @Override
    public void clearChips() {
        ownerValues.removeAllViews();
    }

    @Override
    public void inflateChips() {
        clearChips();
        if(owners != null) {
            for (Owner owner : owners) {
                addOwner(owner);
            }
        }
    }

    @Override
    public void removeChip(ChipView chipView) {
        ownerValues.removeView(chipView);
    }

    @Override
    public void addOwner(final Owner owner) {
        final ChipView chipView = new ChipView(getContext());
        chipView.setLabel(owner.getName());
        chipView.setDeletable(true);
        ownerValues.addView(chipView);
        chipView.setOnDeleteClicked(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                owners.remove(owner);
                removeChip(chipView);
            }
        });
        chipView.setOnChipClicked(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedOwner = owner;
                startActivityForResult(OwnerInfoActivity.getIntent(getContext(), owner), 1);
            }
        });
    }

    @Override
    public void removeClickOwner() {
        owners.remove(clickedOwner);
        clickedOwner = null;
    }
    public Owner clickedOwner = null;



    private void setGisCode(String string) {
        edtGSID.setText(string);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder2.unbind();
    }
}
