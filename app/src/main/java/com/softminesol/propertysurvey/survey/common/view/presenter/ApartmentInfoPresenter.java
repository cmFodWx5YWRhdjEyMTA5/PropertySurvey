package com.softminesol.propertysurvey.survey.common.view.presenter;

import android.content.Intent;

import com.softminesol.propertysurvey.survey.apartmentEntry.domain.SaveApartmentSurveyFormUseCase;
import com.softminesol.propertysurvey.survey.common.model.apartment.Owner;
import com.softminesol.propertysurvey.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.propertysurvey.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.propertysurvey.survey.common.view.activity.OwnerInfoActivity;

import javax.inject.Inject;

import frameworks.basemvp.AppBasePresenter;
import frameworks.network.usecases.RequestParams;
import frameworks.utils.AdapterFactory;
import rx.Subscriber;

/**
 * Created by sandeep on 6/5/18.
 */
public class ApartmentInfoPresenter extends AppBasePresenter<ApartmentInfoContract.View> implements ApartmentInfoContract.Presenter {

    private final AdapterFactory adapterFactory;
    private final SaveApartmentSurveyFormUseCase saveApartmentSurveyFormUseCase;


    @Inject
    public ApartmentInfoPresenter(AdapterFactory adapterFactory,SaveApartmentSurveyFormUseCase saveApartmentSurveyFormUseCase) {
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

        }
        return super.onActivityResult(requestCode, resultCode, data);
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
        SaveApartmentRequest saveApartmentRequest=new SaveApartmentRequest();
        saveApartmentRequest.setGisId(getView().getGisCode());
        saveApartmentRequest.setFloor(getView().getFloorCount());
        saveApartmentRequest.setPropertyUsage(getView().getPropertyUsage());
        saveApartmentRequest.setNonResidentialCode(getView().getNonResidentialCode());
        saveApartmentRequest.setNonResidentialCategory(getView().getNonRegCategory());
        saveApartmentRequest.setShopName(getView().getShopName());
        saveApartmentRequest.setBusinessType(getView().getBusinessType());
        saveApartmentRequest.setBusinessCode(getView().getBusinessCode());
        saveApartmentRequest.setLicenseNumber(getView().getEdtLicenceNo());
        saveApartmentRequest.setLicenseValidity(getView().getEdtLicenceValidity());
        saveApartmentRequest.setLicenseStatus(getView().getLicenceStatus());
        saveApartmentRequest.setBusinessBuiltArea(getView().getBusinessBuiltArea());
        saveApartmentRequest.setRespodentName(getView().getRespondentName());
        saveApartmentRequest.setRespodentStatus(getView().getRespondentStatus());
        saveApartmentRequest.setSourceWater(getView().getSourceWater());
        saveApartmentRequest.setConstructionType(getView().getCunstructionType());
        saveApartmentRequest.setSelfOccupied(getView().getSelfOccupied());
        saveApartmentRequest.setTenanted(getView().getTenanted());
        saveApartmentRequest.setPowerBackup(getView().getPowerBackUp());
        saveApartmentRequest.setBuildingName(getView().getBuildingName());
        saveApartmentRequest.setStreet(getView().getStreet());
        saveApartmentRequest.setColony(getView().getColony());
        saveApartmentRequest.setPincode(getView().getPincode());
        saveApartmentRequest.setWardNo(getView().getWardNumber());
        saveApartmentRequest.setCircleNo(getView().getCircleNumber());
        saveApartmentRequest.setRevenueCircle(getView().getRevenueCircle());
        saveApartmentRequest.setOwnerCount(getView().getOwnerCount());
        saveApartmentRequest.setOwners(getView().getOwners());
        saveApartmentRequest.setOccupencyStatus(getView().getOccupencyStatus());
        saveApartmentRequest.setElectricityConnectionStatus(getView().getElectronicConnectionStatus());
        saveApartmentRequest.setElectricityConnection(getView().getEdtElectionConnectionNo());
        saveApartmentRequest.setSewerageStatus(getView().getSewerageStatus());

        return saveApartmentRequest;


    }

    @Override
    public void onNextClick() {
        SaveApartmentRequest formData=getApartmentData();
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
                getView().showToast("Error");
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












}
