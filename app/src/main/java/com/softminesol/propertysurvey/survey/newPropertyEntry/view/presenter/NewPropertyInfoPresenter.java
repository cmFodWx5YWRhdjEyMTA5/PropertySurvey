package com.softminesol.propertysurvey.survey.newPropertyEntry.view.presenter;

import com.softminesol.propertysurvey.survey.cloudsync.NewFormSync;
import com.softminesol.propertysurvey.survey.cloudsync.NewPropertyScope;
import com.softminesol.propertysurvey.survey.cloudsync.SyncManager;
import com.softminesol.propertysurvey.survey.common.di.SurveyFormScope;
import com.softminesol.propertysurvey.survey.common.domain.SurveyAreaTypeUseCase;
import com.softminesol.propertysurvey.survey.common.domain.SurveyMeasurementListUseCase;
import com.softminesol.propertysurvey.survey.common.model.formData.FormData;
import com.softminesol.propertysurvey.survey.common.view.presenter.PropertyLocationContract;
import com.softminesol.propertysurvey.survey.common.view.presenter.PropertyLocationPresenter;
import com.softminesol.propertysurvey.survey.newPropertyEntry.domain.SurveyFormSubmitUseCase;

import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import frameworks.network.usecases.RequestParams;
import frameworks.utils.AdapterFactory;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by sandeep on 13/5/18.
 */
public class NewPropertyInfoPresenter extends PropertyLocationPresenter implements PropertyLocationContract.Presenter {
    private final SurveyFormSubmitUseCase surveyFormSubmitUseCase;


    @Inject
    NewFormSync syncManager;

    @Inject
    NewPropertyInfoPresenter(AdapterFactory adapterFactory, SurveyAreaTypeUseCase areaTypeUseCase, SurveyMeasurementListUseCase measurementListUseCase, SurveyFormSubmitUseCase surveyFormSubmitUseCase) {
        super(adapterFactory, areaTypeUseCase, measurementListUseCase);
        this.surveyFormSubmitUseCase = surveyFormSubmitUseCase;
    }

    @Override
    public void onSubmitClick() {
        super.onSubmitClick();
        if (validateForm()) {
            FormData formData = getFormData();
            RequestParams requestParams = RequestParams.create();
            requestParams.putObject("formdata", formData);
            getView().showProgressBar();
            surveyFormSubmitUseCase.execute(requestParams, new Subscriber<BaseResponse>() {
                @Override
                public void onCompleted() {
                    getView().hideProgressBar();
                }

                @Override
                public void onError(Throwable e) {
                    getView().hideProgressBar();
                }

                @Override
                public void onNext(BaseResponse baseResponse) {
                    getView().showToast(baseResponse.getMessage());
                    getView().finish();
                    syncToSever();
                }
            });
        }
    }

    private void syncToSever() {
        syncManager.execute(new Subscriber<BaseResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse baseResponse) {

            }
        });
    }
}
