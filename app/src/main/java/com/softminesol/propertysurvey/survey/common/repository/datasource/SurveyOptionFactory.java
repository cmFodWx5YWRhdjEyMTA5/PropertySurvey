package com.softminesol.propertysurvey.survey.common.repository.datasource;

import com.softminesol.propertysurvey.survey.common.model.AreaType;
import com.softminesol.propertysurvey.survey.common.model.ColonyList;
import com.softminesol.propertysurvey.survey.common.model.ConstructionType;
import com.softminesol.propertysurvey.survey.common.model.FloorsList;
import com.softminesol.propertysurvey.survey.common.model.MeasurementUnitList;
import com.softminesol.propertysurvey.survey.common.model.OLDPropertyUIDS;
import com.softminesol.propertysurvey.survey.common.model.OwnerShipList;
import com.softminesol.propertysurvey.survey.common.model.PropertyCategoryList;
import com.softminesol.propertysurvey.survey.common.model.PropertySubCategoryList;
import com.softminesol.propertysurvey.survey.common.model.PropertyTypes;
import com.softminesol.propertysurvey.survey.common.model.RebateList;
import com.softminesol.propertysurvey.survey.common.model.UsageList;
import com.softminesol.propertysurvey.survey.common.model.formData.FormData;

import javax.inject.Inject;

import frameworks.network.usecases.RequestParams;
import rx.Observable;

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
