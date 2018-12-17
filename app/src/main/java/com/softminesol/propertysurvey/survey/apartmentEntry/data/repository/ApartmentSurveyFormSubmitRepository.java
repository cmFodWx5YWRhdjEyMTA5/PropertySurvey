package com.softminesol.propertysurvey.survey.apartmentEntry.data.repository;

import com.softminesol.propertysurvey.survey.apartmentEntry.data.repository.datasource.SubmitFormDataFactory;
import com.softminesol.propertysurvey.survey.apartmentEntry.domain.IApartmentSurveyFormSaveRepository;
import com.softminesol.propertysurvey.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.propertysurvey.survey.common.model.property.GetPropertySaveResponse;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by sandeep on 13/5/18.
 */
public class ApartmentSurveyFormSubmitRepository implements IApartmentSurveyFormSaveRepository {
    SubmitFormDataFactory submitFormDataFactory;

    @Inject
    public ApartmentSurveyFormSubmitRepository(SubmitFormDataFactory surveyFormSubmitRepository) {
        this.submitFormDataFactory = surveyFormSubmitRepository;
    }


    @Override
    public Observable<GetPropertySaveResponse> submitCloudNewApartment(final SaveApartmentRequest formData) {
        return  submitFormDataFactory.getCloudSubmitFomData().submitCloudNewApartment(formData).doOnError(new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                submitCloudNewApartment(formData);
            }
        });
    }
}
