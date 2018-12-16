package com.softminesol.propertysurvey.survey.cloudsync;

import com.softminesol.propertysurvey.imageupload.domain.intractor.ImageUploadUseCase;
import com.softminesol.propertysurvey.imageupload.model.ImageUploadResponse;
import com.softminesol.propertysurvey.survey.common.realm.RealmPropertyDataMapper;
import com.softminesol.propertysurvey.survey.distributionbill.domain.OffLIneBillDistributionUseCase;
import com.softminesol.propertysurvey.survey.distributionbill.domain.UploadBillDetailUseCase;
import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetails;

import java.util.List;

import javax.crypto.interfaces.PBEKey;
import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;
import rx.functions.Func1;

import static com.softminesol.propertysurvey.imageupload.domain.intractor.ImageUploadUseCase.IMAGE_PATH;

public class DistributionFormSync extends UseCase<BaseResponse>{
    RealmPropertyDataMapper realmPropertyDataMapper;
    private ImageUploadUseCase imageUploadUseCase;
    OffLIneBillDistributionUseCase offLIneBillDistributionUseCase;

    @Inject
    public DistributionFormSync(UploadBillDetailUseCase uploadBillDetailUseCase, RealmPropertyDataMapper realmPropertyDataMapper, ImageUploadUseCase imageUploadUseCase,OffLIneBillDistributionUseCase offLIneBillDistributionUseCase) {
        this.realmPropertyDataMapper = realmPropertyDataMapper;
        this.imageUploadUseCase = imageUploadUseCase;
        this.offLIneBillDistributionUseCase = offLIneBillDistributionUseCase;
    }



    public Observable<BaseResponse> uploadBill(BillDetails billDetails) {
        RequestParams requestParams = RequestParams.create();
        requestParams.putObject("billDetails", billDetails);
        return offLIneBillDistributionUseCase.createObservable(requestParams);
    }

    @Override
    public Observable<BaseResponse> createObservable(RequestParams requestParams) {
        return realmPropertyDataMapper.getUpdateBillDistributionForm().flatMap(new Func1<List<BillDetails>, Observable<BaseResponse>>() {
            @Override
            public Observable<BaseResponse> call(List<BillDetails> billDetails) {
                if(billDetails != null && billDetails.size() > 0) {
                    return Observable.just(billDetails).flatMapIterable(new Func1<List<BillDetails>, Iterable<BillDetails>>() {
                        @Override
                        public Iterable<BillDetails> call(List<BillDetails> billDetails) {
                            return billDetails;
                        }
                    }).flatMap(new Func1<BillDetails, Observable<BaseResponse>>() {
                        @Override
                        public Observable<BaseResponse> call(final BillDetails billDetails) {
                            if (billDetails.getImagePath() != null && !billDetails.getImagePath().isEmpty()) {
                                RequestParams requestParams = RequestParams.create();
                                requestParams.putString(IMAGE_PATH, billDetails.getImagePath());
                                return imageUploadUseCase.createObservable(requestParams).flatMap(new Func1<ImageUploadResponse, Observable<BaseResponse>>() {
                                    @Override
                                    public Observable<BaseResponse> call(ImageUploadResponse imageUploadResponse) {
                                        billDetails.setImageID(imageUploadResponse.getImage().get(0).getPropertyimagesid() + "");
                                        return uploadBill(billDetails);
                                    }
                                });
                            } else {
                                return uploadBill(billDetails);
                            }
                        }
                    });
                }else {
                    return Observable.just(new BaseResponse());
                }
            }
        });
    }
}

