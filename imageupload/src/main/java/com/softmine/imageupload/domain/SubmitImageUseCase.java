package com.softmine.imageupload.domain;

import com.softmine.imageupload.model.ImageUploadResponse;
import com.softmine.imageupload.model.SubmitImagesBody;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;

/**
 * Created by sandeepgoyal on 13/05/18.
 */

public class SubmitImageUseCase extends UseCase<ImageUploadResponse> {
    private String BODY_DATA = "BODY_DATA";
    private IImageUploadRepository repository;

    public RequestParams createRequestParams(SubmitImagesBody submitImagesBody){
        RequestParams requestParams=RequestParams.create();
        requestParams.putObject(BODY_DATA, submitImagesBody);
        return requestParams;
    }

    @Inject
    public SubmitImageUseCase(IImageUploadRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<ImageUploadResponse> createObservable(RequestParams requestParams) {
        return repository.submitImages((SubmitImagesBody) requestParams.getObject(BODY_DATA));
    }


}
