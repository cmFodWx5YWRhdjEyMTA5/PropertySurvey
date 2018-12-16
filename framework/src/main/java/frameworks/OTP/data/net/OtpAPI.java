package frameworks.OTP.data.net;

import frameworks.OTP.data.model.OTPData;
import frameworks.network.model.BaseResponse;
import frameworks.network.model.DataResponse;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by sandeepgoyal on 18/05/18.
 */

public interface OtpAPI {

    @POST
    Observable<Response<DataResponse<BaseResponse>>> verifyOTP(@Url String url,@Body OTPData otpData);
}
