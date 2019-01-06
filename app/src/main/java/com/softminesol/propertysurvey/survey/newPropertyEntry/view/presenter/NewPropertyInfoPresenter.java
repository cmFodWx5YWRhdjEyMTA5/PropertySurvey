package com.softminesol.propertysurvey.survey.newPropertyEntry.view.presenter;

import com.softminesol.propertysurvey.survey.cloudsync.NewFormSync;
import com.softminesol.propertysurvey.survey.common.domain.SurveyAreaTypeUseCase;
import com.softminesol.propertysurvey.survey.common.domain.SurveyMeasurementListUseCase;
import com.softminesol.propertysurvey.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.propertysurvey.survey.common.model.property.SavePropertyRequest;
import com.softminesol.propertysurvey.survey.common.view.activity.ApartmentInfoActivity;
import com.softminesol.propertysurvey.survey.common.view.presenter.PropertyLocationPresenter;
import com.softminesol.propertysurvey.survey.newPropertyEntry.domain.SaveSurveyFormUseCase;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.utils.AdapterFactory;
import rx.Subscriber;

/**
 * Created by sandeep on 13/5/18.
 */
public class NewPropertyInfoPresenter extends PropertyLocationPresenter<NewPropertyInforFragmentContract.View> implements NewPropertyInforFragmentContract.Presenter {
    private final SaveSurveyFormUseCase saveSurveyFormUseCase;


    @Inject
    NewFormSync syncManager;

    @Inject
    NewPropertyInfoPresenter(AdapterFactory adapterFactory, SurveyAreaTypeUseCase areaTypeUseCase, SurveyMeasurementListUseCase measurementListUseCase, SaveSurveyFormUseCase saveSurveyFormUseCase) {
        super(adapterFactory, areaTypeUseCase, measurementListUseCase);
        this.saveSurveyFormUseCase = saveSurveyFormUseCase;
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
                    if(getPropertySaveResponse.getGisId()!= null) {
                        getView().startActivity(ApartmentInfoActivity.createIntent(getView().getContext(), getPropertySaveResponse.getGisId()));
                    }else {
                        if(getPropertySaveResponse.getTempId() > 0) {
                            getView().startActivity(ApartmentInfoActivity.createIntent(getView().getContext(),getPropertySaveResponse.getTempId()));
                        }
                    }
                }
            });

        }
    }
}
