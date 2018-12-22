package com.softmine.imageupload.domain;

import com.softmine.imageupload.model.ImageUploadResponse;
import com.softmine.imageupload.model.SubmitImagesBody;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by sandeepgoyal on 13/05/18.
 */

public interface IImageUploadRepository {
    Observable<ImageUploadResponse> uploadImage(MultipartBody.Part params);

    Observable<ImageUploadResponse> submitImages(SubmitImagesBody submitImagesBody);


}
