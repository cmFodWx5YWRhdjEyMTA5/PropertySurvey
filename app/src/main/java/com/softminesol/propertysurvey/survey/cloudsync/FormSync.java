package com.softminesol.propertysurvey.survey.cloudsync;

import com.softmine.imageupload.domain.ImageUploadUseCase;
import com.softmine.imageupload.model.ImageUploadResponse;
import com.softminesol.propertysurvey.survey.common.model.formData.FloorDetailsItem;
import com.softminesol.propertysurvey.survey.common.model.formData.FormData;
import com.softminesol.propertysurvey.survey.common.realm.RealmPropertyDataMapper;

import frameworks.network.model.BaseResponse;
import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;
import rx.functions.Func1;

import static com.softmine.imageupload.domain.ImageUploadUseCase.IMAGE_PATH;


public abstract class FormSync extends UseCase<BaseResponse>{

     final RealmPropertyDataMapper realmPropertyDataMapper;
     ImageUploadUseCase imageUploadUseCase;


    public FormSync(RealmPropertyDataMapper realmPropertyDataMapper, ImageUploadUseCase imageUploadUseCase) {
        this.realmPropertyDataMapper = realmPropertyDataMapper;
        this.imageUploadUseCase = imageUploadUseCase;
    }
    abstract public Observable<BaseResponse> sync() ;

    public Observable<BaseResponse> syncForm(final FormData formData1) {
        return syncPictures(formData1);
    }

    abstract public Observable<BaseResponse> pushFormToCLoud(FormData formData1) ;


    private Observable<BaseResponse> syncPictures(final FormData formData1) {
        for(final FloorDetailsItem floorDetailsItem: formData1.getFloorDetails()) {
            if (floorDetailsItem.getImagePath() != null && !floorDetailsItem.getImagePath().isEmpty()) {
                RequestParams requestParams = RequestParams.create();
                requestParams.putString(IMAGE_PATH, floorDetailsItem.getImagePath());
                return imageUploadUseCase.createObservable(requestParams).flatMap(new Func1<ImageUploadResponse, Observable<BaseResponse>>() {
                    @Override
                    public Observable<BaseResponse> call(ImageUploadResponse imageUploadResponse) {
                        floorDetailsItem.setImagePath("");
                        floorDetailsItem.setPropertyImageID(imageUploadResponse.getUploadResponseData().getImageId() + "");
                        return syncPictures(formData1);

                    }
                });
            }
        }
        return pushFormToCLoud(formData1);
    }
}
