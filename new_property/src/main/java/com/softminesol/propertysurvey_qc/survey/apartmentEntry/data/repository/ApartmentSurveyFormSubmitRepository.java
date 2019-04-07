package com.softminesol.propertysurvey_qc.survey.apartmentEntry.data.repository;

import com.softminesol.propertysurvey_qc.survey.apartmentEntry.data.repository.datasource.SubmitFormDataFactory;
import com.softminesol.propertysurvey_qc.survey.apartmentEntry.domain.IApartmentSurveyFormSaveRepository;
import com.softminesol.survey_framework.survey.common.model.apartment.Owner;
import com.softminesol.survey_framework.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.survey_framework.survey.common.model.property.GetPropertySaveResponse;

import java.util.List;

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


    public Observable<GetPropertySaveResponse> submitCacheNewApartment(final SaveApartmentRequest formData) {
        return submitFormDataFactory.getCacheSubmitFormData().submitFormData(formData);
    }

    @Override
    public Observable<List<SaveApartmentRequest>> getDraftedApartmentItems() {
        return submitFormDataFactory.getCacheSubmitFormData().getDraftedApartments();
    }

    @Override
    public Observable<GetPropertySaveResponse> submitCloudNewApartment(final SaveApartmentRequest formData) {
        List<Owner> ownerList = formData.getOwners();
        for(Owner owner: ownerList) {
            if(owner.getRegistryImagePath().size()>0) {
                submitCacheNewApartment(formData);
                return Observable.error(new Throwable("Unable to update to server"));
            }
        }

        if(formData.getApartmentImagepath().size()>0) {
            submitCacheNewApartment(formData);
            return Observable.error(new Throwable("Unable to update to server"));
        }else if(formData.getGisId()== null) {
            submitCacheNewApartment(formData);
            return Observable.error(new Throwable("Unable to update to server"));
        } else{
            return submitFormDataFactory.getCloudSubmitFomData().submitCloudNewApartment(formData).doOnError(new Action1<Throwable>() {
                @Override
                public void call(Throwable throwable) {
                    submitCacheNewApartment(formData);
                }
            });
        }
    }
}
