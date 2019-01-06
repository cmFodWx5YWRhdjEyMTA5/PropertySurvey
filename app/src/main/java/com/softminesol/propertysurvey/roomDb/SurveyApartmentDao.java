package com.softminesol.propertysurvey.roomDb;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.softminesol.propertysurvey.survey.common.model.apartment.Owner;
import com.softminesol.propertysurvey.survey.common.model.apartment.SaveApartmentRequest;

import java.util.List;

@Dao
public interface SurveyApartmentDao {
    @Query("SELECT * FROM saveApartmentrequest")
    List<SaveApartmentRequest> getAll();


    @Insert
    void insert(SaveApartmentRequest owner);

    @Delete
    void delete(SaveApartmentRequest owner);


    @Query("UPDATE saveApartmentrequest SET gisId = :gsid WHERE tempPropertyApartmentId = :tid")
    int updateTour(long tid, String gsid);
}
