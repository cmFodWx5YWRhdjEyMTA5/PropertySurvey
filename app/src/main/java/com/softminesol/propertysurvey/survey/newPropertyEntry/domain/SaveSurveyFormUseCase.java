package com.softminesol.propertysurvey.survey.newPropertyEntry.domain;


import com.softmine.imageupload.domain.ImageUploadUseCase;
import com.softmine.imageupload.model.ImageUploadResponse;
import com.softminesol.propertysurvey.CommonBaseUrl;
import com.softminesol.propertysurvey.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.propertysurvey.survey.common.model.property.SavePropertyRequest;

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
public class SaveSurveyFormUseCase extends UseCase<GetPropertySaveResponse> {

    private final ImageUploadUseCase imageUploadUseCase;
    ISurveyFormSaveRepository surveyFormSubmitRepository;

    @Inject
    public SaveSurveyFormUseCase(ISurveyFormSaveRepository surveyFormSubmitRepository,ImageUploadUseCase imageUploadUseCase) {
        this.surveyFormSubmitRepository = surveyFormSubmitRepository;
        this.imageUploadUseCase = imageUploadUseCase;
    }

    @Override
    public Observable<GetPropertySaveResponse> createObservable(final RequestParams requestParams) {

        final SavePropertyRequest formData = (SavePropertyRequest) requestParams.getObject("formdata");
                List<String> fileURIs = formData.getImagesList();
               return Observable.from(fileURIs).concatMap(new Func1<String, Observable<ImageUploadResponse>>() {
                    @Override
                    public Observable<ImageUploadResponse> call(String s) {
                        RequestParams requestParams1 = RequestParams.create();
                        requestParams1.putString(ImageUploadUseCase.IMAGE_PATH,s);
                        requestParams1.putString(ImageUploadUseCase.PARAM_NAME,"propertyImage");
                        requestParams1.putString(ImageUploadUseCase.URL,CommonBaseUrl.BASE_URL+"property/uploadPropertImage");
                        return imageUploadUseCase.createObservable(requestParams1);
                    }
                }).toList().flatMap(new Func1<List<ImageUploadResponse>, Observable<GetPropertySaveResponse>>() {
                    @Override
                    public Observable<GetPropertySaveResponse> call(List<ImageUploadResponse> imageUploadResponses) {
                        List<String> imageIdList = new ArrayList<>(imageUploadResponses.size());
                        for(ImageUploadResponse imageId:imageUploadResponses) {
                            imageIdList.add(imageId.getUploadResponseData().getImageId()+"");
                        }
                        formData.setImagesList(imageIdList);
                        return surveyFormSubmitRepository.submitCloudNewProperty(formData);
                    }
                });



        }

}
