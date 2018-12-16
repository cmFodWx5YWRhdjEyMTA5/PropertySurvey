package com.softminesol.propertysurvey.imageupload.data.repository.datasource;

import com.softminesol.propertysurvey.imageupload.model.ImageUploadResponse;

import javax.inject.Inject;

import okhttp3.MultipartBody;
import rx.Observable;

/**
 * Created by sandeepgoyal on 13/05/18.
 */

public class ImageUploadFactory {
    CloudImageUploader cloudImageUploader;

    @Inject
    public ImageUploadFactory(CloudImageUploader cloudImageUploader) {
        this.cloudImageUploader = cloudImageUploader;
    }

    public Observable<ImageUploadResponse> uploadImage(MultipartBody.Part params) {
        return cloudImageUploader.uploadImage(params);
    }
}
