package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.OldPropertyUIDItem;
import com.softminesol.propertysurvey.survey.common.realm.model.OldPropertyUIDItemModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class OldPropertyUIDItemModelMapper {

    public OldPropertyUIDItemModel transformToRealmDb(OldPropertyUIDItem oldPropertyUIDItem) {
        OldPropertyUIDItemModel oldPropertyUIDItemModel = null;
        if (oldPropertyUIDItem != null) {
            oldPropertyUIDItemModel = new OldPropertyUIDItemModel();
            oldPropertyUIDItemModel.setOldpropertyuid(oldPropertyUIDItem.getOldpropertyuid());
        }
        return oldPropertyUIDItemModel;
    }

    public RealmList<OldPropertyUIDItemModel> transformToRealmDb(List<OldPropertyUIDItem> oldPropertyUIDItemList) {
        RealmList<OldPropertyUIDItemModel> realmList = null;
        if (oldPropertyUIDItemList != null) {
            realmList = new RealmList<>();
            for (OldPropertyUIDItem oldPropertyUIDItem : oldPropertyUIDItemList) {
                realmList.add(transformToRealmDb(oldPropertyUIDItem));
            }
        }
        return realmList;
    }

    public OldPropertyUIDItem transformToViewModel(OldPropertyUIDItemModel oldPropertyUIDItemModel) {
        OldPropertyUIDItem oldPropertyUIDItem = null;
        if (oldPropertyUIDItemModel != null) {
            oldPropertyUIDItem = new OldPropertyUIDItem();
            oldPropertyUIDItem.setOldpropertyuid(oldPropertyUIDItemModel.getOldpropertyuid());
        }
        return oldPropertyUIDItem;
    }

    public List<OldPropertyUIDItem> transformToViewModel(List<OldPropertyUIDItemModel> oldPropertyUIDItemModelList) {
        List<OldPropertyUIDItem> oldPropertyUIDItemList = null;
        if (oldPropertyUIDItemModelList != null) {
            oldPropertyUIDItemList = new ArrayList<>();
            for (OldPropertyUIDItemModel oldPropertyUIDItemModel : oldPropertyUIDItemModelList) {
                oldPropertyUIDItemList.add(transformToViewModel(oldPropertyUIDItemModel));
            }
        }
        return oldPropertyUIDItemList;
    }

}
