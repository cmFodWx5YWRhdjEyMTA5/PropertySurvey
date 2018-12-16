package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.OwnerShipList;
import com.softminesol.propertysurvey.survey.common.realm.model.OwnerShipListModel;

public class OwnerShipListModelMapper {

    public OwnerShipListModel transformToRealmDb(OwnerShipList ownerShipList) {
        OwnerShipListModel ownerShipListModel = null;
        if (ownerShipList != null) {
            ownerShipListModel = new OwnerShipListModel();
            ownerShipListModel.setOwnership(new OwnershipItemModelMapper().transformToRealmDb(ownerShipList.getOwnership()));
        }
        return ownerShipListModel;
    }

    public OwnerShipList transformToViewModel(OwnerShipListModel ownerShipListModel) {
        OwnerShipList ownerShipList = null;
        if (ownerShipListModel != null) {
            ownerShipList = new OwnerShipList();
            ownerShipList.setOwnership(new OwnershipItemModelMapper().transformToViewModel(ownerShipListModel.getOwnership()));
        }
        return ownerShipList;
    }
}
