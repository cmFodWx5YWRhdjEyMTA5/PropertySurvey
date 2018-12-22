package com.softminesol.propertysurvey.survey.common.view.presenter;

import android.content.Intent;
import android.location.Location;
import android.view.MotionEvent;
import android.view.View;

import com.pchmn.materialchips.ChipView;
import com.softmine.imageupload.model.ImageUpload;
import com.softmine.imageupload.view.ImageUploadActivity;
import com.softminesol.maps.MapsActivityCurrentPlace;
import com.softminesol.propertysurvey.survey.common.domain.SurveyAreaTypeUseCase;
import com.softminesol.propertysurvey.survey.common.domain.SurveyMeasurementListUseCase;
import com.softminesol.propertysurvey.survey.common.model.AreaType;
import com.softminesol.propertysurvey.survey.common.model.MeasurementUnitList;
import com.softminesol.propertysurvey.survey.common.model.formData.FloorDetailsItem;
import com.softminesol.propertysurvey.survey.common.model.formData.FormData;
import com.softminesol.propertysurvey.survey.common.model.property.SavePropertyRequest;
import com.softminesol.propertysurvey.survey.common.view.activity.FloorInfoActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import frameworks.basemvp.AppBasePresenter;
import frameworks.customadapter.CustomAdapterModel;
import frameworks.utils.AdapterFactory;
import rx.Subscriber;

/**
 * Created by sandeep on 6/5/18.
 */
public class PropertyLocationPresenter<T extends PropertyLocationContract.View> extends AppBasePresenter<T> implements PropertyLocationContract.Presenter<T> {
    protected final AdapterFactory adapterFactory;
    private final SurveyAreaTypeUseCase areaTypeUseCase;
    private final SurveyMeasurementListUseCase measurementListUseCase;
    protected List<FloorDetailsItem> floorDetailsItems = new ArrayList<>();

    @Inject
    public PropertyLocationPresenter(AdapterFactory adapterFactory, SurveyAreaTypeUseCase areaTypeUseCase, SurveyMeasurementListUseCase measurementListUseCase) {
        this.adapterFactory = adapterFactory;
        this.areaTypeUseCase = areaTypeUseCase;
        this.measurementListUseCase = measurementListUseCase;
    }

    @Override
    public void attachView(T view) {
        super.attachView(view);
        areaTypeUseCase.execute(new Subscriber<AreaType>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(AreaType areaType) {
                getView().setAreaType(adapterFactory.getCustomAdapter((List<CustomAdapterModel>) (List<?>) areaType.getAreaType()));
            }
        });

        measurementListUseCase.execute(new Subscriber<MeasurementUnitList>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(MeasurementUnitList measurementUnitList) {
                getView().setAreaMeasurementUnit(adapterFactory.getCustomAdapter((List<CustomAdapterModel>) (List<?>) measurementUnitList.getMeasurementUnit()));
                getView().setLengthWidthMeasuremntUnit(adapterFactory.getCustomAdapter((List<CustomAdapterModel>) (List<?>) measurementUnitList.getMeasurementUnit()));
            }
        });
        getView().setSewageConnectoion(adapterFactory.getYesNoAdapter());
        getView().setWaterConnection(adapterFactory.getYesNoAdapter());
        getView().setMsmo(adapterFactory.getYesNoAdapter());
        getView().setPropertyUsage(adapterFactory.getTypeOfPropertyUsage());
        getView().setTypeOfProperty(adapterFactory.getTypeOfPropertyAdapter());
        getView().setTypeOfNonesProperty(adapterFactory.getTypeOfNonResPropertyAdapter());
        getView().setRainWaterHarvesting(adapterFactory.getYesNoAdapter());
        getView().setLiftFacility(adapterFactory.getYesNoAdapter());
        getView().setPowerBackup(adapterFactory.getYesNoAdapter());
        getView().setParkingFacility(adapterFactory.getYesNoAdapter());
        getView().setFireFighting(adapterFactory.getYesNoAdapter());
        getView().setSourceOfWater(adapterFactory.getSourceOfWaterProperty());

    }

    @Override
    public void onSubmitClick() {

    }

    @Override
    public void onAddressClick() {
        getView().startActivityForResult(new Intent(getView().getContext(), MapsActivityCurrentPlace.class),2);
    }

    public boolean validateForm() {
        return true;
    }


    public SavePropertyRequest getPropertyData() {

        SavePropertyRequest savePropertyRequest=new SavePropertyRequest();
        savePropertyRequest.setMapId(getView().getEdtMapId());
        savePropertyRequest.setParcelId(getView().getParcelId());
        savePropertyRequest.setPropertyType(getView().getTypeOfProperty());
        savePropertyRequest.setRainHarvestingSystem(getView().getRainWaterHarvesting());
        savePropertyRequest.setIndividualBuilding(getView().getEdtIndvStatus());
        savePropertyRequest.setLiftFacility(getView().getLiftFacility());
        savePropertyRequest.setParkingFacility(getView().getParkingFacility());
        savePropertyRequest.setFireFighting(getView().getFireFighting());
        savePropertyRequest.setAgeOfProperty(getView().getEdtAgeOfBuilding());
        savePropertyRequest.setTotalFloor(getView().getFloorCount());
        savePropertyRequest.setPlotArea(getView().getEdtPropertyArea());
        savePropertyRequest.setBuildingName(getView().getEdtApartmentBuildingName());
        savePropertyRequest.setStreet(getView().getStateCode());
        savePropertyRequest.setColony(getView().getEdtColonyCode());
        savePropertyRequest.setPincode(getView().getPincode());
        savePropertyRequest.setWardNo(getView().getWardNumber());
        savePropertyRequest.setCircleNo(getView().getCircleNumber());
        savePropertyRequest.setRevenueCircle(getView().getRevenueCircle());
        savePropertyRequest.setPropertyUsage(getView().getPropertyUsage());
        return savePropertyRequest;
    }

    public FormData getFormData() {


        FormData formData = new FormData();
        formData.setAddressLine1(getView().getEdtCurrentAddress());
        formData.setBasePlotSizeLength(getView().getEdtLength());
        formData.setBasePlotSizeWidth(getView().getEdtWidth());
        formData.setColonyName(getView().getEdtColonyCode());
        formData.setDistrictCode(getView().getEdtDistCode());
        formData.setFloorcount(getView().getEdtNoFloors());
        formData.setFloorDetails(floorDetailsItems);
        formData.setLocationID(getView().getEdtMapId());
        formData.setMCCOde(getView().getEdtMcCode());
        formData.setZone(getView().getEdtZone());
        if(location != null) {
            formData.setLattitude(location.getLatitude());
            formData.setLongitutue(location.getLongitude());
        }
        formData.setMeasurementUnit(getView().getAreaMeasUnit());
        formData.setOldPropertyUID(getView().getEdtOldPropertyNo());
        formData.setPropertyUID(getView().getEdtPropertyId());
        formData.setPropertyNumber(getView().getEdtOldPropertyNo());
        formData.setSeverageConnection(getView().getEdtSewCon());
        formData.setStateCode(getView().getStateCode());
        formData.setStreetCode(getView().getEdtStreetCode());
        formData.setTotalArea(getView().getEdtPropertyArea());
        formData.setTotalAreaMeasurementUnit(getView().getAreaMeasUnit());
        formData.setWardNo(getView().getEdtWardNo());
        formData.setWaterConnection(getView().getEdtWCon());
        formData.setYearOfSeverageConnection(getView().getEdtSewConYear());
        formData.setMSMO(getView().getMsmo());
        formData.setRemarks(getView().getEdtRemark());
        return formData;

    }

    Location location;
    //TODO change requestcode to static constant
    @Override
    public void onAddFloorCLicked() {
        getView().startActivityForResult(new Intent(getView().getContext(), FloorInfoActivity.class), 1);
    }

    @Override
    public void onUploadImageClick() {
        getView().startActivityForResult(ImageUploadActivity.getIntent(getView().getContext()),ImageUploadActivity.REQUEST_GET_FILE_SERVER_URI);
    }

    @Override
    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 ) {
            if(resultCode == 1) {
                if (clickedFloorDetailsItem != null) {
                    floorDetailsItems.remove(clickedFloorDetailsItem);
                }
                FloorDetailsItem formDetailsItem = (FloorDetailsItem) data.getSerializableExtra("floorDetails");
                floorDetailsItems.add(formDetailsItem);
            }
            // IF user just cancel then null clickeditem clickedFloorDetailsItem added new floor it always be null
            getView().clearChips();
            for(FloorDetailsItem floorDetailsItem: floorDetailsItems) {
                addChip(floorDetailsItem);
            }
            clickedFloorDetailsItem = null;
        }else if(requestCode == 2) {
            if(resultCode == 2) {
                  location = (Location) data.getParcelableExtra("Location");
                  if(location != null) {
                      getView().setLatLng(location.getLatitude()+","+location.getLongitude());
                  }
            }
        }
        return super.onActivityResult(requestCode, resultCode, data);
    }

    FloorDetailsItem clickedFloorDetailsItem;
    protected void addChip(final FloorDetailsItem formDetailsItem) {
        final ChipView chipView = new ChipView(getView().getContext());
        chipView.setDeletable(true);
        chipView.setLabel(formDetailsItem.getFloorType());
        getView().addChipView(chipView);
        getView().setFloorCount(floorDetailsItems.size() + "");
        chipView.setOnDeleteClicked(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                floorDetailsItems.remove(formDetailsItem);
                getView().removeChip(chipView);
            }
        });
        chipView.setOnChipClicked(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedFloorDetailsItem = formDetailsItem;
                getView().startActivityForResult(FloorInfoActivity.getFloorInfoIntet(getView().getContext(),formDetailsItem),1);

            }
        });
    }
}
