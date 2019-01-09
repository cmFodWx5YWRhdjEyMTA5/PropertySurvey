package com.softminesol.propertysurvey.survey.common.domain_luc;

import com.softminesol.propertysurvey.survey.common.domain.ISurveyOptionRepository;
import com.softminesol.propertysurvey.survey.common.model.newmodel.ConstructionType;
import com.tokopedia.usecase.RequestParams;
import com.tokopedia.usecase.UseCase;

import rx.Observable;

public class SurveyConstructionType extends UseCase<ConstructionType> {
    ISurveyOptionRepository repository;
    public SurveyConstructionType(ISurveyOptionRepository repository) {
        this.repository = repository;
    }
    @Override
    public Observable<ConstructionType> createObservable(RequestParams requestParams) {
        return repository.getConstructionType();
    }
}
