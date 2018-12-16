package com.softminesol.propertysurvey.imageupload.domain;

import com.softminesol.propertysurvey.imageupload.model.ImageUploadResponse;

import okhttp3.MultipartBody;
import rx.Observable;

/**
 * Created by sandeepgoyal on 13/05/18.
 */

public interface IImageUploadRepository {
    Observable<ImageUploadResponse> uploadImage(MultipartBody.Part params);
}
