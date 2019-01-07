package com.softminesol.propertysurvey.roomDb;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.softminesol.propertysurvey.survey.common.model.apartment.Owner;
import com.softminesol.propertysurvey.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.propertysurvey.survey.common.model.property.SavePropertyRequest;

@Database(entities = {
        SaveApartmentRequest.class,SavePropertyRequest.class},version = 1)
@TypeConverters({OwnerTypeConverter.class,ListStringConverter.class})
public abstract class PropertySurveyDB extends RoomDatabase {
    public abstract SurveyApartmentDao getApartmentDao();
    public abstract SurveyPropertyDao getPropertyDao();
    private static PropertySurveyDB INSTANCE = null;
    public static PropertySurveyDB getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized(PropertySurveyDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context,
                            PropertySurveyDB.class, "PropertySurveyDB.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
