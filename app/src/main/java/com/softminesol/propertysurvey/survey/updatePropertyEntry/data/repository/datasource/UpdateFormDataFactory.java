package com.softminesol.propertysurvey.survey.updatePropertyEntry.data.repository.datasource;

import com.softminesol.propertysurvey.survey.common.model.formData.FormData;

import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import rx.Observable;

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
