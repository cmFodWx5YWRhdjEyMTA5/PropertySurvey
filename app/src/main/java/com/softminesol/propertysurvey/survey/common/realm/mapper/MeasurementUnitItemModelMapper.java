package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.MeasurementUnitItem;
import com.softminesol.propertysurvey.survey.common.realm.model.MeasurementUnitItemModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class MeasurementUnitItemModelMapper {

    public MeasurementUnitItemModel transformToRealmDb(MeasurementUnitItem measurementUnitItem) {
        MeasurementUnitItemModel measurementUnitItemModel = null;
        if (measurementUnitItem != null) {
            measurementUnitItemModel = new MeasurementUnitItemModel();
            measurementUnitItemModel.setMeasurementid(measurementUnitItem.getMeasurementid());
            measurementUnitItemModel.setMeasurementunit(measurementUnitItem.getMeasurementunit());
        }
        return measurementUnitItemModel;
    }

    public RealmList<MeasurementUnitItemModel> transformToRealmDb(List<MeasurementUnitItem> measurementUnitItemList) {
        RealmList<MeasurementUnitItemModel> realmList = null;
        if (measurementUnitItemList != null) {
            realmList = new RealmList<>();
            for (MeasurementUnitItem measurementUnitItem : measurementUnitItemList) {
                realmList.add(transformToRealmDb(measurementUnitItem));
            }
        }
        return realmList;
    }

    public MeasurementUnitItem transformToViewModel(MeasurementUnitItemModel measurementUnitItemModel) {
        MeasurementUnitItem measurementUnitItem = null;
        if (measurementUnitItemModel != null) {
            measurementUnitItem = new MeasurementUnitItem();
            measurementUnitItem.setMeasurementid(measurementUnitItemModel.getMeasurementid());
            measurementUnitItem.setMeasurementunit(measurementUnitItemModel.getMeasurementunit());
        }
        return measurementUnitItem;
    }

    public List<MeasurementUnitItem> transformToViewModel(List<MeasurementUnitItemModel> floorsItemModelList) {
        List<MeasurementUnitItem> floorsItemList = null;
        if (floorsItemModelList != null) {
            floorsItemList = new ArrayList<>();
            for (MeasurementUnitItemModel floorsItemModel : floorsItemModelList) {
                floorsItemList.add(transformToViewModel(floorsItemModel));
            }
        }
        return floorsItemList;
    }

}
