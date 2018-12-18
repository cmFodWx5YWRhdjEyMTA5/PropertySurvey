package com.softminesol.propertysurvey.survey.apartmentEntry.di;

import com.softminesol.propertysurvey.survey.apartmentEntry.data.net.NewServeyAPI;
import com.softminesol.propertysurvey.survey.apartmentEntry.data.repository.ApartmentSurveyFormSubmitRepository;
import com.softminesol.propertysurvey.survey.apartmentEntry.data.repository.datasource.SubmitFormDataFactory;
import com.softminesol.propertysurvey.survey.apartmentEntry.domain.IApartmentSurveyFormSaveRepository;


import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by sandeep on 6/5/18.
 */
@Module
public class NewApartmentSurveyModule {
    @Provides
    NewServeyAPI provideLoginApi(Retrofit retrofit) {
        return retrofit.create(NewServeyAPI.class);
    }

    @Provides
    IApartmentSurveyFormSaveRepository getSaveSurveyOptionRepository(SubmitFormDataFactory submitFormDataFactory) {
        return new ApartmentSurveyFormSubmitRepository(submitFormDataFactory);
    }

}
