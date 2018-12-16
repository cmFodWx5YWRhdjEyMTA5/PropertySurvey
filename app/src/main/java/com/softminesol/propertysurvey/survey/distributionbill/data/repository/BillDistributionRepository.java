package com.softminesol.propertysurvey.survey.distributionbill.data.repository;

import com.softminesol.propertysurvey.survey.distributionbill.data.repository.datasource.BillDistributionFactory;
import com.softminesol.propertysurvey.survey.distributionbill.domain.IBillDistributionRepository;
import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetail;
import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetails;

import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by sandeepgoyal on 14/05/18.
 */

public class BillDistributionRepository implements IBillDistributionRepository {
    BillDistributionFactory billDistributionFactory;

    @Inject
    public BillDistributionRepository(BillDistributionFactory billDistributionFactory) {
        this.billDistributionFactory = billDistributionFactory;
    }

    @Override
    public Observable<BillDetail> getBillDistributionData(final String id) {
        return billDistributionFactory.getCacheBillDistributionData().getBillDistributionData(id).flatMap(new Func1<BillDetail, Observable<BillDetail>>() {
            @Override
            public Observable<BillDetail> call(BillDetail billDetail) {
                if(billDetail == null) {
                    return billDistributionFactory.getCloudBillDistributionData().getBillDistributionData(id);
                }
                return Observable.just(billDetail);
            }
        });
    }

    public Observable<BaseResponse> uploadBillDistributionData(final BillDetails billDetails) {
        return billDistributionFactory.getCloudBillDistributionData().uploadBillDistributionData(billDetails).onErrorResumeNext(new Func1<Throwable, Observable<BaseResponse>>() {
            @Override
            public Observable<BaseResponse> call(Throwable throwable) {
                return cacheBillDistributionData(billDetails);
            }
        }).doOnNext(new Action1<BaseResponse>() {
            @Override
            public void call(BaseResponse baseResponse) {
                billDetails.setState("");
                updateCacheBillDistribution(billDetails);
            }
        });

    }

    @Override
    public Observable<BaseResponse> cacheBillDistributionData(BillDetails billDetails) {
        billDetails.setState("UPDATE");
        return billDistributionFactory.getCacheBillDistributionData().uploadBillDistributionData(billDetails);
    }

    @Override
    public Observable<BaseResponse> updateCacheBillDistribution(BillDetails billDetail) {
        return billDistributionFactory.getCacheBillDistributionData().uploadBillDistributionData(billDetail);
    }

    @Override
    public Observable<BaseResponse> updateOfflineCacheBillDistributionToCloud(final BillDetails billDetail) {
        return billDistributionFactory.getCloudBillDistributionData().uploadOfflineBillDistributionData(billDetail).doOnNext(new Action1<BaseResponse>() {
            @Override
            public void call(BaseResponse baseResponse) {
                billDetail.setState("");
                updateCacheBillDistribution(billDetail);
            }
        });
    }


}