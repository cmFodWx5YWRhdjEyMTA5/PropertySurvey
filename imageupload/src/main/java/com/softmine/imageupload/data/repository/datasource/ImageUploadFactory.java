package com.softmine.imageupload.data.repository.datasource;

import com.softmine.imageupload.model.ImageUploadResponse;
import com.softmine.imageupload.model.SubmitImagesBody;

import java.util.HashMap;

import javax.inject.Inject;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by sandeepgoyal on 13/05/18.
 */

public class ImageUploadFactory {
    private CloudImageUploader cloudImageUploader;

    @Inject
    public ImageUploadFactory(CloudImageUploader cloudImageUploader) {
        this.cloudImageUploader = cloudImageUploader;
    }

    public Observable<ImageUploadResponse> uploadImage(MultipartBody.Part params) {
        return cloudImageUploader.uploadImage(params);
    }

    public Observable<ImageUploadResponse> uploadImage(MultipartBody.Part params,String url) {
        return cloudImageUploader.uploadImage(params,url);
    }

    public Observable<ImageUploadResponse> submitImages(SubmitImagesBody submitImagesBody) {
        return cloudImageUploader.submitImages(submitImagesBody);
    }


}
