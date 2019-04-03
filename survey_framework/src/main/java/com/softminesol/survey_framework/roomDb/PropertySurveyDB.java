package com.softminesol.survey_framework.roomDb;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.softminesol.survey_framework.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.survey_framework.survey.common.model.property.SavePropertyRequest;

@Database(entities = {
        SaveApartmentRequest.class,SavePropertyRequest.class,Type.class},version = 3)
@TypeConverters({OwnerTypeConverter.class,ListStringConverter.class})
public abstract class PropertySurveyDB extends RoomDatabase {
    public abstract SurveyApartmentDao getApartmentDao();
    public abstract SurveyPropertyDao getPropertyDao();
    public abstract GETAPIDao getapiDao();
    private static PropertySurveyDB INSTANCE = null;
    /*static final Migration MIGRATION_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // Since we didn't alter the table, there's nothing else to do here.
            database.execSQL("ALTER TABLE savepropertyrequest add  ");
        }
    };*/
    public static PropertySurveyDB getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized(PropertySurveyDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context,
                            PropertySurveyDB.class, "PropertySurveyDB.db")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}
