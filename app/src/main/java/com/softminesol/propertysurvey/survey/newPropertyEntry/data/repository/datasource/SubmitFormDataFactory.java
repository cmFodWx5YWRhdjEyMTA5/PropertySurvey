package com.softminesol.propertysurvey.survey.newPropertyEntry.data.repository.datasource;

import javax.inject.Inject;

/**
 * Created by sandeep on 13/5/18.
 */
public class SubmitFormDataFactory {
    CloudSubmitFomData cloudSubmitFomData;
    CacheSubmitFormData cacheSubmitFormData;

    @Inject
    public SubmitFormDataFactory(CloudSubmitFomData cloudSubmitFomData,CacheSubmitFormData cacheSubmitFormData) {
        this.cloudSubmitFomData = cloudSubmitFomData;
        this.cacheSubmitFormData = cacheSubmitFormData;
    }

    public CacheSubmitFormData getCacheSubmitFormData() {
        return cacheSubmitFormData;
    }

    public CloudSubmitFomData getCloudSubmitFomData() {

        return cloudSubmitFomData;
    }
}
