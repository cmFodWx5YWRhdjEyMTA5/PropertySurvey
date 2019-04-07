package com.softminesol.propertysurvey_qc;

import com.softminesol.propertysurvey_qc.home.HomeRouterImpl;
import com.softminesol.survey_framework.SurveyAppApplication;

import routers.IHomeRouter;
import routers.IRouterProducer;

/**
 * Created by sandeepgoyal on 12/05/18.
 */

public class QCSurveyApp extends SurveyAppApplication implements IRouterProducer {

    @Override
    public IHomeRouter getHomeRouter() {
        return new HomeRouterImpl();
    }

}
