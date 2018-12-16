package com.softminesol.propertysurvey.imageupload.domain.intractor;

import com.softminesol.propertysurvey.imageupload.domain.IImageUploadRepository;
import com.softminesol.propertysurvey.imageupload.model.ImageUploadResponse;

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
    IImageUploadRepository repository;

    @Inject
    public ImageUploadUseCase(IImageUploadRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<ImageUploadResponse> createObservable(RequestParams requestParams) {
        return repository.uploadImage(generateRequestImage(requestParams.getString(IMAGE_PATH, "")));
    }

    public Map<String, RequestBody> getParamsUploadImage(String pathFile) {
        Map<String, RequestBody> paramsUploadImage = new HashMap<>();

        File file = new File(pathFile);

        RequestBody fileToUpload = RequestBody.create(MediaType.parse("image/*"), file);

        paramsUploadImage.put("imgUploader", fileToUpload);

        return paramsUploadImage;
    }


    private MultipartBody.Part generateRequestImage(String pathFile) {

        File file = new File(pathFile);
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);

        return MultipartBody.Part.createFormData("imgUploader", file.getName(), requestBody);

    }

}
