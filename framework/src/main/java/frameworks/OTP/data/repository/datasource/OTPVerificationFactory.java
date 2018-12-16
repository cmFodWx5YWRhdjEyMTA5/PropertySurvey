package frameworks.OTP.data.repository.datasource;

import javax.inject.Inject;

import frameworks.OTP.data.model.OTPData;
import frameworks.network.model.BaseResponse;
import rx.Observable;

/**
 * Created by sandeepgoyal on 18/05/18.
 */

public class OTPVerificationFactory {
    CloudOTPVerificationSource cloudOTPVerificationSource;

    @Inject
    public OTPVerificationFactory(CloudOTPVerificationSource cloudOTPVerificationSource) {
        this.cloudOTPVerificationSource = cloudOTPVerificationSource;
    }

    public Observable<BaseResponse> verifyOTP(OTPData otpData) {
        return cloudOTPVerificationSource.verifyOTP(otpData);
    }
}
