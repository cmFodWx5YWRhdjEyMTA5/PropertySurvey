package com.softminesol.propertysurvey.survey.distributionbill.presenter;

import android.content.Intent;
import android.net.Uri;
import android.widget.ArrayAdapter;

import com.softmine.imageupload.view.ActivityPicChooser;
import com.softminesol.propertysurvey.GlobalConfig;
import com.softminesol.propertysurvey.R;
import com.softminesol.propertysurvey.imageupload.domain.intractor.ImageUploadUseCase;
import com.softminesol.propertysurvey.imageupload.model.ImageUploadResponse;
import com.softminesol.propertysurvey.survey.cloudsync.DistributionFormSync;
import com.softminesol.propertysurvey.survey.common.model.OLDPropertyUIDS;
import com.softminesol.propertysurvey.survey.distributionbill.domain.BillDistributionPropertyIdListUseCase;
import com.softminesol.propertysurvey.survey.distributionbill.domain.GetBillDetailUseCase;
import com.softminesol.propertysurvey.survey.distributionbill.domain.UploadBillDetailUseCase;
import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetail;
import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetails;

import java.util.List;

import javax.inject.Inject;

import frameworks.OTP.data.model.OTPConstants;
import frameworks.OTP.data.model.OTPData;
import frameworks.OTP.view.OtpVerficationActivity;
import frameworks.basemvp.AppBasePresenter;
import frameworks.customadapter.CustomAdapterModel;
import frameworks.network.model.BaseResponse;
import frameworks.network.usecases.RequestParams;
import frameworks.utils.AdapterFactory;
import rx.Subscriber;

import static com.softmine.imageupload.view.ActivityPicChooser.IMAGE_URI_REQUEST;
import static com.softmine.imageupload.view.ActivityPicChooser.IMAGE_URI_RESULT;
import static com.softminesol.propertysurvey.imageupload.domain.intractor.ImageUploadUseCase.IMAGE_PATH;

/**
 * Created by sandeepgoyal on 14/05/18.
 */

public class DistributionBillPresenter extends AppBasePresenter<DistributionBillContract.View> implements DistributionBillContract.Presenter {

    GetBillDetailUseCase getBillDetailUseCase;
    BillDistributionPropertyIdListUseCase propertyIdListUseCase;
    ImageUploadUseCase imageUploadUseCase;
    AdapterFactory adapterFactory;
    UploadBillDetailUseCase uploadBillDetailUseCase;
    DistributionFormSync syncManager;
    boolean imageSyncPassed;


    @Inject
    public DistributionBillPresenter(AdapterFactory adapterFactory, GetBillDetailUseCase getBillDetailUseCase, BillDistributionPropertyIdListUseCase surveyPropertyIdListUseCase,
                                     ImageUploadUseCase imageUploadUseCase, UploadBillDetailUseCase uploadBillDetailUseCase, DistributionFormSync syncManager) {
        this.getBillDetailUseCase = getBillDetailUseCase;
        this.propertyIdListUseCase = surveyPropertyIdListUseCase;
        this.adapterFactory = adapterFactory;
        this.imageUploadUseCase = imageUploadUseCase;
        this.uploadBillDetailUseCase = uploadBillDetailUseCase;
        this.syncManager = syncManager;
    }


    @Override
    public void attachView(DistributionBillContract.View view) {
        super.attachView(view);
        getView().setStatusOptions(ArrayAdapter.createFromResource(getView().getContext(),
                R.array.status, in.healthhunt.framework.R.layout.dropdown_item));
    }

    public void onUploadPickClick() {
        getView().startActivityForResult(new Intent(getView().getContext(), ActivityPicChooser.class), IMAGE_URI_REQUEST);
    }

    @Override
    public void onOldPropertyChange(String oldPropertyChange) {
        RequestParams requestParams = RequestParams.create();
        requestParams.putString("query", oldPropertyChange);

        propertyIdListUseCase.execute(requestParams, new Subscriber<OLDPropertyUIDS>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(OLDPropertyUIDS oldPropertyUIDS) {
                getView().setOldPropertyIDAdapter((List<CustomAdapterModel>) (List<?>) oldPropertyUIDS.getOldPropertyUID());
            }
        });

    }

    @Override
    public void onPropertyIDSelected(String oldpropertyuid) {
        RequestParams requestParams = RequestParams.create();
        requestParams.putString("id", oldpropertyuid);
        clearForm();
        getView().showProgressBar();
        getBillDetailUseCase.execute(requestParams, new Subscriber<BillDetail>() {
            @Override
            public void onCompleted() {
                getView().hideProgressBar();
            }

            @Override
            public void onError(Throwable e) {
                getView().hideProgressBar();
            }

            @Override
            public void onNext(BillDetail billDetail) {
                BillDetails billDetails = billDetail.getBillDetails();
                getView().setEdtAddress(billDetails.getAddressLine1());
                getView().setEdtName(billDetails.getName());
                getView().setEdtPhNo(billDetails.getMobileNumber() + "");
            }
        });
    }

    private void clearForm() {
        getView().setEdtAddress("");
        getView().setEdtName("");
        getView().setEdtPhNo("");
        getView().setEdtPicId("");
        getView().setEdtStatus("");
    }

    @Override
    public void onUploadBillClick() {
        BillDetails billDetails = new BillDetails();
        billDetails.setAddressLine1(getView().getEdtAddress());
        billDetails.setMobileNumber(getView().getEdtPhNo());
        billDetails.setName(getView().getEdtName());
        billDetails.setOldPropertyUID(getView().getEdtPropertyId());
        billDetails.setStatus(getView().getEdtStatus());
        if(imageSyncPassed) {
            billDetails.setImageID(getView().getEdtPicId());
        }else {
            billDetails.setImagePath(getView().getEdtPicId());
        }
        RequestParams requestParams = RequestParams.create();
        requestParams.putObject("billDetails", billDetails);
        getView().showProgressBar();
        uploadBillDetailUseCase.execute(requestParams, new Subscriber<BaseResponse>() {
            @Override
            public void onCompleted() {
                getView().hideProgressBar();
            }

            @Override
            public void onError(Throwable e) {
                getView().hideProgressBar();
                if (e.getMessage().equals("Please verify OTP")) {
                    Intent intent = new Intent(getView().getContext(), OtpVerficationActivity.class);
                    OTPData otp = new OTPData();
                    otp.setmVerifiedId(getView().getEdtPropertyId());
                    intent.putExtra("otp_data", otp);
                    getView().startActivityForResult(intent, OTPConstants.OTPRequest);
                }
                getView().finish();
            }

            @Override
            public void onNext(BaseResponse baseResponse) {
                if (baseResponse.getMessage().equals("Please verify OTP")) {
                    Intent intent = new Intent(getView().getContext(), OtpVerficationActivity.class);
                    OTPData otp = new OTPData();
                    otp.setmVerifiedId(getView().getEdtPropertyId());
                    intent.putExtra("otp_data", otp);
                    getView().startActivityForResult(intent, OTPConstants.OTPRequest);
                } else {
                    getView().showToast(baseResponse.getMessage());
                    getView().finish();
                    syncManager.execute(new Subscriber<BaseResponse>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(BaseResponse baseResponse) {

                        }
                    });

                }
            }
        });
    }




    @Override
    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == IMAGE_URI_REQUEST && resultCode == IMAGE_URI_RESULT) {
            final Uri uri = data.getData();
            if(GlobalConfig.distributeCacheFirst()) {
                imageSyncPassed = false;
                getView().setEdtPicId(uri.getPath());
            }else {
                getView().showProgressBar();
                RequestParams requestParams = RequestParams.create();
                requestParams.putString(IMAGE_PATH, uri.getPath());
                imageUploadUseCase.execute(requestParams, new Subscriber<ImageUploadResponse>() {
                    @Override
                    public void onCompleted() {
                        getView().hideProgressBar();
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().hideProgressBar();
                        getView().showToast(e.getMessage());
                        imageSyncPassed = false;
                        getView().setEdtPicId(uri.getPath());
                    }

                    @Override
                    public void onNext(ImageUploadResponse imageUploadResponse) {
                        getView().setEdtPicId(imageUploadResponse.getImage().get(0).getPropertyimagesid() + "");
                    }
                });
            }

        } else if (requestCode == OTPConstants.OTPRequest) {
            if (resultCode == OTPConstants.OTPSuccess) {
                getView().finish();
                getView().showToast("Property Update Successfully");
                syncManager.execute(new Subscriber<BaseResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BaseResponse baseResponse) {

                    }
                });
            } else {
                getView().showToast("OTP verification Fail");
            }
        }
        return super.onActivityResult(requestCode, resultCode, data);
    }
}

