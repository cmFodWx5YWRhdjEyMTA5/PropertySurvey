package com.softminesol.propertysurvey_qc.qasearch.propertysearch.di;

import com.softminesol.propertysurvey_qc.qasearch.apartmentEntry.view.fragment.NewApartmentFragment;
import com.softminesol.propertysurvey_qc.qasearch.newPropertyEntry.view.fragment.NewPropertyInfoFragment;
import com.softminesol.propertysurvey_qc.qasearch.propertysearch.view.SearchPropertyListActivity;
import com.softminesol.survey_framework.survey.common.di.SurveyFormScope;
import com.softminesol.survey_framework.survey.common.di.SurveyModule;

import dagger.Component;
import frameworks.di.component.BaseAppComponent;

/**
 * Created by sandeep on 13/5/18.
 */
@SurveyFormScope
@Component(modules = {QAModule.class, SurveyModule.class}, dependencies = BaseAppComponent.class)
public interface QAComponent {
    void inject(NewPropertyInfoFragment newPropertyInfoFragment);
    void inject(NewApartmentFragment newApartmentFragment);
    void inject(SearchPropertyListActivity draftedListActivity);
}
