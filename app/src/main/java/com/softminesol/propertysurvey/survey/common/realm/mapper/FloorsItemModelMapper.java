package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.FloorsItem;
import com.softminesol.propertysurvey.survey.common.realm.model.FloorsItemModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class FloorsItemModelMapper {

    public FloorsItemModel transformToRealmDb(FloorsItem floorsItem) {
        FloorsItemModel floorsItemModel = null;
        if (floorsItem != null) {
            floorsItemModel = new FloorsItemModel();
            floorsItemModel.setFloorid(floorsItem.getFloorid());
            floorsItemModel.setFloor(floorsItem.getText());
        }
        return floorsItemModel;
    }

    public RealmList<FloorsItemModel> transformToRealmDb(List<FloorsItem> floorsItemList) {
        RealmList<FloorsItemModel> realmList = null;
        if (floorsItemList != null) {
            realmList = new RealmList<>();
            for (FloorsItem floorsItem : floorsItemList) {
                realmList.add(transformToRealmDb(floorsItem));
            }
        }
        return realmList;
    }

    public FloorsItem transformToViewModel(FloorsItemModel floorsItemModel) {
        FloorsItem floorsItem = null;
        if (floorsItemModel != null) {
            floorsItem = new FloorsItem();
            floorsItem.setFloorid(floorsItemModel.getFloorid());
            floorsItem.setFloor(floorsItemModel.getText());
        }
        return floorsItem;
    }

    public List<FloorsItem> transformToViewModel(List<FloorsItemModel> floorsItemModelList) {
        List<FloorsItem> floorsItemList = null;
        if (floorsItemModelList != null) {
            floorsItemList = new ArrayList<>();
            for (FloorsItemModel floorsItemModel : floorsItemModelList) {
                floorsItemList.add(transformToViewModel(floorsItemModel));
            }
        }
        return floorsItemList;
    }

}
