package com.softminesol.propertysurvey;

import com.softminesol.propertysurvey.home.HomeRouterImpl;
import com.softminesol.survey_framework.SurveyAppApplication;

import routers.IHomeRouter;
import routers.IRouterProducer;

/**
 * Created by sandeepgoyal on 12/05/18.
 */

public class NewSurveyApp extends SurveyAppApplication implements IRouterProducer {

    @Override
    public IHomeRouter getHomeRouter() {
        return new HomeRouterImpl();
    }

}
