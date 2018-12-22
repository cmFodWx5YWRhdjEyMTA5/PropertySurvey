package com.softmine.imageupload.data.repository.datasource;

import com.softmine.imageupload.data.net.ImageUploadAPI;
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

public class CloudImageUploader {
    private ImageUploadAPI imageUploadAPI;

    @Inject
    public CloudImageUploader(ImageUploadAPI imageUploadAPI) {
        this.imageUploadAPI = imageUploadAPI;
    }

    public Observable<ImageUploadResponse> uploadImage(MultipartBody.Part params) {
        return imageUploadAPI.uploadImage(params);
    }

    public Observable<ImageUploadResponse> submitImages(SubmitImagesBody submitImagesBody) {
        return null;
    }

}
