package com.softminesol.propertysurvey.getToken.model;

import frameworks.network.model.BaseResponse;

/**
 * Created by sandeepgoyal on 04/05/18.
 */

public class LoginResponse extends BaseResponse {


    String authToken;


    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @Override
    public String toString() {
        return super.toString() + " \nauthToken " + authToken;
    }
}
