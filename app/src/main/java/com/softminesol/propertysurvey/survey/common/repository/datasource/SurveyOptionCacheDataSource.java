package com.softminesol.propertysurvey.survey.common.repository.datasource;

import android.content.Context;

import com.softminesol.propertysurvey.roomDb.PropertySurveyDB;
import com.softminesol.propertysurvey.roomDb.Type;
import com.softminesol.propertysurvey.survey.common.model.ConstructionType;
import com.softminesol.propertysurvey.survey.common.model.PropertyTypes;
import com.softminesol.propertysurvey.survey.common.model.newmodel.BuildingAge;
import com.softminesol.propertysurvey.survey.common.model.newmodel.Floors;
import com.softminesol.propertysurvey.survey.common.model.newmodel.NonResidentalCategory;
import com.softminesol.propertysurvey.survey.common.model.newmodel.OccupancyStatus;
import com.softminesol.propertysurvey.survey.common.model.newmodel.PropertyUsage;
import com.softminesol.propertysurvey.survey.common.model.newmodel.RespondentStatus;
import com.softminesol.propertysurvey.survey.common.model.newmodel.SourceWater;

import javax.inject.Inject;

import frameworks.di.qualifier.ApplicationContext;
import frameworks.utils.GsonFactory;
import rx.Observable;

public class SurveyOptionCacheDataSource {
     PropertySurveyDB propertySurveyDB;
     public static final String PROPERTY_TYPE = "property_type";
     public static final String PROPERTY_USAGE = "property_usage";
     public static final String RESPONDENT_STATUS = "respondent_status";
     public static final String OCCUPANCY_STATUS = "ocupancy_status";
     public static final String BUILDING_AGE = "building_age";
     public static final String CONSTRUCTION_TYPE = "construction_type";
     public static final String Floors = "floors";
     public static final String NON_RESIDENTAL_CATEGORY = "NonResidentalCategory";
     public static final String SOURCE_OF_WATER = "sourceOfWater";


    @Inject
    public SurveyOptionCacheDataSource(@ApplicationContext Context context) {
        this.propertySurveyDB = PropertySurveyDB.getInstance(context);
    }


    public Observable<PropertyTypes> getPropertyTypes() {
        Type type =propertySurveyDB.getapiDao().select(PROPERTY_TYPE);
        PropertyTypes propertyTypes = null;
                if(type != null) {
                    propertyTypes = GsonFactory.getGson().fromJson(type.getJson(),PropertyTypes.class);
                }
        return Observable.just(propertyTypes);
    }



    public void savePropertyTypes(PropertyTypes propertyTypes) {
        String json = GsonFactory.getGson().toJson(propertyTypes);
        Type type = new Type();
        type.setJson(json);
        type.setType(PROPERTY_TYPE);
        propertySurveyDB.getapiDao().insert(type);
    }

    public Observable<PropertyUsage> getPropertyUsage() {
        Type type =propertySurveyDB.getapiDao().select(PROPERTY_USAGE);
        PropertyUsage propertyTypes =  null;
        if(type != null) {
            propertyTypes = GsonFactory.getGson().fromJson(type.getJson(),PropertyUsage.class);
        }

        return Observable.just(propertyTypes);
    }



    public void savePropertyUsage(PropertyUsage propertyTypes) {
        String json = GsonFactory.getGson().toJson(propertyTypes);
        Type type = new Type();
        type.setJson(json);
        type.setType(PROPERTY_USAGE);
        propertySurveyDB.getapiDao().insert(type);
    }

    public Observable<RespondentStatus> getRespondentStatus() {
        Type type =propertySurveyDB.getapiDao().select(RESPONDENT_STATUS);
        RespondentStatus propertyTypes = null;
        if(type != null) {
            propertyTypes =GsonFactory.getGson().fromJson(type.getJson(),RespondentStatus.class);
        }

        return Observable.just(propertyTypes);
    }



    public void saveRespondentStatus(RespondentStatus propertyTypes) {
        String json = GsonFactory.getGson().toJson(propertyTypes);
        Type type = new Type();
        type.setJson(json);
        type.setType(RESPONDENT_STATUS);
        propertySurveyDB.getapiDao().insert(type);
    }

    public Observable<OccupancyStatus> getOccupancyStatus() {
        Type type =propertySurveyDB.getapiDao().select(OCCUPANCY_STATUS);
        OccupancyStatus propertyTypes = null;

        if(type != null) {
            propertyTypes = GsonFactory.getGson().fromJson(type.getJson(),OccupancyStatus.class);
        }

        return Observable.just(propertyTypes);
    }



    public void saveOccupancyStatus(OccupancyStatus propertyTypes) {
        String json = GsonFactory.getGson().toJson(propertyTypes);
        Type type = new Type();
        type.setJson(json);
        type.setType(OCCUPANCY_STATUS);
        propertySurveyDB.getapiDao().insert(type);
    }

    public Observable<BuildingAge> getBuildingAges() {
        Type type =propertySurveyDB.getapiDao().select(BUILDING_AGE);
        BuildingAge propertyTypes = null;
        if(type != null) {
            propertyTypes =GsonFactory.getGson().fromJson(type.getJson(),BuildingAge.class);
        }
        return Observable.just(propertyTypes);
    }



    public void saveBuildingAge(BuildingAge propertyTypes) {
        String json = GsonFactory.getGson().toJson(propertyTypes);
        Type type = new Type();
        type.setJson(json);
        type.setType(BUILDING_AGE);
        propertySurveyDB.getapiDao().insert(type);
    }

    public Observable<com.softminesol.propertysurvey.survey.common.model.newmodel.ConstructionType> getConstructionType() {
        Type type =propertySurveyDB.getapiDao().select(CONSTRUCTION_TYPE);
        com.softminesol.propertysurvey.survey.common.model.newmodel.ConstructionType propertyTypes = null;
        if(type!=null) {
            propertyTypes = GsonFactory.getGson().fromJson(type.getJson(), com.softminesol.propertysurvey.survey.common.model.newmodel.ConstructionType.class);
        }
        return Observable.just(propertyTypes);
    }



    public void saveConstructionType(com.softminesol.propertysurvey.survey.common.model.newmodel.ConstructionType propertyTypes) {
        String json = GsonFactory.getGson().toJson(propertyTypes);
        Type type = new Type();
        type.setJson(json);
        type.setType(CONSTRUCTION_TYPE);
        propertySurveyDB.getapiDao().insert(type);
    }

    public Observable<Floors> getFloors() {
        Type type =propertySurveyDB.getapiDao().select(Floors);
        Floors propertyTypes = null;
        if(type!=null) {
            propertyTypes = GsonFactory.getGson().fromJson(type.getJson(),Floors.class);
        }
        return Observable.just(propertyTypes);
    }



    public void saveFloorse(Floors propertyTypes) {
        String json = GsonFactory.getGson().toJson(propertyTypes);
        Type type = new Type();
        type.setJson(json);
        type.setType(Floors);
        propertySurveyDB.getapiDao().insert(type);
    }

    public Observable<NonResidentalCategory> getNonResidentalCategorys() {
        Type type =propertySurveyDB.getapiDao().select(NON_RESIDENTAL_CATEGORY);
        NonResidentalCategory propertyTypes = null;
        if(type != null) {
            propertyTypes = GsonFactory.getGson().fromJson(type.getJson(),NonResidentalCategory.class);
        }
        return Observable.just(propertyTypes);
    }



    public void saveNonResidentalCategory(NonResidentalCategory propertyTypes) {
        String json = GsonFactory.getGson().toJson(propertyTypes);
        Type type = new Type();
        type.setJson(json);
        type.setType(NON_RESIDENTAL_CATEGORY);
        propertySurveyDB.getapiDao().insert(type);
    }


    public Observable<SourceWater> getSourceWater() {
        Type type =propertySurveyDB.getapiDao().select(SOURCE_OF_WATER);
        SourceWater propertyTypes = null;
        if(type != null) {
            propertyTypes = GsonFactory.getGson().fromJson(type.getJson(), SourceWater.class);
        }
        return Observable.just(propertyTypes);
    }



    public void saveSourceWatery(SourceWater propertyTypes) {
        String json = GsonFactory.getGson().toJson(propertyTypes);
        Type type = new Type();
        type.setJson(json);
        type.setType(SOURCE_OF_WATER);
        propertySurveyDB.getapiDao().insert(type);
    }


}
