package com.softminesol.survey_framework.roomDb;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface GETAPIDao {
    @Insert
    void insert(Type type);

    @Query("select * from type WHERE type = :type")
    Type select(String type);
}
