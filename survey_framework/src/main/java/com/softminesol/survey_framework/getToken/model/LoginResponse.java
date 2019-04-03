package com.softminesol.survey_framework.getToken.model;

import com.google.gson.annotations.SerializedName;

import frameworks.appsession.UserInfo;
import frameworks.network.model.BaseResponse;

/**
 * Created by sandeepgoyal on 04/05/18.
 */

public class LoginResponse extends BaseResponse {


    String authToken;

    @SerializedName("EmployeeDetails")
    UserInfo employeeDetails;

    public UserInfo getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(UserInfo employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

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
