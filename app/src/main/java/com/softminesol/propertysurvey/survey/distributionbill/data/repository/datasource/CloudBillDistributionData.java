package com.softminesol.propertysurvey.survey.distributionbill.data.repository.datasource;

import com.softminesol.propertysurvey.survey.distributionbill.data.net.BillDistributionAPI;
import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetail;
import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetails;

import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import frameworks.network.model.DataResponse;
import retrofit2.Response;
import rx.Observable;
import rx.functions.Func1;


/**
 * Created by sandeepgoyal on 14/05/18.
 */

public class CloudBillDistributionData {
    BillDistributionAPI billDistributionAPI;

    @Inject
    public CloudBillDistributionData(BillDistributionAPI billDistributionAPI) {
        this.billDistributionAPI = billDistributionAPI;
    }

    public Observable<BillDetail> getBillDistributionData(String id) {
        return billDistributionAPI.getBillDistributionData(id).map(new Func1<Response<DataResponse<BillDetail>>, BillDetail>() {
            @Override
            public BillDetail call(Response<DataResponse<BillDetail>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }

    public Observable<BaseResponse> uploadBillDistributionData(BillDetails billDetails) {
        return billDistributionAPI.uploadBillDistributionData(billDetails).map(new Func1<Response<DataResponse<BaseResponse>>, BaseResponse>() {
            @Override
            public BaseResponse call(Response<DataResponse<BaseResponse>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }
    public Observable<BaseResponse> uploadOfflineBillDistributionData(BillDetails billDetails) {
        return billDistributionAPI.uploadOfflineBillDistributionData(billDetails).map(new Func1<Response<DataResponse<BaseResponse>>, BaseResponse>() {
            @Override
            public BaseResponse call(Response<DataResponse<BaseResponse>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }
}
