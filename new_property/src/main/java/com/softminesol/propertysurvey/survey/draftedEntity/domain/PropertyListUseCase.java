package com.softminesol.propertysurvey.survey.draftedEntity.domain;

import com.softminesol.survey_framework.survey.common.model.property.SavePropertyRequest;
import com.softminesol.propertysurvey.survey.newPropertyEntry.domain.ISurveyFormSaveRepository;

import java.util.List;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

public class PropertyListUseCase extends UseCase<List<SavePropertyRequest>> {

    private final ISurveyFormSaveRepository iSurveyFormSaveRepository;

    @Inject
    public PropertyListUseCase(ISurveyFormSaveRepository iSurveyFormSaveRepository) {
        this.iSurveyFormSaveRepository = iSurveyFormSaveRepository;
    }

    @Override
    public Observable<List<SavePropertyRequest>> createObservable(RequestParams requestParams) {
        return iSurveyFormSaveRepository.getDraftedSaveProperties();
    }
}
