package frameworks.OTP.presenter;


import javax.inject.Inject;

import frameworks.OTP.data.model.OTPData;
import frameworks.OTP.view.OTPRecieverView;
import frameworks.OTP.domain.OtpVerifyUseCase;
import frameworks.OTP.intractor.OTPIntractor;
import frameworks.OTP.intractor.OTPIntractorImpl;
import frameworks.network.model.BaseResponse;
import frameworks.network.usecases.RequestParams;
import rx.Subscriber;

/**
 * Created by Sandeep on 17/09/2016.
 */
public class OTPPresenterImpl implements OTPPresenter, OTPIntractor.OnOTPVerificationCompleted {
    OTPRecieverView mOTPReciever = null;
    OTPIntractor mOTPIntractor = null;
    OtpVerifyUseCase otpVerifyUseCase;

    @Inject
    public OTPPresenterImpl(OtpVerifyUseCase otpVerifyUseCase) {
        this.otpVerifyUseCase = otpVerifyUseCase;
    }

    public void  attach(OTPRecieverView view) {
        mOTPReciever = view;
        mOTPIntractor = new OTPIntractorImpl();
    }

    @Override
    public void verifyOTP(OTPData otp) {
        RequestParams requestParams = RequestParams.create();
        requestParams.putObject("otp_data",otp);
        mOTPReciever.showProgress();
        otpVerifyUseCase.execute(requestParams, new Subscriber<BaseResponse>() {
            @Override
            public void onCompleted() {
                mOTPReciever.hideProgress();
            }

            @Override
            public void onError(Throwable e) {
                mOTPReciever.hideProgress();
            }

            @Override
            public void onNext(BaseResponse baseResponse) {
                if(baseResponse.getMessage().equals("Verified")) {
                    mOTPReciever.setVerificationSuccessful();
                }else {
                    mOTPReciever.setVerficationFailed();
                }
            }
        });
    }

    @Override
    public void otpVerificationSuccessful() {
        mOTPReciever.setVerificationSuccessful();
    }

    @Override
    public void otpVerificationFailed() {
        mOTPReciever.setVerficationFailed();
    }
}
