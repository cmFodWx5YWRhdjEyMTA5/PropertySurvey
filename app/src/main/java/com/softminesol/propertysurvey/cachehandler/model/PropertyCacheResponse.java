package com.softminesol.propertysurvey.cachehandler.model;

import com.softminesol.propertysurvey.survey.common.model.formData.FormData;

import java.util.List;

public class PropertyCacheResponse {
    List<FormData> Property;
    int pageCount;

    public List<FormData> getProperty() {
        return Property;
    }

    public void setProperty(List<FormData> property) {
        Property = property;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
