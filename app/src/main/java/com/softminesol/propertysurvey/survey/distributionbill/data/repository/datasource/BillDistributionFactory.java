package com.softminesol.propertysurvey.survey.distributionbill.data.repository.datasource;

import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetail;
import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetails;

import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import rx.Observable;

/**
 * Created by sandeepgoyal on 14/05/18.
 */

public class BillDistributionFactory {
    CloudBillDistributionData cloudBillDistributionData;
    CacheBillDistributionData cacheBillDistributionData;

    @Inject
    public BillDistributionFactory(CloudBillDistributionData cloudBillDistributionData,CacheBillDistributionData cacheBillDistributionData) {
        this.cloudBillDistributionData = cloudBillDistributionData;
        this.cacheBillDistributionData = cacheBillDistributionData;
    }


    public CloudBillDistributionData getCloudBillDistributionData() {
        return cloudBillDistributionData;
    }

    public CacheBillDistributionData getCacheBillDistributionData() {
        return cacheBillDistributionData;
    }
}
