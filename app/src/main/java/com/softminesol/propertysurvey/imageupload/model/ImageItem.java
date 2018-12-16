package com.softminesol.propertysurvey.imageupload.model;

public class ImageItem {
    private String imagename;
    private int propertyimagesid;

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public int getPropertyimagesid() {
        return propertyimagesid;
    }

    public void setPropertyimagesid(int propertyimagesid) {
        this.propertyimagesid = propertyimagesid;
    }

    @Override
    public String toString() {
        return
                "ImageItem{" +
                        "imagename = '" + imagename + '\'' +
                        ",propertyimagesid = '" + propertyimagesid + '\'' +
                        "}";
    }
}
