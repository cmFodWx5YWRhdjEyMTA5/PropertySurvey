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
import rx.functions.Func1;

/**
 * Created by sandeepgoyal on 13/05/18.
 */

public class ImageUploadUseCase extends UseCase<ImageUploadResponse> {
    public static String IMAGE_PATH = "PATH";
    public static String URL = "URL";
    public static String PARAM_NAME = "PARAM_NAME";
    private final CompressImageUseCase compressImageUseCase;

    IImageUploadRepository repository;

    @Inject
    public ImageUploadUseCase(IImageUploadRepository repository,CompressImageUseCase compressImageUseCase) {
        this.repository = repository;
        this.compressImageUseCase = compressImageUseCase;
    }


    public RequestParams createRequestParams(String imagePath,String url,String param_name) {
        RequestParams requestParams = RequestParams.create();
        requestParams.putObject(IMAGE_PATH, imagePath);
        requestParams.putString(URL,url);
        requestParams.putString(PARAM_NAME,param_name);
        return requestParams;
    }
    @Override
    public Observable<ImageUploadResponse> createObservable(final RequestParams requestParams) {

        final String url = requestParams.getString(URL, null);

            return compressImageUseCase.createObservable(compressImageUseCase.createRequestParams(requestParams.getString(IMAGE_PATH, ""))).flatMap(new Func1<String, Observable<ImageUploadResponse>>() {
                @Override
                public Observable<ImageUploadResponse> call(String s) {
                    return repository.uploadImage(generateRequestImage(s, requestParams.getString(PARAM_NAME, "image")),url);
                }
            });

    }




    private MultipartBody.Part generateRequestImage(String pathFile,String param_name) {

        File file = new File(pathFile);
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);
        return MultipartBody.Part.createFormData(param_name, file.getName(), requestBody);

    }

}
