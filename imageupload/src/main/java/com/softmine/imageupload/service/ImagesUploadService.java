package com.softmine.imageupload.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import com.softmine.imageupload.di.ImageUploadComponent;
import com.softmine.imageupload.di.DaggerImageUploadComponent;
import com.softmine.imageupload.presenter.IUploadImagesServiceContract;
import com.softmine.imageupload.presenter.ImageUploadPresenterImpl;
import com.tokopedia.imageupload.R;

import java.util.ArrayList;

import javax.inject.Inject;

import frameworks.AppBaseApplication;


public class ImagesUploadService extends Service implements IUploadImagesServiceContract.UploadImagesListener {
    public static final String TAG = "ImagesUploadService";
    public static final String FILE_PATHS = "FILE_PATHS";
    private static final String DELIVERY_ID = "DELIVERY_ID";
    private String GENERAL = "ANDROID_GENERAL_CHANNEL";
    public static final String ACTION_UPLOAD_COMPLETE = "action.upload.complete";
    public static final String ACTION_UPLOAD_FAIL = "action.upload.fail";

    @Inject
    ImageUploadPresenterImpl presenter;

    private ArrayList<String> filePaths;
    private int deliveryId;
    private NotificationManager notificationManager;


    public static Intent getIntent(Context context, ArrayList<String> filePaths) {
        Intent intent = new Intent(context, ImagesUploadService.class);
        intent.putStringArrayListExtra(FILE_PATHS, filePaths);
        return intent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        ImageUploadComponent component = DaggerImageUploadComponent.builder().baseAppComponent(((AppBaseApplication.getApplication()).getBaseAppComponent())).build();
        component.inject(this);
        presenter.attach(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        filePaths = intent.getStringArrayListExtra(FILE_PATHS);
        deliveryId = intent.getIntExtra(DELIVERY_ID, -1);
        presenter.uploadImages(filePaths, deliveryId);
        createNotification();
        return START_REDELIVER_INTENT;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    Integer notificationID = 100;
    NotificationCompat.Builder builder;

    public void createNotification() {
        builder = buildBaseNotification();
        Notification notification = builder
                .setAutoCancel(false)
                .setOngoing(true)
                .setProgress(filePaths.size(), 0, true)
                .build();
        notificationManager.notify(TAG, notificationID, notification);
    }


    private NotificationCompat.Builder buildBaseNotification() {

        int largeIconRes = R.mipmap.ic_launcher;
        return new NotificationCompat.Builder(this, GENERAL)
                .setContentTitle("Uploading Images")
                .setSmallIcon(R.drawable.back_arrow)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), largeIconRes))
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true);
    }


    @Override
    public void onProgressComplete() {
        notificationManager.cancel(TAG, notificationID);
        builder = buildBaseNotification();
//        Intent intent = null;
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
//        builder.setContentIntent(pendingIntent);
        Notification notification = builder.setContentText(getString(R.string.submitted_success)).build();
        notificationManager.notify(TAG, notificationID, notification);
        Intent intent1 = new Intent(ACTION_UPLOAD_COMPLETE);
        sendBroadcast(intent1);
        stopSelf();

    }


    @Override
    public void onProgressFail() {
        notificationManager.cancel(TAG, notificationID);
        builder = buildBaseNotification();
        Notification notification = builder.setContentText(getString(R.string.submit_fail)).build();
        notificationManager.notify(TAG, notificationID, notification);
        sendBroadcast(new Intent(ACTION_UPLOAD_FAIL));
        stopSelf();
    }

}