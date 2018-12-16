package com.softminesol.propertysurvey.survey.common.view.presenter;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;

import com.pchmn.materialchips.ChipView;
import com.softminesol.propertysurvey.GlobalConfig;
import com.softminesol.propertysurvey.imageupload.domain.intractor.ImageUploadUseCase;
import com.softminesol.propertysurvey.imageupload.model.ImageUploadResponse;
import com.softminesol.propertysurvey.survey.common.domain.SurveyConstructionTypeUseCase;
import com.softminesol.propertysurvey.survey.common.domain.SurveyFloorListUseCase;
import com.softminesol.propertysurvey.survey.common.domain.SurveyGetCategoryUseCase;
import com.softminesol.propertysurvey.survey.common.domain.SurveyGetPropertyTypeUseCase;
import com.softminesol.propertysurvey.survey.common.domain.SurveyGetSubCategoryUseCase;
import com.softminesol.propertysurvey.survey.common.domain.SurveyMeasurementListUseCase;
import com.softminesol.propertysurvey.survey.common.domain.SurveyOwnerShipUseCase;
import com.softminesol.propertysurvey.survey.common.domain.SurveyRebateUseCase;
import com.softminesol.propertysurvey.survey.common.domain.SurveyUsageListUseCase;
import com.softminesol.propertysurvey.survey.common.model.ConstructionType;
import com.softminesol.propertysurvey.survey.common.model.FloorsList;
import com.softminesol.propertysurvey.survey.common.model.MeasurementUnitList;
import com.softminesol.propertysurvey.survey.common.model.OwnerShipList;
import com.softminesol.propertysurvey.survey.common.model.PropertyCategory;
import com.softminesol.propertysurvey.survey.common.model.PropertyCategoryList;
import com.softminesol.propertysurvey.survey.common.model.PropertySubCategoryList;
import com.softminesol.propertysurvey.survey.common.model.PropertyType;
import com.softminesol.propertysurvey.survey.common.model.PropertyTypes;
import com.softminesol.propertysurvey.survey.common.model.RebateList;
import com.softminesol.propertysurvey.survey.common.model.UsageList;
import com.softminesol.propertysurvey.survey.common.model.formData.FloorDetailsItem;
import com.softminesol.propertysurvey.survey.common.model.formData.OwnerDetailsItem;
import com.softminesol.propertysurvey.survey.common.view.activity.ApartmentInfoActivity;
import com.softminesol.propertysurvey.survey.common.view.activity.OwnerInfoActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import frameworks.basemvp.AppBasePresenter;
import frameworks.customadapter.CustomAdapterModel;
import frameworks.imageloader.view.ActivityPicChooser;
import frameworks.network.usecases.RequestParams;
import frameworks.utils.AdapterFactory;
import rx.Subscriber;

import static com.softminesol.propertysurvey.imageupload.domain.intractor.ImageUploadUseCase.IMAGE_PATH;
import static frameworks.imageloader.view.ActivityPicChooser.IMAGE_URI_REQUEST;
import static frameworks.imageloader.view.ActivityPicChooser.IMAGE_URI_RESULT;

/**
 * Created by sandeep on 6/5/18.
 */
public class FloorInfoPresenter extends AppBasePresenter<FloorInfoContract.View> implements FloorInfoContract.Presenter {

    private final AdapterFactory adapterFactory;
    private final SurveyMeasurementListUseCase surveyMeasurementListUseCase;
    private final SurveyUsageListUseCase surveyUsageListUseCase;
    private final SurveyRebateUseCase surveyRebateUseCase;
    private final SurveyGetPropertyTypeUseCase surveyGetPropertyTypeUseCase;
    private final SurveyGetSubCategoryUseCase surveyGetSubCategoryUseCase;
    private final SurveyConstructionTypeUseCase surveyConstructionTypeUseCase;
    private final SurveyGetCategoryUseCase surveyGetCategoryUseCase;
    private final ImageUploadUseCase imageUploadUseCase;
    private final SurveyOwnerShipUseCase surveyOwnerShipUseCase;
    SurveyFloorListUseCase surveyFloorListUseCase;
    List<PropertyCategory> propertyCategories;
    List<PropertyType> propertyType;
    List<OwnerDetailsItem> ownerDetailsItems = new ArrayList<>();
    boolean imageSyncPassed;

    @Inject
    public FloorInfoPresenter(AdapterFactory adapterFactory, SurveyFloorListUseCase surveyFloorListUseCase, SurveyMeasurementListUseCase surveyMeasurementListUseCase,
                              SurveyUsageListUseCase surveyUsageListUseCase, SurveyRebateUseCase surveyRebateUseCase, SurveyGetCategoryUseCase surveyGetCategoryUseCase,
                              SurveyGetPropertyTypeUseCase surveyGetPropertyTypeUseCase, SurveyGetSubCategoryUseCase surveyGetSubCategoryUseCase,
                              SurveyConstructionTypeUseCase surveyConstructionTypeUseCase, ImageUploadUseCase imageUploadUseCase, SurveyOwnerShipUseCase surveyOwnerShipUseCase) {
        this.surveyFloorListUseCase = surveyFloorListUseCase;
        this.adapterFactory = adapterFactory;
        this.surveyMeasurementListUseCase = surveyMeasurementListUseCase;
        this.surveyUsageListUseCase = surveyUsageListUseCase;
        this.surveyRebateUseCase = surveyRebateUseCase;
        this.surveyGetPropertyTypeUseCase = surveyGetPropertyTypeUseCase;
        this.surveyGetSubCategoryUseCase = surveyGetSubCategoryUseCase;
        this.surveyConstructionTypeUseCase = surveyConstructionTypeUseCase;
        this.surveyGetCategoryUseCase = surveyGetCategoryUseCase;
        this.imageUploadUseCase = imageUploadUseCase;
        this.surveyOwnerShipUseCase = surveyOwnerShipUseCase;
    }

    @Override
    public void attachView(FloorInfoContract.View view) {
        super.attachView(view);
        if (getView().getFloorDetailItem() != null) {
            setFloorDetails(getView().getFloorDetailItem());
        }
        surveyFloorListUseCase.execute(new Subscriber<FloorsList>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(FloorsList floorsList) {
                getView().setFloorList(adapterFactory.getCustomAdapter((List<CustomAdapterModel>) (List<?>) floorsList.getFloors()));
            }
        });

        surveyMeasurementListUseCase.execute(new Subscriber<MeasurementUnitList>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MeasurementUnitList measurementUnitList) {
                getView().setMeasurementUnit(adapterFactory.getCustomAdapter((List<CustomAdapterModel>) (List<?>) measurementUnitList.getMeasurementUnit()));
            }
        });
        surveyUsageListUseCase.execute(new Subscriber<UsageList>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(UsageList usageList) {
                getView().setUsageType(adapterFactory.getCustomAdapter((List<CustomAdapterModel>) (List<?>) usageList.getUsage()));
            }
        });

        surveyRebateUseCase.execute(new Subscriber<RebateList>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(RebateList rebateList) {
                getView().setRebateIdList(adapterFactory.getCustomAdapter((List<CustomAdapterModel>) (List<?>) rebateList.getRebate()));
            }
        });


        surveyConstructionTypeUseCase.execute(new Subscriber<ConstructionType>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ConstructionType constructionType) {
                getView().setConstructionType(adapterFactory.getCustomAdapter((List<CustomAdapterModel>) (List<?>) constructionType.getConstructionType()));

            }
        });

        getView().setBPLOption(adapterFactory.getYesNoAdapter());

        surveyGetCategoryUseCase.execute(new Subscriber<PropertyCategoryList>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(PropertyCategoryList propertyCategoryList) {
                propertyCategories = propertyCategoryList.getPropertyCategories();
                getView().setPropertyCategoryList(adapterFactory.getCustomAdapter((List<CustomAdapterModel>) (List<?>) propertyCategories));
                if (getView().getPropertyCategory() != null) {
                    onPropertyCategorySelect(getView().getPropertyCategory());
                }

            }
        });
        surveyOwnerShipUseCase.execute(new Subscriber<OwnerShipList>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(OwnerShipList ownerShipList) {
                getView().setOwnderShipType(adapterFactory.getCustomAdapter((List<CustomAdapterModel>) (List<?>) ownerShipList.getOwnership()));
            }
        });


    }

    @Override
    public void onNextClick() {

        if (validateForm()) {
            Intent i = new Intent();
            i.putExtra("floorDetails", getFloorDetail());
            getView().setResult(1, i);
            getView().finish();
        }
    }

    public boolean validateForm() {
        if (TextUtils.isEmpty(getView().getSelectFloorId())) {
            getView().setfloorTypeError("Please Select Floor Type");
            return false;
        }
        return true;
    }

    private FloorDetailsItem getFloorDetail() {
        FloorDetailsItem floorDetailsItem = new FloorDetailsItem();
        floorDetailsItem.setBplNumber(getView().getBPLNo());
        floorDetailsItem.setConstructionType(getView().getSelectTypeOfConstruction());
        floorDetailsItem.setCoveredArea(getView().getEdtCoveredArea());
        floorDetailsItem.setCoveredAreaMeasurementUnit(getView().getCoveredAreaMeasurementUnit());
        floorDetailsItem.setFloorType(getView().getSelectFloorId());
        floorDetailsItem.setIsBPL(getView().isBPL());
        floorDetailsItem.setLicesenceIssueDate(getView().getTradleLicenceIssueDate());
        floorDetailsItem.setOccupierName(getView().getOccupierName());
        floorDetailsItem.setOccupyingYear(getView().getYearOfOccupying());
        floorDetailsItem.setOwnerDetails(ownerDetailsItems);
        floorDetailsItem.setPropertyCategory(getView().getPropertyCategory());
        if(imageSyncPassed) {
            floorDetailsItem.setPropertyImageID(getView().getPropertyImageId());
        } else {
            floorDetailsItem.setImagePath(getView().getPropertyImageId());
        }
        floorDetailsItem.setPropertyOwnerCount(getView().getNoOfOwners());
        floorDetailsItem.setPropertyOwnerType(getView().getOwnerShipType());
        floorDetailsItem.setPropertySubType(getView().getPropertySubtype());
        floorDetailsItem.setPropertyType(getView().getEdtPropertyType());
        floorDetailsItem.setRebateID(getView().getSelectRebateId());
        floorDetailsItem.setTitleOfBuilding(getView().getTitleOfBuilding());
        floorDetailsItem.setTradeLicesenceNumber(getView().getTradeLicenceNo());
        floorDetailsItem.setTypeOfBusiness(getView().getBuisnessType());
        floorDetailsItem.setUsageType(getView().getEdtUsageId());
        floorDetailsItem.setYearOfConstruction(getView().getEdtYearOfConstruction());
        floorDetailsItem.setYearOfEstablishment(getView().getYearOfEstablishment());
        return floorDetailsItem;
    }

    @Override
    public void onAddApartmentClick() {
        getView().startActivityForResult(new Intent(getView().getContext(), ApartmentInfoActivity.class), 1);
    }

    @Override
    public void onPropertyCategorySelect(String i) {
        RequestParams requestParams = RequestParams.create();
        PropertyCategory propertyCategory = new PropertyCategory();
        propertyCategory.setCategory(i);
        requestParams.putInt("id", (int) (long) propertyCategories.get(propertyCategories.indexOf(propertyCategory)).getPropertycategoryid());
        surveyGetPropertyTypeUseCase.execute(requestParams, new Subscriber<PropertyTypes>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(PropertyTypes propertyTypes) {
                propertyType = propertyTypes.getPropertyTypes();
                getView().setPropertyType(adapterFactory.getCustomAdapter((List<CustomAdapterModel>) (List<?>) propertyType));
                if (getView().getEdtPropertyType() != null) {
                    onPropertyTypeSelect(getView().getEdtPropertyType());
                }
            }
        });

    }

    @Override
    public void onPropertyTypeSelect(String i) {
        RequestParams requestParams = RequestParams.create();
        PropertyType propertyTypes = new PropertyType();
        propertyTypes.setPropertType(i);
        requestParams.putInt("id", (int) (long) propertyType.get(propertyType.indexOf(propertyTypes)).getPropertytypeid());
        surveyGetSubCategoryUseCase.execute(requestParams, new Subscriber<PropertySubCategoryList>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(PropertySubCategoryList propertySubCategoryList) {
                getView().setSubPropertyType(adapterFactory.getCustomAdapter((List<CustomAdapterModel>) (List<?>) propertySubCategoryList.getPropertySubCategory()));
            }
        });
    }

    @Override
    public void onPropertyImageClick() {
        getView().startActivityForResult(new Intent(getView().getContext(), ActivityPicChooser.class), IMAGE_URI_REQUEST);
    }

    @Override
    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == 1) {
                OwnerDetailsItem ownerDetailsItemDetailsItem = (OwnerDetailsItem) data.getSerializableExtra("ownerDetail");
                if (clickedOwnerDetailsItem != null) {
                    ownerDetailsItems.remove(clickedOwnerDetailsItem);
                }
                ownerDetailsItems.add(ownerDetailsItemDetailsItem);
            }
            getView().clearChips();
            for (OwnerDetailsItem ownerDetailsItem : ownerDetailsItems) {
                addChipView(ownerDetailsItem);
            }
            getView().setNoofOwner(ownerDetailsItems.size() + "");
            clickedOwnerDetailsItem = null;
        } else if (requestCode == IMAGE_URI_REQUEST && resultCode == IMAGE_URI_RESULT) {
            final Uri uri = data.getData();
            if (GlobalConfig.distributeCacheFirst()) {
                getView().setImageURIPath(uri.getPath());
                imageSyncPassed = false;
            } else {
                getView().showProgressBar();

                RequestParams requestParams = RequestParams.create();
                requestParams.putString(IMAGE_PATH, uri.getPath());
                imageUploadUseCase.execute(requestParams, new Subscriber<ImageUploadResponse>() {
                    @Override
                    public void onCompleted() {
                        getView().hideProgressBar();
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().hideProgressBar();
                        getView().showToast(e.getMessage());
                        getView().setImageURIPath(uri.getPath());
                        imageSyncPassed = false;
                    }

                    @Override
                    public void onNext(ImageUploadResponse imageUploadResponse) {
                        imageSyncPassed = true;
                        getView().setImageURIPath(imageUploadResponse.getImage().get(0).getPropertyimagesid() + "");
                    }
                });
            }

        }
        return super.onActivityResult(requestCode, resultCode, data);
    }

    OwnerDetailsItem clickedOwnerDetailsItem;

    void addChipView(final OwnerDetailsItem ownerDetailsItem) {
        final ChipView chipView = new ChipView(getView().getContext());
        chipView.setLabel(ownerDetailsItem.getName());
        chipView.setDeletable(true);
        getView().addChipView(chipView);
        chipView.setOnDeleteClicked(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ownerDetailsItems.remove(ownerDetailsItem);
                getView().removeChip(chipView);
            }
        });
        chipView.setOnChipClicked(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedOwnerDetailsItem = ownerDetailsItem;
                getView().startActivityForResult(OwnerInfoActivity.getIntent(getView().getContext(), ownerDetailsItem), 1);
            }
        });
    }

    public void setFloorDetails(FloorDetailsItem floorDetails) {
        getView().setBPLNo(floorDetails.getBplNumber());
        getView().setBuisnessType(floorDetails.getTypeOfBusiness());
        getView().setSelectTypeOfConstruction(floorDetails.getConstructionType());
        getView().setCoveredAreaMeasurementUnit(floorDetails.getCoveredAreaMeasurementUnit());
        getView().setEdtCoveredArea(floorDetails.getCoveredArea());
        getView().setEdtPropertyType(floorDetails.getPropertyType());
        getView().setEdtUsageId(floorDetails.getUsageType());
        getView().setEdtYearOfConstruction(floorDetails.getYearOfConstruction());
        getView().setisBPL(floorDetails.getIsBPL());
        getView().setNoofOwner(floorDetails.getPropertyOwnerCount());
        getView().setOccupierName(floorDetails.getOccupierName());
        getView().setOwnerShipType(floorDetails.getPropertyOwnerType());
        getView().setPropertyCategory(floorDetails.getPropertyCategory());
        getView().setPropertyImageId(floorDetails.getPropertyImageID());
        getView().setPropertySubtype(floorDetails.getPropertySubType());
        getView().setSelectFloorId(floorDetails.getFloorType());
        getView().setSelectRebateId(floorDetails.getRebateID());
        getView().setTitleOfBuilding(floorDetails.getTitleOfBuilding());
        getView().setTradeLicenceNo(floorDetails.getTradeLicesenceNumber());
        getView().setTradleLicenceIssueDate(floorDetails.getLicesenceIssueDate());
        getView().setYearOfEstablishment(floorDetails.getYearOfEstablishment());
        getView().setYearOfOccupying(floorDetails.getYearOfOccupying());
        ownerDetailsItems = floorDetails.getOwnerDetails();
        for (OwnerDetailsItem ownerDetailsItem : ownerDetailsItems) {
            addChipView(ownerDetailsItem);
        }
    }

    public void clearViews() {
        getView().setBPLNo("");
        getView().setBuisnessType("");
        getView().setSelectTypeOfConstruction("");
        getView().setCoveredAreaMeasurementUnit("");
        getView().setEdtCoveredArea("");
        getView().setEdtPropertyType("");
        getView().setEdtUsageId("");
        getView().setEdtYearOfConstruction("");
        getView().setisBPL("");
        getView().setNoofOwner("");
        getView().setOccupierName("");
        getView().setOwnerShipType("");
        getView().setPropertyCategory("");
        getView().setPropertyImageId("");
        getView().setPropertySubtype("");
        getView().setSelectFloorId("");
        getView().setSelectRebateId("");
        getView().setTitleOfBuilding("");
        getView().setTradeLicenceNo("");
        getView().setTradleLicenceIssueDate("");
        getView().setYearOfEstablishment("");
        getView().setYearOfOccupying("");
        ownerDetailsItems = new ArrayList<>();
        getView().clearChips();
    }

}
