package com.softminesol.propertysurvey_qc.qasearch.propertysearch.view;

import com.softminesol.survey_framework.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.survey_framework.survey.common.model.property.SavePropertyRequest;

import java.util.List;

import frameworks.basemvp.IActivityView;
import frameworks.basemvp.IPresenter;
import frameworks.customadapter.CustomAdapterModel;

public interface ISearchPropertyListContract {

      interface IDraftedListActivityView extends IActivityView {
         void setDraftedApartmentList(List<SaveApartmentRequest> saveApartmentRequests);
         void setDraftedPropertyList(List<SavePropertyRequest> savePropertyRequests);
         void setPropertyIdList(List<CustomAdapterModel> oldPropertyUID);
    }

    public interface IDraftedListActivityPresenter extends IPresenter<IDraftedListActivityView> {
        void onPropertyIDSelected(String oldpropertyuid);
    }
}
