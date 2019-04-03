package com.softminesol.survey_framework.rolebase.domain;

import com.softminesol.survey_framework.rolebase.model.RoleData;

import rx.Observable;

public interface IRoleBaseRepository {
    Observable<RoleData> getRoleBase();
}
