package com.softminesol.propertysurvey.home.di;


import com.softminesol.propertysurvey.cachehandler.di.CacheModule;
import com.softminesol.propertysurvey.home.view.DashBoardActivity;
import com.softminesol.propertysurvey.rolebase.di.RoleBaseModule;
import com.softminesol.propertysurvey.survey.distributionbill.di.BillDistributionModule;
import com.softminesol.propertysurvey.survey.newPropertyEntry.di.NewSurveyModule;
import com.softminesol.propertysurvey.survey.updatePropertyEntry.di.UpdateSurveyModule;

import dagger.Component;
import frameworks.di.component.BaseAppComponent;

@DashboardScope
@Component(modules = {CacheModule.class,DashBoardModule.class, RoleBaseModule.class, NewSurveyModule.class, UpdateSurveyModule.class, BillDistributionModule.class}, dependencies = BaseAppComponent.class)
public interface DashBoardComponent {
    public void inject(DashBoardActivity activity);
}
