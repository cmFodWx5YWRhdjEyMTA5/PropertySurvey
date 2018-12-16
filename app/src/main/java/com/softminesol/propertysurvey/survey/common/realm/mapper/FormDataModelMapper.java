package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.formData.FormData;
import com.softminesol.propertysurvey.survey.common.realm.model.FormDataModel;

public class FormDataModelMapper {

    public FormDataModel transformToRealmDb(FormData formData) {
        FormDataModel formDataModel = new FormDataModel();
        if (formData != null) {
            formDataModel.setTotalAreaMeasurementUnit(formData.getTotalAreaMeasurementUnit());
            formDataModel.setWardNo(formData.getWardNo());
            formDataModel.setDistrictCode(formData.getDistrictCode());
            formDataModel.setState(formData.getState());
            formDataModel.setFloorcount(formData.getFloorcount());
            formDataModel.setStreetCode(formData.getStreetCode());
            formDataModel.setColonyName(formData.getColonyName());
            formDataModel.setMeasurementUnit(formData.getMeasurementUnit());
            formDataModel.setPropertyUID(formData.getPropertyUID());
            formDataModel.setZone(formData.getZone());
            formDataModel.setLocationID(formData.getLocationID());
            formDataModel.setFloorDetails(new FloorDetailsItemModelMapper().transformToRealmDb(formData.getFloorDetails()));
            formDataModel.setAreaType(formData.getAreaType());
            formDataModel.setBasePlotSizeWidth(formData.getBasePlotSizeWidth());
            formDataModel.setBasePlotSizeLength(formData.getBasePlotSizeLength());
            formDataModel.setAddressLine1(formData.getAddressLine1());
            formDataModel.setStateCode(formData.getStateCode());
            formDataModel.setYearOfSeverageConnection(formData.getYearOfSeverageConnection());
            formDataModel.setSeverageConnection(formData.getSeverageConnection());
            formDataModel.setOldPropertyUID(formData.getOldPropertyUID());
            formDataModel.setPropertyNumber(formData.getPropertyNumber());
            formDataModel.setTotalArea(formData.getTotalArea());
            formDataModel.setWaterConnection(formData.getWaterConnection());
            formDataModel.setMCCOde(formData.getMCCOde());
            formDataModel.setMSMO(formData.getMSMO());
            formDataModel.setRemarks(formData.getRemarks());
        }
        return formDataModel;
    }

    public FormData transformToViewModel(FormDataModel formDataModel) {
        FormData formData = new FormData();
        if (formDataModel != null) {
            formData.setTotalAreaMeasurementUnit(formDataModel.getTotalAreaMeasurementUnit());
            formData.setWardNo(formDataModel.getWardNo());
            formData.setDistrictCode(formDataModel.getDistrictCode());
            formData.setFloorcount(formDataModel.getFloorcount());
            formData.setStreetCode(formDataModel.getStreetCode());
            formData.setColonyName(formDataModel.getColonyName());
            formData.setState(formDataModel.getState());
            formData.setMeasurementUnit(formDataModel.getMeasurementUnit());
            formData.setPropertyUID(formDataModel.getPropertyUID());
            formData.setZone(formDataModel.getZone());
            formData.setLocationID(formDataModel.getLocationID());
            formData.setFloorDetails(new FloorDetailsItemModelMapper().transformToViewModel(formDataModel.getFloorDetails()));
            formData.setAreaType(formDataModel.getAreaType());
            formData.setBasePlotSizeWidth(formDataModel.getBasePlotSizeWidth());
            formData.setBasePlotSizeLength(formDataModel.getBasePlotSizeLength());
            formData.setAddressLine1(formDataModel.getAddressLine1());
            formData.setStateCode(formDataModel.getStateCode());
            formData.setYearOfSeverageConnection(formDataModel.getYearOfSeverageConnection());
            formData.setSeverageConnection(formDataModel.getSeverageConnection());
            formData.setOldPropertyUID(formDataModel.getOldPropertyUID());
            formData.setPropertyNumber(formDataModel.getPropertyNumber());
            formData.setTotalArea(formDataModel.getTotalArea());
            formData.setWaterConnection(formDataModel.getWaterConnection());
            formData.setMCCOde(formDataModel.getMCCOde());
            formData.setMSMO(formDataModel.getMSMO());
            formData.setRemarks(formDataModel.getRemarks());
        }
        return formData;
    }
}
