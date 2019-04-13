package com.softminesol.propertysurvey_qc.qasearch.newPropertyEntry.view.presenter;

import com.softminesol.locations.locationmanager.domain.GetLocationAddressUseCase;
import com.softminesol.propertysurvey_qc.qasearch.newPropertyEntry.domain.SaveSurveyCacheUseCase;
import com.softminesol.propertysurvey_qc.qasearch.newPropertyEntry.domain.SaveSurveyFormUseCase;
import com.softminesol.survey_framework.survey.common.domain.SurveyGetPropertyTypeUseCase;
import com.softminesol.survey_framework.survey.common.domain_luc.SurveyPropertyUsage;
import com.softminesol.survey_framework.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.survey_framework.survey.common.model.property.SavePropertyRequest;
import com.softminesol.survey_framework.survey.common.view.presenter.PropertyLocationPresenter;

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
    public String selectedfdGSID;


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
        if(draftedPropertyRequest !=  null) {
            formData.setId(draftedPropertyRequest.getId());
        }
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
                e.printStackTrace();
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
            selectedfdGSID = draftedPropertyRequest.getGsid();
            RequestParams requestParams = saveSurveyFormUseCase.createRequestParams(selectedfdGSID,formData);
            getView().showProgressBar();
            saveSurveyFormUseCase.execute(requestParams, new Subscriber<GetPropertySaveResponse>() {
                @Override
                public void onCompleted() {
                    getView().hideProgressBar();
                    getView().showSnackBar("Save Successfully");

                }

                @Override
                public void onError(Throwable e) {
                    e.printStackTrace();
                    getView().hideProgressBar();
                    getView().showToast(e.getMessage());

                }

                @Override
                public void onNext(GetPropertySaveResponse getPropertySaveResponse) {
                    getView().finish();
                    /*if (getPropertySaveResponse.getGisId() != null) {
                        getView().startActivity(NewApartmentInfoActivity.createIntent(getView().getContext(), getPropertySaveResponse.getGisId()));
                        getView().finish();
                    } else {
                        if (getPropertySaveResponse.getTempId() > 0) {
                            getView().startActivity(NewApartmentInfoActivity.createIntent(getView().getContext(), getPropertySaveResponse.getTempId()));
                            getView().finish();
                        }
                    }*/
                }
            });

        }
    }
}
