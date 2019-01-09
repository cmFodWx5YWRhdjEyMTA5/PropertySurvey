package com.softminesol.propertysurvey.survey.updatePropertyEntry.view.presenter;

import com.softminesol.locations.locationmanager.domain.GetLocationAddressUseCase;
import com.softminesol.propertysurvey.survey.cloudsync.OldFormSync;
import com.softminesol.propertysurvey.survey.common.domain.GetPropertyInfoUseCase;
import com.softminesol.propertysurvey.survey.common.domain.SurveyAreaTypeUseCase;
import com.softminesol.propertysurvey.survey.common.domain.SurveyMeasurementListUseCase;
import com.softminesol.propertysurvey.survey.common.domain.SurveyPropertyIdListUseCase;
import com.softminesol.propertysurvey.survey.common.model.OLDPropertyUIDS;
import com.softminesol.propertysurvey.survey.common.model.formData.FloorDetailsItem;
import com.softminesol.propertysurvey.survey.common.model.formData.FormData;
import com.softminesol.propertysurvey.survey.common.view.presenter.PropertyLocationPresenter;
import com.softminesol.propertysurvey.survey.updatePropertyEntry.domain.SurveyFormUpdateUseCase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import frameworks.customadapter.CustomAdapterModel;
import frameworks.network.usecases.RequestParams;
import frameworks.utils.AdapterFactory;
import rx.Subscriber;

/**
 * Created by sandeepgoyal on 13/05/18.
 */

public class UpdatePropertyPresenter extends PropertyLocationPresenter<UpdatePropertyContractor.View> implements UpdatePropertyContractor.Presenter {
    private final SurveyPropertyIdListUseCase surveyPropertyIdListUseCase;
    private final GetPropertyInfoUseCase getPropertyInfoUseCase;
    private final SurveyFormUpdateUseCase surveyFormUpdateUseCase;


    OldFormSync syncManager;
    @Inject
    public UpdatePropertyPresenter(AdapterFactory adapterFactory, SurveyAreaTypeUseCase areaTypeUseCase, SurveyMeasurementListUseCase measurementListUseCase, SurveyPropertyIdListUseCase surveyPropertyIdListUseCase,
                                   GetPropertyInfoUseCase getPropertyInfoUseCase, SurveyFormUpdateUseCase surveyFormUpdateUseCase,OldFormSync oldFormSync, GetLocationAddressUseCase reverseGeoCodeAddress) {
        super(adapterFactory, areaTypeUseCase, measurementListUseCase,reverseGeoCodeAddress);
        this.surveyPropertyIdListUseCase = surveyPropertyIdListUseCase;
        this.getPropertyInfoUseCase = getPropertyInfoUseCase;
        this.surveyFormUpdateUseCase = surveyFormUpdateUseCase;
        this.syncManager = oldFormSync;
    }

    @Override
    public void onOldPropertyChange(String oldPropertyChange) {
        RequestParams requestParams = RequestParams.create();
        requestParams.putString("query", oldPropertyChange);

        surveyPropertyIdListUseCase.execute(requestParams, new Subscriber<OLDPropertyUIDS>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(OLDPropertyUIDS oldPropertyUIDS) {
                getView().setOldPropertyIDAdapter((List<CustomAdapterModel>) (List<?>) oldPropertyUIDS.getOldPropertyUID());
            }
        });
    }

    @Override
    public void onPropertyIDSelected(String propertyId) {
        RequestParams requestParams = RequestParams.create();
        requestParams.putString("query", propertyId);
        getView().showProgressBar();
        clearFields();
        getPropertyInfoUseCase.execute(requestParams, new Subscriber<FormData>() {
            @Override
            public void onCompleted() {
                getView().hideProgressBar();

            }

            @Override
            public void onError(Throwable e) {
                getView().hideProgressBar();
            }

            @Override
            public void onNext(FormData formData) {
                getView().setEdtCurrentAddress(formData.getAddressLine1());
                getView().setEdtLength(formData.getBasePlotSizeLength());
                getView().setEdtWidth(formData.getBasePlotSizeWidth());
                getView().setEdtColonyCode(formData.getColonyName());
                getView().setEdtDistCode(formData.getDistrictCode());
                getView().setEdtNoFloors(formData.getFloorcount());
                floorDetailsItems = formData.getFloorDetails();
                getView().setEdtMapId(formData.getLocationID());
                getView().setEdtMcCode(formData.getMCCOde());
                getView().setEdtZone(formData.getZone());
                getView().setAreaMeasUnit(formData.getMeasurementUnit());
                getView().setEdtOldPropertyNo(formData.getOldPropertyUID());
                getView().setEdtPropertyId(formData.getPropertyUID());
                getView().setEdtOldPropertyNo(formData.getPropertyNumber());
                getView().setEdtSewCon(formData.getSeverageConnection());
                getView().setStateCode(formData.getStateCode());
                getView().setEdtStreetCode(formData.getStreetCode());
                getView().setEdtPropertyArea(formData.getTotalArea());
                getView().setAreaMeasUnit(formData.getTotalAreaMeasurementUnit());
                getView().setEdtWardNo(formData.getWardNo());
                getView().setEdtWCon(formData.getWaterConnection());
                getView().setEdtSewConYear(formData.getYearOfSeverageConnection());
                getView().setMsmo(formData.getMSMO());
                getView().setEdtRemark(formData.getRemarks());
                for (FloorDetailsItem floorDetailsItem : floorDetailsItems) {
                    addChip(floorDetailsItem);
                }

            }
        });
    }

    public void onSubmitClick() {
        super.onSubmitClick();
        if (validateForm()) {

        }
    }

        public void clearFields(){
            getView().setEdtCurrentAddress("");
            getView().setEdtLength("");
            getView().setEdtWidth("");
            getView().setEdtColonyCode("");
            getView().setEdtDistCode("");
            getView().setEdtNoFloors("");
            floorDetailsItems = new ArrayList<>();
            getView().setEdtMapId("");
            getView().setEdtMcCode("");
            getView().setEdtZone("");
            getView().setAreaMeasUnit("");
            getView().setEdtOldPropertyNo("");
            getView().setEdtPropertyId("");
            getView().setEdtOldPropertyNo("");
            getView().setEdtSewCon("");
            getView().setStateCode("");
            getView().setEdtStreetCode("");
            getView().setEdtPropertyArea("");
            getView().setAreaMeasUnit("");
            getView().setEdtWardNo("");
            getView().setEdtWCon("");
            getView().setEdtSewConYear("");
            getView().setMsmo("");
            getView().setEdtRemark("");
            getView().clearChips();

    }
}

