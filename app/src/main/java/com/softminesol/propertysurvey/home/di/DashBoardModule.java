package com.softminesol.propertysurvey.home.di;

import android.content.Context;

import com.softminesol.propertysurvey.getToken.data.interceptor.GetTokenInterceptor;
import com.softminesol.propertysurvey.getToken.data.net.LoginAPIURL;
import com.softminesol.propertysurvey.imageupload.di.ImageUploadModule;
import com.softminesol.propertysurvey.imageupload.domain.intractor.ImageUploadUseCase;
import com.softminesol.propertysurvey.rolebase.data.net.RoleBaseAPI;
import com.softminesol.propertysurvey.rolebase.data.repository.RoleBaseRepository;
import com.softminesol.propertysurvey.rolebase.data.repository.datasource.RoleBaseDataFactory;
import com.softminesol.propertysurvey.rolebase.domain.IRoleBaseRepository;
import com.softminesol.propertysurvey.survey.common.di.SurveyModule;
import com.softminesol.propertysurvey.survey.common.realm.RealmPropertyDataMapper;

import dagger.Module;
import dagger.Provides;
import frameworks.di.module.net.NetModule;
import frameworks.di.qualifier.ApplicationContext;
import frameworks.network.interceptor.AppAuthInterceptor;
import frameworks.network.interceptor.ErrorResponseInterceptor;
import frameworks.network.model.BaseResponseError;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * Created by sandeep on 5/5/18.
 */
@Module(includes = {SurveyModule.class, ImageUploadModule.class})
public class DashBoardModule {
    @Provides
    RoleBaseAPI provideLoginApi(Retrofit retrofit) {
        return retrofit.create(RoleBaseAPI.class);
    }

}
