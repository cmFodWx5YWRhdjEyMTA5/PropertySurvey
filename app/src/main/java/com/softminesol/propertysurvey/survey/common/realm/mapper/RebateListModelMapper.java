package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.RebateList;
import com.softminesol.propertysurvey.survey.common.realm.model.RebateListModel;

public class  RebateListModelMapper {

    public RebateListModel transformToRealmDb(RebateList rebateList) {
        RebateListModel rebateListModel = null;
        if (rebateList != null) {
            rebateListModel = new RebateListModel();
            rebateListModel.setRebate(new RebateItemModelMapper().transformToRealmDb(rebateList.getRebate()));
        }
        return rebateListModel;
    }

    public RebateList transformToViewModel(RebateListModel rebateListModel) {
        RebateList rebateList = null;
        if (rebateListModel != null) {
            rebateList = new RebateList();
            rebateList.setRebate(new RebateItemModelMapper().transformToViewModel(rebateListModel.getRebate()));
        }
        return rebateList;
    }

}
