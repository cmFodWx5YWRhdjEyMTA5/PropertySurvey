package frameworks.OTP.di;

import dagger.Module;
import dagger.Provides;
import frameworks.OTP.data.net.OtpAPI;
import frameworks.OTP.data.repository.OTPVerificationRepository;
import frameworks.OTP.data.repository.datasource.OTPVerificationFactory;
import frameworks.OTP.domain.IOTPVerificationRepository;
import frameworks.OTP.domain.OtpVerifyUseCase;
import frameworks.OTP.presenter.OTPPresenter;
import frameworks.OTP.presenter.OTPPresenterImpl;
import frameworks.appsession.AppSessionManager;
import frameworks.network.interceptor.AppAuthInterceptor;
import frameworks.network.interceptor.ErrorResponseInterceptor;
import frameworks.network.model.BaseResponseError;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * Created by sandeepgoyal on 18/05/18.
 */
@Module
public class OtpVerifyModule {
    @Provides
    OtpAPI provideLoginApi(Retrofit retrofit) {
        return retrofit.create(OtpAPI.class);
    }

    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient,
                             Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder.baseUrl("http://124.0.0.1").client(okHttpClient).build();
    }

    @Provides
    OkHttpClient provideOkHttpClient(AppAuthInterceptor appAuthInterceptor,HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(appAuthInterceptor)
                .addInterceptor(new ErrorResponseInterceptor(BaseResponseError.class))
                .build();
    }

    @Provides
    IOTPVerificationRepository getTokenRepository(OTPVerificationFactory otpVerificationFactory) {
        return new OTPVerificationRepository(otpVerificationFactory);

    }

    @Provides
    OTPPresenter getOTPPresenter(OtpVerifyUseCase useCase) {
       return new OTPPresenterImpl(useCase);
    }

    @Provides
    OtpVerifyUseCase getOTPUseCase(IOTPVerificationRepository iotpVerificationRepository) {
        return new OtpVerifyUseCase(iotpVerificationRepository);
    }
}
