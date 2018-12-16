package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.realm.model.BillDetailModel;
import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetail;

public class BillDetailModelMapper {

    public BillDetailModel transformToRealmDb(BillDetail billDetail) {
        BillDetailModel billDetailModel = null;
        if (billDetail != null) {
            billDetailModel = new BillDetailModel();
            billDetailModel.setBillDetailsModel(new BillDetailsModelMapper().transformToRealmDb(billDetail.getBillDetails()));
        }
        return billDetailModel;
    }

    public BillDetail transformToViewModel(BillDetailModel billDetailModel) {
        BillDetail billDetail = null;
        if (billDetailModel != null) {
            billDetail = new BillDetail();
            billDetail.setBillDetails(new BillDetailsModelMapper().transformToViewModel(billDetailModel.getBillDetailsModel()));
        }
        return billDetail;
    }
}
