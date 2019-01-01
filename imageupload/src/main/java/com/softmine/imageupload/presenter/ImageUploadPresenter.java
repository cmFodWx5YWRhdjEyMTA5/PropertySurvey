package com.softmine.imageupload.presenter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.softmine.imageupload.domain.ImageListUploadSubmitUseCase;
import com.softmine.imageupload.domain.ImageUploadUseCase;
import com.softmine.imageupload.model.ImageUploadResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import frameworks.basemvp.AppBasePresenter;
import frameworks.network.usecases.RequestParams;
import rx.Subscriber;

public class ImageUploadPresenter extends AppBasePresenter<IUploadImageContractor.View> implements IUploadImageContractor.Presenter {

    private final ImageListUploadSubmitUseCase imageListUploadSubmitUseCase;

    public static final String FILE_PATHS = "FILE_PATHS";
    @Inject
    public ImageUploadPresenter(ImageUploadUseCase imageUploadUseCase, ImageListUploadSubmitUseCase imageListUploadSubmitUseCase) {
        this.imageListUploadSubmitUseCase = imageListUploadSubmitUseCase;
    }

    @Override
    public void attachView(IUploadImageContractor.View view) {
        super.attachView(view);
        getView().initVariables();
    }


    @Override
    public void uploadImages(List<String> fileUris) {
        RequestParams requestParams = imageListUploadSubmitUseCase.createRequestParams(fileUris,getView().getURL(),getView().getParamName());
        getView().showProgressBar("Please Wait");
        imageListUploadSubmitUseCase.execute(requestParams, new Subscriber<List<String>>() {
            @Override
            public void onCompleted() {
                getView().hideProgressBar();
            }

            @Override
            public void onError(Throwable e) {
                getView().hideProgressBar();
                getView().showSnackBar(e.getMessage());
            }

            @Override
            public void onNext(List<String> strings) {

                Intent intent = new Intent();
                intent.putStringArrayListExtra(FILE_PATHS, (ArrayList<String>) strings);
                getView().setResult(Activity.RESULT_OK,intent);
                getView().finish();

            }
        });
    }
}

