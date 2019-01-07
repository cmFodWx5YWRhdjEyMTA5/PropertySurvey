package com.softminesol.propertysurvey.roomDb;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.softminesol.propertysurvey.survey.common.model.apartment.Owner;
import com.softminesol.propertysurvey.survey.common.model.property.SavePropertyRequest;

import java.util.List;

@Dao
public interface SurveyPropertyDao {
    @Query("SELECT * FROM savepropertyrequest")
    List<SavePropertyRequest> getAll();

    @Insert
    long insert(SavePropertyRequest savePropertyRequest);

    @Delete
    void delete(SavePropertyRequest savePropertyRequest);
}
