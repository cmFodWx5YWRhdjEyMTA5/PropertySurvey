package com.softminesol.propertysurvey.home.domain;

import com.softminesol.survey_framework.rolebase.domain.RoleBaseUseCase;
import com.softminesol.survey_framework.rolebase.model.RoleData;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

public class DashBoardUseCase extends UseCase<RoleData>{

    RoleBaseUseCase roleBaseUseCase;
    @Inject
    public DashBoardUseCase(RoleBaseUseCase roleBaseUseCase) {
        this.roleBaseUseCase = roleBaseUseCase;
    }

    @Override
    public Observable<RoleData> createObservable(final RequestParams requestParams) {
        return roleBaseUseCase.createObservable(requestParams);
    }
}
