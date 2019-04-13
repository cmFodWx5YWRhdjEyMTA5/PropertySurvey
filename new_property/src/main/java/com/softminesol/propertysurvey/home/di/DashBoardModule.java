package com.softminesol.propertysurvey.home.di;

import com.softminesol.survey_framework.rolebase.data.net.RoleBaseAPI;
import com.softminesol.survey_framework.survey.common.di.SurveyModule;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by sandeep on 5/5/18.
 */
@Module(includes = {SurveyModule.class})
public class DashBoardModule {
    @Provides
    RoleBaseAPI provideLoginApi(Retrofit retrofit) {
        return retrofit.create(RoleBaseAPI.class);
    }

}
