package com.softminesol.propertysurvey.survey.common.di;

import com.softmine.imageupload.data.net.ImageUploadAPI;
import com.softmine.imageupload.data.repository.ImageUploadRepository;
import com.softmine.imageupload.data.repository.datasource.ImageUploadFactory;
import com.softmine.imageupload.domain.IImageUploadRepository;
import com.softminesol.propertysurvey.survey.apartmentEntry.data.net.NewServeyAPI;
import com.softminesol.propertysurvey.survey.apartmentEntry.data.repository.ApartmentSurveyFormSubmitRepository;
import com.softminesol.propertysurvey.survey.apartmentEntry.data.repository.datasource.SubmitFormDataFactory;
import com.softminesol.propertysurvey.survey.apartmentEntry.domain.IApartmentSurveyFormSaveRepository;
import com.softminesol.propertysurvey.survey.common.domain.ISurveyOptionRepository;
import com.softminesol.propertysurvey.survey.common.net.SurveyAPI;
import com.softminesol.propertysurvey.survey.common.net.SurveyAPIURL;
import com.softminesol.propertysurvey.survey.common.repository.SurveyOptionRepository;
import com.softminesol.propertysurvey.survey.common.repository.datasource.SurveyOptionCloudDataSource;
import com.softminesol.propertysurvey.survey.common.repository.datasource.SurveyOptionFactory;

import dagger.Module;
import dagger.Provides;
import frameworks.network.interceptor.AppAuthInterceptor;
import frameworks.network.interceptor.ErrorResponseInterceptor;
import frameworks.network.model.BaseResponseError;
import frameworks.utils.GsonFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sandeep on 6/5/18.
 */
@Module
public class SurveyModule {

    @Provides
    NewServeyAPI provideNewLoginApi(Retrofit retrofit) {
        return retrofit.create(NewServeyAPI.class);
    }

    @Provides
    IApartmentSurveyFormSaveRepository getSaveSurveyOptionRepository(SubmitFormDataFactory submitFormDataFactory) {
        return new ApartmentSurveyFormSubmitRepository(submitFormDataFactory);
    }
    @Provides
    SurveyAPI provideLoginApi(Retrofit retrofit) {
        return retrofit.create(SurveyAPI.class);
    }


    @Provides
    ISurveyOptionRepository getSurveyOptionRepository(SurveyOptionFactory surveyOptionFactory) {
        return new SurveyOptionRepository(surveyOptionFactory);
    }


    @Provides
    SurveyOptionCloudDataSource getSuveyOptionCloudSource(SurveyAPI surveyAPI) {
        return new SurveyOptionCloudDataSource(surveyAPI);
    }


    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient,
                             Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder.baseUrl(SurveyAPIURL.BASE_URL).addConverterFactory(GsonConverterFactory.create(GsonFactory.getGson())).client(okHttpClient).build();
    }

    @Provides
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, AppAuthInterceptor appAuthInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(appAuthInterceptor)
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(new ErrorResponseInterceptor(BaseResponseError.class))
                .build();
    }



    @Provides
    IImageUploadRepository getImageUploadRepository(ImageUploadFactory imageUploadFactory) {
        return new ImageUploadRepository(imageUploadFactory);
    }

    @Provides
    ImageUploadAPI provideImageUploadApi(Retrofit retrofit) {
        return retrofit.create(ImageUploadAPI.class);
    }

}
