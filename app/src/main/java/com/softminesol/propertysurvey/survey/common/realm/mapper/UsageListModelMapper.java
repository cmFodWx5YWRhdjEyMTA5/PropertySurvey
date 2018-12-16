package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.UsageList;
import com.softminesol.propertysurvey.survey.common.realm.model.UsageListModel;

public class UsageListModelMapper {

    public UsageListModel transformToRealmDb(UsageList usageList) {
        UsageListModel usageListModel = null;
        if (usageList != null) {
            usageListModel = new UsageListModel();
            usageListModel.setUsage(new UsageItemModelMapper().transformToRealmDb(usageList.getUsage()));
        }
        return usageListModel;
    }

    public UsageList transformToViewModel(UsageListModel usageListModel) {
        UsageList usageList = null;
        if (usageListModel != null) {
            usageList = new UsageList();
            usageList.setUsage(new UsageItemModelMapper().transformToViewModel(usageListModel.getUsage()));
        }
        return usageList;
    }

}
