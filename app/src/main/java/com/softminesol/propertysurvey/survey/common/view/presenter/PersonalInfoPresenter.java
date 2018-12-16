package com.softminesol.propertysurvey.survey.common.view.presenter;

import android.content.Intent;
import android.text.TextUtils;

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

    public boolean validateForm() {
        if (TextUtils.isEmpty(getView().getOwnerName())) {
            getView().setOwnerNameError("Please Enter");
            return false;
        }
        return true;
    }

    private OwnerDetailsItem getOwnerDetail() {
        OwnerDetailsItem ownerDetailsItem = new OwnerDetailsItem();

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
        return ownerDetailsItem;
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
