package frameworks.OTP.domain;

import frameworks.OTP.data.model.OTPData;
import frameworks.network.model.BaseResponse;
import rx.Observable;

/**
 * Created by sandeepgoyal on 18/05/18.
 */

public interface IOTPVerificationRepository {
    public Observable<BaseResponse> verifyOTP(OTPData otpData) ;
}
