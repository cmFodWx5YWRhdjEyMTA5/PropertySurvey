package com.softminesol.propertysurvey.survey.newPropertyEntry.domain;

import com.softmine.imageupload.domain.ImageUploadUseCase;
import com.softmine.imageupload.model.ImageUploadResponse;
import com.softminesol.propertysurvey.GlobalConfig;
import com.softminesol.propertysurvey.survey.common.model.formData.FloorDetailsItem;
import com.softminesol.propertysurvey.survey.common.model.formData.FormData;

import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

import static com.softmine.imageupload.domain.ImageUploadUseCase.IMAGE_PATH;


/**
 * Created by sandeep on 13/5/18.
 */
public class SurveyFormSubmitUseCase extends UseCase<BaseResponse> {

    ISurveyFormSubmitRepository surveyFormSubmitRepository;
    ImageUploadUseCase imageUploadUseCase;

    @Inject
    public SurveyFormSubmitUseCase(ISurveyFormSubmitRepository surveyFormSubmitRepository, ImageUploadUseCase imageUploadUseCase) {
        this.surveyFormSubmitRepository = surveyFormSubmitRepository;
        this.imageUploadUseCase = imageUploadUseCase;
    }

    @Override
    public Observable<BaseResponse> createObservable(RequestParams requestParams) {
        FormData formData = (FormData) requestParams.getObject("formdata");
        if(GlobalConfig.distributeCacheFirst()) {
            return surveyFormSubmitRepository.submitNewProperty(formData);
        }else {
            final boolean[] imageSyncSuccess = {true};
            for (final FloorDetailsItem floorDetailsItem : formData.getFloorDetails()) {
                if (floorDetailsItem.getImagePath() != null) {
                    RequestParams requestParamss = RequestParams.create();
                    requestParamss.putString(IMAGE_PATH, floorDetailsItem.getImagePath());
                    Observable.just(imageUploadUseCase.createObservable(requestParamss).toBlocking().first()).doOnError(new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {
                            imageSyncSuccess[0] = false;
                        }
                    }).doOnNext(new Action1<ImageUploadResponse>() {
                        @Override
                        public void call(ImageUploadResponse imageUploadResponse) {
                            floorDetailsItem.setPropertyImageID(imageUploadResponse.getUploadResponseData().getImageId() + "");
                        }
                    });
                }
            }
            if (imageSyncSuccess[0]) {
                return surveyFormSubmitRepository.submitCloudNewProperty(formData);
            } else {
                return surveyFormSubmitRepository.submitNewProperty(formData);
            }
        }
    }
}
