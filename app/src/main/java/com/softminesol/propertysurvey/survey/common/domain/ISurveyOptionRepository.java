package com.softminesol.propertysurvey.survey.common.domain;

import com.softminesol.propertysurvey.survey.common.model.PropertyTypes;
import com.softminesol.propertysurvey.survey.common.model.newmodel.BuildingAge;
import com.softminesol.propertysurvey.survey.common.model.newmodel.ConstructionType;
import com.softminesol.propertysurvey.survey.common.model.newmodel.Floors;
import com.softminesol.propertysurvey.survey.common.model.newmodel.NonResidentalCategory;
import com.softminesol.propertysurvey.survey.common.model.newmodel.OccupancyStatus;
import com.softminesol.propertysurvey.survey.common.model.newmodel.PropertyUsage;
import com.softminesol.propertysurvey.survey.common.model.newmodel.RespondentStatus;
import com.softminesol.propertysurvey.survey.common.model.newmodel.SourceWater;

import rx.Observable;

/**
 * Created by sandeep on 6/5/18.
 */
public interface ISurveyOptionRepository {
   public Observable<PropertyTypes> getPropertyType();
   public Observable<PropertyUsage> getPropertyUsage();
   public Observable<RespondentStatus> getRespondentStatus();
   public Observable<OccupancyStatus> getOccupancyStatus();
   public Observable<BuildingAge> getBuildingAge();
   public Observable<ConstructionType> getConstructionType();
   public Observable<Floors> getFloors();
   public Observable<NonResidentalCategory> getNonResidentalCategory();
   public Observable<SourceWater> getSourceWater();

}
