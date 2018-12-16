package com.softminesol.propertysurvey.survey.common.realm;

import android.content.Context;

import com.softminesol.propertysurvey.SurveyAppApplication;
import com.softminesol.propertysurvey.survey.common.model.AreaType;
import com.softminesol.propertysurvey.survey.common.model.ColonyList;
import com.softminesol.propertysurvey.survey.common.model.ConstructionType;
import com.softminesol.propertysurvey.survey.common.model.FloorsList;
import com.softminesol.propertysurvey.survey.common.model.MeasurementUnitList;
import com.softminesol.propertysurvey.survey.common.model.OLDPropertyUIDS;
import com.softminesol.propertysurvey.survey.common.model.OldPropertyUIDItem;
import com.softminesol.propertysurvey.survey.common.model.OwnerShipList;
import com.softminesol.propertysurvey.survey.common.model.PropertyCategory;
import com.softminesol.propertysurvey.survey.common.model.PropertyCategoryList;
import com.softminesol.propertysurvey.survey.common.model.PropertySubCategoryList;
import com.softminesol.propertysurvey.survey.common.model.PropertyTypes;
import com.softminesol.propertysurvey.survey.common.model.RebateList;
import com.softminesol.propertysurvey.survey.common.model.UsageList;
import com.softminesol.propertysurvey.survey.common.model.formData.FormData;
import com.softminesol.propertysurvey.survey.common.realm.mapper.AreaTypeModelMapper;
import com.softminesol.propertysurvey.survey.common.realm.mapper.BillDetailsModelMapper;
import com.softminesol.propertysurvey.survey.common.realm.mapper.ColonyListModelMapper;
import com.softminesol.propertysurvey.survey.common.realm.mapper.ConstructionTypeModelMapper;
import com.softminesol.propertysurvey.survey.common.realm.mapper.FloorsListModelMapper;
import com.softminesol.propertysurvey.survey.common.realm.mapper.FormDataModelMapper;
import com.softminesol.propertysurvey.survey.common.realm.mapper.MeasurementUnitListModelMapper;
import com.softminesol.propertysurvey.survey.common.realm.mapper.OldPropertyUIDSModelMapper;
import com.softminesol.propertysurvey.survey.common.realm.mapper.OwnerShipListModelMapper;
import com.softminesol.propertysurvey.survey.common.realm.mapper.PropertyCategoryListModelMapper;
import com.softminesol.propertysurvey.survey.common.realm.mapper.PropertySubCategoryListModelMapper;
import com.softminesol.propertysurvey.survey.common.realm.mapper.PropertyTypeModelMapper;
import com.softminesol.propertysurvey.survey.common.realm.mapper.PropertyTypesModelMapper;
import com.softminesol.propertysurvey.survey.common.realm.mapper.RebateListModelMapper;
import com.softminesol.propertysurvey.survey.common.realm.mapper.UsageListModelMapper;
import com.softminesol.propertysurvey.survey.common.realm.model.AreaTypeModel;
import com.softminesol.propertysurvey.survey.common.realm.model.BillDetailModel;
import com.softminesol.propertysurvey.survey.common.realm.model.BillDetailsModel;
import com.softminesol.propertysurvey.survey.common.realm.model.ColonyListModel;
import com.softminesol.propertysurvey.survey.common.realm.model.ConstructionTypeModel;
import com.softminesol.propertysurvey.survey.common.realm.model.FloorsListModel;
import com.softminesol.propertysurvey.survey.common.realm.model.FormDataModel;
import com.softminesol.propertysurvey.survey.common.realm.model.MeasurementUnitListModel;
import com.softminesol.propertysurvey.survey.common.realm.model.OldPropertyUIDItemModel;
import com.softminesol.propertysurvey.survey.common.realm.model.OldPropertyUIDSModel;
import com.softminesol.propertysurvey.survey.common.realm.model.OwnerShipListModel;
import com.softminesol.propertysurvey.survey.common.realm.model.PropertyCategoryListModel;
import com.softminesol.propertysurvey.survey.common.realm.model.PropertyCategoryModel;
import com.softminesol.propertysurvey.survey.common.realm.model.PropertySubCategoryListModel;
import com.softminesol.propertysurvey.survey.common.realm.model.PropertyTypeModel;
import com.softminesol.propertysurvey.survey.common.realm.model.PropertyTypesModel;
import com.softminesol.propertysurvey.survey.common.realm.model.RebateListModel;
import com.softminesol.propertysurvey.survey.common.realm.model.UsageListModel;
import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetail;
import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetails;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by madhurigupta on 26/05/18.
 */

public class RealmPropertyDataMapper {

    private static RealmPropertyDataMapper instance;
    private final String key = "dbId";
    private SurveyAppApplication surveyAppApplication;


    public RealmPropertyDataMapper(Context context) {
        surveyAppApplication = (SurveyAppApplication) context;
    }

    public static RealmPropertyDataMapper getInstance(Context context) {
        if (instance == null) {
            instance = new RealmPropertyDataMapper(context);
        }
        return instance;
    }


    public boolean addOrUpdateDistributionDataList(List<BillDetails> billDetails) {
        if (billDetails != null) {
            PropertyRealm<BillDetail> dataSchema = new PropertyRealm(surveyAppApplication.getPropertyDataRealm());
            for(BillDetails billDetail: billDetails) {
                BillDetailsModel billDetailsModel = new BillDetailsModelMapper().transformToRealmDb(billDetail);
                dataSchema.delete(key, billDetailsModel.getOldPropertyUID(), BillDetailsModel.class);
                billDetailsModel.setDbId(billDetail.getOldPropertyUID());
                dataSchema.saveData(billDetailsModel);
            }
            dataSchema.closeRealm();
            return true;
        }
        return false;
    }

    public boolean addOrUpdatePropertyDataList(List<FormData> formDataList) {
        if (formDataList != null) {
            PropertyRealm<FormDataModel> dataSchema = new PropertyRealm(surveyAppApplication.getPropertyDataRealm());
            for(FormData formData: formDataList) {
                FormDataModel formDataModel = new FormDataModelMapper().transformToRealmDb(formData);
                dataSchema.delete(key, formDataModel.getOldPropertyUID(), FormDataModel.class);
                formDataModel.setDbId(formData.getOldPropertyUID());
                dataSchema.saveData(formDataModel);
            }
            dataSchema.closeRealm();
            return true;
        }
        return false;
    }


    public BillDetails getDistributionData(String oldPropertyId) {
        if (oldPropertyId != null) {
            Realm realm = surveyAppApplication.getPropertyDataRealm();
            PropertyRealm<BillDetailsModel> propertyRealm = new PropertyRealm<>(realm);
            BillDetailsModel billDetailsModel = propertyRealm.getDataObject(BillDetailsModel.class, key, oldPropertyId);
            if (billDetailsModel != null) {
                return new BillDetailsModelMapper().transformToViewModel(billDetailsModel);
            }
        }
        return null;
    }
    public boolean updateDistributionData(BillDetails billDetails) {
        if (billDetails != null) {
            PropertyRealm<BillDetailsModel> dataSchema = new PropertyRealm(surveyAppApplication.getPropertyDataRealm());
            dataSchema.delete(key, billDetails.getOldPropertyUID(), BillDetailsModel.class);
            BillDetailsModel billDetailModel = new BillDetailsModelMapper().transformToRealmDb(billDetails);
            billDetailModel.setDbId(billDetails.getOldPropertyUID());
            dataSchema.saveData(billDetailModel);
            dataSchema.closeRealm();
            return true;
        }
        return false;
    }

    public Observable<OLDPropertyUIDS> getDistributionPropertyIdList(String query) {
        Realm realm = surveyAppApplication.getPropertyDataRealm();
        PropertyRealm propertyRealm = new PropertyRealm(realm);
        RealmResults<BillDetailsModel> propertyRealmAllData = propertyRealm.contains(key,query,BillDetailsModel.class);
        if (propertyRealmAllData != null && propertyRealmAllData.size() > 0) {
            RealmList<OldPropertyUIDItemModel> oldPropertyUIDItemModels =new RealmList<>();
            for(int i = 0;i< propertyRealmAllData.size();i++) {
                OldPropertyUIDItemModel oldPropertyUIDItemModel = new OldPropertyUIDItemModel();
                oldPropertyUIDItemModel.setOldpropertyuid(propertyRealmAllData.get(i).getOldPropertyUID());
                oldPropertyUIDItemModels.add(oldPropertyUIDItemModel);
            }
            OldPropertyUIDSModel oldPropertyUIDSModel = new OldPropertyUIDSModel();
            oldPropertyUIDSModel.setOldPropertyUID(oldPropertyUIDItemModels);
            OLDPropertyUIDS oldPropertyUIDS = new OldPropertyUIDSModelMapper().transformToViewModel(oldPropertyUIDSModel);
            if (oldPropertyUIDS != null) {
                propertyRealm.closeRealm();
                return Observable.just(oldPropertyUIDS);
            }
        }
        return Observable.just(null);
    }
    public boolean addPropertyData(FormData formData) {
        if (formData != null) {
            PropertyRealm<FormDataModel> dataSchema = new PropertyRealm(surveyAppApplication.getPropertyDataRealm());
            dataSchema.delete(key, formData.getOldPropertyUID(), FormDataModel.class);
            FormDataModel formDataModel = new FormDataModelMapper().transformToRealmDb(formData);
            formDataModel.setDbId(formData.getOldPropertyUID());
            dataSchema.saveData(formDataModel);
            dataSchema.closeRealm();
            return true;
        }
        return false;

    }
    public boolean updatePropertyData(FormData formData) {
        if (formData != null) {
            PropertyRealm<FormDataModel> dataSchema = new PropertyRealm(surveyAppApplication.getPropertyDataRealm());
            dataSchema.delete(key, formData.getOldPropertyUID(), FormDataModel.class);
            FormDataModel formDataModel = new FormDataModelMapper().transformToRealmDb(formData);
            formDataModel.setDbId(formData.getOldPropertyUID());
            dataSchema.saveData(formDataModel);
            dataSchema.closeRealm();
            return true;
        }
        return false;
    }


    public FormData getPropertyData(String propertyId) {
        if (propertyId != null) {
            Realm realm = surveyAppApplication.getPropertyDataRealm();
            PropertyRealm<FormDataModel> propertyRealm = new PropertyRealm<>(realm);
            FormDataModel formDataModel = propertyRealm.getDataObject(FormDataModel.class, key, propertyId);
            if (formDataModel != null) {
                return new FormDataModelMapper().transformToViewModel(formDataModel);
            }
        }
        return null;
    }

    public void savePropertyCategory(PropertyCategoryList propertyCategoryList) {
        if (propertyCategoryList != null) {
            PropertyRealm<PropertyCategoryList> dataSchema = new PropertyRealm(surveyAppApplication.getPropertyDataRealm());
            dataSchema.clearAllData(PropertyCategoryListModel.class);
            PropertyCategoryListModel propertyCategoryListModel = new PropertyCategoryListModelMapper().transformToRealmDb(propertyCategoryList);
            dataSchema.saveData(propertyCategoryListModel);
            dataSchema.closeRealm();
        }
    }

    public void savePropertyTypes(PropertyTypes propertyTypes,int id) {
        if (propertyTypes != null) {
            PropertyRealm<PropertyTypes> dataSchema = new PropertyRealm(surveyAppApplication.getPropertyDataRealm());
            dataSchema.delete(key,id+"",PropertyTypesModel.class);
            PropertyTypesModel propertyCategoryListModel = new PropertyTypesModelMapper().transformToRealmDb(propertyTypes);
            propertyCategoryListModel.setDbId(id+"");
            dataSchema.saveData(propertyCategoryListModel);
            dataSchema.closeRealm();
        }
    }

    public void savePropertySubCategoryList(PropertySubCategoryList propertySubCategoryList,int id) {
        if (propertySubCategoryList != null) {
            PropertyRealm<PropertySubCategoryList> dataSchema = new PropertyRealm(surveyAppApplication.getPropertyDataRealm());
            dataSchema.delete(key,id+"",PropertySubCategoryListModel.class);
            PropertySubCategoryListModel propertyCategoryListModel = new PropertySubCategoryListModelMapper().transformToRealmDb(propertySubCategoryList);
            propertyCategoryListModel.setDbId(id+"");
            dataSchema.saveData(propertyCategoryListModel);
            dataSchema.closeRealm();
        }
    }

    public void saveRebateList(RebateList rebateList) {
        if (rebateList != null) {
            PropertyRealm<RebateList> dataSchema = new PropertyRealm(surveyAppApplication.getPropertyDataRealm());
            dataSchema.clearAllData(RebateListModel.class);
            RebateListModel rebateListModel = new RebateListModelMapper().transformToRealmDb(rebateList);
            dataSchema.saveData(rebateListModel);
            dataSchema.closeRealm();
        }
    }

    public void saveColonyList(ColonyList colonyList) {
        if (colonyList != null) {
            PropertyRealm<ColonyList> dataSchema = new PropertyRealm(surveyAppApplication.getPropertyDataRealm());
            dataSchema.clearAllData(ColonyListModel.class);
            ColonyListModel colonyListModel = new ColonyListModelMapper().transformToRealmDb(colonyList);
            dataSchema.saveData(colonyListModel);
            dataSchema.closeRealm();
        }
    }

    public void saveUsageList(UsageList usageList) {
        if (usageList != null) {
            PropertyRealm<UsageList> dataSchema = new PropertyRealm(surveyAppApplication.getPropertyDataRealm());
            dataSchema.clearAllData(UsageListModel.class);
            UsageListModel usageListModel= new UsageListModelMapper().transformToRealmDb(usageList);
            dataSchema.saveData(usageListModel);
            dataSchema.closeRealm();
        }
    }

    public void saveMeasurementList(MeasurementUnitList measurementUnitList) {
        if (measurementUnitList != null) {
            PropertyRealm<MeasurementUnitList> dataSchema = new PropertyRealm(surveyAppApplication.getPropertyDataRealm());
            dataSchema.clearAllData(MeasurementUnitListModel.class);
            MeasurementUnitListModel measurementUnitListModel= new MeasurementUnitListModelMapper().transformToRealmDb(measurementUnitList);
            dataSchema.saveData(measurementUnitListModel);
            dataSchema.closeRealm();
        }
    }

    public void saveFloorList(FloorsList floorsList) {
        if (floorsList != null) {
            PropertyRealm<FloorsList> dataSchema = new PropertyRealm(surveyAppApplication.getPropertyDataRealm());
            dataSchema.clearAllData(FloorsListModel.class);
            FloorsListModel floorsListModel= new FloorsListModelMapper().transformToRealmDb(floorsList);
            dataSchema.saveData(floorsListModel);
            dataSchema.closeRealm();
        }
    }

    public void saveOwnerShipList(OwnerShipList ownerShipList) {
        if (ownerShipList != null) {
            PropertyRealm<OwnerShipList> dataSchema = new PropertyRealm(surveyAppApplication.getPropertyDataRealm());
            dataSchema.clearAllData(OwnerShipListModel.class);
            OwnerShipListModel ownerShipListModel= new OwnerShipListModelMapper().transformToRealmDb(ownerShipList);
            dataSchema.saveData(ownerShipListModel);
            dataSchema.closeRealm();
        }
    }

    public void saveAreaType(AreaType areaType) {
        if (areaType != null) {
            PropertyRealm<AreaType> dataSchema = new PropertyRealm(surveyAppApplication.getPropertyDataRealm());
            dataSchema.clearAllData(AreaTypeModel.class);
            AreaTypeModel areaTypeModel= new AreaTypeModelMapper().transformToRealmDb(areaType);
            dataSchema.saveData(areaTypeModel);
        }
    }

    public void saveConstructionType(ConstructionType constructionType) {
        if (constructionType != null) {
            PropertyRealm<ConstructionType> dataSchema = new PropertyRealm(surveyAppApplication.getPropertyDataRealm());
            dataSchema.clearAllData(ConstructionTypeModel.class);
            ConstructionTypeModel constructionTypeModel= new ConstructionTypeModelMapper().transformToRealmDb(constructionType);
            dataSchema.saveData(constructionTypeModel);
            dataSchema.closeRealm();
        }
    }

    public void savePropertyIdList(OLDPropertyUIDS oldPropertyUIDS) {
        if (oldPropertyUIDS != null) {
            PropertyRealm<OLDPropertyUIDS> dataSchema = new PropertyRealm(surveyAppApplication.getPropertyDataRealm());
            dataSchema.clearAllData(OldPropertyUIDSModel.class);
            OldPropertyUIDSModel oldPropertyUIDSModel= new OldPropertyUIDSModelMapper().transformToRealmDb(oldPropertyUIDS);
            dataSchema.saveData(oldPropertyUIDSModel);
            dataSchema.closeRealm();
        }
    }





    public Observable<List<FormData>> getFormDataList() {
        Realm realm = surveyAppApplication.getPropertyDataRealm();
        PropertyRealm propertyRealm = new PropertyRealm(realm);
        RealmResults<FormDataModel> propertyRealmAllData = propertyRealm.getAllData(FormDataModel.class);
        if (propertyRealmAllData != null && propertyRealmAllData.size() > 0) {
            RealmList<FormDataModel> propertyCategoryListModels = new RealmList<>();
            propertyCategoryListModels.addAll(propertyRealmAllData);
            List<FormData> formData = new ArrayList<>();
            for(int i= 0;i<propertyCategoryListModels.size();i++) {
                formData.add(new FormDataModelMapper().transformToViewModel(propertyCategoryListModels.get(i)));
            }
            if (formData != null) {
                propertyRealm.closeRealm();
                return Observable.just(formData);
            }
        }
        propertyRealm.closeRealm();
        return Observable.just(null);
    }



    public Observable<PropertyCategoryList> getPropertyCategoryList() {
        Realm realm = surveyAppApplication.getPropertyDataRealm();
        PropertyRealm propertyRealm = new PropertyRealm(realm);
        RealmResults<PropertyCategoryListModel> propertyRealmAllData = propertyRealm.getAllData(PropertyCategoryListModel.class);
        if (propertyRealmAllData != null && propertyRealmAllData.size() > 0) {
            RealmList<PropertyCategoryListModel> propertyCategoryListModels = new RealmList<>();
            propertyCategoryListModels.addAll(propertyRealmAllData);
            PropertyCategoryList propertyCategoryList = new PropertyCategoryListModelMapper().transformToViewModel(propertyCategoryListModels.get(0));
            propertyRealm.closeRealm();
            return Observable.just(propertyCategoryList);
        }
        propertyRealm.closeRealm();
        return Observable.just(null);
    }


    public Observable<PropertyTypes> getPropertyTypes(int id) {
                Realm realm = surveyAppApplication.getPropertyDataRealm();
                PropertyRealm propertyRealm = new PropertyRealm(realm);
                RealmResults<PropertyTypesModel> propertyRealmAllData = propertyRealm.getData(PropertyTypesModel.class, key, id+"");
                if (propertyRealmAllData != null && propertyRealmAllData.size() > 0) {
                    RealmList<PropertyTypesModel> propertyTypesModelRealmList = new RealmList<>();
                    propertyTypesModelRealmList.addAll(propertyRealmAllData);
                    PropertyTypes propertyTypes = new PropertyTypesModelMapper().transformToViewModel(propertyTypesModelRealmList.get(0));
                    propertyRealm.closeRealm();
                    return Observable.just(propertyTypes);
                }
                propertyRealm.closeRealm();
                return Observable.just(null);
    }


    public Observable<PropertySubCategoryList> getPropertySubCategoryList(int id) {
                Realm realm = surveyAppApplication.getPropertyDataRealm();
                PropertyRealm propertyRealm = new PropertyRealm(realm);
                RealmResults<PropertySubCategoryListModel> propertyRealmAllData = propertyRealm.getData(PropertySubCategoryListModel.class,key,id+"");
                if (propertyRealmAllData != null && propertyRealmAllData.size() > 0) {
                    RealmList<PropertySubCategoryListModel> propertySubCategoryListModelRealmList = new RealmList<>();
                    propertySubCategoryListModelRealmList.addAll(propertyRealmAllData);
                    PropertySubCategoryList propertySubCategoryList = new PropertySubCategoryListModelMapper().transformToViewModel(propertySubCategoryListModelRealmList.get(0));
                    if (propertySubCategoryList != null) {
                        propertyRealm.closeRealm();
                        return Observable.just(propertySubCategoryList);
                    }
                }
                propertyRealm.closeRealm();
                return Observable.just(null);
    }


    public Observable<RebateList> getRebateList() {
        Realm realm = surveyAppApplication.getPropertyDataRealm();
        PropertyRealm propertyRealm = new PropertyRealm(realm);
                RealmResults<RebateListModel> propertyRealmAllData = propertyRealm.getAllData(RebateListModel.class);
                if (propertyRealmAllData != null && propertyRealmAllData.size() > 0) {
                    RealmList<RebateListModel> rebateListModelRealmList = new RealmList<>();
                    rebateListModelRealmList.addAll(propertyRealmAllData);
                    RebateList rebateList = new RebateListModelMapper().transformToViewModel(rebateListModelRealmList.get(0));
                    if (rebateList != null) {
                        return Observable.just(rebateList);
                    }
                }
                return Observable.just(null);
    }


    public Observable<ColonyList> getColonyList() {
        Realm realm = surveyAppApplication.getPropertyDataRealm();
        PropertyRealm propertyRealm = new PropertyRealm(realm);
                RealmResults<ColonyListModel> propertyRealmAllData = propertyRealm.getAllData(ColonyListModel.class);
                if (propertyRealmAllData != null && propertyRealmAllData.size() > 0) {
                    RealmList<ColonyListModel> colonyListModelRealmList = new RealmList<>();
                    colonyListModelRealmList.addAll(propertyRealmAllData);
                    ColonyList colonyList = new ColonyListModelMapper().transformToViewModel(colonyListModelRealmList.get(0));
                    if (colonyList != null) {
                        propertyRealm.closeRealm();
                        return Observable.just(colonyList);
                    }
                }
                propertyRealm.closeRealm();
                return Observable.just(null);
    }


    public Observable<UsageList> getUsageList() {
                Realm realm = surveyAppApplication.getPropertyDataRealm();
                PropertyRealm propertyRealm = new PropertyRealm(realm);
                RealmResults<UsageListModel> propertyRealmAllData = propertyRealm.getAllData(UsageListModel.class);
                if (propertyRealmAllData != null && propertyRealmAllData.size() > 0) {
                    RealmList<UsageListModel> usageListModelRealmList = new RealmList<>();
                    usageListModelRealmList.addAll(propertyRealmAllData);
                    UsageList usageList = new UsageListModelMapper().transformToViewModel(usageListModelRealmList.get(0));
                    if (usageList != null) {
                        propertyRealm.closeRealm();
                       return Observable.just(usageList);
                    }
                }
                propertyRealm.closeRealm();
                return Observable.just(null);
    }


    public Observable<MeasurementUnitList> getMeasurementUnitList() {
                Realm realm = surveyAppApplication.getPropertyDataRealm();
                PropertyRealm propertyRealm = new PropertyRealm(realm);
                RealmResults<MeasurementUnitListModel> propertyRealmAllData = propertyRealm.getAllData(MeasurementUnitListModel.class);
                if (propertyRealmAllData != null && propertyRealmAllData.size() > 0) {
                    RealmList<MeasurementUnitListModel> measurementUnitListModelRealmList = new RealmList<>();
                    measurementUnitListModelRealmList.addAll(propertyRealmAllData);
                    MeasurementUnitList measurementUnitList = new MeasurementUnitListModelMapper().transformToViewModel(measurementUnitListModelRealmList.get(0));
                    if (measurementUnitList != null) {
                        propertyRealm.closeRealm();
                        return Observable.just(measurementUnitList);
                    }
                }
                propertyRealm.closeRealm();
                return Observable.just(null);
    }


    public Observable<FloorsList> getFloorList() {
                Realm realm = surveyAppApplication.getPropertyDataRealm();
                PropertyRealm propertyRealm = new PropertyRealm(realm);
                RealmResults<FloorsListModel> propertyRealmAllData = propertyRealm.getAllData(FloorsListModel.class);
                if (propertyRealmAllData != null && propertyRealmAllData.size() > 0) {
                    RealmList<FloorsListModel> floorsListModelRealmList = new RealmList<>();
                    floorsListModelRealmList.addAll(propertyRealmAllData);
                    FloorsList floorsList = new FloorsListModelMapper().transformToViewModel(floorsListModelRealmList.get(0));
                    if (floorsList != null) {
                        propertyRealm.closeRealm();
                        return Observable.just(floorsList);
                    }

                }
                propertyRealm.closeRealm();
                return Observable.just(null);
    }



    public Observable<OwnerShipList> getOwnerShipList() {
                Realm realm = surveyAppApplication.getPropertyDataRealm();
                PropertyRealm propertyRealm = new PropertyRealm(realm);
                RealmResults<OwnerShipListModel> propertyRealmAllData = propertyRealm.getAllData(OwnerShipListModel.class);
                if (propertyRealmAllData != null && propertyRealmAllData.size() > 0) {
                    RealmList<OwnerShipListModel> ownerShipListModelRealmList = new RealmList<>();
                    ownerShipListModelRealmList.addAll(propertyRealmAllData);
                    OwnerShipList ownerShipList = new OwnerShipListModelMapper().transformToViewModel(ownerShipListModelRealmList.get(0));
                    if (ownerShipList != null) {
                        propertyRealm.closeRealm();
                        return Observable.just(ownerShipList);
                    }
                }
                propertyRealm.closeRealm();
                return Observable.just(null);
    }


    public Observable<AreaType> getAreaType() {
                Realm realm = surveyAppApplication.getPropertyDataRealm();
                PropertyRealm propertyRealm = new PropertyRealm(realm);
                RealmResults<AreaTypeModel> propertyRealmAllData = propertyRealm.getAllData(AreaTypeModel.class);
                if (propertyRealmAllData != null && propertyRealmAllData.size() > 0) {
                    RealmList<AreaTypeModel> areaTypeModelRealmList = new RealmList<>();
                    areaTypeModelRealmList.addAll(propertyRealmAllData);
                    AreaType areaType = new AreaTypeModelMapper().transformToViewModel(areaTypeModelRealmList.get(0));
                    if (areaType != null) {
                        propertyRealm.closeRealm();
                        return Observable.just(areaType);
                    }
                }
                propertyRealm.closeRealm();
                return Observable.just(null);
    }


    public Observable<ConstructionType> getConstructionType() {
                Realm realm = surveyAppApplication.getPropertyDataRealm();
                PropertyRealm propertyRealm = new PropertyRealm(realm);
                RealmResults<ConstructionTypeModel> propertyRealmAllData = propertyRealm.getAllData(ConstructionTypeModel.class);
                if (propertyRealmAllData != null && propertyRealmAllData.size() > 0) {
                    RealmList<ConstructionTypeModel> constructionTypeModelRealmList = new RealmList<>();
                    constructionTypeModelRealmList.addAll(propertyRealmAllData);
                    ConstructionType constructionType = new ConstructionTypeModelMapper().transformToViewModel(constructionTypeModelRealmList.get(0));
                    if (constructionType != null) {
                        propertyRealm.closeRealm();
                        return Observable.just(constructionType);
                    }
                }
                propertyRealm.closeRealm();
                return Observable.just(null);
    }

    String formKey = "oldPropertyUID";

    public Observable<OLDPropertyUIDS> getPropertyIdList(String query) {
                Realm realm = surveyAppApplication.getPropertyDataRealm();
                PropertyRealm propertyRealm = new PropertyRealm(realm);
                RealmResults<FormDataModel> propertyRealmAllData = propertyRealm.contains(key,query,FormDataModel.class);
                if (propertyRealmAllData != null && propertyRealmAllData.size() > 0) {
                    RealmList<OldPropertyUIDItemModel> oldPropertyUIDItemModels =new RealmList<>();
                    for(int i = 0;i< propertyRealmAllData.size();i++) {
                        OldPropertyUIDItemModel oldPropertyUIDItemModel = new OldPropertyUIDItemModel();
                        oldPropertyUIDItemModel.setOldpropertyuid(propertyRealmAllData.get(i).getOldPropertyUID());
                        oldPropertyUIDItemModels.add(oldPropertyUIDItemModel);
                    }
                    OldPropertyUIDSModel oldPropertyUIDSModel = new OldPropertyUIDSModel();
                    oldPropertyUIDSModel.setOldPropertyUID(oldPropertyUIDItemModels);
                    OLDPropertyUIDS oldPropertyUIDS = new OldPropertyUIDSModelMapper().transformToViewModel(oldPropertyUIDSModel);
                    if (oldPropertyUIDS != null) {
                        propertyRealm.closeRealm();
                        return Observable.just(oldPropertyUIDS);
                    }
                }
                propertyRealm.closeRealm();
                return Observable.just(null);
    }



    public Observable<FormData> getFormData(String query) {
        Realm realm = surveyAppApplication.getPropertyDataRealm();
        PropertyRealm propertyRealm = new PropertyRealm(realm);
        RealmResults<FormDataModel> formDataModels = propertyRealm.getData(FormDataModel.class,key,query);
        if (formDataModels != null && formDataModels.size() > 0) {
            RealmList<FormDataModel> formDataModelss = new RealmList<>();
            formDataModelss.addAll(formDataModels);
            FormData formData = new FormDataModelMapper().transformToViewModel(formDataModelss.get(0));
            if (formData != null) {
                propertyRealm.closeRealm();
                return Observable.just(formData);
            }
        }
        propertyRealm.closeRealm();
        return Observable.just(null);

    }

    public Observable<List<FormData>> getUpdateFormData() {
        Realm realm = surveyAppApplication.getPropertyDataRealm();
        PropertyRealm propertyRealm = new PropertyRealm(realm);
        RealmResults<FormDataModel> formDataModels = propertyRealm.getData(FormDataModel.class,"state","UPDATE");
        if (formDataModels != null && formDataModels.size() > 0) {
            RealmList<FormDataModel> formDataModelss = new RealmList<>();
            formDataModelss.addAll(formDataModels);
            List<FormData> formData = new ArrayList<>();
            for(int i= 0;i<formDataModelss.size();i++) {
                formData.add(new FormDataModelMapper().transformToViewModel(formDataModelss.get(i)));
            }
            if (formData != null) {
                propertyRealm.closeRealm();
                return Observable.just(formData);
            }
        }
        propertyRealm.closeRealm();
        return Observable.just(null);
    }

    public Observable<List<BillDetails>> getAllBillDistributionForm() {
        Realm realm = surveyAppApplication.getPropertyDataRealm();
        PropertyRealm propertyRealm = new PropertyRealm(realm);
        RealmResults<BillDetailsModel> billDetailsModels = propertyRealm.getAllData(BillDetailsModel.class);
        if (billDetailsModels != null && billDetailsModels.size() > 0) {
            RealmList<BillDetailsModel> billDetailModels1 = new RealmList<>();
            billDetailModels1.addAll(billDetailsModels);
            List<BillDetails> billDetails = new ArrayList<>();
            for(int i= 0;i<billDetailModels1.size();i++) {
                billDetails.add(new BillDetailsModelMapper().transformToViewModel(billDetailModels1.get(i)));
            }
            if (billDetails != null) {
                propertyRealm.closeRealm();
                return Observable.just(billDetails);
            }
        }
        propertyRealm.closeRealm();
        return Observable.just(null);
    }

    public Observable<List<BillDetails>> getUpdateBillDistributionForm() {
        Realm realm = surveyAppApplication.getPropertyDataRealm();
        PropertyRealm propertyRealm = new PropertyRealm(realm);
        RealmResults<BillDetailsModel> billDetailsModels = propertyRealm.getData(BillDetailsModel.class,"state","UPDATE");
        if (billDetailsModels != null && billDetailsModels.size() > 0) {
            RealmList<BillDetailsModel> billDetailModels1 = new RealmList<>();
            billDetailModels1.addAll(billDetailsModels);
            List<BillDetails> billDetails = new ArrayList<>();
            for(int i= 0;i<billDetailModels1.size();i++) {
                billDetails.add(new BillDetailsModelMapper().transformToViewModel(billDetailModels1.get(i)));
            }
            if (billDetails != null) {
                propertyRealm.closeRealm();
                return Observable.just(billDetails);
            }
        }
        propertyRealm.closeRealm();
        return Observable.just(null);
    }
    public Observable<List<FormData>> getNewFormData() {
        Realm realm = surveyAppApplication.getPropertyDataRealm();
        PropertyRealm propertyRealm = new PropertyRealm(realm);
        RealmResults<FormDataModel> formDataModels = propertyRealm.getData(FormDataModel.class,"state","NEW");
        if (formDataModels != null && formDataModels.size() > 0) {
            RealmList<FormDataModel> formDataModelss = new RealmList<>();
            formDataModelss.addAll(formDataModels);
            List<FormData> formData = new ArrayList<>();
            for(int i= 0;i<formDataModelss.size();i++) {
                 formData.add(new FormDataModelMapper().transformToViewModel(formDataModelss.get(i)));
            }
            if (formData != null) {
                propertyRealm.closeRealm();
                return Observable.just(formData);
            }
        }
        propertyRealm.closeRealm();
        return Observable.just(null);
    }
    public void delete(String keyValue) {
        PropertyRealm dataSchema = new PropertyRealm(surveyAppApplication.getPropertyDataRealm());
        dataSchema.delete(key, keyValue, BillDetailsModel.class);
        dataSchema.delete(key, keyValue, FormDataModel.class);
        dataSchema.closeRealm();
    }

    public <T> void delete(String keyValue, Class<T> tClass) {
        PropertyRealm dataSchema = new PropertyRealm(surveyAppApplication.getPropertyDataRealm());
        dataSchema.delete(key, keyValue, tClass);
        dataSchema.closeRealm();
    }

    public void clearCache() {
        PropertyRealm dataSchema = new PropertyRealm(surveyAppApplication.getPropertyDataRealm());
        dataSchema.clearRealmDb();
        dataSchema.closeRealm();
    }
}
