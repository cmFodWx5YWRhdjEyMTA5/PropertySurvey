package com.softminesol.propertysurvey.rolebase.domain;

import com.softminesol.propertysurvey.rolebase.model.RoleData;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

public class RoleBaseUseCase extends UseCase<RoleData> {
    IRoleBaseRepository roleBaseRepository;

    public RoleBaseUseCase(IRoleBaseRepository roleBaseRepository) {
        this.roleBaseRepository = roleBaseRepository;
    }

    @Override
    public Observable<RoleData> createObservable(RequestParams requestParams) {
        return roleBaseRepository.getRoleBase();
    }
}
