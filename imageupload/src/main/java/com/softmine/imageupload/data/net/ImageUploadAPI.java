package com.softmine.imageupload.data.net;

import com.softmine.imageupload.model.ImageUploadResponse;
import com.softmine.imageupload.model.SubmitImagesBody;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by sandeepgoyal on 13/05/18.
 */

public interface ImageUploadAPI {
    @Multipart
    @POST(ImageUploadURL.UPLOAD_IMAGE_API)
    Observable<ImageUploadResponse> uploadImage(@Part MultipartBody.Part params);

    @Multipart
    @POST()
    Observable<ImageUploadResponse> uploadImage(@Part MultipartBody.Part params,@Url String url);

    }
