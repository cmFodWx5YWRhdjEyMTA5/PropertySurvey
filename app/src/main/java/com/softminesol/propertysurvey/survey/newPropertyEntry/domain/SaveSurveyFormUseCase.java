package com.softminesol.propertysurvey.survey.newPropertyEntry.domain;


import com.softmine.imageupload.domain.ImageUploadUseCase;
import com.softminesol.propertysurvey.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.propertysurvey.survey.common.model.property.SavePropertyRequest;

import java.util.List;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;


/**
 * Created by sandeep on 13/5/18.
 */
public class SaveSurveyFormUseCase extends UseCase<GetPropertySaveResponse> {

    private final ImageUploadUseCase imageUploadUseCase;
    ISurveyFormSaveRepository surveyFormSubmitRepository;

    @Inject
    public SaveSurveyFormUseCase(ISurveyFormSaveRepository surveyFormSubmitRepository, ImageUploadUseCase imageUploadUseCase) {
        this.surveyFormSubmitRepository = surveyFormSubmitRepository;
        this.imageUploadUseCase = imageUploadUseCase;
    }

    @Override
    public Observable<GetPropertySaveResponse> createObservable(final RequestParams requestParams) {

        final SavePropertyRequest formData = (SavePropertyRequest) requestParams.getObject("formdata");
        List<String> fileURIs = formData.getImagesList();
        return surveyFormSubmitRepository.submitCloudNewProperty(formData);
      }

}
