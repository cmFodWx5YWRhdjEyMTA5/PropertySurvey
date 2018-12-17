package com.softminesol.propertysurvey.survey.apartmentEntry.di;

import com.softminesol.propertysurvey.imageupload.di.ImageUploadModule;
import com.softminesol.propertysurvey.survey.common.di.SurveyFormScope;
import com.softminesol.propertysurvey.survey.common.di.SurveyModule;
import com.softminesol.propertysurvey.survey.common.view.fragment.ApartmentInfoFragment;

import dagger.Component;
import frameworks.di.component.BaseAppComponent;

/**
 * Created by sandeep on 13/5/18.
 */
@SurveyFormScope
@Component(modules = {NewSurveyModule.class}, dependencies = BaseAppComponent.class)
public interface NewSurveyComponent {
    public void inject(ApartmentInfoFragment apartmentInfoFragment);
}
