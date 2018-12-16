package com.softminesol.propertysurvey.survey.common.domain;

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

import frameworks.network.usecases.RequestParams;
import rx.Observable;

/**
 * Created by sandeep on 6/5/18.
 */
public interface ISurveyOptionRepository {
    public Observable<PropertyCategoryList> getPropertyCategory();

    public Observable<PropertyTypes> getProperyTypes(RequestParams requestParams);

    public Observable<PropertySubCategoryList> getPropertySubCategoryList(RequestParams requestParams);

    public Observable<RebateList> getPropertyRebateList();

    public Observable<ColonyList> getColonyList();

    public Observable<UsageList> getUsageList();

    public Observable<MeasurementUnitList> getMeasurementList();

    public Observable<FloorsList> getFloorList();

    public Observable<OwnerShipList> getOwnerShipList();

    public Observable<AreaType> getAreaType();

    public Observable<ConstructionType> getConstructionType();

    public Observable<OLDPropertyUIDS> getPropertyIdList(String query);

    public Observable<OLDPropertyUIDS> getPropertyBillingIdList(String query);

    public Observable<FormData> getFormData(String query);
}
