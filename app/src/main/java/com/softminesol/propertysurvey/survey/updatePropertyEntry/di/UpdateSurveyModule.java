package com.softminesol.propertysurvey.survey.updatePropertyEntry.di;

import com.softminesol.propertysurvey.survey.newPropertyEntry.data.repository.SurveyFormSubmitRepository;
import com.softminesol.propertysurvey.survey.newPropertyEntry.data.repository.datasource.SubmitFormDataFactory;
import com.softminesol.propertysurvey.survey.newPropertyEntry.domain.ISurveyFormSubmitRepository;
import com.softminesol.propertysurvey.survey.updatePropertyEntry.data.net.UpdateServeyAPI;
import com.softminesol.propertysurvey.survey.updatePropertyEntry.data.repository.UpdateFormSubmitRepository;
import com.softminesol.propertysurvey.survey.updatePropertyEntry.data.repository.datasource.UpdateFormDataFactory;
import com.softminesol.propertysurvey.survey.updatePropertyEntry.domain.ISurveyFormUpdateRepository;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by sandeep on 6/5/18.
 */
@Module
public class UpdateSurveyModule {
    @Provides
    UpdateServeyAPI provideLoginApi(Retrofit retrofit) {
        return retrofit.create(UpdateServeyAPI.class);
    }

    @Provides
    ISurveyFormUpdateRepository getSurveyOptionRepository(UpdateFormDataFactory updateFormDataFactory) {
        return new UpdateFormSubmitRepository(updateFormDataFactory);
    }


}
