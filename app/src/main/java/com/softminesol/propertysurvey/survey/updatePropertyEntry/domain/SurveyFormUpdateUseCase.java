package com.softminesol.propertysurvey.survey.updatePropertyEntry.domain;

import com.softminesol.propertysurvey.GlobalConfig;
import com.softminesol.propertysurvey.imageupload.domain.intractor.ImageUploadUseCase;
import com.softminesol.propertysurvey.imageupload.model.ImageUploadResponse;
import com.softminesol.propertysurvey.survey.common.model.formData.FloorDetailsItem;
import com.softminesol.propertysurvey.survey.common.model.formData.FormData;

import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

import static com.softminesol.propertysurvey.imageupload.domain.intractor.ImageUploadUseCase.IMAGE_PATH;

/**
 * Created by sandeep on 13/5/18.
 */
public class SurveyFormUpdateUseCase extends UseCase<BaseResponse> {

    ISurveyFormUpdateRepository surveyFormUpdateRepository;
    ImageUploadUseCase imageUploadUseCase;
    @Inject
    public SurveyFormUpdateUseCase(ISurveyFormUpdateRepository surveyFormUpdateRepository, ImageUploadUseCase imageUploadUseCase) {
        this.surveyFormUpdateRepository = surveyFormUpdateRepository;
        this.imageUploadUseCase = imageUploadUseCase;
    }

    @Override
    public Observable<BaseResponse> createObservable(RequestParams requestParams) {
        final FormData formData = (FormData) requestParams.getObject("formdata");
        if (GlobalConfig.distributeCacheFirst()) {
            return surveyFormUpdateRepository.updateProperty(formData);
        } else {
            final boolean[] imageSyncSuccess = {true};
            for (final FloorDetailsItem floorDetailsItem : formData.getFloorDetails()) {
                if (floorDetailsItem.getImagePath() != null && !floorDetailsItem.getImagePath().isEmpty()) {
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
                            floorDetailsItem.setPropertyImageID(imageUploadResponse.getImage().get(0).getPropertyimagesid() + "");
                        }
                    });
                }
            }
            if (imageSyncSuccess[0]) {
                return surveyFormUpdateRepository.updatePropertyOnCloud(formData).onErrorResumeNext(new Func1<Throwable, Observable<BaseResponse>>() {
                    @Override
                    public Observable<BaseResponse> call(Throwable throwable) {
                        return surveyFormUpdateRepository.updateProperty(formData);
                    }
                });
            } else {
                return surveyFormUpdateRepository.updateProperty(formData);
            }
        }
    }


}
