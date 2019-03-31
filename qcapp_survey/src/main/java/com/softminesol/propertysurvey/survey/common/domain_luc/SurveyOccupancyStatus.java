package com.softminesol.propertysurvey.survey.common.domain_luc;

import com.softminesol.propertysurvey.survey.common.domain.ISurveyOptionRepository;
import com.softminesol.propertysurvey.survey.common.model.PropertyType;
import com.softminesol.propertysurvey.survey.common.model.newmodel.OccupancyStatus;
import com.tokopedia.usecase.RequestParams;
import com.tokopedia.usecase.UseCase;

import javax.inject.Inject;

import rx.Observable;

public class SurveyOccupancyStatus extends UseCase<OccupancyStatus> {
    ISurveyOptionRepository repository;
    @Inject
    public SurveyOccupancyStatus(ISurveyOptionRepository repository) {
        this.repository = repository;
    }
    @Override
    public Observable<OccupancyStatus> createObservable(RequestParams requestParams) {
        return repository.getOccupancyStatus();
    }
}
