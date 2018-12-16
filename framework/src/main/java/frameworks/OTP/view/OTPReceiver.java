package frameworks.OTP.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class OTPReceiver extends BroadcastReceiver {

    private static final String OTP_DELIMITER = ":";
    private static final String SMS_ORIGIN = "TMOTPI";

    OnOTPReceiveListener mListener;

    public OTPReceiver() {

    }

    public OTPReceiver(OnOTPReceiveListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        final Bundle bundle = intent.getExtras();
        try {
            if (bundle != null) {
                Object[] pdusObj = (Object[]) bundle.get("pdus");
                for (Object aPdusObj : pdusObj) {
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) aPdusObj);
                    String senderAddress = currentMessage.getDisplayOriginatingAddress();
                    String message = currentMessage.getDisplayMessageBody();
                    // if the SMS is not from our gateway, ignore the message
                    if (!senderAddress.toLowerCase().contains(SMS_ORIGIN.toLowerCase())) {
                        return;
                    }
                    // verification code from sms
                    String verificationCode = getVerificationCode(message);
                    mListener.onOTPReceive(verificationCode);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getVerificationCode(String message) {
        String code = null;
        int index = message.indexOf(OTP_DELIMITER);

        if (index != -1) {
            int start = index + 1;
            int length = 6;
            code = message.substring(start, start + length);
            return code;
        }
        return code;
    }

    public interface OnOTPReceiveListener {
        public static String SMS_RECEIVED_ACTION = "android.provider.Telephony.SMS_RECEIVED";
        public static int SMS_RECEIVE_PRIORITY = 99999;

        public void onOTPReceive(String otp);
    }
}
