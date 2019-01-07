package com.softminesol.propertysurvey.survey.common.view.presenter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

import com.softmine.imageupload.presenter.ImageUploadPresenter;
import com.softmine.imageupload.view.ActivityPicChooser;
import com.softmine.imageupload.view.ImageUploadActivity;
import com.softminesol.propertysurvey.CommonBaseUrl;
import com.softminesol.propertysurvey.survey.common.model.apartment.Owner;
import com.softminesol.propertysurvey.survey.common.model.formData.OwnerDetailsItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import frameworks.basemvp.AppBasePresenter;
import frameworks.utils.AdapterFactory;

import static com.softmine.imageupload.view.ActivityPicChooser.IMAGE_URI_RESULT;
import static com.softmine.imageupload.view.ImageUploadActivity.FILE_PATHS;
import static com.softmine.imageupload.view.ImageUploadActivity.REQUEST_GET_FILE_SERVER_URI;

/**
 * Created by sandeep on 6/5/18.
 */
public class PersonalInfoPresenter extends AppBasePresenter<PersonalInfoContract.View> implements PersonalInfoContract.Presenter {


    AdapterFactory adapterFactory;

    public static final int REQUEST_PROPERTY_REGISTRY = 1;
    public static final int REQUEST_OWNER_ID = 2;

    @Inject
    public PersonalInfoPresenter(AdapterFactory adapterFactory) {
        this.adapterFactory = adapterFactory;
    }

    @Override
    public void attachView(PersonalInfoContract.View view) {
        super.attachView(view);
        getView().setGenderAdapter(adapterFactory.getGenderAdapter());
        getView().setRelationShipAdapter(adapterFactory.getRelationShipAdapter());
        getView().setIsRespondantIsOwnerAdapter(adapterFactory.getYesNoAdapter());
        if(getView().getOwnerDetailItem()!= null) {
            setOwnerDetails(getView().getOwnerDetailItem());
        }

    }

    @Override
    public void onNextClick() {
        if (validateForm()) {
            Intent i = new Intent();
            i.putExtra("ownerDetail", getOwnerDetail());
            getView().setResult(1, i);
            getView().finish();
        }
    }

    @Override
    public void onUploadRegistryClick() {
        String url = CommonBaseUrl.BASE_URL+"person/uploadPersonImage";
        String param_name = "personImage";
        getView().startActivityForResult(ImageUploadActivity.getIntent(getView().getContext(),url,param_name),REQUEST_GET_FILE_SERVER_URI);
    }


    @Override
    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ImageUploadActivity.REQUEST_GET_FILE_SERVER_URI) {
            if(resultCode == ImageUploadPresenter.RESULT_FILE_URI) {
                fileUrls = data.getStringArrayListExtra(FILE_PATHS);
            }else if(resultCode == ImageUploadPresenter.RESULT_FILE_PATHS) {
                filePaths = data.getStringArrayListExtra(FILE_PATHS);
            }
        }
        return super.onActivityResult(requestCode,resultCode,data);
    }
    ArrayList<String> fileUrls;
    ArrayList<String> filePaths;
    public String registryPicPath = "";
    public String userIdPath = "";

    public boolean validateForm() {
        if (TextUtils.isEmpty(getView().getOwnerName())) {
            getView().setOwnerNameError("Please Enter");
            return false;
        }
        return true;
    }

    private Owner getOwnerDetail() {

        Owner owner=new Owner();
        owner.setName(getView().getOwnerName());
        owner.setAadharId(getView().getAdharId());
        owner.setMobileNo(getView().getMobileNo());
        owner.setEmail(getView().getEmail());
        owner.setBuildingName(getView().getBuildingName());
        owner.setStreet(getView().getStreet());
        owner.setColony(getView().getColony());
        owner.setPincode(getView().getPincode());
        owner.setWardNo(getView().getWardNumber());
        owner.setZoneId(getView().getZondeid());
        owner.setRegistryImage(fileUrls);
        owner.setRegistryImagePath(filePaths);
        return owner;
    }


    public void setOwnerDetails(OwnerDetailsItem ownerDetails) {
        getView().setCurrentAddress(ownerDetails.getAddressLine1());
        getView().setEmail(ownerDetails.getEmailID());
        getView().setFatherName(ownerDetails.getRelationWith());
        getView().setMobileNo(ownerDetails.getMobileNumber());
        getView().setOwnerName(ownerDetails.getName());
        getView().setOwnerShipShare(ownerDetails.getOwnershipShare());
        getView().setRelationType(ownerDetails.getRelationName());
        getView().setSelectGender(ownerDetails.getGender());
    }
}
