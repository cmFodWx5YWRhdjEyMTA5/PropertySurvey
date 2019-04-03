package com.softminesol.survey_framework.roomDb;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.softminesol.survey_framework.survey.common.model.apartment.SaveApartmentRequest;

import java.util.List;

@Dao
public interface SurveyApartmentDao {
    @Query("SELECT * FROM saveApartmentrequest")
    List<SaveApartmentRequest> getAll();


    @Insert
    long insert(SaveApartmentRequest saveApartmentRequest);

    @Delete
    void delete(SaveApartmentRequest saveApartmentRequest);

    @Update
    void update(SaveApartmentRequest saveApartmentRequest);


    @Query("UPDATE saveApartmentrequest SET gisId = :gsid WHERE tempPropertyApartmentId = :tid")
    int updateTour(long tid, String gsid);

    @Query("select * from saveApartmentrequest")
    List<SaveApartmentRequest> getApartments();

    @Query("select * from saveApartmentrequest WHERE idDrafted = 1")
    List<SaveApartmentRequest> getDraftedApartments();

    @Query("select count(*) from saveApartmentrequest WHERE idDrafted = 1")
    int getdraftedApartementCount();

    @Query("select count(*) from saveApartmentrequest WHERE idDrafted = 0")
    int getNondraftedApartementCount();
}
