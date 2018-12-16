package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.ColoniesItem;
import com.softminesol.propertysurvey.survey.common.realm.model.ColoniesItemModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class ColoniesItemModelMapper {

    public ColoniesItemModel transformToRealmDb(ColoniesItem coloniesItem) {
        ColoniesItemModel coloniesItemModel = null;
        if (coloniesItem != null) {
            coloniesItemModel = new ColoniesItemModel();
            coloniesItemModel.setColonyid(coloniesItem.getColonyid());
            coloniesItemModel.setColonyname(coloniesItem.getColonyname());
        }
        return coloniesItemModel;
    }

    public RealmList<ColoniesItemModel> transformToRealmDb(List<ColoniesItem> coloniesItemList) {
        RealmList<ColoniesItemModel> realmList = null;
        if (coloniesItemList != null) {
            realmList = new RealmList<>();
            for (ColoniesItem coloniesItem : coloniesItemList) {
                realmList.add(transformToRealmDb(coloniesItem));
            }
        }
        return realmList;
    }

    public ColoniesItem transformToViewModel(ColoniesItemModel coloniesItemModel) {
        ColoniesItem coloniesItem = null;
        if (coloniesItemModel != null) {
            coloniesItem = new ColoniesItem();
            coloniesItem.setColonyname(coloniesItemModel.getColonyname());
            coloniesItem.setColonyid(coloniesItemModel.getColonyid());
        }
        return coloniesItem;
    }

    public List<ColoniesItem> transformToViewModel(List<ColoniesItemModel> coloniesItemModelList) {
        List<ColoniesItem> coloniesItemList = null;
        if (coloniesItemModelList != null) {
            coloniesItemList = new ArrayList<>();
            for (ColoniesItemModel coloniesItemModel : coloniesItemModelList) {
                coloniesItemList.add(transformToViewModel(coloniesItemModel));
            }
        }
        return coloniesItemList;
    }
}
