package com.softminesol.propertysurvey.survey.common.view.presenter;

import android.content.Intent;
import android.location.Location;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.pchmn.materialchips.ChipView;
import com.softmine.imageupload.presenter.ImageUploadPresenter;
import com.softmine.imageupload.view.ImageUploadActivity;
import com.softminesol.locations.locationmanager.data.AddressComponentsItem;
import com.softminesol.locations.locationmanager.data.ReverseGeoCodeAddress;
import com.softminesol.locations.locationmanager.domain.GetLocationAddressUseCase;
import com.softminesol.maps.MapsActivityCurrentPlace;
import com.softminesol.propertysurvey.CommonBaseUrl;
import com.softminesol.propertysurvey.R;
import com.softminesol.propertysurvey.survey.common.domain.SurveyGetPropertyTypeUseCase;
import com.softminesol.propertysurvey.survey.common.domain_luc.SurveyPropertyUsage;
import com.softminesol.propertysurvey.survey.common.model.PropertyTypes;
import com.softminesol.propertysurvey.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.propertysurvey.survey.common.model.formData.FloorDetailsItem;
import com.softminesol.propertysurvey.survey.common.model.newmodel.PropertyUsage;
import com.softminesol.propertysurvey.survey.common.model.property.SavePropertyRequest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import frameworks.basemvp.AppBasePresenter;
import frameworks.customadapter.CustomAdapterModel;
import frameworks.utils.AdapterFactory;
import rx.Subscriber;

import static com.softmine.imageupload.view.ImageUploadActivity.FILE_PATHS;

/**
 * Created by sandeep on 6/5/18.
 */
public class PropertyLocationPresenter<T extends PropertyLocationContract.View> extends AppBasePresenter<T> implements PropertyLocationContract.Presenter<T> {
    protected final AdapterFactory adapterFactory;
    private final SurveyGetPropertyTypeUseCase getPropertyTypeUseCase;
    private final SurveyPropertyUsage surveyPropertyUsage;
    protected List<FloorDetailsItem> floorDetailsItems = new ArrayList<>();

    GetLocationAddressUseCase reverseGeoCodeAddress;
    protected SavePropertyRequest draftedPropertyRequest;
    @Inject
    public PropertyLocationPresenter(AdapterFactory adapterFactory, SurveyGetPropertyTypeUseCase getPropertyTypeUseCase,
                                     SurveyPropertyUsage surveyPropertyUsage, GetLocationAddressUseCase reverseGeoCodeAddress) {
        this.adapterFactory = adapterFactory;
        this.reverseGeoCodeAddress = reverseGeoCodeAddress;
        this.getPropertyTypeUseCase = getPropertyTypeUseCase;
        this.surveyPropertyUsage = surveyPropertyUsage;
    }

    @Override
    public void attachView(T view) {
        super.attachView(view);
        surveyPropertyUsage.execute(new Subscriber<PropertyUsage>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(PropertyUsage propertyUsage) {
                getView().setPropertyUsage(adapterFactory.getCustomAdapter((List<CustomAdapterModel>) (List<?>) propertyUsage.getPropertyUsage()));
            }
        });
        getPropertyTypeUseCase.execute(new Subscriber<PropertyTypes>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(PropertyTypes propertyTypes) {
                getView().setTypeOfProperty(adapterFactory.getCustomAdapter((List<CustomAdapterModel>) (List<?>) propertyTypes.getPropertyTypes()));
            }
        });

        getView().setRainWaterHarvesting(adapterFactory.getYesNoAdapter());
        getView().setLiftFacility(adapterFactory.getYesNoAdapter());
        getView().setParkingFacility(adapterFactory.getYesNoAdapter());
        getView().setFireFighting(adapterFactory.getYesNoAdapter());
        getView().setBuidlingStatus(adapterFactory.getBuildingStatus());
        getView().setRoadWidth(adapterFactory.getRoadWidth());

    }

    @Override
    public void onSubmitClick() {

    }

    @Override
    public void onSaveToDraft() {

    }

    @Override
    public void onAddressClick() {
        getView().startActivityForResult(MapsActivityCurrentPlace.getInstance(getView().getContext(), GoogleMap.MAP_TYPE_SATELLITE), 2);
    }

    public boolean validateForm() {
        return true;
    }


    public SavePropertyRequest getPropertyData() {

        SavePropertyRequest savePropertyRequest = new SavePropertyRequest();
        savePropertyRequest.setMapId(getView().getMapId());
        savePropertyRequest.setParcelId(getView().getParcelId());
        savePropertyRequest.setPropertyType(getView().getPropertyType());
        savePropertyRequest.setPropertyUsage(getView().getPropertyUsage());
        savePropertyRequest.setBuildingName(getView().getBuildingName());
        savePropertyRequest.setStreet(getView().getStreetName());
        savePropertyRequest.setColony(getView().getColonyName());
        savePropertyRequest.setPincode(getView().getPinCode());
        savePropertyRequest.setWardNo(getView().getWardNo());
        savePropertyRequest.setZoneId(getView().getZoneId());
        savePropertyRequest.setRainHarvestingSystem(getView().getRainWaterHarvesting());
        savePropertyRequest.setBuildingStatus(getView().getBuildingStatus());
        savePropertyRequest.setPlotArea(getView().getPropetyArea());
        savePropertyRequest.setLiftFacility(getView().getLiftFacility());
        savePropertyRequest.setParkingFacility(getView().getParkingFacility());
        savePropertyRequest.setAgeOfProperty(getView().getAgeOfBuilding());
        savePropertyRequest.setTotalFloor(getView().getfloorCount());
        savePropertyRequest.setFireFighting(getView().getFireFighting());
        savePropertyRequest.setRoadWidth(getView().getRoadWidth());
        //savePropertyRequest.setOldPropertyId(getView().getOldPropertyId());
        if (location != null) {
            savePropertyRequest.setLattitude(location.getLatitude() + "");
            savePropertyRequest.setLongitude(location.getLongitude() + "");
        }
        savePropertyRequest.setImagesList(fileUrls);
        savePropertyRequest.setImagePathList(filePaths);
        return savePropertyRequest;
    }

    public void setPropertyRequest(SavePropertyRequest savePropertyRequest) {
        draftedPropertyRequest = savePropertyRequest;
        getView().setGisId(savePropertyRequest.getGsid());
        getView().setMapId(savePropertyRequest.getMapId());
        getView().setParcelId(savePropertyRequest.getParcelId());
        getView().setPropertyType(savePropertyRequest.getPropertyType());
        getView().setPropertyUsageItem(savePropertyRequest.getPropertyUsage());
        getView().setBuildingName(savePropertyRequest.getBuildingName());
        getView().setStreet(savePropertyRequest.getStreet());
        getView().setColony(savePropertyRequest.getColony());
        getView().setPincode(savePropertyRequest.getPincode());
        getView().setWardNo(savePropertyRequest.getWardNo());
        getView().setZoneId(savePropertyRequest.getZoneId());
        getView().setRainHarvestingSystem(savePropertyRequest.getRainHarvestingSystem());
        getView().setBuildingStatus(savePropertyRequest.getBuildingStatus());
        getView().setPlotArea(savePropertyRequest.getPlotArea());
        getView().setLiftFacilityItem(savePropertyRequest.getLiftFacility());
        getView().setParkingFacilityItem(savePropertyRequest.getParkingFacility());
        getView().setAgeOfProperty(savePropertyRequest.getAgeOfProperty());
        getView().setFireFightingItem(savePropertyRequest.getFireFighting());
        getView().setRoadWidthItem(savePropertyRequest.getRoadWidth());
       // getView().setOldPropertyId(savePropertyRequest.getOldPropertyId());
        location = new Location("");
        if(savePropertyRequest.getLattitude() != null && savePropertyRequest.getLongitude() != null) {
            location.setLatitude(Double.parseDouble(savePropertyRequest.getLattitude()));
            location.setLongitude(Double.parseDouble(savePropertyRequest.getLattitude()));
        }
        fileUrls = (ArrayList<String>) savePropertyRequest.getImagesList();
        filePaths = (ArrayList<String>) savePropertyRequest.getImagePathList();
    }
    protected Location location;

    //TODO change requestcode to static constant


    @Override
    public void onUploadImageClick() {
        String url = CommonBaseUrl.BASE_URL + "property/uploadPropertImage";
        String param_name = "propertyImage";

        getView().startActivityForResult(ImageUploadActivity.getIntent(getView().getContext(), url, param_name), ImageUploadActivity.REQUEST_GET_FILE_SERVER_URI);
    }

    @Override
    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == 1) {
                if (clickedFloorDetailsItem != null) {
                    floorDetailsItems.remove(clickedFloorDetailsItem);
                }
                FloorDetailsItem formDetailsItem = (FloorDetailsItem) data.getSerializableExtra("floorDetails");
                floorDetailsItems.add(formDetailsItem);
            }
            // IF user just cancel then null clickeditem clickedFloorDetailsItem added new floor it always be null
            clickedFloorDetailsItem = null;
        } else if (requestCode == 2) {
            if (resultCode == 2) {
                location = (Location) data.getParcelableExtra("Location");
                if (location != null) {
                    reverseGeoCodeAddress.execute(reverseGeoCodeAddress.createRequestParams(location.getLatitude() + "", location.getLongitude() + "",
                            getView().getContext().getString(R.string.google_maps_key)), new Subscriber<ReverseGeoCodeAddress>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onNext(ReverseGeoCodeAddress reverseGeoCodeAddress) {
                            List<AddressComponentsItem> addressComponentsItems = reverseGeoCodeAddress.getAddressComponents();
                            for(AddressComponentsItem addressComponentsItem:addressComponentsItems) {
                                List<String> types = addressComponentsItem.getTypes();
                                if(types.contains("sublocality_level_1")) {
                                    getView().setColonyName(addressComponentsItem.getLongName());
                                }
                                if(types.contains("street_number") || types.contains("route")) {
                                    getView().setStreetName(addressComponentsItem.getLongName());
                                }
                                if(types.contains("postal_code")) {
                                    getView().setPinCode(addressComponentsItem.getLongName());
                                }

                            }
                        }
                    });
                     getView().setLatLng(location.getLatitude()+","+location.getLongitude());
                }
            }
        } else if (requestCode == ImageUploadActivity.REQUEST_GET_FILE_SERVER_URI) {
            if (resultCode == ImageUploadPresenter.RESULT_FILE_URI) {
                fileUrls = data.getStringArrayListExtra(FILE_PATHS);
            } else if (resultCode == ImageUploadPresenter.RESULT_FILE_PATHS) {
                filePaths = data.getStringArrayListExtra(FILE_PATHS);
            }
        }
        return true;
    }


    protected ArrayList<String> fileUrls;
    protected ArrayList<String> filePaths;

    FloorDetailsItem clickedFloorDetailsItem;

    protected void addChip(final FloorDetailsItem formDetailsItem) {
        final ChipView chipView = new ChipView(getView().getContext());
        chipView.setDeletable(true);
        chipView.setLabel(formDetailsItem.getFloorType());
        getView().setFloorCount(floorDetailsItems.size() + "");
        chipView.setOnDeleteClicked(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                floorDetailsItems.remove(formDetailsItem);
            }
        });

    }
}
