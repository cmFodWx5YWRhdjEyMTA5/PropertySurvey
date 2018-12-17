package com.softminesol.propertysurvey.survey.newPropertyEntry.domain;

import com.softminesol.propertysurvey.GlobalConfig;
import com.softminesol.propertysurvey.imageupload.domain.intractor.ImageUploadUseCase;
import com.softminesol.propertysurvey.imageupload.model.ImageUploadResponse;
import com.softminesol.propertysurvey.survey.common.model.formData.FloorDetailsItem;
import com.softminesol.propertysurvey.survey.common.model.formData.FormData;
import com.softminesol.propertysurvey.survey.common.model.property.GetPropertySaveResponse;
import com.softminesol.propertysurvey.survey.common.model.property.SavePropertyRequest;

import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import frameworks.network.usecases.RequestParams;
import frameworks.network.usecases.UseCase;
import rx.Observable;
import rx.functions.Action1;

import static com.softminesol.propertysurvey.imageupload.domain.intractor.ImageUploadUseCase.IMAGE_PATH;

/**
 * Created by sandeep on 13/5/18.
 */
public class SaveSurveyFormUseCase extends UseCase<GetPropertySaveResponse> {

    ISurveyFormSaveRepository surveyFormSubmitRepository;

    @Inject
    public SaveSurveyFormUseCase(ISurveyFormSaveRepository surveyFormSubmitRepository) {
        this.surveyFormSubmitRepository = surveyFormSubmitRepository;
    }

    @Override
    public Observable<GetPropertySaveResponse> createObservable(RequestParams requestParams) {
        SavePropertyRequest formData = (SavePropertyRequest) requestParams.getObject("formdata");
                return surveyFormSubmitRepository.submitCloudNewProperty(formData);

        }

}
