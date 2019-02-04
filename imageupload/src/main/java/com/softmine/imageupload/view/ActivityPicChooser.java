package com.softmine.imageupload.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.Toast;

import com.softminesol.permissions.apppermission.PermissionActivity;
import com.softminesol.permissions.apppermission.Permissions;
import com.tokopedia.imageupload.R;
import com.tokopedia.imageupload.R2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sandeep on 4/1/18.
 */
public class ActivityPicChooser extends PermissionActivity {
    public final static int REQUEST_CAMERA = 1;
    public final static int SELECT_FILE = 2;
    public final static int IMAGE_URI_RESULT = 3;
    public final static int IMAGE_URI_REQUEST = 4;
    boolean isCameraOpenPermission = false;
    boolean isWriteExternalPermission = false;

   public static Intent createIntent(Context context) {
        return new Intent(context,ActivityPicChooser.class);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isCameraOpenPermission = getPermission(new String[]{Permissions.PERMISSION_CAMERA_OPEN.getPermission(), Permissions.PERMISSION_WRITE_EXTERNAL_STORATE.getPermission()},Permissions.PERMISSION_CAMERA_OPEN.getRequestId());
        setContentView(R.layout.feed_pic_chooser_option);
        ButterKnife.bind(this);
        findViewById(R.id.btn_camera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onViewClicked(v);
            }
        });
        findViewById(R.id.btn_open_gallery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onViewClicked(v);
            }
        });
        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onViewClicked(v);
            }
        });
    }




    private void galleryIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"), SELECT_FILE);
    }

    private void cameraIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Uri fileUri = getOutputMediaFileUri(); // create a file to save the image
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name

        startActivityForResult(intent, REQUEST_CAMERA);

    }


    public void onViewClicked(View view) {
        int i = view.getId();
        if (i  == R.id.btn_camera) {
            if (isCameraOpenPermission)
                cameraIntent();
            else {
                Toast.makeText(this, "No Permission For Camera", Toast.LENGTH_LONG).show();
            }

        } else if (i == R.id.btn_open_gallery) {
            if (isWriteExternalPermission) {
                galleryIntent();
            } else {
                Toast.makeText(this, "No Permission For Gallery", Toast.LENGTH_LONG).show();
            }


        } else if (i == R.id.btn_cancel) {
            finish();

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
        }else {
            finish();
        }
    }

    private void onSelectFromGalleryResult(Intent data) {
        Bitmap bm = null;
        if (data != null) {
            Uri uri = data.getData();
            setResultandFinish(uri);
        } else {
            finish();
        }
    }

    private void onCaptureImageResult(Intent data) {

        Uri uri = Uri.parse(imagePath);
        Intent intent = new Intent();
        intent.setData(uri);
        setResult(IMAGE_URI_RESULT, intent);
        finish();
    }

    private void setResultandFinish(Uri uri) {
        Intent intent = new Intent();
        intent.setData(uri);
        setResult(IMAGE_URI_RESULT, intent);
        finish();
    }

    /** Create a file Uri for saving an image or video */
    private  Uri getOutputMediaFileUri(){
        File file = getOutputMediaFile();
        imagePath = file.getPath();
        return FileProvider.getUriForFile(this,"com.softminesol.propertysurvey_new.provider", file);
    }

    String imagePath;

    /** Create a File for saving an image or video */
    private static File getOutputMediaFile(){
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "PropertySurvey");
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
         return new File(mediaStorageDir.getPath() + File.separator + "IMG_"+ timeStamp + ".jpg");

    }

    @Override
    public void setPermission(int requestCode, boolean isGranted) {
        if (Permissions.PERMISSION_WRITE_EXTERNAL_STORATE.getRequestId() == requestCode) {
            isWriteExternalPermission = isGranted;
        }
        if (Permissions.PERMISSION_CAMERA_OPEN.getRequestId() == requestCode) {
            isCameraOpenPermission = isGranted;
        }
    }


}
