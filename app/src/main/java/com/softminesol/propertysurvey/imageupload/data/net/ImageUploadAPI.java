package com.softminesol.propertysurvey.imageupload.data.net;

import com.softminesol.propertysurvey.imageupload.model.ImageUploadResponse;

import frameworks.network.model.DataResponse;
import okhttp3.MultipartBody;
import retrofit2.Response;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

/**
 * Created by sandeepgoyal on 13/05/18.
 */

public interface ImageUploadAPI {
    @Multipart
    @POST(ImageUploadURL.imageUpload)
    Observable<Response<DataResponse<ImageUploadResponse>>> uploadImage(@Part MultipartBody.Part params);
}
