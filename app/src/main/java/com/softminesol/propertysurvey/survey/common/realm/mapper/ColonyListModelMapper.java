package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.ColonyList;
import com.softminesol.propertysurvey.survey.common.realm.model.ColonyListModel;

public class ColonyListModelMapper {

    public ColonyListModel transformToRealmDb(ColonyList colonyList) {
        ColonyListModel colonyListModel = null;
        if (colonyList != null) {
            colonyListModel = new ColonyListModel();
            colonyListModel.setColonies(new ColoniesItemModelMapper().transformToRealmDb(colonyList.getColonies()));
        }
        return colonyListModel;
    }

    public ColonyList transformToViewModel(ColonyListModel colonyListModel) {
        ColonyList colonyList = null;
        if (colonyListModel != null) {
            colonyList = new ColonyList();
            colonyList.setColonies(new ColoniesItemModelMapper().transformToViewModel(colonyListModel.getColonies()));
        }
        return colonyList;
    }
}
