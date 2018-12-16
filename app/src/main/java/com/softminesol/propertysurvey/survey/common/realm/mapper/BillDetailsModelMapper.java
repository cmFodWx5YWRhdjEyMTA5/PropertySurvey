package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.realm.model.BillDetailsModel;
import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetails;

public class BillDetailsModelMapper {

    public BillDetailsModel transformToRealmDb(BillDetails billDetails) {
        BillDetailsModel billDetailsModel = null;
        if (billDetails != null) {
            billDetailsModel = new BillDetailsModel();
            billDetailsModel.setMobileNumber(billDetails.getMobileNumber());
            billDetailsModel.setName(billDetails.getName());
            billDetailsModel.setAddressLine1(billDetails.getAddressLine1());
            billDetailsModel.setImagePath(billDetails.getImagePath());
            billDetailsModel.setEmailID((String) billDetails.getEmailID());
            billDetailsModel.setOldPropertyUID(billDetails.getOldPropertyUID());
            billDetailsModel.setImageID(billDetails.getImageID());
            billDetailsModel.setStatus(billDetails.getStatus());
            billDetailsModel.setState(billDetails.getState());
        }
        return billDetailsModel;
    }

    public BillDetails transformToViewModel(BillDetailsModel billDetailsModel) {
        BillDetails billDetails = null;
        if (billDetailsModel != null) {
            billDetails = new BillDetails();
            billDetails.setMobileNumber(billDetailsModel.getMobileNumber());
            billDetails.setName(billDetailsModel.getName());
            billDetails.setAddressLine1(billDetailsModel.getAddressLine1());
            billDetails.setEmailID(billDetailsModel.getEmailID());
            billDetails.setImagePath(billDetailsModel.getImagePath());
            billDetails.setOldPropertyUID(billDetailsModel.getOldPropertyUID());
            billDetails.setImageID(billDetailsModel.getImageID());
            billDetails.setStatus(billDetailsModel.getStatus());
            billDetails.setState(billDetailsModel.getState());
        }
        return billDetails;
    }
}
