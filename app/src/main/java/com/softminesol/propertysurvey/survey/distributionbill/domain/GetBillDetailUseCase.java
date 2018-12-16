package com.softminesol.propertysurvey.survey.distributionbill.domain;

import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetail;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

/**
 * Created by sandeepgoyal on 14/05/18.
 */

public class GetBillDetailUseCase extends UseCase<BillDetail> {
    IBillDistributionRepository billDistributionRepository;

    @Inject
    public GetBillDetailUseCase(IBillDistributionRepository billDistributionRepository) {
        this.billDistributionRepository = billDistributionRepository;
    }

    @Override
    public Observable<BillDetail> createObservable(RequestParams requestParams) {
        return billDistributionRepository.getBillDistributionData(requestParams.getString("id", ""));
    }
}
