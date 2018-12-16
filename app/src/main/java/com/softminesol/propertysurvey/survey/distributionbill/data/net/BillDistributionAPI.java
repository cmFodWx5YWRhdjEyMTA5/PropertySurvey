package com.softminesol.propertysurvey.survey.distributionbill.data.net;

import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetail;
import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetails;

import frameworks.network.model.BaseResponse;
import frameworks.network.model.DataResponse;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by sandeep on 13/5/18.
 */
public interface BillDistributionAPI {

    @GET(BillDistributionURL.billDistributionAPI)
    Observable<Response<DataResponse<BillDetail>>> getBillDistributionData(@Path("id") String id);

    @POST(BillDistributionURL.billDistributionPostAPI)
    Observable<Response<DataResponse<BaseResponse>>> uploadBillDistributionData(@Body BillDetails billDetails);


    @POST(BillDistributionURL.billDistributionPostOffline)
    Observable<Response<DataResponse<BaseResponse>>> uploadOfflineBillDistributionData(@Body BillDetails billDetals);
}
