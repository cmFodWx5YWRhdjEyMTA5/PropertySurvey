package com.softminesol.survey_framework.survey.common.repository;

import com.softminesol.survey_framework.survey.common.domain.ISurveyOptionRepository;
import com.softminesol.survey_framework.survey.common.model.PropertyTypes;
import com.softminesol.survey_framework.survey.common.model.newmodel.BuildingAge;
import com.softminesol.survey_framework.survey.common.model.newmodel.Floors;
import com.softminesol.survey_framework.survey.common.model.newmodel.NonResidentalCategory;
import com.softminesol.survey_framework.survey.common.model.newmodel.OccupancyStatus;
import com.softminesol.survey_framework.survey.common.model.newmodel.PropertyUsage;
import com.softminesol.survey_framework.survey.common.model.newmodel.RespondentStatus;
import com.softminesol.survey_framework.survey.common.model.newmodel.SourceWater;
import com.softminesol.survey_framework.survey.common.repository.datasource.SurveyOptionFactory;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by sandeep on 6/5/18.
 */
public class SurveyOptionRepository implements ISurveyOptionRepository {
    SurveyOptionFactory surveyOptionFactory;

    @Inject
    public SurveyOptionRepository(SurveyOptionFactory surveyOptionFactory) {
        this.surveyOptionFactory = surveyOptionFactory;
    }






    @Override
    public Observable<PropertyTypes> getPropertyType() {
        return  surveyOptionFactory.getSurveyOptionCacheDataSource().getPropertyTypes().flatMap(new Func1<PropertyTypes, Observable<PropertyTypes>>() {
            @Override
            public Observable<PropertyTypes> call(PropertyTypes propertyTypes) {
                if(propertyTypes != null) {
                    return Observable.just(propertyTypes);
                }else {
                    return surveyOptionFactory.getSurveyOptionCloudDataSource().getPropertyTypes().doOnNext(new Action1<PropertyTypes>() {
                        @Override
                        public void call(PropertyTypes propertyTypes) {
                            surveyOptionFactory.getSurveyOptionCacheDataSource().savePropertyTypes(propertyTypes);
                        }
                    });
                }
            }
        });
    }

    @Override
    public Observable<PropertyUsage> getPropertyUsage() {
        return  surveyOptionFactory.getSurveyOptionCacheDataSource().getPropertyUsage().flatMap(new Func1<PropertyUsage, Observable<PropertyUsage>>() {
            @Override
            public Observable<PropertyUsage> call(PropertyUsage propertyTypes) {
                if(propertyTypes != null) {
                    return Observable.just(propertyTypes);
                }else {
                    return surveyOptionFactory.getSurveyOptionCloudDataSource().getPropertyUsage().doOnNext(new Action1<PropertyUsage>() {
                        @Override
                        public void call(PropertyUsage propertyTypes) {
                            surveyOptionFactory.getSurveyOptionCacheDataSource().savePropertyUsage(propertyTypes);
                        }
                    });
                }
            }
        });
    }

    @Override
    public Observable<RespondentStatus> getRespondentStatus() {
        return  surveyOptionFactory.getSurveyOptionCacheDataSource().getRespondentStatus().flatMap(new Func1<RespondentStatus, Observable<RespondentStatus>>() {
            @Override
            public Observable<RespondentStatus> call(RespondentStatus propertyTypes) {
                if(propertyTypes != null) {
                    return Observable.just(propertyTypes);
                }else {
                    return surveyOptionFactory.getSurveyOptionCloudDataSource().getRespondentStatus().doOnNext(new Action1<RespondentStatus>() {
                        @Override
                        public void call(RespondentStatus propertyTypes) {
                            surveyOptionFactory.getSurveyOptionCacheDataSource().saveRespondentStatus(propertyTypes);
                        }
                    });
                }
            }
        });
    }

    @Override
    public Observable<OccupancyStatus> getOccupancyStatus() {
        return  surveyOptionFactory.getSurveyOptionCacheDataSource().getOccupancyStatus().flatMap(new Func1<OccupancyStatus, Observable<OccupancyStatus>>() {
            @Override
            public Observable<OccupancyStatus> call(OccupancyStatus propertyTypes) {
                if(propertyTypes != null) {
                    return Observable.just(propertyTypes);
                }else {
                    return surveyOptionFactory.getSurveyOptionCloudDataSource().getOccupancyStatus().doOnNext(new Action1<OccupancyStatus>() {
                        @Override
                        public void call(OccupancyStatus propertyTypes) {
                            surveyOptionFactory.getSurveyOptionCacheDataSource().saveOccupancyStatus(propertyTypes);
                        }
                    });
                }
            }
        });
    }

    @Override
    public Observable<BuildingAge> getBuildingAge() {
        return  surveyOptionFactory.getSurveyOptionCacheDataSource().getBuildingAges().flatMap(new Func1<BuildingAge, Observable<BuildingAge>>() {
            @Override
            public Observable<BuildingAge> call(BuildingAge propertyTypes) {
                if(propertyTypes != null) {
                    return Observable.just(propertyTypes);
                }else {
                    return surveyOptionFactory.getSurveyOptionCloudDataSource().getBuildingAge().doOnNext(new Action1<BuildingAge>() {
                        @Override
                        public void call(BuildingAge propertyTypes) {
                            surveyOptionFactory.getSurveyOptionCacheDataSource().saveBuildingAge(propertyTypes);
                        }
                    });
                }
            }
        });
    }

    @Override
    public Observable<com.softminesol.survey_framework.survey.common.model.newmodel.ConstructionType> getConstructionType() {
        return  surveyOptionFactory.getSurveyOptionCacheDataSource().getConstructionType().flatMap(new Func1<com.softminesol.survey_framework.survey.common.model.newmodel.ConstructionType, Observable<com.softminesol.survey_framework.survey.common.model.newmodel.ConstructionType>>() {
            @Override
            public Observable<com.softminesol.survey_framework.survey.common.model.newmodel.ConstructionType> call(com.softminesol.survey_framework.survey.common.model.newmodel.ConstructionType propertyTypes) {
                if(propertyTypes != null) {
                    return Observable.just(propertyTypes);
                }else {
                    return surveyOptionFactory.getSurveyOptionCloudDataSource().getConstructionType1().doOnNext(new Action1<com.softminesol.survey_framework.survey.common.model.newmodel.ConstructionType>() {
                        @Override
                        public void call(com.softminesol.survey_framework.survey.common.model.newmodel.ConstructionType propertyTypes) {
                            surveyOptionFactory.getSurveyOptionCacheDataSource().saveConstructionType(propertyTypes);
                        }
                    });
                }
            }
        });
    }

    @Override
    public Observable<Floors> getFloors() {
        return  surveyOptionFactory.getSurveyOptionCacheDataSource().getFloors().flatMap(new Func1<Floors, Observable<Floors>>() {
            @Override
            public Observable<Floors> call(Floors propertyTypes) {
                if(propertyTypes != null) {
                    return Observable.just(propertyTypes);
                }else {
                    return surveyOptionFactory.getSurveyOptionCloudDataSource().getFloors().doOnNext(new Action1<Floors>() {
                        @Override
                        public void call(Floors propertyTypes) {
                            surveyOptionFactory.getSurveyOptionCacheDataSource().saveFloorse(propertyTypes);
                        }
                    });
                }
            }
        });
    }

    @Override
    public Observable<NonResidentalCategory> getNonResidentalCategory() {
        return  surveyOptionFactory.getSurveyOptionCacheDataSource().getNonResidentalCategorys().flatMap(new Func1<NonResidentalCategory, Observable<NonResidentalCategory>>() {
            @Override
            public Observable<NonResidentalCategory> call(NonResidentalCategory propertyTypes) {
                if(propertyTypes != null) {
                    return Observable.just(propertyTypes);
                }else {
                    return surveyOptionFactory.getSurveyOptionCloudDataSource().getNonResidentalCategorys().doOnNext(new Action1<NonResidentalCategory>() {
                        @Override
                        public void call(NonResidentalCategory propertyTypes) {
                            surveyOptionFactory.getSurveyOptionCacheDataSource().saveNonResidentalCategory(propertyTypes);
                        }
                    });
                }
            }
        });
    }

    @Override
    public Observable<SourceWater> getSourceWater() {
        return  surveyOptionFactory.getSurveyOptionCacheDataSource().getSourceWater().flatMap(new Func1<SourceWater, Observable<SourceWater>>() {
            @Override
            public Observable<SourceWater> call(SourceWater propertyTypes) {
                if(propertyTypes != null) {
                    return Observable.just(propertyTypes);
                }else {
                    return surveyOptionFactory.getSurveyOptionCloudDataSource().getSourceWater().doOnNext(new Action1<SourceWater>() {
                        @Override
                        public void call(SourceWater propertyTypes) {
                            surveyOptionFactory.getSurveyOptionCacheDataSource().saveSourceWatery(propertyTypes);
                        }
                    });
                }
            }
        });
    }
}
