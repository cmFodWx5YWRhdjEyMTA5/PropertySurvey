package com.softminesol.propertysurvey_qc.survey.draftedEntity.view;

import com.softminesol.survey_framework.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.survey_framework.survey.common.model.property.SavePropertyRequest;
import com.softminesol.propertysurvey_qc.survey.draftedEntity.domain.ApartmentListUseCase;
import com.softminesol.propertysurvey_qc.survey.draftedEntity.domain.PropertyListUseCase;

import java.util.List;

import javax.inject.Inject;

import frameworks.basemvp.AppBasePresenter;
import rx.Subscriber;

public class DraftedListPresenter extends AppBasePresenter<IDraftedListActivityContract.IDraftedListActivityView> implements IDraftedListActivityContract.IDraftedListActivityPresenter {

    ApartmentListUseCase apartmentListUseCase;
    PropertyListUseCase propertyListUseCase;

    @Inject
    public DraftedListPresenter(ApartmentListUseCase apartmentListUseCase,
                                PropertyListUseCase propertyListUseCase) {
        this.apartmentListUseCase = apartmentListUseCase;
        this.propertyListUseCase = propertyListUseCase;
    }

    @Override
    public void attachView(IDraftedListActivityContract.IDraftedListActivityView view) {
        super.attachView(view);
        apartmentListUseCase.execute(new Subscriber<List<SaveApartmentRequest>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(List<SaveApartmentRequest> saveApartmentRequests) {
                getView().setDraftedApartmentList(saveApartmentRequests);
            }
        });
        propertyListUseCase.execute(new Subscriber<List<SavePropertyRequest>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(List<SavePropertyRequest> savePropertyRequests) {
                getView().setDraftedPropertyList(savePropertyRequests);
            }
        });
    }
}
