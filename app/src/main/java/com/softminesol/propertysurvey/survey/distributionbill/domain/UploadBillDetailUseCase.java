package com.softminesol.propertysurvey.survey.distributionbill.domain;

import com.softmine.imageupload.domain.ImageUploadUseCase;
import com.softmine.imageupload.model.ImageUploadResponse;
import com.softminesol.propertysurvey.GlobalConfig;
import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetails;

import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

import static com.softmine.imageupload.domain.ImageUploadUseCase.IMAGE_PATH;


/**
 * Created by sandeepgoyal on 14/05/18.
 */

public class UploadBillDetailUseCase extends UseCase<BaseResponse> {
    IBillDistributionRepository billDistributionRepository;
    ImageUploadUseCase imageUploadUseCase;


    @Inject
    public UploadBillDetailUseCase(IBillDistributionRepository billDistributionRepository,ImageUploadUseCase imageUploadUseCase,OffLIneBillDistributionUseCase offLIneBillDistributionUseCase) {
        this.billDistributionRepository = billDistributionRepository;
        this.imageUploadUseCase = imageUploadUseCase;
    }

    @Override
    public Observable<BaseResponse> createObservable(RequestParams requestParams) {
        final BillDetails billDetail = (BillDetails) requestParams.getObject("billDetails");
        if(GlobalConfig.distributeCacheFirst()) {
            return billDistributionRepository.cacheBillDistributionData(billDetail);
        } else if(billDetail.getImagePath() != null && !billDetail.getImagePath().isEmpty()) {
            //upload image first
            RequestParams requestParamss = RequestParams.create();
            requestParamss.putString(IMAGE_PATH, billDetail.getImagePath());
            return imageUploadUseCase.createObservable(requestParamss).doOnError(new Action1<Throwable>() {
                @Override
                public void call(Throwable throwable) {
                    billDistributionRepository.cacheBillDistributionData(billDetail);
                }
            }).flatMap(new Func1<ImageUploadResponse, Observable<BaseResponse>>() {
                @Override
                public Observable<BaseResponse> call(ImageUploadResponse imageUploadResponse) {
                    billDetail.setImageID(imageUploadResponse.getUploadResponseData().getImageId()+"");
                    billDetail.setImagePath("");
                    return billDistributionRepository.uploadBillDistributionData(billDetail);
                }
            });

        }else {
            return billDistributionRepository.uploadBillDistributionData(billDetail);
        }
    }
}
