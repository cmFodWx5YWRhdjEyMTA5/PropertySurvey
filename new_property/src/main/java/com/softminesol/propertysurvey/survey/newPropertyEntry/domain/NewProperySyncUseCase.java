package com.softminesol.propertysurvey.survey.newPropertyEntry.domain;

import com.softmine.imageupload.domain.ImageUploadUseCase;
import com.softmine.imageupload.model.ImageUploadResponse;
import com.softminesol.survey_framework.CommonBaseUrl;
import com.softminesol.survey_framework.localcachesync.data.SurveyPropertyOfflineRepository;
import com.softminesol.survey_framework.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.survey_framework.survey.common.model.property.SavePropertyRequest;
import com.softminesol.propertysurvey.survey.newPropertyEntry.domain.SaveSurveyFormUseCase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class NewProperySyncUseCase extends UseCase<List<String>> {
    ImageUploadUseCase imageListUploadSubmitUseCase;
    SurveyPropertyOfflineRepository iSurveyOfflineRepository;
    SaveSurveyFormUseCase saveSurveyFormUseCase;


    @Inject
    public NewProperySyncUseCase(ImageUploadUseCase imageListUploadSubmitUseCase, SurveyPropertyOfflineRepository iSurveyOfflineRepository, SaveSurveyFormUseCase saveSurveyFormUseCase) {
        this.imageListUploadSubmitUseCase = imageListUploadSubmitUseCase;
        this.iSurveyOfflineRepository = iSurveyOfflineRepository;
        this.saveSurveyFormUseCase = saveSurveyFormUseCase;
    }

    @Override
    public Observable<List<String>> createObservable(RequestParams requestParams) {
        return Observable.from(iSurveyOfflineRepository.getSaveProperty()).concatMap(new Func1<SavePropertyRequest, Observable<GetPropertySaveResponse>>() {
            @Override
            public Observable<GetPropertySaveResponse> call(final SavePropertyRequest savePropertyRequest) {
                final List<String> imagePathList = new ArrayList<>(savePropertyRequest.getImagePathList());

                if (imagePathList != null && imagePathList.size() > 0) {
                    return Observable.from(imagePathList).concatMap(new Func1<String, Observable<GetPropertySaveResponse>>() {
                        @Override
                        public Observable<GetPropertySaveResponse> call(final String s) {
                            String url = CommonBaseUrl.BASE_URL + "property/uploadPropertImage";
                            String param_name = "propertyImage";
                            return imageListUploadSubmitUseCase.createObservable(imageListUploadSubmitUseCase.createRequestParams(s, url, param_name)).map(new Func1<ImageUploadResponse, SavePropertyRequest>() {
                                @Override
                                public SavePropertyRequest call(ImageUploadResponse imageUploadResponse) {
                                        savePropertyRequest.getImagePathList().remove(s);
                                    if(imageUploadResponse != null) {
                                        savePropertyRequest.getImagesList().add(imageUploadResponse.getUploadResponseData().getImageId() + "");
                                    }
                                    return savePropertyRequest;
                                }
                            }).flatMap(new Func1<SavePropertyRequest, Observable<GetPropertySaveResponse>>() {
                                @Override
                                public Observable<GetPropertySaveResponse> call(SavePropertyRequest savePropertyRequest) {
                                    return updateToServer(savePropertyRequest);
                                }
                            });
                        }
                    });

                } else {
                    return updateToServer(savePropertyRequest);
                }


            }
        }).map(new Func1<GetPropertySaveResponse, String>() {
            @Override
            public String call(GetPropertySaveResponse getPropertySaveResponse) {
                return getPropertySaveResponse.getGisId();
            }
        }).toList();
    }

    public Observable<GetPropertySaveResponse> updateToServer(final SavePropertyRequest savePropertyRequest) {
        return saveSurveyFormUseCase.createObservable(saveSurveyFormUseCase.createRequestParams(savePropertyRequest)).doOnNext(new Action1<GetPropertySaveResponse>() {
            @Override
            public void call(GetPropertySaveResponse getPropertySaveResponse) {
                iSurveyOfflineRepository.deleteProeprtyrRequest(savePropertyRequest);
                iSurveyOfflineRepository.updateGSID(savePropertyRequest.getId(), getPropertySaveResponse.getGisId());
            }
        });
    }
}

