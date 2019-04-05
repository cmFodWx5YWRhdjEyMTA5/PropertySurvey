package com.softminesol.propertysurvey.survey.common.view.presenter;

import android.content.Intent;

import com.softmine.imageupload.presenter.ImageUploadPresenter;
import com.softmine.imageupload.view.ImageUploadActivity;
import com.softminesol.propertysurvey.CommonBaseUrl;
import com.softminesol.propertysurvey.survey.apartmentEntry.domain.SaveApartmentCacheUseCase;
import com.softminesol.propertysurvey.survey.apartmentEntry.domain.SaveApartmentSurveyFormUseCase;
import com.softminesol.propertysurvey.survey.cloudsync.SyncManager;
import com.softminesol.propertysurvey.survey.common.domain_luc.SurveyConstructionType;
import com.softminesol.propertysurvey.survey.common.domain_luc.SurveyFloor;
import com.softminesol.propertysurvey.survey.common.domain_luc.SurveyNonResidentCategory;
import com.softminesol.propertysurvey.survey.common.domain_luc.SurveyOccupancyStatus;
import com.softminesol.propertysurvey.survey.common.domain_luc.SurveyPropertyUsage;
import com.softminesol.propertysurvey.survey.common.domain_luc.SurveyRespodentStatus;
import com.softminesol.propertysurvey.survey.common.domain_luc.SurveySourceWaterUseCase;
import com.softminesol.propertysurvey.survey.common.model.apartment.Owner;
import com.softminesol.propertysurvey.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.propertysurvey.survey.common.model.newmodel.ConstructionType;
import com.softminesol.propertysurvey.survey.common.model.newmodel.Floors;
import com.softminesol.propertysurvey.survey.common.model.newmodel.NonResidentalCategory;
import com.softminesol.propertysurvey.survey.common.model.newmodel.NonResidentalCategoryItem;
import com.softminesol.propertysurvey.survey.common.model.newmodel.OccupancyStatus;
import com.softminesol.propertysurvey.survey.common.model.newmodel.PropertyUsage;
import com.softminesol.propertysurvey.survey.common.model.newmodel.RespondentStatus;
import com.softminesol.propertysurvey.survey.common.model.newmodel.SourceWater;
import com.softminesol.propertysurvey.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.propertysurvey.survey.common.view.activity.OwnerInfoActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import frameworks.basemvp.AppBasePresenter;
import frameworks.customadapter.CustomAdapterModel;
import frameworks.network.usecases.RequestParams;
import frameworks.utils.AdapterFactory;
import rx.Subscriber;

import static com.softmine.imageupload.view.ImageUploadActivity.FILE_PATHS;
import static com.softmine.imageupload.view.ImageUploadActivity.REQUEST_GET_FILE_SERVER_URI;

/**
 * Created by sandeep on 6/5/18.
 */
public class ApartmentInfoPresenter extends AppBasePresenter<ApartmentInfoContract.View> implements ApartmentInfoContract.Presenter {

    private final AdapterFactory adapterFactory;
    private final SaveApartmentSurveyFormUseCase saveApartmentSurveyFormUseCase;
    private final SurveyFloor surveyFloorListUseCase;
    private final SurveyPropertyUsage surveyPropertyUsage;
    private final SurveyNonResidentCategory surveyNonResidentCategory;
    private final SurveyRespodentStatus surveyRespodentStatus;
    private final SurveyOccupancyStatus surveyOccupancyStatus;
    private final SurveySourceWaterUseCase surveySourceWaterUseCase;
    private final SurveyConstructionType surveyConstructionType;
    private final SaveApartmentCacheUseCase saveApartmentCacheUseCase;
    private SyncManager syncManager;

    @Inject
    public ApartmentInfoPresenter(AdapterFactory adapterFactory, SaveApartmentSurveyFormUseCase saveApartmentSurveyFormUseCase,
                                  SyncManager syncManager, SurveyFloor surveyFloorListUseCase,
                                  SurveyPropertyUsage surveyPropertyUsage, SurveyNonResidentCategory surveyNonResidentCategory,
                                  SurveyRespodentStatus surveyRespodentStatus, SurveyOccupancyStatus surveyOccupancyStatus, SurveySourceWaterUseCase surveySourceWaterUseCase,
                                  SurveyConstructionType surveyConstructionType,SaveApartmentCacheUseCase saveApartmentCacheUseCase) {
        this.adapterFactory = adapterFactory;
        this.saveApartmentSurveyFormUseCase = saveApartmentSurveyFormUseCase;
        this.syncManager = syncManager;
        this.surveyFloorListUseCase = surveyFloorListUseCase;
        this.surveyPropertyUsage = surveyPropertyUsage;
        this.surveyNonResidentCategory = surveyNonResidentCategory;
        this.surveyRespodentStatus = surveyRespodentStatus;
        this.surveyOccupancyStatus = surveyOccupancyStatus;
        this.surveySourceWaterUseCase = surveySourceWaterUseCase;
        this.surveyConstructionType = surveyConstructionType;
        this.saveApartmentCacheUseCase = saveApartmentCacheUseCase;

    }

    @Override
    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == 1) {
                Owner ownerDetailsItemDetailsItem = (Owner) data.getSerializableExtra("ownerDetail");
                getView().removeClickOwner();
                getView().setOwner(ownerDetailsItemDetailsItem);

            }
            getView().clearChips();
            getView().inflateChips();

        } if (requestCode == ImageUploadActivity.REQUEST_GET_FILE_SERVER_URI) {
            if(resultCode == ImageUploadPresenter.RESULT_FILE_URI) {
                fileUrls = data.getStringArrayListExtra(FILE_PATHS);

            }else if(resultCode == ImageUploadPresenter.RESULT_FILE_PATHS) {
                filePaths = data.getStringArrayListExtra(FILE_PATHS);

            }
        }
        return true;
    }


    @Override
    public void attachView(ApartmentInfoContract.View view) {
        super.attachView(view);
        getView().setLicenceStatus(adapterFactory.getYesNoAdapter());
        surveyFloorListUseCase.execute(new Subscriber<Floors>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(Floors floors) {

                getView().setFloorList(adapterFactory.getCustomAdapter((List<CustomAdapterModel>) (List<?>) floors.getFloors()));
            }
        });
        surveyPropertyUsage.execute(new Subscriber<PropertyUsage>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(PropertyUsage propertyUsage) {

                getView().setPropertyUsage(adapterFactory.getCustomAdapter((List<CustomAdapterModel>) (List<?>) propertyUsage.getPropertyUsage()));
            }
        });
        surveyRespodentStatus.execute(new Subscriber<RespondentStatus>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(RespondentStatus respondentStatus) {
                getView().setRespondentStatus(adapterFactory.getCustomAdapter((List<CustomAdapterModel>) (List<?>) respondentStatus.getRespodentStatus()));
            }
        });

        surveyOccupancyStatus.execute(new Subscriber<OccupancyStatus>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(OccupancyStatus occupancyStatus) {
                getView().setOccupencyStatus(adapterFactory.getCustomAdapter((List<CustomAdapterModel>) (List<?>) occupancyStatus.getOccupancyStatus()));
            }
        });
        surveyConstructionType.execute(new Subscriber<ConstructionType>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(ConstructionType constructionType) {
                getView().setConstructionType(adapterFactory.getCustomAdapter((List<CustomAdapterModel>) (List<?>) constructionType.getConstructionTypes()));
            }
        });
        surveySourceWaterUseCase.execute(new Subscriber<SourceWater>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(SourceWater sourceWater) {
                getView().setSourceOfWater(adapterFactory.getCustomAdapter((List<CustomAdapterModel>) (List<?>) sourceWater.getSourceWater()));
            }
        });
        surveyNonResidentCategory.execute(new Subscriber<NonResidentalCategory>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(NonResidentalCategory nonResidentalCategory) {
                nonResidentalCategoryItems = nonResidentalCategory.getNonResidentalCategory();
                getView().setNonRegCategory(adapterFactory.getCustomAdapter((List<CustomAdapterModel>) (List<?>) nonResidentalCategory.getNonResidentalCategory()));
            }
        });


        getView().setSpPowerBackup(adapterFactory.getYesNoAdapter());
        getView().setSpElectricityConnStatus(adapterFactory.getYesNoAdapter());
        getView().setSpSewerageConnStatus(adapterFactory.getYesNoAdapter());

    }

    List<NonResidentalCategoryItem> nonResidentalCategoryItems = new ArrayList<>();

    public void setApartmentData(SaveApartmentRequest saveApartmentRequest) {
        getView().setTempId(saveApartmentRequest.getTempPropertyApartmentId()+"");
        getView().setGisId(saveApartmentRequest.getGisId()+"");
        getView().setFloorNumber( saveApartmentRequest.getFloor());
        getView().setPropertyUsageItem(saveApartmentRequest.getPropertyUsage());
        getView().setNonResidentialCode(saveApartmentRequest.getNonResidentialCode());
        getView().setNonResidentalCategory(saveApartmentRequest.getNonResidentialCategory());
        getView().setShopName(saveApartmentRequest.getShopName());
        getView().setBusinessType(saveApartmentRequest.getBusinessType());
        getView().setBuisnessCode(saveApartmentRequest.getBusinessCode());
        getView().setEdtLicenceNo(saveApartmentRequest.getLicenseNumber());
        getView().setLicenseValidity(saveApartmentRequest.getLicenseValidity());
        getView().setLicenseStatus(saveApartmentRequest.getLicenseStatus());
        getView().setBusinessBuiltArea(saveApartmentRequest.getBusinessBuiltArea());
        getView().setRespodentName(saveApartmentRequest.getRespodentName());
        getView().setRespodentStatus(saveApartmentRequest.getRespodentStatus());
        getView().setOccupencyStatusItem(saveApartmentRequest.getOccupencyStatus()+"");
        getView().setElectricityConnectionStatus(saveApartmentRequest.getElectricityConnectionStatus()+"");
        getView().setElectricityConnection(saveApartmentRequest.getElectricityConnection()+"");
        getView().setSewerageStatus(saveApartmentRequest.getSewerageStatus()+"");
        getView().setSewerageConnectionNumber(saveApartmentRequest.getSewerageConnectionNumber()+"");
        getView().setSourceWater(saveApartmentRequest.getSourceWater()+"");
        getView().setConstructionTypeItem(saveApartmentRequest.getConstructionType()+"");
        getView().setSelfOccupiedArea(saveApartmentRequest.getSelfOccupiedArea()+"");
        getView().setTenantedCarpetArea(saveApartmentRequest.getTenantedCarpetArea()+"");
        getView().setPowerBackup(saveApartmentRequest.getPowerBackup()+"");
        getView().setOwnerCount(saveApartmentRequest.getOwnerCount()+"");
        getView().setOwners(saveApartmentRequest.getOwners());
        fileUrls = saveApartmentRequest.getApartmentImage();
        filePaths = saveApartmentRequest.getApartmentImagepath();
    }
    public SaveApartmentRequest getApartmentData() {

        SaveApartmentRequest saveApartmentRequest = new SaveApartmentRequest();
        if(getView().getGsid() == null || getView().getGsid().isEmpty()) {
            saveApartmentRequest.setTempPropertyApartmentId(getView().getTempId());
        }else {
            saveApartmentRequest.setGisId(getView().getGsid());
        }
        saveApartmentRequest.setFloor(getView().getFloorNumber());
        saveApartmentRequest.setPropertyUsage(getView().getPropertyUsage());
        saveApartmentRequest.setNonResidentialCode(getView().getNonResedentalCode());
        saveApartmentRequest.setNonResidentialCategory(getView().getNonResidentalCategory());
        saveApartmentRequest.setShopName(getView().getShopName());
        saveApartmentRequest.setBusinessType(getView().getBuisnessType());
        saveApartmentRequest.setBusinessCode(getView().getBuisnessCode());
        saveApartmentRequest.setLicenseNumber(getView().getLicenceNo());
        saveApartmentRequest.setLicenseValidity(getView().getLicenceValidity());
        saveApartmentRequest.setLicenseStatus(getView().getLiceceStatus());
        saveApartmentRequest.setBusinessBuiltArea(getView().getBuisnessBuiltArea());
        saveApartmentRequest.setRespodentName(getView().getRespodentName());
        saveApartmentRequest.setRespodentStatus(getView().getRespondentStatus());
        saveApartmentRequest.setOccupencyStatus(getView().getOccupencyStatus());
        saveApartmentRequest.setElectricityConnectionStatus(getView().getElectricityStatus());

        saveApartmentRequest.setElectricityConnection(getView().getElectricConnectionNumber());
        saveApartmentRequest.setSewerageStatus(getView().getSewarageConnectionStatus());
        saveApartmentRequest.setSewerageConnectionNumber(getView().getSewarageConnectionNumber());
        saveApartmentRequest.setSourceWater(getView().getSourceOfWater());
        saveApartmentRequest.setConstructionType(getView().getConstructionType());
        saveApartmentRequest.setSelfOccupiedArea(getView().getSelfCarpetArea());
        saveApartmentRequest.setTenantedCarpetArea(getView().getTenantedCarpetArea());
        saveApartmentRequest.setPowerBackup(getView().getPowerBackup());
        saveApartmentRequest.setOwnerCount(getView().getOwnerCount());
        saveApartmentRequest.setOwners(getView().getOwners());
        saveApartmentRequest.setApartmentImage(fileUrls);
        saveApartmentRequest.setApartmentImagepath(filePaths);
        return saveApartmentRequest;


    }
    List<String> fileUrls = new ArrayList<>();
    List<String> filePaths = new ArrayList<>();
    @Override
    public void onNextClick() {
        if(validateForm()) {
            SaveApartmentRequest formData = getApartmentData();
            RequestParams requestParams = RequestParams.create();
            requestParams.putObject("formdata", formData);
            getView().showProgressBar();
            saveApartmentSurveyFormUseCase.execute(requestParams, new Subscriber<GetPropertySaveResponse>() {
                @Override
                public void onCompleted() {
                    getView().hideProgressBar();
                    // getView().showSnackBar("Save Successfully");

                }

                @Override
                public void onError(Throwable e) {
                    getView().hideProgressBar();
                    getView().showToast(e.getMessage());
                    getView().gotoHome();
                    e.printStackTrace();
                }

                @Override
                public void onNext(GetPropertySaveResponse getPropertySaveResponse) {
                    getView().showToast("Save Successfully");
                    syncManager.execute(new Subscriber<List<GetPropertySaveResponse>>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onNext(List<GetPropertySaveResponse> getPropertySaveResponses) {

                        }
                    });
                    getView().gotoHome();
                }
            });
        }
    }

    private boolean validateForm() {
        if(getView().getElectricConnectionNumber().length() > 0 &&getView().getElectricConnectionNumber().length()< 9) {
            getView().setElectricityConnectionError("Electricity Number should be 9 digit");
            return false;
        }
        return true;
    }

    @Override
    public void onAddOwnerClick() {
        getView().startActivityForResult(new Intent(getView().getContext(), OwnerInfoActivity.class), 1);

    }

    @Override
    public void onSaveToDraft() {
        SaveApartmentRequest formData = getApartmentData();
        formData.setIdDrafted(true);
        RequestParams requestParams = RequestParams.create();
        requestParams.putObject("formdata", formData);
        getView().showProgressBar();
        saveApartmentCacheUseCase.execute(requestParams, new Subscriber<GetPropertySaveResponse>() {
            @Override
            public void onCompleted() {
                getView().hideProgressBar();
            }

            @Override
            public void onError(Throwable e) {
                getView().hideProgressBar();
                getView().showToast(e.getMessage());
                getView().gotoHome();
                e.printStackTrace();
            }

            @Override
            public void onNext(GetPropertySaveResponse getPropertySaveResponse) {
                getView().showToast("Save Successfully");
                getView().gotoHome();
            }
        });
    }

    @Override
    public void onNonRegCategorySelected(int position) {
            getView().setNonResidentialCode(nonResidentalCategoryItems.get(position).getCode());
    }

    @Override
    public void addApartmentPic() {

        String url = CommonBaseUrl.BASE_URL + "apartment/uploadapartmentImage";
        String param_name = "apartmentImage";
        getView().startActivityForResult(ImageUploadActivity.getIntent(getView().getContext(), url, param_name), REQUEST_GET_FILE_SERVER_URI);
    }


}
