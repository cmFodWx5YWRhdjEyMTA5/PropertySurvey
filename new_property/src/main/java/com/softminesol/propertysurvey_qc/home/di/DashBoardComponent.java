package com.softminesol.propertysurvey_qc.home.di;


import com.softminesol.propertysurvey_qc.home.view.DashBoardActivity;
import com.softminesol.survey_framework.rolebase.di.RoleBaseModule;
import com.softminesol.propertysurvey_qc.survey.newPropertyEntry.di.NewSurveyModule;

import dagger.Component;
import frameworks.di.component.BaseAppComponent;

@DashboardScope
@Component(modules = {DashBoardModule.class, RoleBaseModule.class, NewSurveyModule.class}, dependencies = BaseAppComponent.class)
public interface DashBoardComponent {
    public void inject(DashBoardActivity activity);
}
