package com.softminesol.propertysurvey.survey.newPropertyEntry.view.presenter;

import com.softminesol.locations.locationmanager.domain.GetLocationAddressUseCase;
import com.softminesol.propertysurvey.localcachesync.domain.NewProperySyncUseCase;
import com.softminesol.propertysurvey.survey.cloudsync.SyncManager;
import com.softminesol.propertysurvey.survey.common.domain.SurveyGetPropertyTypeUseCase;
import com.softminesol.propertysurvey.survey.common.domain_luc.SurveyPropertyUsage;
import com.softminesol.propertysurvey.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.propertysurvey.survey.common.model.property.SavePropertyRequest;
import com.softminesol.propertysurvey.survey.common.view.activity.ApartmentInfoActivity;
import com.softminesol.propertysurvey.survey.common.view.presenter.PropertyLocationPresenter;
import com.softminesol.propertysurvey.survey.newPropertyEntry.domain.SaveSurveyCacheUseCase;
import com.softminesol.propertysurvey.survey.newPropertyEntry.domain.SaveSurveyFormUseCase;

import java.util.List;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.utils.AdapterFactory;
import rx.Subscriber;

/**
 * Created by sandeep on 13/5/18.
 */
public class NewPropertyInfoPresenter extends PropertyLocationPresenter<NewPropertyInforFragmentContract.View> implements NewPropertyInforFragmentContract.Presenter {
    private final SaveSurveyFormUseCase saveSurveyFormUseCase;
    private final SaveSurveyCacheUseCase saveSurveyCacheUseCase;


    @Inject
    SyncManager syncManager;

    @Inject
    NewPropertyInfoPresenter(AdapterFactory adapterFactory, SurveyGetPropertyTypeUseCase getPropertyTypeUseCase,
                             SurveyPropertyUsage surveyPropertyUsage, SaveSurveyFormUseCase saveSurveyFormUseCase, GetLocationAddressUseCase reverseGeoCodeAddress,
                                SaveSurveyCacheUseCase saveSurveyCacheUseCase) {
        super(adapterFactory, getPropertyTypeUseCase, surveyPropertyUsage, reverseGeoCodeAddress);
        this.saveSurveyFormUseCase = saveSurveyFormUseCase;
        this.saveSurveyCacheUseCase = saveSurveyCacheUseCase;

    }

    @Override
    public void onSaveToDraft() {
        SavePropertyRequest formData = getPropertyData();
        formData.setIdDrafted(true);
        RequestParams requestParams = RequestParams.create();
        requestParams.putObject("formdata", formData);
        getView().showProgressBar();
        saveSurveyCacheUseCase.execute(requestParams, new Subscriber<GetPropertySaveResponse>() {
            @Override
            public void onCompleted() {

                getView().hideProgressBar();
                getView().showSnackBar("Saved to Draft");
                getView().finish();
            }

            @Override
            public void onError(Throwable e) {
                getView().hideProgressBar();
                getView().showToast(e.getMessage());
            }

            @Override
            public void onNext(GetPropertySaveResponse getPropertySaveResponse) {

            }
        });
    }

    @Override
    public void onSubmitClick() {
        super.onSubmitClick();
        if (validateForm()) {
            SavePropertyRequest formData = getPropertyData();
            RequestParams requestParams = RequestParams.create();
            requestParams.putObject("formdata", formData);
            getView().showProgressBar();
            saveSurveyFormUseCase.execute(requestParams, new Subscriber<GetPropertySaveResponse>() {
                @Override
                public void onCompleted() {
                    getView().hideProgressBar();
                    getView().showSnackBar("Save Successfully");

                }

                @Override
                public void onError(Throwable e) {
                    getView().hideProgressBar();
                    getView().showToast(e.getMessage());

                }

                @Override
                public void onNext(GetPropertySaveResponse getPropertySaveResponse) {
                    if (getPropertySaveResponse.getGisId() != null) {
                        getView().startActivity(ApartmentInfoActivity.createIntent(getView().getContext(), getPropertySaveResponse.getGisId()));
                        syncManager.execute(new Subscriber<List<GetPropertySaveResponse>>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(List<GetPropertySaveResponse> getPropertySaveResponses) {

                            }
                        });
                        getView().finish();
                    } else {
                        if (getPropertySaveResponse.getTempId() > 0) {
                            getView().startActivity(ApartmentInfoActivity.createIntent(getView().getContext(), getPropertySaveResponse.getTempId()));
                            getView().finish();
                        }
                    }
                }
            });

        }
    }
}
