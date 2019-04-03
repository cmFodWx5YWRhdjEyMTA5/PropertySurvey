package com.softminesol.survey_framework.roomDb;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.softminesol.survey_framework.survey.common.model.property.SavePropertyRequest;

import java.util.List;

@Dao
public interface SurveyPropertyDao {
    @Query("SELECT * FROM savepropertyrequest Where idDrafted = 0")
    List<SavePropertyRequest> getAll();

    @Insert
    long insert(SavePropertyRequest savePropertyRequest);

    @Update
    void update(SavePropertyRequest savePropertyRequest);

    @Delete
    void delete(SavePropertyRequest savePropertyRequest);

    @Query("select * from savepropertyrequest WHERE idDrafted = 1")
    List<SavePropertyRequest> getDraftedProperties();

    @Query("select count(*) from savepropertyrequest WHERE idDrafted = 1")
    public int getDraftedPropertiesCount();

    @Query("select count(*) from savepropertyrequest WHERE idDrafted = 0")
    public int getNonDraftedPropertiesCount();
}
