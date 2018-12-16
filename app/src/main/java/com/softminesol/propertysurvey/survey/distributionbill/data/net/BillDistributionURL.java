package com.softminesol.propertysurvey.survey.distributionbill.data.net;

/**
 * Created by sandeep on 13/5/18.
 */
public interface BillDistributionURL {
    String billDistributionAPI = "billDistribution/{id}";
    String billDistributionPostAPI = "billDistribution/create";
    String billDistributionPostOffline = "billDistribution/createOffline";
}
