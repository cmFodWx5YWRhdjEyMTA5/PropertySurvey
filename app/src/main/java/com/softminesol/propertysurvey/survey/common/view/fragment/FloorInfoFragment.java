package com.softminesol.propertysurvey.survey.common.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

import com.pchmn.materialchips.ChipView;
import com.softminesol.propertysurvey.R;
import com.softminesol.propertysurvey.SurveyAppApplication;
import com.softminesol.propertysurvey.survey.common.di.DaggerSurveyComponent;
import com.softminesol.propertysurvey.survey.common.di.SurveyComponent;
import com.softminesol.propertysurvey.survey.common.model.formData.FloorDetailsItem;
import com.softminesol.propertysurvey.survey.common.view.activity.onMenuClick;
import com.softminesol.propertysurvey.survey.common.view.presenter.FloorInfoContract;
import com.softminesol.propertysurvey.survey.common.view.presenter.FloorInfoPresenter;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import frameworks.basemvp.AppBaseFragment;

/**
 * Created by sandeep on 5/5/18.
 */
public class FloorInfoFragment extends AppBaseFragment<FloorInfoContract.Presenter> implements FloorInfoContract.View {


    @BindView(R.id.select_floor_id)
    MaterialBetterSpinner selectFloorId;
    @BindView(R.id.edt_covered_area)
    EditText edtCoveredArea;
    @BindView(R.id.edt_usage_id)
    MaterialBetterSpinner edtUsageId;
    @BindView(R.id.select_rebate_id)
    MaterialBetterSpinner selectRebateId;
    @BindView(R.id.select_property_category)
    MaterialBetterSpinner selectPropertyCategory;
    @BindView(R.id.edt_pt_id)
    MaterialBetterSpinner edtPropertyType;
    @BindView(R.id.select_type_of_construction)
    MaterialBetterSpinner selectTypeOfConstruction;
    @BindView(R.id.edt_year_of_construction)
    EditText edtYearOfConstruction;
    @Inject
    FloorInfoPresenter floorInfoPresenter;
    SurveyComponent surveyComponent;
    @BindView(R.id.edt_measment_unit)
    MaterialBetterSpinner edtMeasmentUnit;
    @BindView(R.id.edt_type_buisness)
    EditText edtTypeBuisness;
    @BindView(R.id.edt_title_building)
    EditText edtTitleBuilding;
    @BindView(R.id.edt_ps_id)
    MaterialBetterSpinner edtPsId;
    @BindView(R.id.edt_year_of_establishment)
    EditText edtYearOfEstablishment;
    @BindView(R.id.edt_trade_lic_no)
    EditText edtTradeLicNo;
    @BindView(R.id.edt_trade_issue_date)
    EditText edtTradeIssueDate;
    @BindView(R.id.edt_propertyImageId)
    EditText edtPropertyImageId;
    @BindView(R.id.edt_year_occupying)
    EditText edtYearOccupying;
    @BindView(R.id.edt_BPLNo)
    EditText edtBPLNo;
    @BindView(R.id.select_isBPL)
    MaterialBetterSpinner selectIsBPL;
    @BindView(R.id.select_OwnerType)
    MaterialBetterSpinner selectOwnerType;
    @BindView(R.id.owner_values)
    LinearLayout ownerValues;
    @BindView(R.id.edt_noOwner)
    EditText edtNoOwner;
    @BindView(R.id.edt_occupyer_name)
    EditText edtOccupierName;
    onMenuClick onMenuClick;

    public static final String FLOOR_DETAIL_KEY = "floorDetails";
    @BindView(R.id.edt_propertyFloorId)
    EditText edtPropertyFloorId;
    @BindView(R.id.edt_propertyId)
    EditText edtPropertyId;
    @BindView(R.id.spn_floors)
    MaterialBetterSpinner spnFloors;
    @BindView(R.id.edt_total_property)
    EditText edtTotalProperty;
    Unbinder unbinder;

    public static FloorInfoFragment newInstance(FloorDetailsItem floorDetailsItem) {
        FloorInfoFragment fragment = new FloorInfoFragment();
        Bundle args = new Bundle();
        args.putSerializable(FLOOR_DETAIL_KEY, floorDetailsItem);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void initInjector() {
        surveyComponent = DaggerSurveyComponent.builder().baseAppComponent(((SurveyAppApplication) getActivity().getApplication()).getBaseAppComponent()).build();
        surveyComponent.inject(this);
    }

    @Override
    public FloorDetailsItem getFloorDetailItem() {
        return (FloorDetailsItem) getArguments().getSerializable(FLOOR_DETAIL_KEY);
    }

    @Override
    public void setfloorTypeError(String error) {
        selectFloorId.setError(error);
    }

    public String getSelectFloorId() {
        return selectFloorId.getText().toString();
    }

    public String getEdtCoveredArea() {
        return edtCoveredArea.getText().toString();
    }

    public String getEdtUsageId() {
        return edtUsageId.getText().toString();
    }

    public String getSelectRebateId() {
        return selectRebateId.getText().toString();
    }

    @Override
    public String getEdtPropertyType() {
        return edtPropertyType.getText().toString();
    }

    public String getSelectTypeOfConstruction() {
        return selectTypeOfConstruction.getText().toString();
    }

    public String getEdtYearOfConstruction() {
        return edtYearOfConstruction.getText().toString();
    }

    @Override
    public String getCoveredAreaMeasurementUnit() {
        return edtMeasmentUnit.getText().toString();
    }

    @Override
    public String getPropertyCategory() {
        return selectPropertyCategory.getText().toString();
    }

    @Override
    public String getBuisnessType() {
        return edtTypeBuisness.getText().toString();
    }

    @Override
    public String getTitleOfBuilding() {
        return edtTitleBuilding.getText().toString();
    }

    @Override
    public String getPropertySubtype() {
        return edtPsId.getText().toString();
    }

    @Override
    public String getYearOfEstablishment() {
        return edtYearOfEstablishment.getText().toString();
    }

    @Override
    public String getTradeLicenceNo() {
        return edtTradeLicNo.getText().toString();
    }

    @Override
    public String getTradleLicenceIssueDate() {
        return edtTradeLicNo.getText().toString();
    }

    @Override
    public String getPropertyImageId() {
        return edtPropertyImageId.getText().toString();
    }

    @Override
    public String getYearOfOccupying() {
        return edtYearOccupying.getText().toString();
    }

    @Override
    public String isBPL() {
        return selectIsBPL.getText().toString();
    }

    @Override
    public String getBPLNo() {
        return edtBPLNo.getText().toString();
    }

    @Override
    public String getOwnerShipType() {
        return selectOwnerType.getText().toString();
    }

    @Override
    public String getNoOfOwners() {
        return edtNoOwner.getText().toString();
    }

    @Override
    public String getOccupierName() {
        return edtOccupierName.getText().toString();
    }

    @Override
    public void setSelectFloorId(String text) {
        selectFloorId.setText(text);
    }

    @Override
    public void setEdtCoveredArea(String text) {
        edtCoveredArea.setText(text);
    }

    @Override
    public void setEdtUsageId(String text) {
        edtUsageId.setText(text);
    }

    @Override
    public void setSelectRebateId(String text) {
        selectRebateId.setText(text);
    }

    @Override
    public void setSelectTypeOfConstruction(String text) {
        selectTypeOfConstruction.setText(text);
    }

    @Override
    public void setEdtYearOfConstruction(String text) {
        edtYearOfConstruction.setText(text);
    }

    @Override
    public void setCoveredAreaMeasurementUnit(String text) {
        edtMeasmentUnit.setText(text);
    }

    @Override
    public void setPropertyCategory(String text) {
        selectPropertyCategory.setText(text);
    }

    @Override
    public void setBuisnessType(String text) {
        edtTypeBuisness.setText(text);
    }

    @Override
    public void setTitleOfBuilding(String text) {
        edtTitleBuilding.setText(text);
    }

    @Override
    public void setEdtPropertyType(String text) {
        edtPropertyType.setText(text);
    }

    @Override
    public void setPropertySubtype(String text) {
        edtPsId.setText(text);
    }

    @Override
    public void setYearOfEstablishment(String text) {
        edtYearOfEstablishment.setText(text);
    }

    @Override
    public void setTradeLicenceNo(String text) {
        edtTradeLicNo.setText(text);
    }

    @Override
    public void setTradleLicenceIssueDate(String text) {
        edtTradeIssueDate.setText(text);
    }

    @Override
    public void setPropertyImageId(String text) {
        edtPropertyImageId.setText(text);
    }

    @Override
    public void setYearOfOccupying(String text) {
        edtYearOccupying.setText(text);
    }

    @Override
    public void setisBPL(String text) {
        selectIsBPL.setText(text);
    }

    @Override
    public void setBPLNo(String text) {
        edtBPLNo.setText(text);
    }

    @Override
    public void setOwnerShipType(String text) {
        selectOwnerType.setText(text);
    }

    @Override
    public void setNoOfOwners(String text) {
        edtNoOwner.setText(text);
    }

    @Override
    public void setOccupierName(String text) {
        edtOccupierName.setText(text);
    }

    @Override
    public void addChipView(ChipView chipView) {
        ownerValues.addView(chipView);
    }

    @Override
    public void setFloorList(ArrayAdapter customAdapter) {
        selectFloorId.setAdapter(customAdapter);
        selectFloorId.setFocusable(true);
    }

    @Override
    public void setMeasurementUnit(ArrayAdapter customAdapter) {
        edtMeasmentUnit.setAdapter(customAdapter);
    }

    @Override
    public void setUsageType(ArrayAdapter customeAdapter) {
        edtUsageId.setAdapter(customeAdapter);
    }

    @Override
    public void setRebateIdList(ArrayAdapter customeAdapter) {
        selectRebateId.setAdapter(customeAdapter);
    }

    @Override
    public void setPropertyCategoryList(ArrayAdapter customAdapter) {
        selectPropertyCategory.setAdapter(customAdapter);
        selectPropertyCategory.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                getPresenter().onPropertyCategorySelect(selectPropertyCategory.getText().toString());
            }
        });
    }

    @Override
    public void setPropertyType(ArrayAdapter customAdapter) {
        edtPropertyType.setAdapter(customAdapter);
        edtPropertyType.setFocusable(true);
        edtPropertyType.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                getPresenter().onPropertyTypeSelect(edtPropertyType.getText().toString());
            }
        });
    }

    @Override
    public void setSubPropertyType(ArrayAdapter customAdapter) {
        edtPsId.setAdapter(customAdapter);
        edtPsId.setFocusable(true);
    }

    @Override
    public void setConstructionType(ArrayAdapter customAdapter) {
        selectTypeOfConstruction.setAdapter(customAdapter);
    }



    @Override
    public void setBPLOption(ArrayAdapter customAdapter) {
        selectIsBPL.setAdapter(customAdapter);
    }

    @Override
    public void setImageURIPath(String imageURIPath) {
        edtPropertyImageId.setText(imageURIPath);
    }

    @Override
    public void setOwnderShipType(ArrayAdapter customAdapter) {
        selectOwnerType.setAdapter(customAdapter);
    }

    @Override
    public void setNoofOwner(String owner) {
        edtNoOwner.setText(owner);
    }

    @Override
    public void clearChips() {
        ownerValues.removeAllViews();
    }

    @Override
    public View getView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_floor_info, container, false);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onMenuClick = (onMenuClick) context;
    }

    @Override
    public FloorInfoContract.Presenter getPresenter() {
        return floorInfoPresenter;
    }

    public String getTitle() {
        return "Property Info";
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
    public void removeChip(ChipView chipView) {
        ownerValues.removeView(chipView);
    }

    @OnClick(R.id.btn_add_apartment)
    public void onViewClicked() {
        getPresenter().onAddApartmentClick();
    }


    @OnClick(R.id.edt_propertyImageId)
    public void onPropertyImageIDClick() {
        getPresenter().onPropertyImageClick();
    }

}
