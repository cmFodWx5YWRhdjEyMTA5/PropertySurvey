package com.softminesol.propertysurvey.home.presenter;

import android.content.Intent;

import com.softminesol.propertysurvey.SurveyAppApplication;
import com.softminesol.propertysurvey.home.domain.DashBoardUseCase;
import com.softminesol.propertysurvey.survey.cloudsync.SyncManager;
import com.softminesol.propertysurvey.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.propertysurvey.survey.common.view.activity.ApartmentInfoActivity;
import com.softminesol.propertysurvey.survey.draftedEntity.view.DraftedListActivity;
import com.softminesol.propertysurvey.survey.newPropertyEntry.view.activity.NewSurveyActivity;

import java.util.List;

import javax.inject.Inject;

import frameworks.basemvp.AppBasePresenter;
import frameworks.network.model.BaseResponse;
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
        getView().startActivity(new Intent(getView().getContext(), DraftedListActivity.class));
    }


    @Override
    public void onAddApartmentClick() {
        getView().startActivity(new Intent(getView().getContext(), ApartmentInfoActivity.class));

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
