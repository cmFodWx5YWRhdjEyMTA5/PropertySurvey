package com.softminesol.survey_framework.rolebase.data.net;

import com.softminesol.survey_framework.rolebase.model.RoleData;

import frameworks.network.model.DataResponse;
import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;

public interface RoleBaseAPI {
    @GET(RoleBaseURL.roleBaseURL)
    Observable<Response<DataResponse<RoleData> >>getRoleBase();
}
