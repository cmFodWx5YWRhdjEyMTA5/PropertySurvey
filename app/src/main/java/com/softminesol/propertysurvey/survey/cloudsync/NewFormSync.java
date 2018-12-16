package com.softminesol.propertysurvey.survey.cloudsync;

import com.softminesol.propertysurvey.imageupload.domain.intractor.ImageUploadUseCase;
import com.softminesol.propertysurvey.survey.cloudsync.domain.SubmitCloudUseCase;
import com.softminesol.propertysurvey.survey.common.model.formData.FormData;
import com.softminesol.propertysurvey.survey.common.realm.RealmPropertyDataMapper;

import java.util.List;

import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import frameworks.network.usecases.RequestParams;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class NewFormSync extends FormSync{
    private final SubmitCloudUseCase updateCloudUseCase;

    @Inject
    public NewFormSync(SubmitCloudUseCase submitCloudUseCase, RealmPropertyDataMapper realmPropertyDataMapper, ImageUploadUseCase imageUploadUseCase) {
        super(realmPropertyDataMapper,imageUploadUseCase);
        this.updateCloudUseCase = submitCloudUseCase;
    }

    public Observable<BaseResponse> sync() {
        return realmPropertyDataMapper.getNewFormData().flatMap(new Func1<List<FormData>, Observable<BaseResponse>>() {
            @Override
            public Observable<BaseResponse> call(List<FormData> formData) {
                if(formData != null && formData.size()>0) {
                    return Observable.just(formData).flatMapIterable(new Func1<List<FormData>, Iterable<FormData>>() {
                        @Override
                        public Iterable<FormData> call(List<FormData> formData) {
                            return formData;
                        }
                    }).flatMap(new Func1<FormData, Observable<BaseResponse>>() {
                        @Override
                        public Observable<BaseResponse> call(FormData formData) {
                            return syncForm(formData);
                        }
                    });
                }else {
                    return Observable.just(new BaseResponse());
                }
            }
        });
    }

    @Override
    public Observable<BaseResponse> pushFormToCLoud(final FormData formData1) {
        RequestParams requestParams = RequestParams.create();
        requestParams.putObject("formData",formData1);
        return updateCloudUseCase.createObservable(requestParams);
    }

    @Override
    public Observable<BaseResponse> createObservable(RequestParams requestParams) {
        return sync();
    }
}
