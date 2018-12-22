package com.softmine.imageupload.presenter;

import android.util.Log;

import com.softmine.imageupload.domain.ImageListUploadSubmitUseCase;
import com.softmine.imageupload.model.ImageUploadResponse;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Subscriber;

public class ImageUploadPresenterImpl implements IUploadImagesServiceContract.UploadImagesPresenter {
    private IUploadImagesServiceContract.UploadImagesListener uploadImagesListener;
    private ImageListUploadSubmitUseCase imageUploadUseCase;

    @Inject
    public ImageUploadPresenterImpl(ImageListUploadSubmitUseCase imageUploadUseCase) {
        this.imageUploadUseCase = imageUploadUseCase;
    }

    public void attach(IUploadImagesServiceContract.UploadImagesListener uploadImagesListener) {
        this.uploadImagesListener = uploadImagesListener;
    }

    @Override
    public void uploadImages(ArrayList<String> filePaths, int deliveryId) {
        imageUploadUseCase.execute(imageUploadUseCase.createRequestParams(filePaths, deliveryId), new Subscriber<ImageUploadResponse>() {
            @Override
            public void onCompleted() {
                Log.d("OnCompletedExecuted", "true");
                uploadImagesListener.onProgressComplete();
            }

            @Override
            public void onError(Throwable e) {
                uploadImagesListener.onProgressFail();
            }

            @Override
            public void onNext(ImageUploadResponse imageUploadResponse) {
                Log.d("uploadresp", imageUploadResponse.toString());
            }
        });
    }


}
