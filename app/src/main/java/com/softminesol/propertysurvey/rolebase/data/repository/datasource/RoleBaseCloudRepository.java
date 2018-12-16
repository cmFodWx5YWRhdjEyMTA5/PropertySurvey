package com.softminesol.propertysurvey.rolebase.data.repository.datasource;

import com.softminesol.propertysurvey.rolebase.data.net.RoleBaseAPI;
import com.softminesol.propertysurvey.rolebase.model.RoleData;

import frameworks.network.model.DataResponse;
import retrofit2.Response;
import rx.Observable;
import rx.functions.Func1;

public class RoleBaseCloudRepository {
    RoleBaseAPI roleBaseAPI;
    public RoleBaseCloudRepository(RoleBaseAPI roleBaseAPI) {
        this.roleBaseAPI = roleBaseAPI;
    }

    public Observable<RoleData> getRoleBase() {
        return roleBaseAPI.getRoleBase().map(new Func1<Response<DataResponse<RoleData>>, RoleData>() {
            @Override
            public RoleData call(Response<DataResponse<RoleData>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }
}
