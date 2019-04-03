package com.softminesol.survey_framework.localcachesync.domain;

import com.softmine.imageupload.domain.ImageUploadUseCase;
import com.softmine.imageupload.model.ImageUploadResponse;
import com.softminesol.propertysurvey.CommonBaseUrl;
import com.softminesol.survey_framework.survey.common.model.apartment.Owner;

import java.util.List;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;
import rx.functions.Func1;

public class OwnerPicUpdateUseCase  extends UseCase<List<Owner>> {
    ImageUploadUseCase imageListUploadSubmitUseCase;


    @Inject
    public OwnerPicUpdateUseCase(ImageUploadUseCase imageListUploadSubmitUseCase) {
        this.imageListUploadSubmitUseCase = imageListUploadSubmitUseCase;
    }

    public RequestParams createRequestParams(List<Owner> owners) {
      RequestParams requestParams = RequestParams.create();
      requestParams.putObject("owners",owners);
      return requestParams;
    }
    @Override
    public Observable<List<Owner>> createObservable(RequestParams requestParams) {
        List<Owner> owners = (List<Owner>) requestParams.getObject("owners");
        return Observable.from(owners).concatMap(new Func1<Owner, Observable<Owner>>() {
            @Override
            public Observable<Owner> call(final Owner owner) {
                List<String> imageUploadUrl = owner.getRegistryImagePath();
                return Observable.from(imageUploadUrl).concatMap(new Func1<String, Observable<Owner>>() {
                    @Override
                    public Observable<Owner> call(final String s) {
                        String url = CommonBaseUrl.BASE_URL + "person/uploadPersonImage";
                        String param_name = "personImage";
                        return imageListUploadSubmitUseCase.createObservable(imageListUploadSubmitUseCase.createRequestParams(s, url, param_name)).map(new Func1<ImageUploadResponse, Owner>() {
                            @Override
                            public Owner call(ImageUploadResponse imageUploadResponse) {
                                owner.getRegistryImagePath().remove(s);
                                owner.getRegistryImage().add(imageUploadResponse.getUploadResponseData().getImageId() + "");
                                return owner;
                            }
                        });
                    }
                });
            }
        }).toList();
    }

}

