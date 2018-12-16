package frameworks.OTP.domain;

import javax.inject.Inject;

import frameworks.OTP.data.model.OTPData;
import frameworks.network.model.BaseResponse;
import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

/**
 * Created by sandeepgoyal on 18/05/18.
 */

public class OtpVerifyUseCase extends UseCase<BaseResponse>{
    IOTPVerificationRepository iotpVerificationRepository;

    @Inject
    public OtpVerifyUseCase(IOTPVerificationRepository iotpVerificationRepository) {
        this.iotpVerificationRepository = iotpVerificationRepository;
    }

    @Override
    public Observable<BaseResponse> createObservable(RequestParams requestParams) {
        return iotpVerificationRepository.verifyOTP((OTPData) requestParams.getObject("otp_data"));
    }
}
