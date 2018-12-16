package com.softminesol.propertysurvey.imageupload.data.repository;

import com.softminesol.propertysurvey.imageupload.data.repository.datasource.ImageUploadFactory;
import com.softminesol.propertysurvey.imageupload.domain.IImageUploadRepository;
import com.softminesol.propertysurvey.imageupload.model.ImageUploadResponse;

import javax.inject.Inject;

import okhttp3.MultipartBody;
import rx.Observable;

/**
 * Created by sandeepgoyal on 13/05/18.
 */

public class ImageUploadRepository implements IImageUploadRepository {
    ImageUploadFactory imageUploadFactory;

    @Inject
    public ImageUploadRepository(ImageUploadFactory imageUploadFactory) {
        this.imageUploadFactory = imageUploadFactory;
    }

    @Override
    public Observable<ImageUploadResponse> uploadImage(MultipartBody.Part params) {
        return imageUploadFactory.uploadImage(params);
    }
}
