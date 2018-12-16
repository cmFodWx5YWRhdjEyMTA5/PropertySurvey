package com.softminesol.propertysurvey.survey.newPropertyEntry.di;

import com.softminesol.propertysurvey.survey.newPropertyEntry.data.net.NewServeyAPI;
import com.softminesol.propertysurvey.survey.newPropertyEntry.data.repository.SurveyFormSubmitRepository;
import com.softminesol.propertysurvey.survey.newPropertyEntry.data.repository.datasource.SubmitFormDataFactory;
import com.softminesol.propertysurvey.survey.newPropertyEntry.domain.ISurveyFormSubmitRepository;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by sandeep on 6/5/18.
 */
@Module
public class NewSurveyModule {
    @Provides
    NewServeyAPI provideLoginApi(Retrofit retrofit) {
        return retrofit.create(NewServeyAPI.class);
    }

    @Provides
    ISurveyFormSubmitRepository getSurveyOptionRepository(SubmitFormDataFactory submitFormDataFactory) {
        return new SurveyFormSubmitRepository(submitFormDataFactory);
    }


}
