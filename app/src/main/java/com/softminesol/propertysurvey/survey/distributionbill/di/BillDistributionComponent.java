package com.softminesol.propertysurvey.survey.distributionbill.di;

import com.softmine.imageupload.di.ImageUploadModule;
import com.softminesol.propertysurvey.survey.common.di.SurveyFormScope;
import com.softminesol.propertysurvey.survey.common.di.SurveyModule;
import com.softminesol.propertysurvey.survey.distributionbill.view.DistributionBillActivity;

import dagger.Component;
import frameworks.di.component.BaseAppComponent;

/**
 * Created by sandeep on 13/5/18.
 */

//TODO survey module because it ocntain base url etc methods
@SurveyFormScope
@Component(modules = {BillDistributionModule.class, SurveyModule.class}, dependencies = BaseAppComponent.class)
public interface BillDistributionComponent {

    public void inject(DistributionBillActivity view);
}
