package com.softminesol.propertysurvey.survey.common.net;

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
import com.softminesol.propertysurvey.survey.common.model.formData.PropertyDetails;

import frameworks.network.model.DataResponse;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by sandeep on 6/5/18.
 */
public interface SurveyAPI {

    @GET(SurveyAPIURL.PROPERTY_CATEGORY_API)
    public Observable<Response<DataResponse<PropertyCategoryList>>> getPropertyCategory();

    @GET(SurveyAPIURL.PROPERTY_TYPE_API)
    public Observable<Response<DataResponse<PropertyTypes>>> getPropertyTypes(@Path("id") int id);

    @GET(SurveyAPIURL.PROPERTY_SUBCATEGORY_API)
    public Observable<Response<DataResponse<PropertySubCategoryList>>> getPropertySubCategoryList(@Path("id") int id);

    @GET(SurveyAPIURL.PROPERTY_REBATE)
    public Observable<Response<DataResponse<RebateList>>> getRebateList();

    @GET(SurveyAPIURL.PROPERTY_COLONY)
    public Observable<Response<DataResponse<ColonyList>>> getColonyList();

    @GET(SurveyAPIURL.PROPERTY_USAGE)
    public Observable<Response<DataResponse<UsageList>>> getUsageList();

    @GET(SurveyAPIURL.PROPERTY_MEASUREMENT)
    public Observable<Response<DataResponse<MeasurementUnitList>>> getMeasurementList();

    @GET(SurveyAPIURL.PROPERTY_FLOOR)
    public Observable<Response<DataResponse<FloorsList>>> getFloorList();

    @GET(SurveyAPIURL.PROPERTY_OWNERSHIP)
    public Observable<Response<DataResponse<OwnerShipList>>> getOwnerShipList();

    @GET(SurveyAPIURL.PROPERTY_AREATYPE)
    public Observable<Response<DataResponse<AreaType>>> getAreaType();

    @GET(SurveyAPIURL.PROPERTY_CONSTRUCTIONTYPE)
    public Observable<Response<DataResponse<ConstructionType>>> getConstructionType();

    @GET(SurveyAPIURL.PROPERTY_IDS)
    public Observable<Response<DataResponse<OLDPropertyUIDS>>> getPropertyIds(@Query("propertyOldUid") String query);

    @GET(SurveyAPIURL.PROPERTY_DETAIL)
    public Observable<Response<DataResponse<PropertyDetails>>> getPropertyDetail(@Path("id") String query);

}
