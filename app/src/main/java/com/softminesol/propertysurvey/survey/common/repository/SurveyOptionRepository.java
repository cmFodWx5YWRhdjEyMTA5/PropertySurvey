package com.softminesol.propertysurvey.survey.common.repository;

import com.softminesol.propertysurvey.survey.common.domain.ISurveyOptionRepository;
import com.softminesol.propertysurvey.survey.common.model.AreaType;
import com.softminesol.propertysurvey.survey.common.model.ColonyList;
import com.softminesol.propertysurvey.survey.common.model.ConstructionType;
import com.softminesol.propertysurvey.survey.common.model.FloorsList;
import com.softminesol.propertysurvey.survey.common.model.MeasurementUnitList;
import com.softminesol.propertysurvey.survey.common.model.OLDPropertyUIDS;
import com.softminesol.propertysurvey.survey.common.model.OwnerShipList;
import com.softminesol.propertysurvey.survey.common.model.PropertyCategoryList;
import com.softminesol.propertysurvey.survey.common.model.PropertySubCategoryList;
import com.softminesol.propertysurvey.survey.common.model.PropertyTypes;
import com.softminesol.propertysurvey.survey.common.model.RebateList;
import com.softminesol.propertysurvey.survey.common.model.UsageList;
import com.softminesol.propertysurvey.survey.common.model.formData.FormData;
import com.softminesol.propertysurvey.survey.common.repository.datasource.SurveyOptionFactory;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
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
    public Observable<PropertyCategoryList> getPropertyCategory() {
        return surveyOptionFactory.getSurveyOptionCacheDataSource().getPropertyCategory().flatMap(new Func1<PropertyCategoryList, Observable<PropertyCategoryList>>() {
            @Override
            public Observable<PropertyCategoryList> call(PropertyCategoryList propertyCategoryList) {
                if(propertyCategoryList != null) {
                    return Observable.just(propertyCategoryList);
                }else {
                    return surveyOptionFactory.getSurveyOptionCloudDataSource().getPropertyCategory().doOnNext(new Action1<PropertyCategoryList>() {
                        @Override
                        public void call(PropertyCategoryList propertyCategoryList) {
                            surveyOptionFactory.getSurveyOptionCacheDataSource().savePropertyCategoryList(propertyCategoryList);
                        }
                    });
                }
            }
        });
    }

    @Override
    public Observable<PropertyTypes> getProperyTypes(RequestParams requestParams) {
        final int id = (requestParams.getInt("id", -1));
        return  surveyOptionFactory.getSurveyOptionCacheDataSource().getPropertyTypes(id).flatMap(new Func1<PropertyTypes, Observable<PropertyTypes>>() {
            @Override
            public Observable<PropertyTypes> call(PropertyTypes propertyTypes) {
                if(propertyTypes != null) {
                    return Observable.just(propertyTypes);
                }else {
                    return surveyOptionFactory.getSurveyOptionCloudDataSource().getPropertyTypes(id).doOnNext(new Action1<PropertyTypes>() {
                        @Override
                        public void call(PropertyTypes propertyTypes) {
                            surveyOptionFactory.getSurveyOptionCacheDataSource().savePropertyTypes(propertyTypes, id);
                        }
                    });
                }
            }
        });
    }

    @Override
    public Observable<PropertySubCategoryList> getPropertySubCategoryList(RequestParams requestParams) {
        final int id = (requestParams.getInt("id", -1));
        return surveyOptionFactory.getSurveyOptionCacheDataSource().getPropertySubeCategoryList(id).flatMap(new Func1<PropertySubCategoryList, Observable<PropertySubCategoryList>>() {
            @Override
            public Observable<PropertySubCategoryList> call(PropertySubCategoryList propertySubCategoryList) {
                if(propertySubCategoryList != null) {
                    return Observable.just(propertySubCategoryList);
                }else {
                    return surveyOptionFactory.getSurveyOptionCloudDataSource().getPropertySubeCategoryList(id).doOnNext(new Action1<PropertySubCategoryList>() {
                        @Override
                        public void call(PropertySubCategoryList propertySubCategoryList) {
                            surveyOptionFactory.getSurveyOptionCacheDataSource().savePropertySubCategoryList(propertySubCategoryList, id);
                        }
                    });
                }
            }
        });
    }

    @Override
    public Observable<RebateList> getPropertyRebateList() {
        return surveyOptionFactory.getSurveyOptionCacheDataSource().getRebateList().flatMap(new Func1<RebateList, Observable<RebateList>>() {
            @Override
            public Observable<RebateList> call(RebateList propertyCategoryList) {
                if(propertyCategoryList != null) {
                    return Observable.just(propertyCategoryList);
                }else {
                    return surveyOptionFactory.getSurveyOptionCloudDataSource().getRebateList().doOnNext(new Action1<RebateList>() {
                        @Override
                        public void call(RebateList rebateList) {
                            surveyOptionFactory.getSurveyOptionCacheDataSource().saveRebateList(rebateList);
                        }
                    });
                }
            }
        });
    }

    public Observable<ColonyList> getColonyList() {
        return surveyOptionFactory.getSurveyOptionCacheDataSource().getColonyList().flatMap(new Func1<ColonyList, Observable<ColonyList>>() {
            @Override
            public Observable<ColonyList> call(ColonyList propertyCategoryList) {
                if(propertyCategoryList != null) {
                    return Observable.just(propertyCategoryList);
                }else {
                    return surveyOptionFactory.getSurveyOptionCloudDataSource().getColonyList().doOnNext(new Action1<ColonyList>() {
                        @Override
                        public void call(ColonyList colonyList) {
                            surveyOptionFactory.getSurveyOptionCacheDataSource().saveColonyList(colonyList);
                        }
                    });
                }
            }
        });
    }

    public Observable<UsageList> getUsageList() {
        return surveyOptionFactory.getSurveyOptionCacheDataSource().getUsageList().flatMap(new Func1<UsageList, Observable<UsageList>>() {
            @Override
            public Observable<UsageList> call(UsageList usageList) {

                return surveyOptionFactory.getSurveyOptionCloudDataSource().getUsageList().doOnNext(new Action1<UsageList>() {
                    @Override
                    public void call(UsageList usageList) {
                        surveyOptionFactory.getSurveyOptionCacheDataSource().saveUsageList(usageList);
                    }
                });
            }
        });
    }

    public Observable<MeasurementUnitList> getMeasurementList() {
        return surveyOptionFactory.getSurveyOptionCacheDataSource().getMeasurementList().flatMap(new Func1<MeasurementUnitList, Observable<MeasurementUnitList>>() {
            @Override
            public Observable<MeasurementUnitList> call(MeasurementUnitList measurementUnitList) {
                if(measurementUnitList  != null) {
                    return Observable.just(measurementUnitList);
                }
                return surveyOptionFactory.getSurveyOptionCloudDataSource().getMeasurementList().doOnNext(new Action1<MeasurementUnitList>() {
                    @Override
                    public void call(MeasurementUnitList measurementUnitList) {
                        surveyOptionFactory.getSurveyOptionCacheDataSource().saveMeasurementList(measurementUnitList);
                    }
                });
            }
        });
    }

    @Override
    public Observable<FloorsList> getFloorList() {
        return surveyOptionFactory.getSurveyOptionCacheDataSource().getFloorList().flatMap(new Func1<FloorsList, Observable<FloorsList>>() {
            @Override
            public Observable<FloorsList> call(FloorsList floorsList) {
                if(floorsList!= null) {
                    return Observable.just(floorsList);
                }
                return surveyOptionFactory.getSurveyOptionCloudDataSource().getFloorList().doOnNext(new Action1<FloorsList>() {
                    @Override
                    public void call(FloorsList floorsList) {
                        surveyOptionFactory.getSurveyOptionCacheDataSource().saveFloorList(floorsList);
                    }
                });
            }
        });
    }

    @Override
    public Observable<OwnerShipList> getOwnerShipList() {
        return surveyOptionFactory.getSurveyOptionCacheDataSource().getOwnerShipList().flatMap(new Func1<OwnerShipList, Observable<OwnerShipList>>() {
            @Override
            public Observable<OwnerShipList> call(OwnerShipList ownerShipList) {
                if(ownerShipList != null) {
                    return Observable.just(ownerShipList);
                }
                return surveyOptionFactory.getSurveyOptionCloudDataSource().getOwnerShipList().doOnNext(new Action1<OwnerShipList>() {
                    @Override
                    public void call(OwnerShipList ownerShipList) {
                        surveyOptionFactory.getSurveyOptionCacheDataSource().saveOwnerShipList(ownerShipList);
                    }
                });
            }
        });
    }

    @Override
    public Observable<AreaType> getAreaType() {
        return surveyOptionFactory.getSurveyOptionCacheDataSource().getAreaType().flatMap(new Func1<AreaType, Observable<AreaType>>() {
            @Override
            public Observable<AreaType> call(AreaType areaType) {
                if(areaType != null) {
                    return Observable.just(areaType);
                }
                return surveyOptionFactory.getSurveyOptionCloudDataSource().getAreaType().doOnNext(new Action1<AreaType>() {
                    @Override
                    public void call(AreaType areaType) {
                        surveyOptionFactory.getSurveyOptionCacheDataSource().saveAreaType(areaType);
                    }
                });
            }
        });
    }

    @Override
    public Observable<ConstructionType> getConstructionType() {
        return surveyOptionFactory.getSurveyOptionCacheDataSource().getConstructionType().flatMap(new Func1<ConstructionType, Observable<ConstructionType>>() {
            @Override
            public Observable<ConstructionType> call(ConstructionType constructionType) {
                if(constructionType != null) {
                    return Observable.just(constructionType);
                }
                return surveyOptionFactory.getSurveyOptionCloudDataSource().getConstructionType().doOnNext(new Action1<ConstructionType>() {
                    @Override
                    public void call(ConstructionType constructionType) {
                        surveyOptionFactory.getSurveyOptionCacheDataSource().saveConstructionType(constructionType);
                    }
                });
            }
        });
    }

    @Override
    public Observable<OLDPropertyUIDS> getPropertyIdList(final String query) {
       return surveyOptionFactory.getSurveyOptionCacheDataSource().getPropertyIdList(query).flatMap(new Func1<OLDPropertyUIDS, Observable<OLDPropertyUIDS>>() {
            @Override
            public Observable<OLDPropertyUIDS> call(OLDPropertyUIDS oldPropertyUIDS) {
                if(oldPropertyUIDS != null)
                    return Observable.just(oldPropertyUIDS);
                return surveyOptionFactory.getSurveyOptionCloudDataSource().getPropertyIdList(query);
            }
        });
    }

    @Override
    public Observable<OLDPropertyUIDS> getPropertyBillingIdList(final String query) {
        return surveyOptionFactory.getSurveyOptionCacheDataSource().getPropertyBillingIdList(query).flatMap(new Func1<OLDPropertyUIDS, Observable<OLDPropertyUIDS>>() {
            @Override
            public Observable<OLDPropertyUIDS> call(OLDPropertyUIDS oldPropertyUIDS) {
                if(oldPropertyUIDS != null)
                    return Observable.just(oldPropertyUIDS);
                return surveyOptionFactory.getSurveyOptionCloudDataSource().getPropertyIdList(query);
            }
        });
    }

    @Override
    public Observable<FormData> getFormData(final String query) {
     return    surveyOptionFactory.getSurveyOptionCacheDataSource().getFormData(query).flatMap(new Func1<FormData, Observable<FormData>>() {
            @Override
            public Observable<FormData> call(FormData formData) {
                if(formData != null)
                    return Observable.just(formData);
                return surveyOptionFactory.getSurveyOptionCloudDataSource().getFormData(query);
            }
        });
    }
}
