package com.softmine.imageupload.domain;


import com.softmine.imageupload.model.ImageUploadResponse;
import com.softmine.imageupload.model.SubmitImagesBody;
import com.softmine.imageupload.model.SubmitImagesFormData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import retrofit2.http.Url;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by sandeepgoyal on 13/05/18.
 */

public class ImageListUploadSubmitUseCase extends UseCase<List<String>> {
    private final String IMAGE_PATHS = "IMAGE_PATHS";
    public static String URL = "URL";
    public static String PARAM_NAME = "PARAM_NAME";
    private final ImageUploadUseCase imageUploadUseCase;


    public RequestParams createRequestParams(List<String> paths,String url,String param_name) {
        RequestParams requestParams = RequestParams.create();
        requestParams.putObject(IMAGE_PATHS, paths);
        requestParams.putString(URL,url);
        requestParams.putString(PARAM_NAME,param_name);
        return requestParams;
    }


    @Inject
    public ImageListUploadSubmitUseCase(ImageUploadUseCase imageUploadUseCase) {
        this.imageUploadUseCase = imageUploadUseCase;
    }

    @Override
    public Observable<List<String>> createObservable(final RequestParams requestParams) {
        ArrayList<String> filePaths = (ArrayList<String>) requestParams.getObject(IMAGE_PATHS);
        requestParams.getParameters().remove(IMAGE_PATHS);
        if (filePaths == null || filePaths.size() == 0)
            return null;
        else {
            return Observable.from(filePaths).concatMap(new Func1<String, Observable<String>>() {
                @Override
                public Observable<String> call(String filePath) {
                    RequestParams requestParams1 =  imageUploadUseCase.createRequestParams(filePath,requestParams.getString(URL,null),requestParams.getString(PARAM_NAME,null));
                    return imageUploadUseCase.createObservable(requestParams1).map(new Func1<ImageUploadResponse, String>() {
                        @Override
                        public String call(ImageUploadResponse imageUploadResponse) {
                            return imageUploadResponse.getUploadResponseData().getImageId()+"";
                        }
                    });
                }
            }).toList();
        }
    }


}
