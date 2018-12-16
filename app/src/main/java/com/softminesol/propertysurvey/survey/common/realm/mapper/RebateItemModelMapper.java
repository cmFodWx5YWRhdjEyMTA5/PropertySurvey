package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.RebateItem;
import com.softminesol.propertysurvey.survey.common.realm.model.RebateItemModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class RebateItemModelMapper {

    public RebateItemModel transformToRealmDb(RebateItem rebateItem) {
        RebateItemModel rebateItemModel = null;
        if (rebateItem != null) {
            rebateItemModel = new RebateItemModel();
            rebateItemModel.setRebateid(rebateItem.getRebateid());
            rebateItemModel.setRebatedescription(rebateItem.getRebatedescription());
        }
        return rebateItemModel;
    }

    public RealmList<RebateItemModel> transformToRealmDb(List<RebateItem> rebateItemList) {
        RealmList<RebateItemModel> realmList = null;
        if (rebateItemList != null) {
            realmList = new RealmList<>();
            for (RebateItem rebateItem : rebateItemList) {
                realmList.add(transformToRealmDb(rebateItem));
            }
        }
        return realmList;
    }

    public RebateItem transformToViewModel(RebateItemModel rebateItemModel) {
        RebateItem rebateItem = null;
        if (rebateItemModel != null) {
            rebateItem = new RebateItem();
            rebateItem.setRebateid(rebateItemModel.getRebateid());
            rebateItem.setRebatedescription(rebateItemModel.getRebatedescription());
        }
        return rebateItem;
    }

    public List<RebateItem> transformToViewModel(List<RebateItemModel> rebateItemModelList) {
        List<RebateItem> rebateItemList = null;
        if (rebateItemModelList != null) {
            rebateItemList = new ArrayList<>();
            for (RebateItemModel rebateItemModel : rebateItemModelList) {
                rebateItemList.add(transformToViewModel(rebateItemModel));
            }
        }
        return rebateItemList;
    }

}
