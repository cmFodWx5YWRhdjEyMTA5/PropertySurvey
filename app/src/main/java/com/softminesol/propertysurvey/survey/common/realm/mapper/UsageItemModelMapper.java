package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.UsageItem;
import com.softminesol.propertysurvey.survey.common.realm.model.UsageItemModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class UsageItemModelMapper {

    public UsageItemModel transformToRealmDb(UsageItem usageItem) {
        UsageItemModel usageItemModel = null;
        if (usageItem != null) {
            usageItemModel = new UsageItemModel();
            usageItemModel.setUsageid(usageItem.getUsageid());
            usageItemModel.setUsagedescription(usageItem.getUsagedescription());
        }
        return usageItemModel;
    }

    public RealmList<UsageItemModel> transformToRealmDb(List<UsageItem> usageItemList) {
        RealmList<UsageItemModel> realmList = null;
        if (usageItemList != null) {
            realmList = new RealmList<>();
            for (UsageItem usageItem : usageItemList) {
                realmList.add(transformToRealmDb(usageItem));
            }
        }
        return realmList;
    }

    public UsageItem transformToViewModel(UsageItemModel usageItemModel) {
        UsageItem usageItem = null;
        if (usageItemModel != null) {
            usageItem = new UsageItem();
            usageItem.setUsageid(usageItemModel.getUsageid());
            usageItem.setUsagedescription(usageItemModel.getUsagedescription());
        }
        return usageItem;
    }

    public List<UsageItem> transformToViewModel(List<UsageItemModel> usageItemModelList) {
        List<UsageItem> usageItemList = null;
        if (usageItemModelList != null) {
            usageItemList = new ArrayList<>();
            for (UsageItemModel usageItemModel : usageItemModelList) {
                usageItemList.add(transformToViewModel(usageItemModel));
            }
        }
        return usageItemList;
    }

}
