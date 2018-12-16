package com.softminesol.propertysurvey.imageupload.model;

import java.util.List;

public class ImageUploadResponse {
    private List<ImageItem> image;

    public List<ImageItem> getImage() {
        return image;
    }

    public void setImage(List<ImageItem> image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return
                "ImageUploadResponse{" +
                        "image = '" + image + '\'' +
                        "}";
    }
}