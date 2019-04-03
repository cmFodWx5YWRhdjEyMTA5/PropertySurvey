package com.softminesol.survey_framework.rolebase.data.repository.datasource;

import com.softminesol.survey_framework.rolebase.data.net.RoleBaseAPI;

import javax.inject.Inject;

public class RoleBaseDataFactory {
    RoleBaseAPI roleBaseAPI;

    @Inject
    public RoleBaseDataFactory(RoleBaseAPI roleBaseAPI) {
        this.roleBaseAPI = roleBaseAPI;
    }

    public RoleBaseCloudRepository getCloudDataSource() {
        return new RoleBaseCloudRepository(roleBaseAPI);
    }
}
