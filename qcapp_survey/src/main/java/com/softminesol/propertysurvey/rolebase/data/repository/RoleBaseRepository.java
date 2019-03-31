package com.softminesol.propertysurvey.rolebase.data.repository;

import com.softminesol.propertysurvey.rolebase.data.repository.datasource.RoleBaseDataFactory;
import com.softminesol.propertysurvey.rolebase.domain.IRoleBaseRepository;
import com.softminesol.propertysurvey.rolebase.model.RoleData;

import javax.inject.Inject;

import rx.Observable;

public class RoleBaseRepository implements IRoleBaseRepository {
    RoleBaseDataFactory roleBaseDataFactory;
    @Inject
    public RoleBaseRepository(RoleBaseDataFactory roleBaseDataFactory) {
        this.roleBaseDataFactory = roleBaseDataFactory;
    }

    @Override
    public Observable<RoleData> getRoleBase() {
        return roleBaseDataFactory.getCloudDataSource().getRoleBase();
    }
}
