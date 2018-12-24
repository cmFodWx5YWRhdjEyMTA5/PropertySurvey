package com.softminesol.propertysurvey.survey.apartmentEntry.domain;

import com.softmine.imageupload.domain.ImageUploadUseCase;
import com.softmine.imageupload.model.ImageUploadResponse;
import com.softminesol.propertysurvey.CommonBaseUrl;
import com.softminesol.propertysurvey.survey.common.model.apartment.Owner;
import com.softminesol.propertysurvey.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.propertysurvey.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.propertysurvey.survey.common.model.property.SavePropertyRequest;
import com.softminesol.propertysurvey.survey.newPropertyEntry.domain.ISurveyFormSaveRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by sandeep on 13/5/18.
 */
public class SaveApartmentSurveyFormUseCase extends UseCase<GetPropertySaveResponse> {

    private final ImageUploadUseCase imageUploadUseCase;
    IApartmentSurveyFormSaveRepository iApartmentSurveyFormSaveRepository;

    @Inject
    public SaveApartmentSurveyFormUseCase(IApartmentSurveyFormSaveRepository iApartmentSurveyFormSaveRepository, ImageUploadUseCase imageUploadUseCase) {
        this.iApartmentSurveyFormSaveRepository = iApartmentSurveyFormSaveRepository;
        this.imageUploadUseCase = imageUploadUseCase;
    }

    @Override
    public Observable<GetPropertySaveResponse> createObservable(final RequestParams requestParams) {
        final SaveApartmentRequest formData = (SaveApartmentRequest) requestParams.getObject("formdata");
        final List<String> fileURIs = formData.getApartmentImage();
        List<Owner> ownerList = formData.getOwners();
        if (ownerList.size() > 0) {
            return Observable.from(ownerList).concatMap(new Func1<Owner, Observable<Owner>>() {
                @Override
                public Observable<Owner> call(final Owner owner) {
                    List<String> registryImage = owner.getRegistryImage();
                    if (registryImage.size() <= 0) {
                        return Observable.just(owner);
                    } else
                        return Observable.from(registryImage).concatMap(new Func1<String, Observable<ImageUploadResponse>>() {
                            @Override
                            public Observable<ImageUploadResponse> call(String s) {
                                RequestParams requestParams1 = RequestParams.create();
                                requestParams1.putString(ImageUploadUseCase.IMAGE_PATH, s);
                                requestParams1.putString(ImageUploadUseCase.PARAM_NAME, "personImage");
                                requestParams1.putString(ImageUploadUseCase.URL, CommonBaseUrl.BASE_URL + "person/uploadPersonImage");
                                return imageUploadUseCase.createObservable(requestParams1);
                            }
                        }).toList().map(new Func1<List<ImageUploadResponse>, Owner>() {
                            @Override
                            public Owner call(List<ImageUploadResponse> imageUploadResponses) {
                                List<String> imageList = new ArrayList<>();
                                ;
                                for (ImageUploadResponse imageId : imageUploadResponses) {
                                    imageList.add(imageId.getUploadResponseData().getImageId() + "");
                                }
                                owner.setRegistryImage(imageList);
                                return owner;
                            }
                        });
                }
            }).toList().flatMap(new Func1<List<Owner>, Observable<GetPropertySaveResponse>>() {
                @Override
                public Observable<GetPropertySaveResponse> call(List<Owner> owners) {
                    return Observable.from(fileURIs).concatMap(new Func1<String, Observable<ImageUploadResponse>>() {
                        @Override
                        public Observable<ImageUploadResponse> call(String s) {
                            RequestParams requestParams1 = RequestParams.create();
                            requestParams1.putString(ImageUploadUseCase.IMAGE_PATH, s);
                            requestParams1.putString(ImageUploadUseCase.PARAM_NAME, "apartmentImage");
                            requestParams1.putString(ImageUploadUseCase.URL, CommonBaseUrl.BASE_URL + "apartment/uploadapartmentImage");
                            return imageUploadUseCase.createObservable(requestParams1);
                        }
                    }).toList().flatMap(new Func1<List<ImageUploadResponse>, Observable<GetPropertySaveResponse>>() {
                        @Override
                        public Observable<GetPropertySaveResponse> call(List<ImageUploadResponse> imageUploadResponses) {
                            List<String> imageIdList = new ArrayList<>(imageUploadResponses.size());
                            for (ImageUploadResponse imageId : imageUploadResponses) {
                                imageIdList.add(imageId.getUploadResponseData().getImageId() + "");
                            }
                            formData.setApartmentImage(imageIdList);
                            return iApartmentSurveyFormSaveRepository.submitCloudNewApartment(formData);
                        }
                    });
                }
            });
        } else {
            return Observable.from(fileURIs).concatMap(new Func1<String, Observable<ImageUploadResponse>>() {
                @Override
                public Observable<ImageUploadResponse> call(String s) {
                    RequestParams requestParams1 = RequestParams.create();
                    requestParams1.putString(ImageUploadUseCase.IMAGE_PATH, s);
                    requestParams1.putString(ImageUploadUseCase.PARAM_NAME, "apartmentImage");
                    requestParams1.putString(ImageUploadUseCase.URL, CommonBaseUrl.BASE_URL + "apartment/uploadapartmentImage");
                    return imageUploadUseCase.createObservable(requestParams1);
                }
            }).toList().flatMap(new Func1<List<ImageUploadResponse>, Observable<GetPropertySaveResponse>>() {
                @Override
                public Observable<GetPropertySaveResponse> call(List<ImageUploadResponse> imageUploadResponses) {
                    List<String> imageIdList = new ArrayList<>(imageUploadResponses.size());
                    for (ImageUploadResponse imageId : imageUploadResponses) {
                        imageIdList.add(imageId.getUploadResponseData().getImageId() + "");
                    }
                    formData.setApartmentImage(imageIdList);
                    return iApartmentSurveyFormSaveRepository.submitCloudNewApartment(formData);
                }
            });
        }


    }

}
