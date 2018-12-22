package com.softmine.imageupload.presenter;


import java.util.ArrayList;

public interface IUploadImagesServiceContract {

    interface UploadImagesListener {

        void onProgressComplete();

        void onProgressFail();
    }

    interface UploadImagesPresenter {
        void uploadImages(ArrayList<String> filePaths, int deliveryId);
    }
}
