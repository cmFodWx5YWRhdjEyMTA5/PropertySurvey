package com.softminesol.propertysurvey.roomDb;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.softminesol.propertysurvey.survey.common.model.apartment.SaveApartmentRequest;

@Dao
public interface GETAPIDao {
    @Insert
    void insert(Type type);

    @Query("select * from type WHERE type = :type")
    Type select(String type);
}
