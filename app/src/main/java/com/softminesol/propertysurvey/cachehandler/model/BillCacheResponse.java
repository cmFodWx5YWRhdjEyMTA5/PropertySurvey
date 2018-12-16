package com.softminesol.propertysurvey.cachehandler.model;

import com.softminesol.propertysurvey.survey.common.model.formData.FormData;
import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetails;

import java.util.List;

public class BillCacheResponse {
    List<BillDetails> BillDetails;
    int pageCount;

    public List<com.softminesol.propertysurvey.survey.distributionbill.model.BillDetails> getBillDetails() {
        return BillDetails;
    }

    public void setBillDetails(List<com.softminesol.propertysurvey.survey.distributionbill.model.BillDetails> billDetails) {
        BillDetails = billDetails;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
