package com.softmine.imageupload.domain;


import com.softmine.imageupload.model.ImageUploadResponse;
import com.softmine.imageupload.model.SubmitImagesBody;
import com.softmine.imageupload.model.SubmitImagesFormData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by sandeepgoyal on 13/05/18.
 */

public class ImageListUploadSubmitUseCase extends UseCase<ImageUploadResponse> {
    private final String IMAGE_PATHS = "IMAGE_PATHS";
    private final String DELIVERY_ID = "DELIVERY_ID ";
    private final SubmitImageUseCase submitImageUseCase;
    private final ImageUploadUseCase imageUploadUseCase;


    public RequestParams createRequestParams(List<String> paths, int deliveryId) {
        RequestParams requestParams = RequestParams.create();
        requestParams.putObject(IMAGE_PATHS, paths);
        requestParams.putInt(DELIVERY_ID, deliveryId);
        return requestParams;
    }


    @Inject
    public ImageListUploadSubmitUseCase(ImageUploadUseCase imageUploadUseCase, SubmitImageUseCase submitImageUseCase) {
        this.imageUploadUseCase = imageUploadUseCase;
        this.submitImageUseCase = submitImageUseCase;
    }

    @Override
    public Observable<ImageUploadResponse> createObservable(final RequestParams requestParams) {
        ArrayList<String> filePaths = (ArrayList<String>) requestParams.getObject(IMAGE_PATHS);
        int deliveryId = requestParams.getInt(DELIVERY_ID, -1);
        requestParams.getParameters().remove(IMAGE_PATHS);
        if (filePaths == null || filePaths.size() == 0)
            return null;
        else {
            return Observable.from(filePaths).concatMap(new Func1<String, Observable<Integer>>() {
                @Override
                public Observable<Integer> call(String filePath) {
                    requestParams.putString(ImageUploadUseCase.IMAGE_PATH, filePath);
                    return imageUploadUseCase.createObservable(requestParams).map(new Func1<ImageUploadResponse, Integer>() {
                        @Override
                        public Integer call(ImageUploadResponse imageUploadResponse) {
                            return imageUploadResponse.getUploadResponseData().getImageId();
                        }
                    });
                }
            }).toList().flatMap(new Func1<List<Integer>, Observable<ImageUploadResponse>>() {
                @Override
                public Observable<ImageUploadResponse> call(List<Integer> imageUploadResponses) {
                    SubmitImagesBody submitImagesBody = new SubmitImagesBody();
                    SubmitImagesFormData imagesFormData = new SubmitImagesFormData();
                    Integer[] imagesId = new Integer[imageUploadResponses.size()];
                    int i = 0;
                    for (Integer id : imageUploadResponses) {
                        imagesId[i++] = id;
                    }
                    imagesFormData.setImages(imagesId);
                    submitImagesBody.setSubmitImagesFormData(imagesFormData);
                    return submitImageUseCase.createObservable(submitImageUseCase.createRequestParams(submitImagesBody));
                }
            });
        }
    }


}
