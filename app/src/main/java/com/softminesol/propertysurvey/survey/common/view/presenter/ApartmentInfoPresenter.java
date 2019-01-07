package com.softminesol.propertysurvey.survey.common.view.presenter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.softmine.imageupload.presenter.ImageUploadPresenter;
import com.softmine.imageupload.view.ActivityPicChooser;
import com.softmine.imageupload.view.ImageUploadActivity;
import com.softminesol.propertysurvey.CommonBaseUrl;
import com.softminesol.propertysurvey.survey.apartmentEntry.domain.SaveApartmentSurveyFormUseCase;
import com.softminesol.propertysurvey.survey.common.model.apartment.Owner;
import com.softminesol.propertysurvey.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.propertysurvey.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.propertysurvey.survey.common.view.activity.OwnerInfoActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import frameworks.basemvp.AppBasePresenter;
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


    @Inject
    public ApartmentInfoPresenter(AdapterFactory adapterFactory, SaveApartmentSurveyFormUseCase saveApartmentSurveyFormUseCase) {
        this.adapterFactory = adapterFactory;
        this.saveApartmentSurveyFormUseCase = saveApartmentSurveyFormUseCase;

    }

    @Override
    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == 1) {
                Owner ownerDetailsItemDetailsItem = (Owner) data.getSerializableExtra("ownerDetail");
                getView().setOwner(ownerDetailsItemDetailsItem);
            }

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
        getView().setPropertyUsage(adapterFactory.getTypeOfPropertyUsage());
        getView().setRespondentStatus(adapterFactory.getRespondentStatus());
        getView().setOccupencyStatus(adapterFactory.getOccupencyStatus());
        getView().setConstructionType(adapterFactory.getCustructionType());
        getView().setSourceOfWater(adapterFactory.getSourceOfWaterProperty());
        getView().setNonRegCategory(adapterFactory.getTypeOfNonResPropertyAdapter());
        getView().setSpPowerBackup(adapterFactory.getYesNoAdapter());
        getView().setSpElectricityConnStatus(adapterFactory.getYesNoAdapter());
        getView().setSpSewerageConnStatus(adapterFactory.getYesNoAdapter());

    }

    public SaveApartmentRequest getApartmentData() {
        SaveApartmentRequest saveApartmentRequest = new SaveApartmentRequest();
        saveApartmentRequest.setGisId(getView().getGsid());
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
    List<String> fileUrls;
    List<String> filePaths;
    @Override
    public void onNextClick() {
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
    public void onAddOwnerClick() {
        getView().startActivityForResult(new Intent(getView().getContext(), OwnerInfoActivity.class), 1);

    }

    @Override
    public void addApartmentPic() {

        String url = CommonBaseUrl.BASE_URL + "apartment/uploadapartmentImage";
        String param_name = "apartmentImage";
        getView().startActivityForResult(ImageUploadActivity.getIntent(getView().getContext(), url, param_name), REQUEST_GET_FILE_SERVER_URI);
    }


}
