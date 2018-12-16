package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.OwnershipItem;
import com.softminesol.propertysurvey.survey.common.realm.model.OwnershipItemModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class OwnershipItemModelMapper {

    public OwnershipItemModel transformToRealmDb(OwnershipItem ownershipItem) {
        OwnershipItemModel ownershipItemModel = null;
        if (ownershipItem != null) {
            ownershipItemModel = new OwnershipItemModel();
            ownershipItemModel.setOwnershipid(ownershipItem.getOwnershipid());
            ownershipItemModel.setOwnership(ownershipItem.getOwnership());
        }
        return ownershipItemModel;
    }

    public RealmList<OwnershipItemModel> transformToRealmDb(List<OwnershipItem> ownershipItemList) {
        RealmList<OwnershipItemModel> realmList = null;
        if (ownershipItemList != null) {
            realmList = new RealmList<>();
            for (OwnershipItem ownershipItem : ownershipItemList) {
                realmList.add(transformToRealmDb(ownershipItem));
            }
        }
        return realmList;
    }

    public OwnershipItem transformToViewModel(OwnershipItemModel ownershipItemModel) {
        OwnershipItem ownershipItem = null;
        if (ownershipItemModel != null) {
            ownershipItem = new OwnershipItem();
            ownershipItem.setOwnershipid(ownershipItemModel.getOwnershipid());
            ownershipItem.setOwnership(ownershipItemModel.getOwnership());
        }
        return ownershipItem;
    }

    public List<OwnershipItem> transformToViewModel(List<OwnershipItemModel> ownershipItemModelList) {
        List<OwnershipItem> ownershipItemList = null;
        if (ownershipItemModelList != null) {
            ownershipItemList = new ArrayList<>();
            for (OwnershipItemModel ownershipItemModel : ownershipItemModelList) {
                ownershipItemList.add(transformToViewModel(ownershipItemModel));
            }
        }
        return ownershipItemList;
    }

}