package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.formData.OwnerDetailsItem;
import com.softminesol.propertysurvey.survey.common.realm.model.OwnerDetailsItemModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class OwnerDetailsItemModelMapper {

    public OwnerDetailsItemModel transformToRealmDB(OwnerDetailsItem ownerDetailsItem) {
        OwnerDetailsItemModel ownerDetailsItemModel = null;
        if (ownerDetailsItem != null) {
            ownerDetailsItemModel = new OwnerDetailsItemModel();
            ownerDetailsItemModel.setRelationName(ownerDetailsItem.getRelationName());
            ownerDetailsItemModel.setRelationWith(ownerDetailsItem.getRelationWith());
            ownerDetailsItemModel.setMobileNumber(ownerDetailsItem.getMobileNumber());
            ownerDetailsItemModel.setName(ownerDetailsItem.getName());
            ownerDetailsItemModel.setAddressLine1(ownerDetailsItem.getAddressLine1());
            ownerDetailsItemModel.setEmailID(ownerDetailsItem.getEmailID());
            ownerDetailsItemModel.setOwnershipShare(ownerDetailsItem.getOwnershipShare());
        }
        return ownerDetailsItemModel;
    }

    public RealmList<OwnerDetailsItemModel> transformToRealmDb(List<OwnerDetailsItem> ownerDetailsItemList) {
        RealmList<OwnerDetailsItemModel> realmList = null;
        if (ownerDetailsItemList != null) {
            realmList = new RealmList<>();
            for (OwnerDetailsItem ownerDetailsItem : ownerDetailsItemList) {
                realmList.add(transformToRealmDB(ownerDetailsItem));
            }
        }
        return realmList;
    }

    public OwnerDetailsItem transformToViewModel(OwnerDetailsItemModel ownerDetailsItemModel) {
        OwnerDetailsItem ownerDetailsItem = null;
        if (ownerDetailsItemModel != null) {
            ownerDetailsItem = new OwnerDetailsItem();
            ownerDetailsItem.setRelationName(ownerDetailsItemModel.getRelationName());
            ownerDetailsItem.setRelationWith(ownerDetailsItemModel.getRelationWith());
            ownerDetailsItem.setMobileNumber(ownerDetailsItemModel.getMobileNumber());
            ownerDetailsItem.setName(ownerDetailsItemModel.getName());
            ownerDetailsItem.setAddressLine1(ownerDetailsItemModel.getAddressLine1());
            ownerDetailsItem.setEmailID(ownerDetailsItemModel.getEmailID());
            ownerDetailsItem.setOwnershipShare(ownerDetailsItemModel.getOwnershipShare());
        }
        return ownerDetailsItem;
    }

    public List<OwnerDetailsItem> transformToViewModel(RealmList<OwnerDetailsItemModel> ownerDetailsItemModelRealmList) {
        List<OwnerDetailsItem> ownerDetailsItemList = null;
        if (ownerDetailsItemModelRealmList != null) {
            ownerDetailsItemList = new ArrayList<>();
            for (OwnerDetailsItemModel ownerDetailsItemModel : ownerDetailsItemModelRealmList) {
                ownerDetailsItemList.add(transformToViewModel(ownerDetailsItemModel));
            }
        }
        return ownerDetailsItemList;
    }
}
