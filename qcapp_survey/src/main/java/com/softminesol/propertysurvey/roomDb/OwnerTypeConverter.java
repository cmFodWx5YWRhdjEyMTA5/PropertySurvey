package com.softminesol.propertysurvey.roomDb;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.reflect.TypeToken;
import com.softminesol.propertysurvey.survey.common.model.apartment.Owner;

import java.util.List;

import frameworks.utils.GsonFactory;

public class OwnerTypeConverter {

    @TypeConverter
    public static String toString(List<Owner> ownerList) {
        return GsonFactory.getGson().toJson(ownerList);
    }

    @TypeConverter
    public static List<Owner> toOwnerList(String value) {
        return GsonFactory.getGson().fromJson(value,new TypeToken<List<Owner>>(){}.getType());
    }
}
