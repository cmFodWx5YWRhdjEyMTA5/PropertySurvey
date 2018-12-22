package com.softmine.imageupload.model;

import com.google.gson.annotations.SerializedName;

public class ImageUploadResponseData {
    @SerializedName("message")
    private String message;
    @SerializedName("image_id")
    private int imageId;

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setImageId(int imageId){
        this.imageId = imageId;
    }

    public int getImageId(){
        return imageId;
    }

    @Override
    public String toString(){
        return
                "Data{" +
                        "message = '" + message + '\'' +
                        ",image_id = '" + imageId + '\'' +
                        "}";
    }
}
