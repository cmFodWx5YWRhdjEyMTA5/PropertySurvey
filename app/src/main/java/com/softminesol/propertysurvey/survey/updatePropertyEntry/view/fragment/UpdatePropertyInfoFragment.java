package com.softminesol.propertysurvey.survey.updatePropertyEntry.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.jakewharton.rxbinding2.widget.RxTextView;
import com.softminesol.propertysurvey.survey.common.model.OldPropertyUIDItem;
import com.softminesol.propertysurvey.survey.common.view.fragment.PropertyInfoFragment;
import com.softminesol.propertysurvey.survey.updatePropertyEntry.di.DaggerUpdateSurveyComponent;
import com.softminesol.propertysurvey.survey.updatePropertyEntry.di.UpdateSurveyComponent;
import com.softminesol.propertysurvey.survey.updatePropertyEntry.view.presenter.UpdatePropertyContractor;
import com.softminesol.propertysurvey.survey.updatePropertyEntry.view.presenter.UpdatePropertyPresenter;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import frameworks.AppBaseApplication;
import frameworks.customadapter.CustomAdapterModel;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sandeep on 5/5/18.
 */
public class UpdatePropertyInfoFragment extends PropertyInfoFragment<UpdatePropertyContractor.Presenter> implements UpdatePropertyContractor.View {

    @Inject
    UpdatePropertyPresenter updatePropertyPresenter;
    UpdateSurveyComponent updateSurveyComponent;
    ArrayAdapter arrayAdapter;// = new ArrayAdapter(getContext(), in.healthhunt.framework.R.layout.dropdown_item);

    public static UpdatePropertyInfoFragment newInstance() {


        UpdatePropertyInfoFragment fragment = new UpdatePropertyInfoFragment();
        return fragment;
    }

    @Override
    protected void initInjector() {
        updateSurveyComponent = DaggerUpdateSurveyComponent.builder().baseAppComponent(((AppBaseApplication) getActivity().getApplication()).getBaseAppComponent()).build();
        updateSurveyComponent.inject(this);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RxTextView.textChanges(edtOldpropertyId)
                .filter(new Predicate<CharSequence>() {
                    @Override
                    public boolean test(CharSequence integer) {
                        return integer.toString().length() > 2;
                    }
                })
                .debounce(100, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CharSequence>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CharSequence value) {
                        updatePropertyPresenter.onOldPropertyChange(value.toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        edtOldpropertyId.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                OldPropertyUIDItem propertyId = (OldPropertyUIDItem) parent.getItemAtPosition(position);
                getPresenter().onPropertyIDSelected(propertyId.getOldpropertyuid());
            }
        });
        arrayAdapter = new ArrayAdapter(getContext(), in.healthhunt.framework.R.layout.dropdown_item);
        edtOldpropertyId.setThreshold(3);
        edtOldpropertyId.setAdapter(arrayAdapter);

    }

    @Override
    public UpdatePropertyContractor.Presenter getPresenter() {
        return updatePropertyPresenter;
    }

    @Override
    public void setEdtDistCode(String text) {
        edtDistCode.setText(text);
    }

    @Override
    public void setEdtMcCode(String text) {
        edtMcCode.setText(text);
    }

    @Override
    public void setEdtColonyCode(String text) {
        edtColonyCode.setText(text);
    }

    @Override
    public void setEdtWardNo(String text) {
        edtWardNo.setText(text);
    }

    @Override
    public void setEdtZone(String text) {
        edtZone.setText(text);
    }

    @Override
    public void setEdtStreetCode(String text) {
        edtStreetCode.setText(text);
    }

    @Override
    public void setAreaType(String text) {
        areaType.setText(text);
    }

    @Override
    public void setOwnershipType(String text) {
    }

    @Override
    public void setEdtPhotoId(String text) {

    }

    @Override
    public void setEdtMapId(String text) {
        edtMapId.setText(text);
    }

    @Override
    public void setEdtHouseNo(String text) {
        edtHouseNo.setText(text);
    }

    @Override
    public void setEdtOldPropertyNo(String text) {
        edtPropertyId.setText(text);
    }

    @Override
    public void setEdtPropertyArea(String text) {
        edtPropertyArea.setText(text);
    }

    @Override
    public void setAreaMeasUnit(String text) {
        areaMeasUnit.setText(text);
    }

    @Override
    public void setEdtYearOfOccBuilding(String text) {
        edtYearOfOccBuilding.setText(text);
    }

    @Override
    public void setEdtLength(String text) {
        edtLength.setText(text);
    }

    @Override
    public void setEdtWidth(String text) {
        edtWidth.setText(text);
    }

    @Override
    public void setLengthWidthUnit(String text) {
        lengthWidthUnit.setText(text);
    }

    @Override
    public void setEdtWCon(String text) {
        edtWCon.setText(text);
    }

    @Override
    public void setEdtSewCon(String text) {
        edtSewCon.setText(text);
    }

    @Override
    public void setEdtSewConYear(String text) {
        edtSewConYear.setText(text);
    }

    @Override
    public void setEdtYearOfEstabl(String text) {

    }

    @Override
    public void setEdtTradeLicNo(String text) {

    }

    @Override
    public void setEdtTradeLicYear(String text) {
        edtTradeLicYear.setText(text);
    }

    @Override
    public void setMsmo(String text) {
        msmo.setText(text);
    }

    @Override
    public void setEdtRemark(String text) {
        edtRemark.setText(text);
    }

    @Override
    public void setEdtPropertyId(String text) {
        edtPropertyId.setText(text);
    }

    @Override
    public void setStateCode(String text) {
        edtStateCode.setText(text);
    }

    @Override
    public void setEdtCurrentAddress(String text) {
        edtCurrentAddress.setText(text);
    }

    @Override
    public void setEdtNoFloors(String text) {
        edtnoFloors.setText(text);
    }

    @Override
    public void setOldPropertyIDAdapter(List<CustomAdapterModel> IdListArrayAdapter) {
        arrayAdapter.clear();
        arrayAdapter.addAll(IdListArrayAdapter);
        arrayAdapter.notifyDataSetChanged();
        arrayAdapter.getFilter().filter("");
    }

}
