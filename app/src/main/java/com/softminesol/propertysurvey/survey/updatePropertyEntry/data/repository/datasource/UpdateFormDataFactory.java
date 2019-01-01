package com.softminesol.propertysurvey.survey.updatePropertyEntry.data.repository.datasource;

import javax.inject.Inject;

/**
 * Created by sandeep on 13/5/18.
 */
public class UpdateFormDataFactory {
    CloudUpdateFomData cloudSubmitFomData;
    CacheUpdateFormData cacheUpdateFormData;

    @Inject
    public UpdateFormDataFactory(CloudUpdateFomData cloudSubmitFomData, CacheUpdateFormData cacheUpdateFormData) {
        this.cloudSubmitFomData = cloudSubmitFomData;
        this.cacheUpdateFormData = cacheUpdateFormData;
    }

    public CloudUpdateFomData getCloudSubmitFomData() {
        return cloudSubmitFomData;
    }

    public CacheUpdateFormData getCacheUpdateFormData() {
        return cacheUpdateFormData;
    }
}
