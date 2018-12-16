package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.FloorsList;
import com.softminesol.propertysurvey.survey.common.realm.model.FloorsListModel;

public class FloorsListModelMapper {

    public FloorsListModel transformToRealmDb(FloorsList floorsList) {
        FloorsListModel floorsListModel = null;
        if (floorsList != null) {
            floorsListModel = new FloorsListModel();
            floorsListModel.setFloors(new FloorsItemModelMapper().transformToRealmDb(floorsList.getFloors()));
        }
        return floorsListModel;
    }

    public FloorsList transformToViewModel(FloorsListModel floorsListModel) {
        FloorsList floorsList = null;
        if (floorsListModel != null) {
            floorsList = new FloorsList();
            floorsList.setFloors(new FloorsItemModelMapper().transformToViewModel(floorsListModel.getFloors()));
        }
        return floorsList;
    }

}
