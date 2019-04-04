package com.softminesol.survey_framework.survey.common.di;

import dagger.Component;
import frameworks.di.component.BaseAppComponent;

/**
 * Created by sandeep on 6/5/18.
 */
@SurveyFormScope
@Component(modules = {SurveyModule.class}, dependencies = BaseAppComponent.class)
public interface SurveyComponent {
}