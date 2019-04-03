package com.softminesol.survey_framework.rolebase.data.repository;

import com.softminesol.survey_framework.rolebase.data.repository.datasource.RoleBaseDataFactory;
import com.softminesol.survey_framework.rolebase.domain.IRoleBaseRepository;
import com.softminesol.survey_framework.rolebase.model.RoleData;

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
