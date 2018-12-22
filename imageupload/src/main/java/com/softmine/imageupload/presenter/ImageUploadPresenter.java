package com.softmine.imageupload.presenter;

import android.util.Log;

import com.softmine.imageupload.domain.ImageUploadUseCase;
import com.softmine.imageupload.model.ImageUploadResponse;

import javax.inject.Inject;

import frameworks.basemvp.AppBasePresenter;
import frameworks.network.usecases.RequestParams;
import rx.Subscriber;

public class ImageUploadPresenter extends AppBasePresenter<IUploadImageContractor.View> implements IUploadImageContractor.Presenter {

    private final ImageUploadUseCase imageUploadUseCase;

    @Inject
    public ImageUploadPresenter(ImageUploadUseCase imageUploadUseCase) {
        this.imageUploadUseCase = imageUploadUseCase;
    }

    @Override
    public void attachView(IUploadImageContractor.View view) {
        super.attachView(view);
        getView().initVariables();
    }

    public void uploadImage(String path){
        RequestParams requestParams=RequestParams.create();
        requestParams.putString(ImageUploadUseCase.IMAGE_PATH, path);
        imageUploadUseCase.execute(requestParams, new Subscriber<ImageUploadResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ImageUploadResponse imageUploadResponse) {
                Log.d("uploadresp", imageUploadResponse.toString());
            }
        });
    }
}

