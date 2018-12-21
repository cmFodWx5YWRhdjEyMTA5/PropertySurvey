package com.softmine.imageupload.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.softmine.imageupload.adapter.ImageUploadAdapter;
import com.softmine.imageupload.di.ImageUploadComponent;
import com.softmine.imageupload.di.DaggerImageUploadComponent;
import com.softmine.imageupload.model.ImageUpload;
import com.softmine.imageupload.presenter.IUploadImageContractor;
import com.softmine.imageupload.presenter.ImageUploadPresenter;
import com.softmine.imageupload.service.ImagesUploadService;
import com.tokopedia.imageupload.R;

import java.util.ArrayList;
import java.util.UUID;

import javax.inject.Inject;

import frameworks.AppBaseApplication;
import frameworks.basemvp.AppBaseActivity;


public class ImageUploadActivity extends AppBaseActivity<IUploadImageContractor.Presenter> implements IUploadImageContractor.View, ImageUploadAdapter.ProductImageListener {


    public static final int REQUEST_GET_FILE_SERVER_URI = 0X8;
    private final int SPAN_COUNT_4 = 4;
    @Inject
    ImageUploadPresenter mPresenter;
    private ImageUploadComponent imageUploadComponent;
    private RecyclerView recyclerView;
    private ImageUploadAdapter adapter;
    private View btnUploadImage;
    public static final String FILE_PATHS = "FILE_PATHS";

    public static Intent getIntent(Context context) {
        Intent intent=new Intent(context, ImageUploadActivity.class);
        return intent;
    }

    @Override
    protected void initInjector() {
        imageUploadComponent = DaggerImageUploadComponent.builder().baseAppComponent(((AppBaseApplication.getApplication()).getBaseAppComponent())).build();
        imageUploadComponent.inject(this);
    }

    @Override
    public int getViewToCreate() {
        return R.layout.activity_image_upload;
    }

    @Override
    public IUploadImageContractor.Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.title_upload_items_images));
        setLeftIcon(R.drawable.ic_action_back);
        setLeftMenuEnable(true);
    }

    @Override
    public void initVariables() {
        recyclerView = findViewById(R.id.recyclerItems);
        btnUploadImage=findViewById(R.id.btnUploadImage);
        recyclerView.setLayoutManager(new GridLayoutManager(this, SPAN_COUNT_4,
                GridLayoutManager.VERTICAL, false));
        adapter = ImageUploadAdapter.createAdapter();
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);
        btnUploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adapter.getItemCount()>1) {
                    ArrayList<String> fileUrls = new ArrayList<>();
                    for (ImageUpload imageUpload : adapter.getList()) {
                        fileUrls.add(imageUpload.getFileLoc());
                    }
                    Intent intent = new Intent();
                    intent.putStringArrayListExtra(FILE_PATHS, fileUrls);
                    startService(ImagesUploadService.getIntent(getContext(), fileUrls));
                    //Intent resultData = new Intent();
                    setResult(RESULT_OK);
                    finish();
                }else{
                    Toast.makeText(getContext(), getResources().getString(R.string.select_atleast_one_image), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onImageDeleted(int size) {

    }

    @Override
    public void uploadImage() {
        startActivityForResult(new Intent(this, ActivityPicChooser.class), 100);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100 && data != null) {
            int position = adapter.getItemCount();
            ImageUpload image = new ImageUpload();
            image.setPosition(position);
            image.setImageId("image" + UUID.randomUUID().toString());
            Uri uri = data.getData();
            if (uri != null) {
                image.setFileLoc(uri.getPath());
            }
            adapter.addImage(image);
        }
    }

    @Override
    public void onLeftMenuClick() {
        finish();
    }

}
