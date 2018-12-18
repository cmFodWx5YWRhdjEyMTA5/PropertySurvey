package com.softminesol.propertysurvey.survey.apartmentEntry.di;

import com.softminesol.propertysurvey.survey.common.di.SurveyFormScope;
import com.softminesol.propertysurvey.survey.common.view.fragment.ApartmentInfoFragment;

import dagger.Component;
import frameworks.di.component.BaseAppComponent;

/**
 * Created by sandeep on 13/5/18.
 */
@SurveyFormScope
@Component(modules = {NewApartmentSurveyModule.class}, dependencies = BaseAppComponent.class)
public interface NewApartmentSurveyComponent {
    public void inject(ApartmentInfoFragment apartmentInfoFragment);
}
