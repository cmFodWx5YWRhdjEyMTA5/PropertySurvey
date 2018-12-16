package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.MeasurementUnitList;
import com.softminesol.propertysurvey.survey.common.realm.model.MeasurementUnitListModel;

public class MeasurementUnitListModelMapper {

    public MeasurementUnitListModel transformToRealmDb(MeasurementUnitList measurementUnitList) {
        MeasurementUnitListModel measurementUnitListModel = null;
        if (measurementUnitList != null) {
            measurementUnitListModel = new MeasurementUnitListModel();
            measurementUnitListModel.setMeasurementUnit(new MeasurementUnitItemModelMapper().transformToRealmDb(measurementUnitList.getMeasurementUnit()));
        }
        return measurementUnitListModel;
    }

    public MeasurementUnitList transformToViewModel(MeasurementUnitListModel measurementUnitListModel) {
        MeasurementUnitList measurementUnitList = null;
        if ( measurementUnitListModel != null) {
            measurementUnitList = new MeasurementUnitList();
            measurementUnitList.setMeasurementUnit(new MeasurementUnitItemModelMapper().transformToViewModel(measurementUnitListModel.getMeasurementUnit()));
        }
        return measurementUnitList;
    }
}
