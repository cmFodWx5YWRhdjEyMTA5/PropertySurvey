package com.softminesol.propertysurvey.survey.common.repository.datasource;

import android.content.Context;

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
import com.softminesol.propertysurvey.survey.common.realm.RealmPropertyDataMapper;

import javax.inject.Inject;

import frameworks.di.qualifier.ApplicationContext;
import rx.Observable;

public class SurveyOptionCacheDataSource {
    RealmPropertyDataMapper realmPropertyDataMapper;

    @Inject
    public SurveyOptionCacheDataSource(@ApplicationContext Context context) {
        this.realmPropertyDataMapper = RealmPropertyDataMapper.getInstance(context);
    }

    public Observable<PropertyCategoryList> getPropertyCategory() {
        return realmPropertyDataMapper.getPropertyCategoryList();
    }

    public void savePropertyCategoryList(PropertyCategoryList propertyCategoryList) {
        realmPropertyDataMapper.savePropertyCategory(propertyCategoryList);
    }

    public Observable<PropertyTypes> getPropertyTypes(int id) {
        return realmPropertyDataMapper.getPropertyTypes(id);
    }

    public Observable<RebateList> getRebateList() {
        return realmPropertyDataMapper.getRebateList();
    }

    public void saveRebateList(RebateList rebateList) {
        realmPropertyDataMapper.saveRebateList(rebateList);
    }

    public Observable<ColonyList> getColonyList() {
        return realmPropertyDataMapper.getColonyList();
    }

    public void saveColonyList(ColonyList colonyList) {
        realmPropertyDataMapper.saveColonyList(colonyList);
    }

    public Observable<UsageList> getUsageList() {
        return realmPropertyDataMapper.getUsageList();
    }

    public void saveUsageList(UsageList usageList) {
         realmPropertyDataMapper.saveUsageList(usageList);
    }


    public Observable<MeasurementUnitList> getMeasurementList() {
        return realmPropertyDataMapper.getMeasurementUnitList();
    }

    public void saveMeasurementList(MeasurementUnitList measurementUnitLis) {
        realmPropertyDataMapper.saveMeasurementList(measurementUnitLis);
    }


    public Observable<FloorsList> getFloorList() {
        return realmPropertyDataMapper.getFloorList();
    }


    public void saveFloorList(FloorsList floorList) {
        realmPropertyDataMapper.saveFloorList(floorList);
    }

    public Observable<OwnerShipList> getOwnerShipList() {
        return realmPropertyDataMapper.getOwnerShipList();
    }

    public void  saveOwnerShipList(OwnerShipList ownerShipList) {
        realmPropertyDataMapper.saveOwnerShipList(ownerShipList);
    }

    public Observable<AreaType> getAreaType() {
        return realmPropertyDataMapper.getAreaType();
    }
    public void  saveAreaType(AreaType areaType) {
        realmPropertyDataMapper.saveAreaType(areaType);
    }

    public Observable<ConstructionType> getConstructionType() {
        return realmPropertyDataMapper.getConstructionType();
    }

    public void saveConstructionType(ConstructionType constructionType) {
        realmPropertyDataMapper.saveConstructionType(constructionType);
    }

    public void savePropertyTypes(PropertyTypes propertyTypes, int id) {
        realmPropertyDataMapper.savePropertyTypes(propertyTypes,id);
    }

    public Observable<PropertySubCategoryList> getPropertySubeCategoryList(int id) {
        return realmPropertyDataMapper.getPropertySubCategoryList(id);
    }

    public void savePropertySubCategoryList(PropertySubCategoryList propertySubCategoryList, int id) {
        realmPropertyDataMapper.savePropertySubCategoryList(propertySubCategoryList,id);
    }


    public Observable<OLDPropertyUIDS> getPropertyIdList(String query) {
        return realmPropertyDataMapper.getPropertyIdList(query);
    }
    public Observable<OLDPropertyUIDS> getPropertyBillingIdList(String query) {
        return realmPropertyDataMapper.getDistributionPropertyIdList(query);
    }

    public Observable<FormData> getFormData(String query) {
        return realmPropertyDataMapper.getFormData(query);
    }
/*
    public Observable<FormData> getFormData(String query) {
        return surveyAPI.getPropertyDetail(query).map(new Func1<Response<DataResponse<PropertyDetails>>, FormData>() {
            @Override
            public FormData call(Response<DataResponse<PropertyDetails>> dataResponseResponse) {
                return dataResponseResponse.body().getData().getFormData();
            }
        });
    }*/
}
