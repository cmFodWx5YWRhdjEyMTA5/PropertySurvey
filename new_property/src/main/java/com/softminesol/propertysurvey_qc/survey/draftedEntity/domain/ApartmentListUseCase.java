package com.softminesol.propertysurvey_qc.survey.draftedEntity.domain;

import com.softminesol.propertysurvey_qc.survey.apartmentEntry.domain.IApartmentSurveyFormSaveRepository;
import com.softminesol.survey_framework.survey.common.model.apartment.SaveApartmentRequest;

import java.util.List;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

public class ApartmentListUseCase extends UseCase<List<SaveApartmentRequest>> {

    private final IApartmentSurveyFormSaveRepository iApartmentSurveyFormSaveRepository;

    @Inject
    public ApartmentListUseCase(IApartmentSurveyFormSaveRepository iApartmentSurveyFormSaveRepository) {
        this.iApartmentSurveyFormSaveRepository  = iApartmentSurveyFormSaveRepository;
    }

    @Override
    public Observable<List<SaveApartmentRequest>> createObservable(RequestParams requestParams) {
        return iApartmentSurveyFormSaveRepository.getDraftedApartmentItems();
    }
}
