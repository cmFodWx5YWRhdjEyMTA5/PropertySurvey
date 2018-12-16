package com.softminesol.propertysurvey.survey.distributionbill.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.jakewharton.rxbinding2.widget.RxTextView;
import com.softminesol.propertysurvey.R;
import com.softminesol.propertysurvey.SurveyAppApplication;
import com.softminesol.propertysurvey.survey.common.model.OldPropertyUIDItem;
import com.softminesol.propertysurvey.survey.distributionbill.di.BillDistributionComponent;
import com.softminesol.propertysurvey.survey.distributionbill.di.DaggerBillDistributionComponent;
import com.softminesol.propertysurvey.survey.distributionbill.presenter.DistributionBillContract;
import com.softminesol.propertysurvey.survey.distributionbill.presenter.DistributionBillPresenter;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import frameworks.basemvp.AppBaseActivity;
import frameworks.customadapter.CustomAdapterModel;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sandeepgoyal on 10/05/18.
 */

public class DistributionBillActivity extends AppBaseActivity<DistributionBillContract.Presenter> implements DistributionBillContract.View {

    @Inject
    DistributionBillPresenter presenter;
    @BindView(R.id.edt_propertyId)
    AutoCompleteTextView edtPropertyId;
    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.edt_address)
    EditText edtAddress;
    @BindView(R.id.edt_ph_no)
    EditText edtPhNo;
    @BindView(R.id.edt_status)
    MaterialBetterSpinner edtStatus;
    @BindView(R.id.edt_PicId)
    EditText edtPicId;
    BillDistributionComponent component;
    ArrayAdapter arrayAdapter;// = new ArrayAdapter(getContext(), in.healthhunt.framework.R.layout.dropdown_item);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxTextView.textChanges(edtPropertyId)
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
                        if (!edtPropertyId.isPerformingCompletion()) {
                            presenter.onOldPropertyChange(value.toString());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        edtPropertyId.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                OldPropertyUIDItem propertyId = (OldPropertyUIDItem) parent.getItemAtPosition(position);
                getPresenter().onPropertyIDSelected(propertyId.getOldpropertyuid());
            }
        });
        arrayAdapter = new ArrayAdapter(getContext(), in.healthhunt.framework.R.layout.dropdown_item);
        edtPropertyId.setAdapter(arrayAdapter);
        edtPropertyId.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                edtPropertyId.showDropDown();
                return false;
            }
        });
        setRightText("Done  ");

    }


    @Override
    protected void onRightMenuClick() {
        super.onRightMenuClick();
        getPresenter().onUploadBillClick();
    }

    @Override
    protected void initInjector() {
        component = DaggerBillDistributionComponent.builder().baseAppComponent(((SurveyAppApplication) getApplication()).getBaseAppComponent()).build();
        component.inject(this);
    }


    public String getEdtPropertyId() {
        return edtPropertyId.getText().toString();
    }

    public void setEdtPropertyId(String edtPropertyId) {
        this.edtPropertyId.setText(edtPropertyId);
    }

    public String getEdtName() {
        return edtName.getText().toString();
    }

    public void setEdtName(String edtName) {
        this.edtName.setText(edtName);
    }

    public String getEdtAddress() {
        return edtAddress.getText().toString();
    }

    public void setEdtAddress(String edtAddress) {
        this.edtAddress.setText(edtAddress);
    }

    public String getEdtPhNo() {
        return edtPhNo.getText().toString();
    }

    public void setEdtPhNo(String edtPhNo) {
        this.edtPhNo.setText(edtPhNo);
    }

    public String getEdtStatus() {
        return edtStatus.getText().toString();
    }

    public void setEdtStatus(String edtStatus) {
        this.edtStatus.setText(edtStatus);
    }

    public String getEdtPicId() {
        return edtPicId.getText().toString();
    }

    public void setEdtPicId(String edtPicId) {
        this.edtPicId.setText(edtPicId);
    }

    public void setOldPropertyIDAdapter(List<CustomAdapterModel> propertyIDList) {
        arrayAdapter.clear();
        arrayAdapter.addAll(propertyIDList);
        arrayAdapter.notifyDataSetChanged();
        arrayAdapter.getFilter().filter("");



    }

    @Override
    public void setStatusOptions(ArrayAdapter arrayAdapter) {
        edtStatus.setAdapter(arrayAdapter);
    }

    @Override
    public int getViewToCreate() {
        return R.layout.acivity_distribution_view;
    }

    @Override
    public DistributionBillContract.Presenter getPresenter() {
        return presenter;
    }

    public void setPresenter(DistributionBillPresenter presenter) {

        this.presenter = presenter;
    }

    @OnClick(R.id.btn_upload_pic)
    public void onViewClicked() {
        presenter.onUploadPickClick();
    }
}
