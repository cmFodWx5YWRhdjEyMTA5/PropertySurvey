package com.softminesol.propertysurvey.survey.common.di;

import com.softminesol.propertysurvey.survey.common.view.fragment.ApartmentInfoFragment;
import com.softminesol.propertysurvey.survey.common.view.fragment.PersonalInfoFragment;
import com.softminesol.propertysurvey.survey.newPropertyEntry.di.NewSurveyModule;

import dagger.Component;
import frameworks.di.component.BaseAppComponent;

/**
 * Created by sandeep on 6/5/18.
 */
@SurveyFormScope
@Component(modules = {NewSurveyModule.class,SurveyModule.class}, dependencies = BaseAppComponent.class)
public interface SurveyComponent {
    public void inject(PersonalInfoFragment fragment);


    public void inject(ApartmentInfoFragment fragment);

}
