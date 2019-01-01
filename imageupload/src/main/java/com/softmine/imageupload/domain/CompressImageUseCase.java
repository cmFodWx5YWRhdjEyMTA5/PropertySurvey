package com.softmine.imageupload.domain;

import android.content.Context;
import android.os.Environment;

import java.io.File;

import javax.inject.Inject;

import frameworks.di.qualifier.ApplicationContext;
import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import id.zelory.compressor.Compressor;
import rx.Observable;

public class CompressImageUseCase extends UseCase<String> {
    public static final String IMAGE_PATH = "image_path";
    Context context;

    @Inject
    public CompressImageUseCase(@ApplicationContext Context context) {
        this.context = context;
    }

    RequestParams createRequestParams(String filePath) {
        RequestParams requestParams = RequestParams.create();
        requestParams.putString(IMAGE_PATH,filePath);
        return requestParams;
    }
    @Override
    public Observable<String> createObservable(RequestParams requestParams) {
        String imagePath = requestParams.getString(IMAGE_PATH,null);
        if(imagePath == null) {
            return null;
        }
        File file = new File(imagePath);
        File compressedImage = null;
        try {
            compressedImage = new Compressor(context)
                    .setDestinationDirectoryPath(Environment.getExternalStoragePublicDirectory(
                            Environment.DIRECTORY_PICTURES).getAbsolutePath())
                    .compressToFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Observable.just(compressedImage.getAbsolutePath());
    }
}
