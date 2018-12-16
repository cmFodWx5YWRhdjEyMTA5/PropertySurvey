package com.softminesol.propertysurvey.imageupload.data.repository.datasource;

import com.softminesol.propertysurvey.imageupload.data.net.ImageUploadAPI;
import com.softminesol.propertysurvey.imageupload.model.ImageUploadResponse;

import javax.inject.Inject;

import frameworks.network.model.DataResponse;
import okhttp3.MultipartBody;
import retrofit2.Response;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by sandeepgoyal on 13/05/18.
 */

public class CloudImageUploader {
    ImageUploadAPI imageUploadAPI;

    @Inject
    public CloudImageUploader(ImageUploadAPI imageUploadAPI) {
        this.imageUploadAPI = imageUploadAPI;
    }

    public Observable<ImageUploadResponse> uploadImage(MultipartBody.Part params) {
        return imageUploadAPI.uploadImage(params).map(new Func1<Response<DataResponse<ImageUploadResponse>>, ImageUploadResponse>() {
            @Override
            public ImageUploadResponse call(Response<DataResponse<ImageUploadResponse>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }
}
