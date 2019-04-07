package com.softminesol.propertysurvey_qc.home.presenter;

import android.content.Intent;

import com.softminesol.propertysurvey_qc.home.domain.DashBoardUseCase;
import com.softminesol.propertysurvey_qc.survey.apartmentEntry.view.activity.NewApartmentInfoActivity;
import com.softminesol.propertysurvey_qc.survey.cloudsync.SyncManager;
import com.softminesol.propertysurvey_qc.survey.draftedEntity.view.DraftedListActivity;
import com.softminesol.propertysurvey_qc.survey.newPropertyEntry.view.activity.NewSurveyActivity;
import com.softminesol.survey_framework.SurveyAppApplication;
import com.softminesol.survey_framework.survey.common.model.property.GetPropertySaveResponse;

import java.util.List;

import javax.inject.Inject;

import frameworks.basemvp.AppBasePresenter;
import frameworks.routers.ILoginInterceptor;
import rx.Subscriber;

/**
 * Created by sandeepgoyal on 10/05/18.
 */

public class DashBoardPresenter extends AppBasePresenter<DashBoardContractor.View> implements DashBoardContractor.Presenter {

    DashBoardUseCase dashBoardUseCase;
    SyncManager syncManager;

    @Inject
    public DashBoardPresenter(DashBoardUseCase dashBoardUseCase,SyncManager syncManager) {
        this.dashBoardUseCase = dashBoardUseCase;
        this.syncManager = syncManager;

    }



    @Override
    public void onNewPropertInfoClick() {
        getView().startActivity(new Intent(getView().getContext(), NewSurveyActivity.class));
    }


    @Override
    public void onAddApartmentClick() {
        getView().startActivity(new Intent(getView().getContext(), NewApartmentInfoActivity.class));

    }

    @Override
    public void onShowDraftClick() {
        getView().startActivity(new Intent(getView().getContext(), DraftedListActivity.class));
    }

    public void onLogout() {
        getView().showProgressBar("Syncing").setCancelable(false);
        syncManager.execute(new Subscriber<List<GetPropertySaveResponse>>() {
            @Override
            public void onCompleted() {
                ((ILoginInterceptor) SurveyAppApplication.getApplication()).logout();
                getView().hideProgressBar();
            }

            @Override
            public void onError(Throwable e) {
                getView().hideProgressBar();
                e.printStackTrace();
                getView().showToast(e.getMessage());
                getView().showToast("Unable to Sync Please Try Again");
            }

            @Override
            public void onNext(List<GetPropertySaveResponse> getPropertySaveResponses) {

            }
        });


    }
}
