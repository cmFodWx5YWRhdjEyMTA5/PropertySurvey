package com.softmine.imageupload.domain;

import com.softmine.imageupload.model.ImageUploadResponse;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by sandeepgoyal on 13/05/18.
 */

public class ImageUploadUseCase extends UseCase<ImageUploadResponse> {
    public static String IMAGE_PATH = "PATH";
    public static String URL = "URL";
    public static String PARAM_NAME = "PARAM_NAME";

    IImageUploadRepository repository;

    @Inject
    public ImageUploadUseCase(IImageUploadRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<ImageUploadResponse> createObservable(RequestParams requestParams) {

        String url = requestParams.getString(URL, null);
        if(url != null) {
            return repository.uploadImage(generateRequestImage(requestParams.getString(IMAGE_PATH, ""), requestParams.getString(PARAM_NAME, "image")),url);

        }else {
            return repository.uploadImage(generateRequestImage(requestParams.getString(IMAGE_PATH, ""), requestParams.getString(PARAM_NAME, "image")));
        }
    }




    private MultipartBody.Part generateRequestImage(String pathFile,String param_name) {

        File file = new File(pathFile);
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);
        return MultipartBody.Part.createFormData(param_name, file.getName(), requestBody);

    }

}
