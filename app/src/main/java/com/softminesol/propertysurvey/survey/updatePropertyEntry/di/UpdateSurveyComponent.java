package com.softminesol.propertysurvey.survey.updatePropertyEntry.di;

import com.softminesol.propertysurvey.imageupload.di.ImageUploadModule;
import com.softminesol.propertysurvey.survey.common.di.SurveyFormScope;
import com.softminesol.propertysurvey.survey.common.di.SurveyModule;
import com.softminesol.propertysurvey.survey.updatePropertyEntry.view.fragment.UpdatePropertyInfoFragment;

import dagger.Component;
import frameworks.di.component.BaseAppComponent;

/**
 * Created by sandeep on 13/5/18.
 */
@SurveyFormScope
@Component(modules = {UpdateSurveyModule.class, SurveyModule.class, ImageUploadModule.class}, dependencies = BaseAppComponent.class)
public interface UpdateSurveyComponent {
    public void inject(UpdatePropertyInfoFragment updatePropertyInfoFragment);
}
