package frameworks.OTP.presenter;


import frameworks.OTP.data.model.OTPData;
import frameworks.OTP.view.OTPRecieverView;

/**
 * Created by Sandeep on 15/09/2016.
 */
public interface OTPPresenter {
    void attach(OTPRecieverView view);
    void verifyOTP(OTPData otp);
}
