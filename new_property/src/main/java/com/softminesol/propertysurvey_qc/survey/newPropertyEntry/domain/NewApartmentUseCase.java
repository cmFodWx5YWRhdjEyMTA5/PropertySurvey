package com.softminesol.propertysurvey_qc.survey.newPropertyEntry.domain;

import com.softmine.imageupload.domain.ImageUploadUseCase;
import com.softmine.imageupload.model.ImageUploadResponse;
import com.softminesol.propertysurvey_qc.CommonBaseUrl;
import com.softminesol.propertysurvey_qc.survey.apartmentEntry.domain.SaveApartmentSurveyFormUseCase;
import com.softminesol.survey_framework.localcachesync.data.SurveyApartmentOfflineRepository;
import com.softminesol.survey_framework.survey.common.model.apartment.Owner;
import com.softminesol.survey_framework.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.survey_framework.survey.common.model.property.GetPropertySaveResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class NewApartmentUseCase extends UseCase<List<GetPropertySaveResponse>> {
    ImageUploadUseCase imageListUploadSubmitUseCase;
    SurveyApartmentOfflineRepository iSurveyOfflineRepository;
    SaveApartmentSurveyFormUseCase saveSurveyFormUseCase;
    OwnerPicUpdateUseCase ownerPicUpdateUseCase;


    @Inject
    public NewApartmentUseCase(ImageUploadUseCase imageListUploadSubmitUseCase, SurveyApartmentOfflineRepository iSurveyOfflineRepository,
                               SaveApartmentSurveyFormUseCase saveSurveyFormUseCase,OwnerPicUpdateUseCase ownerPicUpdateUseCase) {
        this.imageListUploadSubmitUseCase = imageListUploadSubmitUseCase;
        this.iSurveyOfflineRepository = iSurveyOfflineRepository;
        this.saveSurveyFormUseCase = saveSurveyFormUseCase;
        this.ownerPicUpdateUseCase = ownerPicUpdateUseCase;
    }

    @Override
    public Observable<List<GetPropertySaveResponse>> createObservable(RequestParams requestParams) {
        return Observable.from(iSurveyOfflineRepository.getGISApartments()).concatMap(new Func1<SaveApartmentRequest, Observable<GetPropertySaveResponse>>() {
            @Override
            public Observable<GetPropertySaveResponse> call(final SaveApartmentRequest saveApartmentRequest) {
                List<Owner> owners = saveApartmentRequest.getOwners();
                ownerPicUpdateUseCase.createObservable(ownerPicUpdateUseCase.createRequestParams(owners)).doOnNext(new Action1<List<Owner>>() {
                    @Override
                    public void call(List<Owner> owners) {
                        saveApartmentRequest.setOwners(owners);
                    }
                });
                final List<String> imagePathList = new ArrayList<>(saveApartmentRequest.getApartmentImagepath());
                if (imagePathList.size() > 0) {
                    return Observable.from(imagePathList).concatMap(new Func1<String, Observable<SaveApartmentRequest>>() {
                        @Override
                        public Observable<SaveApartmentRequest> call(final String s) {
                            String url = CommonBaseUrl.BASE_URL + "apartment/uploadapartmentImage";
                            String param_name = "apartmentImage";
                            return imageListUploadSubmitUseCase.createObservable(imageListUploadSubmitUseCase.createRequestParams(s, url, param_name))
                                    .map(new Func1<ImageUploadResponse, SaveApartmentRequest>() {
                                @Override
                                public SaveApartmentRequest call(ImageUploadResponse imageUploadResponse) {
                                        saveApartmentRequest.getApartmentImagepath().remove(s);
                                    if(imageUploadResponse != null) {
                                        saveApartmentRequest.getApartmentImage().add(imageUploadResponse.getUploadResponseData().getImageId() + "");
                                    }
                                    return saveApartmentRequest;
                                }
                            });
                        }
                    }).flatMap(new Func1<SaveApartmentRequest, Observable<GetPropertySaveResponse>>() {
                        @Override
                        public Observable<GetPropertySaveResponse> call(SaveApartmentRequest savePropertyRequest) {
                            return updateToServer(savePropertyRequest);
                        }
                    });

                } else {
                    return updateToServer(saveApartmentRequest);
                }
            }
        }).toList();
    }

    public Observable<GetPropertySaveResponse> updateToServer(final SaveApartmentRequest saveApartmentRequest) {
        return saveSurveyFormUseCase.createObservable(saveSurveyFormUseCase.createRequestParams(saveApartmentRequest)).doOnNext(new Action1<GetPropertySaveResponse>() {
            @Override
            public void call(GetPropertySaveResponse getPropertySaveResponse) {
                iSurveyOfflineRepository.deleteSavedApartment(saveApartmentRequest);
            }
        });
    }


}

