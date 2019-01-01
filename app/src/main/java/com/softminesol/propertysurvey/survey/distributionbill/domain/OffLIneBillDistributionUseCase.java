package com.softminesol.propertysurvey.survey.distributionbill.domain;

import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetails;

import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

public class OffLIneBillDistributionUseCase extends UseCase<BaseResponse> {
    IBillDistributionRepository billDistributionRepository;

    @Inject
    public OffLIneBillDistributionUseCase(IBillDistributionRepository billDistributionRepository) {
        this.billDistributionRepository = billDistributionRepository;
    }

    @Override
    public Observable<BaseResponse> createObservable(RequestParams requestParams) {
        return billDistributionRepository.updateOfflineCacheBillDistributionToCloud((BillDetails) requestParams.getObject("billDetails"));
    }
}
