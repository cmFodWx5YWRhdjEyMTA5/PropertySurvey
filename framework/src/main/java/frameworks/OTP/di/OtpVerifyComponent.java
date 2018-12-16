package frameworks.OTP.di;

import dagger.Component;
import frameworks.OTP.view.OtpVerficationActivity;
import frameworks.di.component.BaseAppComponent;

/**
 * Created by sandeepgoyal on 18/05/18.
 */

@OTPScope
@Component(modules = {OtpVerifyModule.class}, dependencies = BaseAppComponent.class)
public interface OtpVerifyComponent {
    public void inject(OtpVerficationActivity activity);
}
