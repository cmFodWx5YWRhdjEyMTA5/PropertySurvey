package frameworks.OTP.data.repository;

import frameworks.OTP.data.model.OTPData;
import frameworks.OTP.data.repository.datasource.OTPVerificationFactory;
import frameworks.OTP.domain.IOTPVerificationRepository;
import frameworks.network.model.BaseResponse;
import rx.Observable;

/**
 * Created by sandeepgoyal on 18/05/18.
 */

public class OTPVerificationRepository implements IOTPVerificationRepository{
    OTPVerificationFactory cloudOTPVerificationSource;

    public OTPVerificationRepository(OTPVerificationFactory cloudOTPVerificationSource) {
        this.cloudOTPVerificationSource = cloudOTPVerificationSource;
    }

    public Observable<BaseResponse> verifyOTP(OTPData otpData) {
        return cloudOTPVerificationSource.verifyOTP(otpData);
    }
}
