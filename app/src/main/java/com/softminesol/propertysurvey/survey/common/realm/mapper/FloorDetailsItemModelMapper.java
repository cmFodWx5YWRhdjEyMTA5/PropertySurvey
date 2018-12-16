package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.formData.FloorDetailsItem;
import com.softminesol.propertysurvey.survey.common.realm.model.FloorDetailsItemModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class FloorDetailsItemModelMapper {

    public FloorDetailsItemModel transformToRealmDb(FloorDetailsItem floorDetailsItem) {
        FloorDetailsItemModel floorDetailsItemModel = null;
        if (floorDetailsItem != null) {
            floorDetailsItemModel = new FloorDetailsItemModel();
            floorDetailsItemModel.setTradeLicesenceNumber(floorDetailsItem.getTradeLicesenceNumber());
            floorDetailsItemModel.setConstructionType(floorDetailsItem.getConstructionType());
            floorDetailsItemModel.setPropertySubType(floorDetailsItem.getPropertySubType());
            floorDetailsItemModel.setCoveredArea(floorDetailsItem.getCoveredArea());
            floorDetailsItemModel.setIsBPL(floorDetailsItem.getIsBPL());
            floorDetailsItemModel.setFloorType(floorDetailsItem.getFloorType());
            floorDetailsItemModel.setYearOfConstruction(floorDetailsItem.getYearOfConstruction());
            floorDetailsItemModel.setOccupierName(floorDetailsItem.getOccupierName());
            floorDetailsItemModel.setPropertyOwnerType(floorDetailsItem.getPropertyOwnerType());
            floorDetailsItemModel.setTitleOfBuilding(floorDetailsItem.getTitleOfBuilding());
            floorDetailsItemModel.setPropertyOwnerCount(floorDetailsItem.getPropertyOwnerCount());
            floorDetailsItemModel.setBplNumber(floorDetailsItem.getBplNumber());
            floorDetailsItemModel.setPropertyImagePath(floorDetailsItem.getImagePath());
            floorDetailsItemModel.setOwnerDetails(new OwnerDetailsItemModelMapper().transformToRealmDb(floorDetailsItem.getOwnerDetails()));
            floorDetailsItemModel.setCoveredAreaMeasurementUnit(floorDetailsItem.getCoveredAreaMeasurementUnit());
            floorDetailsItemModel.setPropertyType(floorDetailsItem.getPropertyType());
            floorDetailsItemModel.setPropertyImageID(floorDetailsItem.getPropertyImageID());
            floorDetailsItemModel.setYearOfEstablishment(floorDetailsItem.getYearOfEstablishment());
            floorDetailsItemModel.setLicesenceIssueDate(floorDetailsItem.getLicesenceIssueDate());
            floorDetailsItemModel.setTypeOfBusiness(floorDetailsItem.getTypeOfBusiness());
            floorDetailsItemModel.setPropertyCategory(floorDetailsItem.getPropertyCategory());
            floorDetailsItemModel.setRebateID(floorDetailsItem.getRebateID());
            floorDetailsItemModel.setUsageType(floorDetailsItem.getUsageType());
            floorDetailsItemModel.setYearOfOccupying(floorDetailsItem.getYearOfOccupying());
        }
        return floorDetailsItemModel;
    }

    public RealmList<FloorDetailsItemModel> transformToRealmDb(List<FloorDetailsItem> floorDetailsItemList) {
        RealmList<FloorDetailsItemModel> realmList = null;
        if (floorDetailsItemList != null) {
            realmList = new RealmList<>();
            for (FloorDetailsItem floorDetailsItem : floorDetailsItemList) {
                realmList.add(transformToRealmDb(floorDetailsItem));
            }
        }
        return realmList;
    }

    public FloorDetailsItem transformToViewModel(FloorDetailsItemModel floorDetailsItemModel) {
        FloorDetailsItem floorDetailsItem = null;
        if (floorDetailsItemModel != null) {
            floorDetailsItem = new FloorDetailsItem();
            floorDetailsItem.setTradeLicesenceNumber(floorDetailsItemModel.getTradeLicesenceNumber());
            floorDetailsItem.setConstructionType(floorDetailsItemModel.getConstructionType());
            floorDetailsItem.setPropertySubType(floorDetailsItemModel.getPropertySubType());
            floorDetailsItem.setCoveredArea(floorDetailsItemModel.getCoveredArea());
            floorDetailsItem.setIsBPL(floorDetailsItemModel.getIsBPL());
            floorDetailsItem.setFloorType(floorDetailsItemModel.getFloorType());
            floorDetailsItem.setYearOfConstruction(floorDetailsItemModel.getYearOfConstruction());
            floorDetailsItem.setOccupierName(floorDetailsItemModel.getOccupierName());
            floorDetailsItem.setPropertyOwnerType(floorDetailsItemModel.getPropertyOwnerType());
            floorDetailsItem.setTitleOfBuilding(floorDetailsItemModel.getTitleOfBuilding());
            floorDetailsItem.setPropertyOwnerCount(floorDetailsItemModel.getPropertyOwnerCount());
            floorDetailsItem.setBplNumber(floorDetailsItemModel.getBplNumber());
            floorDetailsItem.setOwnerDetails(new OwnerDetailsItemModelMapper().transformToViewModel(floorDetailsItemModel.getOwnerDetails()));
            floorDetailsItem.setCoveredAreaMeasurementUnit(floorDetailsItemModel.getCoveredAreaMeasurementUnit());
            floorDetailsItem.setPropertyType(floorDetailsItemModel.getPropertyType());
            floorDetailsItem.setPropertyImageID(floorDetailsItemModel.getPropertyImageID());
            floorDetailsItem.setYearOfEstablishment(floorDetailsItemModel.getYearOfEstablishment());
            floorDetailsItem.setImagePath(floorDetailsItemModel.getPropertyImagePath());
            floorDetailsItem.setLicesenceIssueDate(floorDetailsItemModel.getLicesenceIssueDate());
            floorDetailsItem.setTypeOfBusiness(floorDetailsItemModel.getTypeOfBusiness());
            floorDetailsItem.setPropertyCategory(floorDetailsItemModel.getPropertyCategory());
            floorDetailsItem.setRebateID(floorDetailsItemModel.getRebateID());
            floorDetailsItem.setUsageType(floorDetailsItemModel.getUsageType());
            floorDetailsItem.setOccupyingYear(floorDetailsItemModel.getYearOfOccupying());
        }
        return floorDetailsItem;
    }


    public List<FloorDetailsItem> transformToViewModel(RealmList<FloorDetailsItemModel> floorDetailsItemModelRealmList) {
        List<FloorDetailsItem> floorDetailsItemList = null;
        if (floorDetailsItemModelRealmList != null) {
            floorDetailsItemList = new ArrayList<>();
            for (FloorDetailsItemModel floorDetailsItemModel : floorDetailsItemModelRealmList) {
                floorDetailsItemList.add(transformToViewModel(floorDetailsItemModel));
            }
        }
        return floorDetailsItemList;
    }
}
