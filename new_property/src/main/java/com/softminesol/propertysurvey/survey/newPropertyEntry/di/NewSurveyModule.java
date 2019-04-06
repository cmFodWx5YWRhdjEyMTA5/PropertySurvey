package com.softminesol.propertysurvey.survey.newPropertyEntry.di;

import com.softminesol.locations.locationmanager.data.source.api.PlaceApi;
import com.softminesol.locations.locationmanager.domain.PlaceRepository;
import com.softminesol.locations.locationmanager.repository.PlaceDataRepository;
import com.softminesol.locations.locationmanager.repository.PlaceDataStoreFactory;
import com.softminesol.propertysurvey.survey.apartmentEntry.data.repository.ApartmentSurveyFormSubmitRepository;
import com.softminesol.propertysurvey.survey.apartmentEntry.domain.IApartmentSurveyFormSaveRepository;
import com.softminesol.propertysurvey.survey.newPropertyEntry.data.net.NewServeyAPI;
import com.softminesol.propertysurvey.survey.newPropertyEntry.data.repository.SurveyFormSubmitRepository;
import com.softminesol.propertysurvey.survey.newPropertyEntry.data.repository.datasource.SubmitFormDataFactory;
import com.softminesol.propertysurvey.survey.newPropertyEntry.domain.ISurveyFormSaveRepository;
import com.softminesol.propertysurvey.survey.newPropertyEntry.domain.ISurveyFormSubmitRepository;
import com.softminesol.survey_framework.survey.common.di.SurveyModule;
import com.softminesol.survey_framework.survey.common.domain_luc.SurveyConstructionType;
import com.softminesol.survey_framework.survey.common.domain_luc.SurveyFloor;
import com.softminesol.survey_framework.survey.common.domain_luc.SurveyNonResidentCategory;
import com.softminesol.survey_framework.survey.common.domain_luc.SurveyOccupancyStatus;
import com.softminesol.survey_framework.survey.common.domain_luc.SurveyPropertyUsage;
import com.softminesol.survey_framework.survey.common.domain_luc.SurveyRespodentStatus;
import com.softminesol.survey_framework.survey.common.domain_luc.SurveySourceWaterUseCase;
import com.softminesol.survey_framework.survey.common.view.presenter.ApartmentInfoPresenter;

import dagger.Module;
import dagger.Provides;
import frameworks.utils.AdapterFactory;
import retrofit2.Retrofit;

/**
 * Created by sandeep on 6/5/18.
 */
@Module(includes = {SurveyModule.class})
public class NewSurveyModule {
    @Provides
    NewServeyAPI provideLoginApi(Retrofit retrofit) {
        return retrofit.create(NewServeyAPI.class);
    }

    @Provides
    com.softminesol.propertysurvey.survey.apartmentEntry.data.net.NewServeyAPI provideLoginApii(Retrofit retrofit) {
        return retrofit.create(com.softminesol.propertysurvey.survey.apartmentEntry.data.net.NewServeyAPI.class);
    }


    @Provides
    IApartmentSurveyFormSaveRepository getSaveSurveyOptionRepository(com.softminesol.propertysurvey.survey.apartmentEntry.data.repository.datasource.SubmitFormDataFactory submitFormDataFactory) {
        return new ApartmentSurveyFormSubmitRepository(submitFormDataFactory);
    }

    @Provides
    ISurveyFormSubmitRepository getSurveyOptionRepository(SubmitFormDataFactory submitFormDataFactory) {
        return new SurveyFormSubmitRepository(submitFormDataFactory);
    }
    @Provides
    ISurveyFormSaveRepository getSaveSurveyOptionRepository1(SubmitFormDataFactory submitFormDataFactory) {
        return new SurveyFormSubmitRepository(submitFormDataFactory);
    }

    @Provides
    PlaceRepository providePlaceRepository(PlaceDataStoreFactory placeDataStoreFactory) {
        return new PlaceDataRepository(placeDataStoreFactory);
    }

    @Provides
    PlaceApi providePlaceAPi(Retrofit retrofit) {
        return retrofit.create(PlaceApi.class);
    }

    @Provides
    ApartmentInfoPresenter getApartmentPresener (AdapterFactory adapterFactory,
                                                                       SurveyFloor surveyFloorListUseCase,
                                                                       SurveyPropertyUsage surveyPropertyUsage, SurveyNonResidentCategory surveyNonResidentCategory,
                                                                       SurveyRespodentStatus surveyRespodentStatus, SurveyOccupancyStatus surveyOccupancyStatus, SurveySourceWaterUseCase surveySourceWaterUseCase,
                                                                       SurveyConstructionType surveyConstructionType) {
        return new ApartmentInfoPresenter( adapterFactory,
                 surveyFloorListUseCase,
                 surveyPropertyUsage,  surveyNonResidentCategory,
                 surveyRespodentStatus,  surveyOccupancyStatus,  surveySourceWaterUseCase,
                 surveyConstructionType);
    }
}
