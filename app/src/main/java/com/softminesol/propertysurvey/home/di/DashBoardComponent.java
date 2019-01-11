package com.softminesol.propertysurvey.home.di;


import com.softminesol.propertysurvey.home.view.DashBoardActivity;
import com.softminesol.propertysurvey.rolebase.di.RoleBaseModule;
import com.softminesol.propertysurvey.survey.newPropertyEntry.di.NewSurveyModule;

import dagger.Component;
import frameworks.di.component.BaseAppComponent;

@DashboardScope
@Component(modules = {DashBoardModule.class, RoleBaseModule.class, NewSurveyModule.class}, dependencies = BaseAppComponent.class)
public interface DashBoardComponent {
    public void inject(DashBoardActivity activity);
}
