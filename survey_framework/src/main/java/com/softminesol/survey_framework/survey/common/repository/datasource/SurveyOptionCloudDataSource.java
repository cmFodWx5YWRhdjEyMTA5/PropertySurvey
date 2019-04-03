package com.softminesol.survey_framework.survey.common.repository.datasource;

import com.softminesol.survey_framework.survey.common.model.AreaType;
import com.softminesol.survey_framework.survey.common.model.ColonyList;
import com.softminesol.survey_framework.survey.common.model.ConstructionType;
import com.softminesol.survey_framework.survey.common.model.FloorsList;
import com.softminesol.survey_framework.survey.common.model.MeasurementUnitList;
import com.softminesol.survey_framework.survey.common.model.OLDPropertyUIDS;
import com.softminesol.survey_framework.survey.common.model.OwnerShipList;
import com.softminesol.survey_framework.survey.common.model.PropertyCategoryList;
import com.softminesol.survey_framework.survey.common.model.PropertySubCategoryList;
import com.softminesol.survey_framework.survey.common.model.PropertyTypes;
import com.softminesol.survey_framework.survey.common.model.RebateList;
import com.softminesol.survey_framework.survey.common.model.UsageList;
import com.softminesol.survey_framework.survey.common.model.formData.FormData;
import com.softminesol.survey_framework.survey.common.model.formData.PropertyDetails;
import com.softminesol.survey_framework.survey.common.model.newmodel.BuildingAge;
import com.softminesol.survey_framework.survey.common.model.newmodel.Floors;
import com.softminesol.survey_framework.survey.common.model.newmodel.NonResidentalCategory;
import com.softminesol.survey_framework.survey.common.model.newmodel.OccupancyStatus;
import com.softminesol.survey_framework.survey.common.model.newmodel.PropertyUsage;
import com.softminesol.survey_framework.survey.common.model.newmodel.RespondentStatus;
import com.softminesol.survey_framework.survey.common.model.newmodel.SourceWater;
import com.softminesol.survey_framework.survey.common.net.SurveyAPI;

import javax.inject.Inject;

import frameworks.network.model.DataResponse;
import retrofit2.Response;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by sandeep on 6/5/18.
 */
public class SurveyOptionCloudDataSource {
    SurveyAPI surveyAPI;

    @Inject
    public SurveyOptionCloudDataSource(SurveyAPI surveyAPI) {
        this.surveyAPI = surveyAPI;
    }

    public Observable<PropertyCategoryList> getPropertyCategory() {
        return surveyAPI.getPropertyCategory().map(new Func1<Response<DataResponse<PropertyCategoryList>>, PropertyCategoryList>() {
            @Override
            public PropertyCategoryList call(Response<DataResponse<PropertyCategoryList>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }


    public Observable<PropertySubCategoryList> getPropertySubeCategoryList(int id) {
        return surveyAPI.getPropertySubCategoryList(id).map(new Func1<Response<DataResponse<PropertySubCategoryList>>, PropertySubCategoryList>() {
            @Override
            public PropertySubCategoryList call(Response<DataResponse<PropertySubCategoryList>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }

    public Observable<RebateList> getRebateList() {
        return surveyAPI.getRebateList().map(new Func1<Response<DataResponse<RebateList>>, RebateList>() {
            @Override
            public RebateList call(Response<DataResponse<RebateList>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }

    public Observable<ColonyList> getColonyList() {
        return surveyAPI.getColonyList().map(new Func1<Response<DataResponse<ColonyList>>, ColonyList>() {
            @Override
            public ColonyList call(Response<DataResponse<ColonyList>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }

    public Observable<UsageList> getUsageList() {
        return surveyAPI.getUsageList().map(new Func1<Response<DataResponse<UsageList>>, UsageList>() {
            @Override
            public UsageList call(Response<DataResponse<UsageList>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }

    public Observable<MeasurementUnitList> getMeasurementList() {
        return surveyAPI.getMeasurementList().map(new Func1<Response<DataResponse<MeasurementUnitList>>, MeasurementUnitList>() {
            @Override
            public MeasurementUnitList call(Response<DataResponse<MeasurementUnitList>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }

    public Observable<FloorsList> getFloorList() {
        return surveyAPI.getFloorList().map(new Func1<Response<DataResponse<FloorsList>>, FloorsList>() {
            @Override
            public FloorsList call(Response<DataResponse<FloorsList>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }

    public Observable<OwnerShipList> getOwnerShipList() {
        return surveyAPI.getOwnerShipList().map(new Func1<Response<DataResponse<OwnerShipList>>, OwnerShipList>() {
            @Override
            public OwnerShipList call(Response<DataResponse<OwnerShipList>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }

    public Observable<AreaType> getAreaType() {
        return surveyAPI.getAreaType().map(new Func1<Response<DataResponse<AreaType>>, AreaType>() {
            @Override
            public AreaType call(Response<DataResponse<AreaType>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }

    public Observable<ConstructionType> getConstructionType() {
        return surveyAPI.getConstructionType().map(new Func1<Response<DataResponse<ConstructionType>>, ConstructionType>() {
            @Override
            public ConstructionType call(Response<DataResponse<ConstructionType>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }

    public Observable<OLDPropertyUIDS> getPropertyIdList(String query) {
        return surveyAPI.getPropertyIds(query).map(new Func1<Response<DataResponse<OLDPropertyUIDS>>, OLDPropertyUIDS>() {
            @Override
            public OLDPropertyUIDS call(Response<DataResponse<OLDPropertyUIDS>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }

    public Observable<FormData> getFormData(String query) {
        return surveyAPI.getPropertyDetail(query).map(new Func1<Response<DataResponse<PropertyDetails>>, FormData>() {
            @Override
            public FormData call(Response<DataResponse<PropertyDetails>> dataResponseResponse) {
                return dataResponseResponse.body().getData().getFormData();
            }
        });
    }

    public Observable<PropertyTypes> getPropertyTypes() {
        return surveyAPI.getPropertyTypes().map(new Func1<Response<DataResponse<PropertyTypes>>, PropertyTypes>() {
            @Override
            public PropertyTypes call(Response<DataResponse<PropertyTypes>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });
    }


    public Observable<PropertyUsage> getPropertyUsage() {
        return surveyAPI.getPropertyUsage1().map(new Func1<Response<DataResponse<PropertyUsage>>, PropertyUsage>() {
            @Override
            public PropertyUsage call(Response<DataResponse<PropertyUsage>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });

    }

    public Observable<RespondentStatus> getRespondentStatus() {
        return surveyAPI.getRespondentStatus().map(new Func1<Response<DataResponse<RespondentStatus>>, RespondentStatus>() {
            @Override
            public RespondentStatus call(Response<DataResponse<RespondentStatus>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });

    }


    public Observable<OccupancyStatus> getOccupancyStatus() {
        return surveyAPI.getOccupancyStatus().map(new Func1<Response<DataResponse<OccupancyStatus>>, OccupancyStatus>() {
            @Override
            public OccupancyStatus call(Response<DataResponse<OccupancyStatus>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });

    }

    public Observable<BuildingAge> getBuildingAge() {
        return surveyAPI.getBuildingAge().map(new Func1<Response<DataResponse<BuildingAge>>, BuildingAge>() {
            @Override
            public BuildingAge call(Response<DataResponse<BuildingAge>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });

    }

    public Observable<com.softminesol.survey_framework.survey.common.model.newmodel.ConstructionType> getConstructionType1() {
        return surveyAPI.getConstructionType1().map(new Func1<Response<DataResponse<com.softminesol.survey_framework.survey.common.model.newmodel.ConstructionType>>, com.softminesol.survey_framework.survey.common.model.newmodel.ConstructionType>() {
            @Override
            public com.softminesol.survey_framework.survey.common.model.newmodel.ConstructionType call(Response<DataResponse<com.softminesol.survey_framework.survey.common.model.newmodel.ConstructionType>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });

    }

    public Observable<Floors> getFloors() {
        return surveyAPI.getFloors().map(new Func1<Response<DataResponse<Floors>>, Floors>() {
            @Override
            public Floors call(Response<DataResponse<Floors>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });

    }

    public Observable<NonResidentalCategory> getNonResidentalCategorys() {
        return surveyAPI.getNonResidentalCategorys().map(new Func1<Response<DataResponse<NonResidentalCategory>>, NonResidentalCategory>() {
            @Override
            public NonResidentalCategory call(Response<DataResponse<NonResidentalCategory>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });

    }

    public Observable<SourceWater> getSourceWater() {
        return surveyAPI.getSourceWater().map(new Func1<Response<DataResponse<SourceWater>>, SourceWater>() {
            @Override
            public SourceWater call(Response<DataResponse<SourceWater>> dataResponseResponse) {
                return dataResponseResponse.body().getData();
            }
        });

    }
}
