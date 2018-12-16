package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.ConstructionTypeItem;
import com.softminesol.propertysurvey.survey.common.realm.model.ConstructionTypeItemModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class ConstructionTypeItemModelMapper {

    public ConstructionTypeItemModel transformToRealmDb(ConstructionTypeItem constructionTypeItem) {
        ConstructionTypeItemModel constructionTypeItemModel = null;
        if (constructionTypeItem != null) {
            constructionTypeItemModel = new ConstructionTypeItemModel();
            constructionTypeItemModel.setConstructiontypeid(constructionTypeItem.getConstructiontypeid());
            constructionTypeItemModel.setConstructiontype(constructionTypeItem.getText());
        }
        return constructionTypeItemModel;
    }

    public RealmList<ConstructionTypeItemModel> transformToRealmDb(List<ConstructionTypeItem> constructionTypeItemList) {
        RealmList<ConstructionTypeItemModel> realmList = null;
        if (constructionTypeItemList != null) {
            realmList = new RealmList<>();
            for (ConstructionTypeItem constructionTypeItem : constructionTypeItemList) {
                realmList.add(transformToRealmDb(constructionTypeItem));
            }
        }
        return realmList;
    }

    public ConstructionTypeItem transformToViewModel(ConstructionTypeItemModel constructionTypeItemModel) {
        ConstructionTypeItem constructionTypeItem = null;
        if (constructionTypeItemModel != null) {
            constructionTypeItem = new ConstructionTypeItem();
            constructionTypeItem.setConstructiontypeid(constructionTypeItemModel.getConstructiontypeid());
            constructionTypeItem.setConstructiontype(constructionTypeItemModel.getText());
        }
        return constructionTypeItem;
    }

    public List<ConstructionTypeItem> transformToViewModel(List<ConstructionTypeItemModel> constructionTypeItemModelList) {
        List<ConstructionTypeItem> constructionTypeItemList = null;
        if (constructionTypeItemModelList != null) {
            constructionTypeItemList = new ArrayList<>();
            for (ConstructionTypeItemModel constructionTypeItemModel : constructionTypeItemModelList) {
                constructionTypeItemList.add(transformToViewModel(constructionTypeItemModel));
            }
        }
        return constructionTypeItemList;
    }
}
