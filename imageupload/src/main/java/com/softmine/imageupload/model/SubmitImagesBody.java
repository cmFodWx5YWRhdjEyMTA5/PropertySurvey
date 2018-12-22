package com.softmine.imageupload.model;

import com.google.gson.annotations.SerializedName;

public class SubmitImagesBody {

    @SerializedName("delivery_id")
    private int deliveryId;

    @SerializedName("form_data")
    SubmitImagesFormData submitImagesFormData;

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public SubmitImagesFormData getSubmitImagesFormData() {
        return submitImagesFormData;
    }

    public void setSubmitImagesFormData(SubmitImagesFormData submitImagesFormData) {
        this.submitImagesFormData = submitImagesFormData;
    }
}
