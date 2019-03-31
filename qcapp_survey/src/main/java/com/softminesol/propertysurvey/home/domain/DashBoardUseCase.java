package com.softminesol.propertysurvey.home.domain;

import com.softminesol.propertysurvey.rolebase.domain.RoleBaseUseCase;
import com.softminesol.propertysurvey.rolebase.model.RoleData;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;
import rx.functions.Func1;

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
