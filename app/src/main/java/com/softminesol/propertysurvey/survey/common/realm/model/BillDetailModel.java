package com.softminesol.propertysurvey.survey.common.realm.model;

import io.realm.RealmObject;

public class BillDetailModel extends RealmObject {
    private BillDetailsModel billDetailsModel;

    public BillDetailsModel getBillDetailsModel() {
        return billDetailsModel;
    }

    public void setBillDetailsModel(BillDetailsModel billDetailsModel) {
        this.billDetailsModel = billDetailsModel;
    }
}
