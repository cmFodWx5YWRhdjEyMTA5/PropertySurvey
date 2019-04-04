package com.softminesol.propertysurvey.survey.apartmentEntry.view.presenter;

import com.softminesol.propertysurvey.survey.apartmentEntry.domain.SaveApartmentCacheUseCase;
import com.softminesol.propertysurvey.survey.apartmentEntry.domain.SaveApartmentSurveyFormUseCase;
import com.softminesol.propertysurvey.survey.cloudsync.SyncManager;
import com.softminesol.survey_framework.survey.common.domain_luc.SurveyConstructionType;
import com.softminesol.survey_framework.survey.common.domain_luc.SurveyFloor;
import com.softminesol.survey_framework.survey.common.domain_luc.SurveyNonResidentCategory;
import com.softminesol.survey_framework.survey.common.domain_luc.SurveyOccupancyStatus;
import com.softminesol.survey_framework.survey.common.domain_luc.SurveyPropertyUsage;
import com.softminesol.survey_framework.survey.common.domain_luc.SurveyRespodentStatus;
import com.softminesol.survey_framework.survey.common.domain_luc.SurveySourceWaterUseCase;
import com.softminesol.survey_framework.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.survey_framework.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.survey_framework.survey.common.view.presenter.ApartmentInfoContract;
import com.softminesol.survey_framework.survey.common.view.presenter.ApartmentInfoPresenter;

import java.util.List;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.utils.AdapterFactory;
import rx.Subscriber;

public class NewApartmentPresenter extends ApartmentInfoPresenter<NewApartmentContract.View> implements NewApartmentContract.Presenter {

    private final SaveApartmentSurveyFormUseCase saveApartmentSurveyFormUseCase;
    private final SaveApartmentCacheUseCase saveApartmentCacheUseCase;
    private SyncManager syncManager;

    @Inject
    public NewApartmentPresenter(AdapterFactory adapterFactory, SaveApartmentSurveyFormUseCase saveApartmentSurveyFormUseCase,
                                  SyncManager syncManager, SurveyFloor surveyFloorListUseCase,
                                  SurveyPropertyUsage surveyPropertyUsage, SurveyNonResidentCategory surveyNonResidentCategory,
                                  SurveyRespodentStatus surveyRespodentStatus, SurveyOccupancyStatus surveyOccupancyStatus, SurveySourceWaterUseCase surveySourceWaterUseCase,
                                  SurveyConstructionType surveyConstructionType, SaveApartmentCacheUseCase saveApartmentCacheUseCase) {
        super(adapterFactory,surveyFloorListUseCase,surveyPropertyUsage,surveyNonResidentCategory,surveyRespodentStatus,surveyOccupancyStatus,surveySourceWaterUseCase,
                surveyConstructionType);
        this.saveApartmentSurveyFormUseCase = saveApartmentSurveyFormUseCase;
        this.syncManager = syncManager;
        this.saveApartmentCacheUseCase = saveApartmentCacheUseCase;
    }
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


}
