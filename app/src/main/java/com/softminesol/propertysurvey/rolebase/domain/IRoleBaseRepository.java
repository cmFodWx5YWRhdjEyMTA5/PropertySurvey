package com.softminesol.propertysurvey.rolebase.domain;

import com.softminesol.propertysurvey.rolebase.model.RoleData;

import rx.Observable;

public interface IRoleBaseRepository {
    Observable<RoleData> getRoleBase();
}
