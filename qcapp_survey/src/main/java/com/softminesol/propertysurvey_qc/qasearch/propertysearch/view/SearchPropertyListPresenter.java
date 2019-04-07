package com.softminesol.propertysurvey_qc.qasearch.propertysearch.view;

import com.softminesol.survey_framework.survey.common.domain.GetPropertyInfoUseCase;
import com.softminesol.survey_framework.survey.common.domain.SurveyPropertyIdListUseCase;
import com.softminesol.survey_framework.survey.common.model.OLDPropertyUIDS;
import com.softminesol.survey_framework.survey.common.model.property.SavePropertyRequest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import frameworks.basemvp.AppBasePresenter;
import frameworks.customadapter.CustomAdapterModel;
import frameworks.network.usecases.RequestParams;
import rx.Subscriber;

public class SearchPropertyListPresenter extends AppBasePresenter<ISearchPropertyListContract.IDraftedListActivityView> implements ISearchPropertyListContract.IDraftedListActivityPresenter {

    private final SurveyPropertyIdListUseCase surveyPropertyIdListUseCase;
    private final GetPropertyInfoUseCase getPropertyInfoUseCase;

    @Inject
    public SearchPropertyListPresenter(SurveyPropertyIdListUseCase surveyPropertyIdListUseCase, GetPropertyInfoUseCase getPropertyInfoUseCase) {
        this.surveyPropertyIdListUseCase = surveyPropertyIdListUseCase;
        this.getPropertyInfoUseCase = getPropertyInfoUseCase;
    }

    @Override
    public void attachView(ISearchPropertyListContract.IDraftedListActivityView view) {
        super.attachView(view);
        surveyPropertyIdListUseCase.execute(new Subscriber<OLDPropertyUIDS>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                getView().hideProgressBar();
                getView().showToast(e.getMessage());
                e.printStackTrace();
            }

            @Override
            public void onNext(OLDPropertyUIDS oldPropertyUIDS) {
                getView().hideProgressBar();
                getView().setPropertyIdList((List<CustomAdapterModel>) (List<?>) oldPropertyUIDS.getOldPropertyUID());
            }
        });
    }
    public String selectedfdGSID;
    @Override
    public void onPropertyIDSelected(String oldpropertyuid) {
        RequestParams requestParams = RequestParams.create();
        requestParams.putString("query", oldpropertyuid);
        selectedfdGSID = oldpropertyuid;
        getView().showProgressBar();
        getPropertyInfoUseCase.execute(requestParams, new Subscriber<SavePropertyRequest>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                getView().hideProgressBar();
                getView().showToast(e.getMessage());
                e.printStackTrace();
            }

            @Override
            public void onNext(SavePropertyRequest savePropertyRequest) {
                getView().hideProgressBar();
                List<SavePropertyRequest> savePropertyRequests = new ArrayList<>();
                savePropertyRequests.add(savePropertyRequest);
                getView().setDraftedPropertyList(savePropertyRequests);
                getView().setDraftedApartmentList(savePropertyRequest.getSaveApartmentRequest());
            }
        });

    }
}
