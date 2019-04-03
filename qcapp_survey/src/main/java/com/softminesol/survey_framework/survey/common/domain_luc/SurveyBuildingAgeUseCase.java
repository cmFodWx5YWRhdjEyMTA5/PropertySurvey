package com.softminesol.survey_framework.survey.common.domain_luc;

import com.softminesol.survey_framework.survey.common.domain.ISurveyOptionRepository;
import com.softminesol.survey_framework.survey.common.model.newmodel.BuildingAge;
import com.tokopedia.usecase.RequestParams;
import com.tokopedia.usecase.UseCase;

import javax.inject.Inject;

import rx.Observable;

public class SurveyBuildingAgeUseCase extends UseCase<BuildingAge> {
    ISurveyOptionRepository repository;
    @Inject
    public SurveyBuildingAgeUseCase(ISurveyOptionRepository repository) {
        this.repository = repository;
    }
    @Override
    public Observable<BuildingAge> createObservable(RequestParams requestParams) {
        return repository.getBuildingAge();
    }
}
