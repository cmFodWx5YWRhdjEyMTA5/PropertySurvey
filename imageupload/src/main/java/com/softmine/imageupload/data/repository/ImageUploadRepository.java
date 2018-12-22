package com.softmine.imageupload.data.repository;

import com.softmine.imageupload.data.repository.datasource.ImageUploadFactory;
import com.softmine.imageupload.domain.IImageUploadRepository;
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

    @Override
    public Observable<ImageUploadResponse> submitImages(SubmitImagesBody submitImagesBody) {
        return imageUploadFactory.submitImages(submitImagesBody);
    }


}
