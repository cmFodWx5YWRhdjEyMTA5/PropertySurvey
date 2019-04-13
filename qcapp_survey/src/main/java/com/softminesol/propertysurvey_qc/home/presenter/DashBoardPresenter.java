package com.softminesol.propertysurvey_qc.home.presenter;

import android.content.Intent;

import com.softminesol.propertysurvey_qc.home.domain.DashBoardUseCase;
import com.softminesol.propertysurvey_qc.qasearch.propertysearch.view.SearchPropertyListActivity;
import com.softminesol.survey_framework.SurveyAppApplication;

import javax.inject.Inject;

import frameworks.basemvp.AppBasePresenter;
import frameworks.routers.ILoginInterceptor;

/**
 * Created by sandeepgoyal on 10/05/18.
 */

public class DashBoardPresenter extends AppBasePresenter<DashBoardContractor.View> implements DashBoardContractor.Presenter {

    DashBoardUseCase dashBoardUseCase;

    @Inject
    public DashBoardPresenter(DashBoardUseCase dashBoardUseCase) {
        this.dashBoardUseCase = dashBoardUseCase;
    }

    public void onLogout() {
        ((ILoginInterceptor) SurveyAppApplication.getApplication()).logout();
    }

    @Override
    public void onPropertySearchClick() {
        getView().startActivity(new Intent(getView().getContext(), SearchPropertyListActivity.class));
    }
}
