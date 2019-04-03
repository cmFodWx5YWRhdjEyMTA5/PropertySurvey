package com.softminesol.survey_framework.survey.common.net;


import com.softminesol.survey_framework.CommonBaseUrl;

/**
 * Created by sandeep on 6/5/18.
 */
public interface SurveyAPIURL {
    String PROPERTY_CATEGORY_API = "property/Category";
    String PROPERTY_TYPE_API = "propertyType";
    String PROPERTY_SUBCATEGORY_API = "property/SubCategory/{id}";
    String PROPERTY_REBATE = "rebate";
    String PROPERTY_COLONY = "colony";
    String PROPERTY_USAGE = "usage";
    String PROPERTY_MEASUREMENT = "measurement";
    String PROPERTY_FLOOR = "floor";
    String PROPERTY_OWNERSHIP = "ownership";
    String PROPERTY_AREATYPE = "areatype";
    String PROPERTY_CONSTRUCTIONTYPE = "constructionType";
    String PROPERTY_IDS = "property/getAllPropertyOldUID";
    String PROPERTY_DETAIL = "/property/view/{id}";
    String PROPERTY_USAGE1 = "propertyUsage";
    String RESPODENT = "respodent";
    String OCCUPENCY = "occupency";
    String BUILDING_AGE = "buildingAge";
    String CONSTRUCTION_TYPE = "constructionType";
    String FLOOR = "floor";
    String NON_RESIDENTAL_CATEGORY = "nonResidentalCategory";
    String SOURCE_WATER = "sourceWater";
    String BASE_URL = CommonBaseUrl.BASE_URL;
    ;

}
