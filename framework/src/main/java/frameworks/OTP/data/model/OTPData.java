package frameworks.OTP.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Sandeep on 17/12/2016.
 */

public class OTPData implements Serializable {

    @SerializedName("oldPropertyUID")
    private String mVerifiedId;
    @SerializedName("otp")
    private String mOTP;

    public String getmVerifiedId() {
        return mVerifiedId;
    }

    public void setmVerifiedId(String mVerifiedId) {
        this.mVerifiedId = mVerifiedId;
    }

    public String getmOTP() {
        return mOTP;
    }

    public void setmOTP(String mOTP) {
        this.mOTP = mOTP;
    }

}
