package com.softminesol.propertysurvey.cachehandler.data.net;

import com.softminesol.propertysurvey.CommonBaseUrl;

/**
 * Created by sandeepgoyal on 03/05/18.
 */

public interface CacheAPIURL {
    String BASE_URL = CommonBaseUrl.BASE_URL;
    String getAssignedData = "/property/getAssignedData/{id}";
    String getBillAssisgned = "/billDistribution/getAssignedBills/{id}";
}
