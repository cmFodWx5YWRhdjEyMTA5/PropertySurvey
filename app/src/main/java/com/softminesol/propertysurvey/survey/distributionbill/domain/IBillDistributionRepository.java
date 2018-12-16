package com.softminesol.propertysurvey.survey.distributionbill.domain;

import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetail;
import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetails;

import frameworks.network.model.BaseResponse;
import rx.Observable;

/**
 * Created by sandeepgoyal on 14/05/18.
 */

public interface IBillDistributionRepository {
    public Observable<BillDetail> getBillDistributionData(String id);

    public Observable<BaseResponse> uploadBillDistributionData(BillDetails billDetails);

    public Observable<BaseResponse> cacheBillDistributionData(BillDetails billDetails);

    public Observable<BaseResponse> updateCacheBillDistribution(BillDetails billDetail);
    public Observable<BaseResponse> updateOfflineCacheBillDistributionToCloud(BillDetails billDetail);
}
