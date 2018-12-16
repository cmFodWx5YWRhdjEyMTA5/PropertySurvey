package com.softminesol.propertysurvey.survey.distributionbill.model;

import com.google.gson.annotations.SerializedName;

public class BillDetail {

    @SerializedName("BillDetails")
    private BillDetails billDetails;

    public BillDetails getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(BillDetails billDetails) {
        this.billDetails = billDetails;
    }

    @Override
    public String toString() {
        return
                "BillDetail{" +
                        "billDetails = '" + billDetails + '\'' +
                        "}";
    }
}