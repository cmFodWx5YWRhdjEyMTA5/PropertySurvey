package com.softminesol.propertysurvey.survey.common.realm.mapper;

import com.softminesol.propertysurvey.survey.common.model.OLDPropertyUIDS;
import com.softminesol.propertysurvey.survey.common.realm.model.OldPropertyUIDSModel;

public class OldPropertyUIDSModelMapper {

    public OldPropertyUIDSModel transformToRealmDb(OLDPropertyUIDS oldPropertyUIDS) {
        OldPropertyUIDSModel oldPropertyUIDSModel = null;
        if (oldPropertyUIDS != null) {
            oldPropertyUIDSModel = new OldPropertyUIDSModel();
            oldPropertyUIDSModel.setOldPropertyUID(new OldPropertyUIDItemModelMapper().transformToRealmDb(oldPropertyUIDS.getOldPropertyUID()));
        }
        return oldPropertyUIDSModel;
    }

    public OLDPropertyUIDS transformToViewModel(OldPropertyUIDSModel oldPropertyUIDSModel) {
        OLDPropertyUIDS oldPropertyUIDS = null;
        if (oldPropertyUIDSModel != null) {
            oldPropertyUIDS = new OLDPropertyUIDS();
            oldPropertyUIDS.setOldPropertyUID(new OldPropertyUIDItemModelMapper().transformToViewModel(oldPropertyUIDSModel.getOldPropertyUID()));
        }
        return oldPropertyUIDS;
    }

}
