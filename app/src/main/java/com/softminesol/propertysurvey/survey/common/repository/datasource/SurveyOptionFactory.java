package com.softminesol.propertysurvey.survey.common.repository.datasource;

import javax.inject.Inject;

/**
 * Created by sandeep on 6/5/18.
 */
public class SurveyOptionFactory {
    private final SurveyOptionCacheDataSource surveyOptionCacheDataSource;
    SurveyOptionCloudDataSource surveyOptionCloudDataSource;

    @Inject
    public SurveyOptionFactory(SurveyOptionCloudDataSource surveyOptionCloudDataSource,SurveyOptionCacheDataSource surveyOptionCacheDataSource) {
        this.surveyOptionCloudDataSource = surveyOptionCloudDataSource;
        this.surveyOptionCacheDataSource = surveyOptionCacheDataSource;
    }


    public SurveyOptionCacheDataSource getSurveyOptionCacheDataSource() {
         return surveyOptionCacheDataSource;

    }

    public SurveyOptionCloudDataSource getSurveyOptionCloudDataSource() {
        return surveyOptionCloudDataSource;
    }


}
