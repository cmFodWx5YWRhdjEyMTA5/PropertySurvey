package com.softminesol.propertysurvey_qc.qasearch.propertysearch.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.softminesol.propertysurvey_qc.R;
import com.softminesol.propertysurvey_qc.qasearch.propertysearch.di.DaggerQAComponent;
import com.softminesol.propertysurvey_qc.qasearch.propertysearch.di.QAComponent;
import com.softminesol.survey_framework.SurveyAppApplication;
import com.softminesol.survey_framework.survey.common.model.OldPropertyUIDItem;
import com.softminesol.survey_framework.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.survey_framework.survey.common.model.property.SavePropertyRequest;

import java.util.List;

import javax.inject.Inject;

import frameworks.basemvp.AppBaseActivity;
import frameworks.customadapter.CustomAdapterModel;

public class SearchPropertyListActivity extends AppBaseActivity<ISearchPropertyListContract.IDraftedListActivityPresenter> implements ISearchPropertyListContract.IDraftedListActivityView {
    QAComponent qaComponent;
    @Inject
    SearchPropertyListPresenter draftedListPresenter;

    SearchPropertyListAdapter draftedListAdapter = new SearchPropertyListAdapter();
    private RecyclerView mActivityDraftedList;

    private AutoCompleteTextView mEdtGSId;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        arrayAdapter = new ArrayAdapter(getContext(), in.healthhunt.framework.R.layout.dropdown_item);
        mEdtGSId.setThreshold(3);
        mEdtGSId.setAdapter(arrayAdapter);
        mEdtGSId.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                OldPropertyUIDItem propertyId = (OldPropertyUIDItem) parent.getItemAtPosition(position);
                getPresenter().onPropertyIDSelected(propertyId.getOldpropertyuid());
            }
        });
        mActivityDraftedList.setLayoutManager(new LinearLayoutManager(this));
        mActivityDraftedList.setAdapter(draftedListAdapter);

    }

    @Override
    protected void initInjector() {
        qaComponent = DaggerQAComponent.builder().baseAppComponent(((SurveyAppApplication) getApplication()).getBaseAppComponent()).build();
        qaComponent.inject(this);
    }

    @Override
    public int getViewToCreate() {
        return R.layout.activity_drafted_list;
    }

    @Override
    public ISearchPropertyListContract.IDraftedListActivityPresenter getPresenter() {
        return draftedListPresenter;
    }

    @Override
    public void setDraftedApartmentList(List<SaveApartmentRequest> saveApartmentRequests) {
        draftedListAdapter.setSaveApartmentRequests(saveApartmentRequests);
    }

    @Override
    public void setDraftedPropertyList(List<SavePropertyRequest> savePropertyRequests) {
        draftedListAdapter.setSavePropertyRequests(savePropertyRequests);
    }

    @Override
    public void setPropertyIdList(List<CustomAdapterModel> oldPropertyUID) {
        arrayAdapter.clear();
        arrayAdapter.addAll(oldPropertyUID);
        arrayAdapter.notifyDataSetChanged();
        arrayAdapter.getFilter().filter("");
    }

    private void initView() {
        mActivityDraftedList = findViewById(R.id.activity_drafted_list);
        mEdtGSId = findViewById(R.id.edt_GSId);
    }
}
