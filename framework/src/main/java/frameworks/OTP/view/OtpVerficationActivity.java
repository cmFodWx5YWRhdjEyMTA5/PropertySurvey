package frameworks.OTP.view;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;


import com.softminesol.permissions.apppermission.PermissionActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import frameworks.AppBaseApplication;
import frameworks.OTP.data.model.OTPConstants;
import frameworks.OTP.data.model.OTPData;
import frameworks.OTP.di.OtpVerifyComponent;
import frameworks.OTP.di.DaggerOtpVerifyComponent;
import frameworks.OTP.presenter.OTPPresenter;
import in.healthhunt.framework.R;
import in.healthhunt.framework.R2;

public class OtpVerficationActivity extends PermissionActivity implements OTPRecieverView, OTPReceiver.OnOTPReceiveListener {

    public static final String OTP_TYPE_MOBILE = "phone";
    public static final String OTP_TYPE_EMAIL = "email";
    @BindView(R2.id.otp_text)
    EditText edtxtOTP;
    @Inject
    OTPPresenter mOTPPresenter;
    OTPReceiver mOTPReceiverBroadcast;
    OTPData mOTPData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verfication);
        initInject();
        ButterKnife.bind(this);
        mOTPPresenter.attach(this);
        mOTPData = (OTPData) getIntent().getSerializableExtra("otp_data");
        getPermission(Manifest.permission.READ_SMS,1);
       ;


    }

    private void initInject() {

        OtpVerifyComponent splashComponent = DaggerOtpVerifyComponent.builder().baseAppComponent(((AppBaseApplication) getApplication()).getBaseAppComponent()).build();
        splashComponent.inject(this);
    }

    @Override
    public void showProgress() {
        showProgress("Please Wait");
    }

    ProgressDialog progress;
    public void showProgress(String message) {
        if(progress == null) {
            progress = new ProgressDialog(this);
        }
        if(!progress.isShowing()) {
            progress.setMessage(message);
            progress.setIndeterminate(true);
            progress.show();
        }
    }
    @Override
    public void hideProgress() {
        if(progress != null && progress.isShowing()) {
            progress.dismiss();
            progress = null;
        }
    }

    @Override
    public void setVerificationSuccessful() {
        setResult(OTPConstants.OTPSuccess);
        finish();
    }

    @Override
    public void setVerficationFailed() {
        Toast.makeText(this,"OTP verification Fail!    " +
                "Try Again",Toast.LENGTH_LONG).show();
    }


    @Override
    public void onOTPReceive(String otp) {
        edtxtOTP.setText(otp);
        submitOTP();

    }

    @OnClick(R2.id.ok_btn_id)
    public void submitOTP() {
        String otp = edtxtOTP.getText().toString();
        if (otp != null) {
            mOTPData.setmOTP(otp);
            mOTPPresenter.verifyOTP(mOTPData);
        } else {
            Toast.makeText(this, "Please Enter OTP", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mOTPReceiverBroadcast != null) {
            unregisterReceiver(mOTPReceiverBroadcast);
        }
    }

    @Override
    public void setPermission(int requestCode, boolean isGranted) {
        if(isGranted) {
            IntentFilter filter = new IntentFilter();
            mOTPReceiverBroadcast = new OTPReceiver(this);
            filter.addAction(SMS_RECEIVED_ACTION);
            filter.setPriority(SMS_RECEIVE_PRIORITY);
            registerReceiver(mOTPReceiverBroadcast, filter);
        }
    }
}