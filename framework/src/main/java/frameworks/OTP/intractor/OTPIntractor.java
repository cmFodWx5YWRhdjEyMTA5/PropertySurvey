package frameworks.OTP.intractor;


import frameworks.OTP.data.model.OTPData;

/**
 * Created by Sandeep on 17/09/2016.
 */
public interface OTPIntractor {
    void verifyOTP(OTPData otp, OnOTPVerificationCompleted listener);
    public interface OnOTPVerificationCompleted {
        public void otpVerificationSuccessful();
        public void otpVerificationFailed();
    }
}
