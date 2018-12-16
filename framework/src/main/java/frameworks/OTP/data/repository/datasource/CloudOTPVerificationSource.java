package frameworks.OTP.data.repository.datasource;


import javax.inject.Inject;

import frameworks.OTP.data.model.OTPData;
import frameworks.OTP.data.net.OtpAPI;
import frameworks.network.model.BaseResponse;
import frameworks.network.model.DataResponse;
import retrofit2.Response;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by sandeepgoyal on 18/05/18.
 */

public class CloudOTPVerificationSource {
    OtpAPI otpAPI;

    @Inject
    public CloudOTPVerificationSource(OtpAPI otpAPI) {
        this.otpAPI = otpAPI;
    }

    public Observable<BaseResponse> verifyOTP(OTPData otpData) {
        return otpAPI.verifyOTP("http://122.160.30.50:5098/billDistribution/verifyOTP",otpData).map(new Func1<Response<DataResponse<BaseResponse>>, BaseResponse>() {
            @Override
            public BaseResponse call(Response<DataResponse<BaseResponse>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }
}
