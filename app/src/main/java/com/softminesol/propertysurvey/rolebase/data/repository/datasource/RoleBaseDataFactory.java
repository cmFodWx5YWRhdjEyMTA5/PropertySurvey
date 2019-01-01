package com.softminesol.propertysurvey.rolebase.data.repository.datasource;

import com.softminesol.propertysurvey.rolebase.data.net.RoleBaseAPI;

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
