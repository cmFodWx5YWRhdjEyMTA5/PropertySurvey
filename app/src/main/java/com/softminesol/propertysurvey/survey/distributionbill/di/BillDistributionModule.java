package com.softminesol.propertysurvey.survey.distributionbill.di;

import com.softminesol.propertysurvey.survey.distributionbill.data.net.BillDistributionAPI;
import com.softminesol.propertysurvey.survey.distributionbill.data.repository.BillDistributionRepository;
import com.softminesol.propertysurvey.survey.distributionbill.data.repository.datasource.BillDistributionFactory;
import com.softminesol.propertysurvey.survey.distributionbill.domain.IBillDistributionRepository;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by sandeep on 6/5/18.
 */
@Module
public class BillDistributionModule {
    @Provides
    BillDistributionAPI provideLoginApi(Retrofit retrofit) {
        return retrofit.create(BillDistributionAPI.class);
    }

    @Provides
    IBillDistributionRepository getSurveyOptionRepository(BillDistributionFactory billDistributionFactory) {
        return new BillDistributionRepository(billDistributionFactory);
    }


}
