package com.softminesol.propertysurvey.survey.common.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pchmn.materialchips.ChipView;
import com.softminesol.propertysurvey.R;
import com.softminesol.propertysurvey.survey.common.di.SurveyComponent;
import com.softminesol.propertysurvey.survey.common.view.activity.onMenuClick;
import com.softminesol.propertysurvey.survey.common.view.presenter.PropertyLocationContract;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import frameworks.basemvp.AppBaseFragment;

/**
 * Created by sandeep on 5/5/18.
 */
public abstract class PropertyInfoFragment<T extends PropertyLocationContract.Presenter> extends AppBaseFragment<PropertyLocationContract.Presenter> implements PropertyLocationContract.View {
    @BindView(R.id.edt_dist_code)
    protected EditText edtDistCode;
    @BindView(R.id.edt_mc_code)
    protected EditText edtMcCode;
    @BindView(R.id.edt_colony_code)
    protected EditText edtColonyCode;
    @BindView(R.id.edt_ward_no)
    protected EditText edtWardNo;
    @BindView(R.id.edt_zone)
    protected EditText edtZone;
    @BindView(R.id.edt_street_code)
    protected EditText edtStreetCode;
    @BindView(R.id.area_type)
    protected MaterialBetterSpinner areaType;
    @BindView(R.id.edt_map_id)
    protected EditText edtMapId;
    @BindView(R.id.edt_house_no)
    protected EditText edtHouseNo;
    @BindView(R.id.edt_property_area)
    protected EditText edtPropertyArea;
    @BindView(R.id.area_meas_unit)
    protected MaterialBetterSpinner areaMeasUnit;
    @BindView(R.id.edt_year_of_occ_building)
    protected EditText edtYearOfOccBuilding;
    @BindView(R.id.edt_length)
    protected EditText edtLength;
    @BindView(R.id.edt_width)
    protected EditText edtWidth;
    @BindView(R.id.length_width_unit)
    protected MaterialBetterSpinner lengthWidthUnit;
    @BindView(R.id.edt_w_con)
    protected MaterialBetterSpinner edtWCon;
    @BindView(R.id.edt_sew_con)
    protected MaterialBetterSpinner edtSewCon;
    @BindView(R.id.edt_sew_con_year)
    protected EditText edtSewConYear;
    protected EditText edtTradeLicYear;
    @BindView(R.id.msmo)
    protected MaterialBetterSpinner msmo;
    @BindView(R.id.edt_remark)
    protected EditText edtRemark;
    @BindView(R.id.edt_address)
    protected EditText edtCurrentAddress;
    @BindView(R.id.edt_noFloor)
    protected EditText edtnoFloors;
    @BindView(R.id.edt_oldpropertyId)
    protected AutoCompleteTextView edtOldpropertyId;
    @BindView(R.id.edt_propertyId)
    protected EditText edtPropertyId;
    @BindView(R.id.edt_state_code)
    protected EditText edtStateCode;
    SurveyComponent surveyComponent;
    @BindView(R.id.floor_values)
    LinearLayout floorValues;
    onMenuClick onMenuClick;
    Unbinder unbinder;
    @BindView(R.id.txtlatlng)
    TextView txtlatlng;
    @BindView(R.id.edt_floor_count)
    EditText edtFloorCount;
    @BindView(R.id.spTypeOfProperty)
    MaterialBetterSpinner spTypeOfProperty;
    @BindView(R.id.spTypeOfNonResProperty)
    MaterialBetterSpinner spTypeOfNonResProperty;
    @BindView(R.id.edt_gisId)
    EditText edtGisId;
    @BindView(R.id.edt_parcelId)
    EditText edtParcelId;
    @BindView(R.id.edt_apartment_building_name)
    EditText edtApartmentBuildingName;
    @BindView(R.id.spLiftFacility)
    MaterialBetterSpinner spLiftFacility;
    @BindView(R.id.spPowerBackup)
    MaterialBetterSpinner spPowerBackup;
    @BindView(R.id.spParkingFacility)
    MaterialBetterSpinner spParkingFacility;
    @BindView(R.id.spFireFighting)
    MaterialBetterSpinner spFireFighting;
    @BindView(R.id.spRainWaterHarvesting)
    MaterialBetterSpinner spRainWaterHarvesting;
    @BindView(R.id.spSourceOfWater)
    MaterialBetterSpinner spSourceOfWater;
    Unbinder unbinder1;
    @BindView(R.id.edt_plot_id)
    EditText edtPlotId;
    @BindView(R.id.spPropertyUsage)
    MaterialBetterSpinner spPropertyUsage;
    @BindView(R.id.edt_total_floor)
    EditText edtTotalFloor;
    @BindView(R.id.edt_pin_code)
    EditText edtPinCode;
    @BindView(R.id.edt_circle_no)
    EditText edtCircleNo;
    @BindView(R.id.edt_circle_revenue)
    EditText edtCircleRevenue;
    @BindView(R.id.edt_building_status)
    EditText edtBuildingStatus;
    @BindView(R.id.edt_age_of_building)
    EditText edtAgeOfBuilding;
    @BindView(R.id.btn_add_floor)
    Button btnAddFloor;
    @BindView(R.id.textILayout_remark)
    TextInputLayout textILayoutRemark;

    @Override
    protected void initInjector() {
    }

    public String getEdtDistCode() {
        return edtDistCode.getText().toString();
    }

    public String getEdtMcCode() {
        return edtMcCode.getText().toString();
    }

    public String getEdtColonyCode() {
        return edtColonyCode.getText().toString();
    }

    public String getEdtWardNo() {
        return edtWardNo.getText().toString();
    }

    public String getEdtZone() {
        return edtZone.getText().toString();
    }

    public String getEdtStreetCode() {
        return edtStreetCode.getText().toString();
    }

    public String getAreaType() {
        return areaType.getText().toString();
    }

    @Override
    public void setAreaType(ArrayAdapter customAdapte) {
        areaType.setAdapter(customAdapte);
    }

    @Override
    public String getOwnershipType() {
        return null;
    }

    @Override
    public String getEdtPhotoId() {
        return null;
    }

    public String getEdtMapId() {
        return edtMapId.getText().toString();
    }

    public String getEdtHouseNo() {
        return edtHouseNo.getText().toString();
    }

    @Override
    public String getEdtOldPropertyNo() {
        return edtOldpropertyId.getText().toString();
    }

    @Override
    public String getEdtPropertyId() {
        return edtPropertyId.getText().toString();
    }

    @Override
    public String getStateCode() {
        return edtStateCode.getText().toString();
    }

    public String getEdtPropertyArea() {
        return edtPropertyArea.getText().toString();
    }

    public String getAreaMeasUnit() {
        return areaMeasUnit.getText().toString();
    }

    public String getEdtYearOfOccBuilding() {
        return edtYearOfOccBuilding.getText().toString();
    }

    public String getEdtLength() {
        return edtLength.getText().toString();
    }

    public String getEdtWidth() {
        return edtWidth.getText().toString();
    }

    public String getLengthWidthUnit() {
        return lengthWidthUnit.getText().toString();
    }

    public String getEdtWCon() {
        return edtWCon.getText().toString();
    }

    public String getEdtSewCon() {
        return edtSewCon.getText().toString();
    }

    public String getEdtSewConYear() {
        return edtSewConYear.getText().toString();
    }

    public String getEdtCurrentAddress() {
        return edtCurrentAddress.getText().toString();
    }

    public String getEdtNoFloors() {
        return edtnoFloors.getText().toString();
    }

    public String getFloorCount() {
        return edtFloorCount.getText().toString();
    }

    public String getTypeOfProperty() {
        return spTypeOfProperty.getText().toString();
    }

    public String getTypeOfNonResProperty() {
        return spTypeOfNonResProperty.getText().toString();
    }

    public String getGisId() {
        return edtGisId.getText().toString();
    }

    public String getParcelId() {
        return edtParcelId.getText().toString();
    }

    public String getEdtSourceOfWater() {
        return spSourceOfWater.getText().toString();
    }

    public String getEdtApartmentBuildingName() {
        return edtApartmentBuildingName.getText().toString();
    }

    public String getLiftFacility() {
        return spLiftFacility.getText().toString();
    }

    public String getParkingFacility() {
        return spParkingFacility.getText().toString();
    }

    public String getFireFighting() {
        return spFireFighting.getText().toString();
    }

    public String getRainWaterHarvesting() {
        return spRainWaterHarvesting.getText().toString();
    }

    public String getPowerBackup() {
        return spPowerBackup.getText().toString();
    }

    @Override
    public void setSewageConnectoion(ArrayAdapter customAdapter) {
        edtSewCon.setAdapter(customAdapter);
    }

    @Override
    public void setTypeOfProperty(ArrayAdapter customAdapter) {
        spTypeOfProperty.setAdapter(customAdapter);
    }
    @Override
    public void setPropertyUsage(ArrayAdapter customAdapter) {
        spPropertyUsage.setAdapter(customAdapter);
    }
    @Override
    public void setTypeOfNonesProperty(ArrayAdapter customAdapter) {
        spTypeOfNonResProperty.setAdapter(customAdapter);
    }

    @Override
    public void setRainWaterHarvesting(ArrayAdapter customAdapter) {
        spRainWaterHarvesting.setAdapter(customAdapter);
    }

    @Override
    public void setLiftFacility(ArrayAdapter customAdapter) {
        spLiftFacility.setAdapter(customAdapter);
    }

    @Override
    public void setPowerBackup(ArrayAdapter customAdapter) {
        spPowerBackup.setAdapter(customAdapter);
    }

    @Override
    public void setParkingFacility(ArrayAdapter customAdapter) {
        spParkingFacility.setAdapter(customAdapter);
    }

    @Override
    public void setFireFighting(ArrayAdapter customAdapter) {
        spFireFighting.setAdapter(customAdapter);
    }

    @Override
    public void setWaterConnection(ArrayAdapter customAdapter) {
        edtWCon.setAdapter(customAdapter);
    }

    @Override
    public void setSourceOfWater(ArrayAdapter customAdapter) {
        spSourceOfWater.setAdapter(customAdapter);
    }

    @Override
    public String getEdtYearOfEstabl() {
        return null;
    }

    @Override
    public String getEdtTradeLicNo() {
        return null;
    }

    public String getEdtTradeLicYear() {
        return edtTradeLicYear.getText().toString();
    }

    public String getMsmo() {
        return msmo.getText().toString();
    }

    @Override
    public void setMsmo(ArrayAdapter customAdapte) {
        msmo.setAdapter(customAdapte);
    }

    public String getEdtRemark() {
        return edtRemark.getText().toString();
    }

    @Override
    public void addChipView(ChipView chipView) {
        floorValues.addView(chipView);
    }

    @Override
    public void setAreaMeasurementUnit(ArrayAdapter customAdapte) {
        areaMeasUnit.setAdapter(customAdapte);
    }

    @Override
    public void setLengthWidthMeasuremntUnit(ArrayAdapter customAdapte) {
        lengthWidthUnit.setAdapter(customAdapte);
    }

    @Override
    public void setFloorCount(String count) {
        edtnoFloors.setText(count);
    }

    public void setLatLng(String latLong) {
        txtlatlng.setText("LatLng: " + latLong);
    }

    @Override
    public void clearChips() {
        floorValues.removeAllViews();
    }

    @Override
    public View getView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_property_info, container, false);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onMenuClick = (onMenuClick) context;
    }

    public abstract PropertyLocationContract.Presenter getPresenter();

    public String getTitle() {
        return "Property Location Info";
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        setRightText("Done  ");
        setLeftMenuEnable(false);
        setRightMenuEnable(true);
    }

    @Override
    public boolean onRightMenuClick() {
        super.onRightMenuClick();
        onMenuClick.onFinishCLick();
        getPresenter().onSubmitClick();
        return true;
    }

    @Override
    public boolean onLeftMenuClick() {
        super.onLeftMenuClick();
        onMenuClick.onBackClick();
        return true;
    }

    @OnClick(R.id.btn_add_floor)
    public void onViewClicked() {
        getPresenter().onAddFloorCLicked();
    }


    @OnClick(R.id.edt_address)
    public void onAddressClick() {

    }


    @Override
    public void removeChip(ChipView chiptView) {
        floorValues.removeView(chiptView);
    }

    @OnClick(R.id.btnlatlong)
    public void onLatLongClick() {
        getPresenter().onAddressClick();
    }


}
