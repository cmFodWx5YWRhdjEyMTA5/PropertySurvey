package com.softminesol.propertysurvey.survey.common.di;

import android.content.Context;

import com.softminesol.propertysurvey.survey.cloudsync.DistributionFormScope;
import com.softminesol.propertysurvey.survey.cloudsync.DistributionFormSync;
import com.softminesol.propertysurvey.survey.cloudsync.NewFormSync;
import com.softminesol.propertysurvey.survey.cloudsync.NewPropertyScope;
import com.softminesol.propertysurvey.survey.cloudsync.OLDProperyScope;
import com.softminesol.propertysurvey.survey.cloudsync.OldFormSync;
import com.softminesol.propertysurvey.survey.cloudsync.SyncManager;
import com.softminesol.propertysurvey.survey.common.domain.ISurveyOptionRepository;
import com.softminesol.propertysurvey.survey.common.net.SurveyAPI;
import com.softminesol.propertysurvey.survey.common.net.SurveyAPIURL;
import com.softminesol.propertysurvey.survey.common.realm.RealmPropertyDataMapper;
import com.softminesol.propertysurvey.survey.common.repository.SurveyOptionRepository;
import com.softminesol.propertysurvey.survey.common.repository.datasource.SurveyOptionCloudDataSource;
import com.softminesol.propertysurvey.survey.common.repository.datasource.SurveyOptionFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import frameworks.di.qualifier.ApplicationContext;
import frameworks.network.interceptor.AppAuthInterceptor;
import frameworks.network.interceptor.ErrorResponseInterceptor;
import frameworks.network.model.BaseResponseError;
import frameworks.utils.GsonFactory;
import okhttp3.Connection;
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
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(appAuthInterceptor)
                .addInterceptor(new ErrorResponseInterceptor(BaseResponseError.class))
                .build();
    }


    @Provides
    RealmPropertyDataMapper realmPropertyDataMapper(@ApplicationContext Context context) {
        return RealmPropertyDataMapper.getInstance(context);
    }


}
