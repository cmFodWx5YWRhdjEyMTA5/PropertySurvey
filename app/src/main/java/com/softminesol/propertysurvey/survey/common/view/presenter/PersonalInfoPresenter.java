package com.softminesol.propertysurvey.survey.common.view.presenter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

import com.softmine.imageupload.view.ActivityPicChooser;
import com.softminesol.propertysurvey.survey.common.model.apartment.Owner;
import com.softminesol.propertysurvey.survey.common.model.formData.OwnerDetailsItem;

import javax.inject.Inject;

import frameworks.basemvp.AppBasePresenter;
import frameworks.utils.AdapterFactory;
import frameworks.utils.Validator;

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
        getView().startActivityForResult(ActivityPicChooser.createIntent(getView().getContext()),REQUEST_PROPERTY_REGISTRY);
    }

    @Override
    public void onUploadIdClick() {

        getView().startActivityForResult(ActivityPicChooser.createIntent(getView().getContext()),REQUEST_OWNER_ID);
    }

    @Override
    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            if (uri != null) {
                if (requestCode == REQUEST_PROPERTY_REGISTRY) {
                    registryPicPath = uri.getPath();
                }
                if (requestCode == REQUEST_OWNER_ID) {
                    userIdPath = uri.getPath();
                }
                return true;
            }
        }
        return super.onActivityResult(requestCode,resultCode,data);
    }

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
        owner.setUniqueId(getView().getUniqueId());
        owner.setMobileNo(getView().getMobileNo());
        owner.setEmail(getView().getEmail());
        owner.setBuildingName(getView().getBuildingName());
        owner.setStreet(getView().getStreet());
        owner.setColony(getView().getColony());
        owner.setPincode(getView().getPincode());
        owner.setWardNo(getView().getWardNumber());
        owner.setCircleNo(getView().getCircleNumber());
        owner.setRevenueCircle(getView().getRevenueCircle());
        return owner;
        /*OwnerDetailsItem ownerDetailsItem = new OwnerDetailsItem();

        ownerDetailsItem.setAddressLine1(getView().getCurrentAddress());
        String email = getView().getEmail();
        if (Validator.validateEmail(email)) {
            ownerDetailsItem.setEmailID(email);
        } else {
            //set error message
        }
        ownerDetailsItem.setGender(getView().getSelectGender());
        String mobile = getView().getMobileNo();
        if (Validator.validateMobile(mobile)) {
            ownerDetailsItem.setMobileNumber(getView().getMobileNo());
        } else {

        }
        ownerDetailsItem.setName(getView().getOwnerName());
        ownerDetailsItem.setRelationName(getView().getRelationType());
        ownerDetailsItem.setRelationWith(getView().getFatherName());
        return ownerDetailsItem;*/
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
