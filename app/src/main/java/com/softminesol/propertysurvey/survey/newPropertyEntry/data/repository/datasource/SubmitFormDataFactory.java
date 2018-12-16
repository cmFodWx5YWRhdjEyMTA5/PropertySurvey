package com.softminesol.propertysurvey.survey.newPropertyEntry.data.repository.datasource;

import com.softminesol.propertysurvey.survey.common.model.formData.FormData;

import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import rx.Observable;

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
