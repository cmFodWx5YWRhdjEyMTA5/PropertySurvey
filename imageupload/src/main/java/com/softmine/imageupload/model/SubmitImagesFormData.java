package com.softmine.imageupload.model;

import com.google.gson.annotations.SerializedName;

public class SubmitImagesFormData {
    @SerializedName("images")
    private Integer[] images;

    public Integer[] getImages() {
        return images;
    }

    public void setImages(Integer[] images) {
        this.images = images;
    }
}
