package com.softminesol.propertysurvey.survey.common.view.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
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
    @BindView(R.id.edt_zone_id)
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
    @BindView(R.id.edt_building_status)
    MaterialBetterSpinner spBuildingStatus;
    @BindView(R.id.edt_age_of_building)
    EditText edtAgeOfBuilding;
    @BindView(R.id.btn_add_floor)
    Button btnAddFloor;
    @BindView(R.id.textILayout_remark)
    TextInputLayout textILayoutRemark;

    @BindView(R.id.spRoadWidth)
    MaterialBetterSpinner spRoadWidth;




    @Override
    protected void initInjector() {
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
    public String getMapId() {
        return edtMapId.getText().toString();
    }

    @Override
    public String getParcelId() {
        return edtParcelId.getText().toString();
    }

    @Override
    public String getPropertyType() {
        return spTypeOfProperty.getText().toString();
    }

    @Override
    public String getPropertyUsage() {
        return spPropertyUsage.getText().toString();
    }

    @Override
    public String getBuildingName() {
        return edtApartmentBuildingName.getText().toString();
    }

    @Override
    public String getStreetName() {
        return edtStreetCode.getText().toString();
    }

    @Override
    public String getColonyName() {
        return edtColonyCode.getText().toString();
    }

    @Override
    public String getPinCode() {
        return edtPinCode.getText().toString();
    }

    @Override
    public String getWardNo() {
        return edtWardNo.getText().toString();
    }

    @Override
    public String getZoneId() {
        return edtZone.getText().toString();
    }

    @Override
    public String getRainWaterHarvesting() {
        return spRainWaterHarvesting.getText().toString();
    }

    @Override
    public String getBuildingStatus() {
        return spBuildingStatus.getText().toString();
    }

    @Override
    public String getPropetyArea() {
        return edtPropertyArea.getText().toString();
    }

    @Override
    public String getLiftFacility() {
        return spLiftFacility.getText().toString();
    }

    @Override
    public String getParkingFacility() {
        return spParkingFacility.getText().toString();
    }

    @Override
    public String getAgeOfBuilding() {
        return edtAgeOfBuilding.getText().toString();
    }

    @Override
    public String getfloorCount() {
        return edtFloorCount.getText().toString();
    }

    @Override
    public String getFireFighting() {
        return spFireFighting.getText().toString();
    }


    @Override
    public String getRoadWidth() {
        return spRoadWidth.getText().toString();
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


    @OnClick(R.id.upload_image)
    public void onUploadImageClick() {
        getPresenter().onUploadImageClick();
    }
    public  void showMessage( String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                getActivity().finish();
            }
        });
        builder.setMessage(message);
        builder.show();
    }

    @Override
    public void setBuidlingStatus(ArrayAdapter buildingStatus) {
        spBuildingStatus.setAdapter(buildingStatus);
    }


    @Override
    public void setRoadWidth(ArrayAdapter customAdapter) {
        spRoadWidth.setAdapter(customAdapter);
    }
}
