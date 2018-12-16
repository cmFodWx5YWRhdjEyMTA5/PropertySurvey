package com.softminesol.propertysurvey.survey.distributionbill.data.repository.datasource;

import android.content.Context;

import com.softminesol.propertysurvey.survey.common.realm.RealmPropertyDataMapper;
import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetail;
import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetails;

import javax.inject.Inject;

import frameworks.di.qualifier.ApplicationContext;
import frameworks.network.model.BaseResponse;
import rx.Observable;

public class CacheBillDistributionData {
    private final RealmPropertyDataMapper realmPropertyDataMapper;

    @Inject
    public CacheBillDistributionData(@ApplicationContext Context context) {
        this.realmPropertyDataMapper = RealmPropertyDataMapper.getInstance(context);
    }


    public Observable<BillDetail> getBillDistributionData(String id) {
        BillDetails billDetails = realmPropertyDataMapper.getDistributionData(id);
        if (billDetails != null) {
            BillDetail billDetail = new BillDetail();
            billDetail.setBillDetails(billDetails);
            return Observable.just(billDetail);
        } else {
            return Observable.just(null);
        }
    }

    public Observable<BaseResponse> uploadBillDistributionData(BillDetails billDetails) {
        if (realmPropertyDataMapper.updateDistributionData(billDetails)) {
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("Submitted Successfully To Cache");
            return Observable.just(baseResponse);
        } else {
            return Observable.error(new Throwable("There is some problem please try again"));
        }

    }
}
