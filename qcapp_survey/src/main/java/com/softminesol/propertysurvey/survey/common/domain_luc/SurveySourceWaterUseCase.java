package com.softminesol.propertysurvey.survey.common.domain_luc;

import com.softminesol.propertysurvey.survey.common.domain.ISurveyOptionRepository;
import com.softminesol.propertysurvey.survey.common.model.PropertyType;
import com.softminesol.propertysurvey.survey.common.model.newmodel.SourceWater;
import com.tokopedia.usecase.RequestParams;
import com.tokopedia.usecase.UseCase;

import javax.inject.Inject;

import rx.Observable;

public class SurveySourceWaterUseCase extends UseCase<SourceWater> {
    ISurveyOptionRepository repository;
    @Inject
    public SurveySourceWaterUseCase(ISurveyOptionRepository repository) {
        this.repository = repository;
    }
    @Override
    public Observable<SourceWater> createObservable(RequestParams requestParams) {
        return repository.getSourceWater();
    }
}
