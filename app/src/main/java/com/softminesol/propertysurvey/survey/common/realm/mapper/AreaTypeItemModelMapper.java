package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.AreaTypeItem;
import com.softminesol.propertysurvey.survey.common.realm.model.AreaTypeItemModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class AreaTypeItemModelMapper {

    public AreaTypeItemModel transformToRealmDb(AreaTypeItem areaTypeItem) {
        AreaTypeItemModel areaTypeItemModel = null;
        if (areaTypeItem != null) {
            areaTypeItemModel = new AreaTypeItemModel();
            areaTypeItemModel.setAreatype(areaTypeItem.getText());
            areaTypeItemModel.setAreatypeid(areaTypeItem.getAreatypeid());
        }
        return areaTypeItemModel;
    }

    public RealmList<AreaTypeItemModel> transformToRealmDb(List<AreaTypeItem> areaTypeItemList) {
        RealmList<AreaTypeItemModel> realmList = null;
        if (areaTypeItemList != null) {
            realmList = new RealmList<>();
            for (AreaTypeItem areaTypeItem : areaTypeItemList) {
                realmList.add(transformToRealmDb(areaTypeItem));
            }
        }
        return realmList;
    }

    public AreaTypeItem transformToViewModel(AreaTypeItemModel areaTypeItemModel) {
        AreaTypeItem areaTypeItem = null;
        if (areaTypeItemModel != null) {
            areaTypeItem = new AreaTypeItem();
            areaTypeItem.setAreatype(areaTypeItemModel.getText());
            areaTypeItem.setAreatypeid(areaTypeItemModel.getAreatypeid());
        }
        return areaTypeItem;
    }

    public List<AreaTypeItem> transformToViewModel(List<AreaTypeItemModel> areaTypeItemModelList) {
        List<AreaTypeItem> areaTypeItemList = null;
        if (areaTypeItemModelList != null) {
            areaTypeItemList = new ArrayList<>();
            for (AreaTypeItemModel areaTypeItemModel : areaTypeItemModelList) {
                areaTypeItemList.add(transformToViewModel(areaTypeItemModel));
            }
        }
        return areaTypeItemList;
    }
}
