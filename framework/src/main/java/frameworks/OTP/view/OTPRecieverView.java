package frameworks.OTP.view;

/**
 * Created by Sandeep on 15/09/2016.
 */
public interface OTPRecieverView {
    void showProgress();
    void hideProgress();

    void setVerificationSuccessful();
    void setVerficationFailed();
}
