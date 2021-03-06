package com.softminesol.propertysurvey.survey.common.domain_luc;

import com.softminesol.propertysurvey.survey.common.domain.ISurveyOptionRepository;
import com.softminesol.propertysurvey.survey.common.model.PropertyType;
import com.softminesol.propertysurvey.survey.common.model.newmodel.RespondentStatus;
import com.tokopedia.usecase.RequestParams;
import com.tokopedia.usecase.UseCase;

import javax.inject.Inject;

import rx.Observable;

public class SurveyRespodentStatus extends UseCase<RespondentStatus> {
    ISurveyOptionRepository repository;
    @Inject
    public SurveyRespodentStatus(ISurveyOptionRepository repository) {
        this.repository = repository;
    }
    @Override
    public Observable<RespondentStatus> createObservable(RequestParams requestParams) {
        return repository.getRespondentStatus();
    }
}
