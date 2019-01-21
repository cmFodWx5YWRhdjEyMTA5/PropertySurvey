package com.softminesol.propertysurvey.survey.draftedEntity.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.softminesol.propertysurvey.R;
import com.softminesol.propertysurvey.SurveyAppApplication;
import com.softminesol.propertysurvey.survey.common.di.DaggerSurveyComponent;
import com.softminesol.propertysurvey.survey.common.di.SurveyComponent;
import com.softminesol.propertysurvey.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.propertysurvey.survey.common.model.property.SavePropertyRequest;

import java.util.List;

import javax.inject.Inject;

import frameworks.basemvp.AppBaseActivity;

public class DraftedListActivity extends AppBaseActivity<IDraftedListActivityContract.IDraftedListActivityPresenter> implements IDraftedListActivityContract.IDraftedListActivityView {
    SurveyComponent surveyComponent;
    @Inject
    DraftedListPresenter draftedListPresenter;

    DraftedListAdapter draftedListAdapter = new DraftedListAdapter();
    private RecyclerView mActivityDraftedList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        mActivityDraftedList.setLayoutManager(new LinearLayoutManager(this));
        mActivityDraftedList.setAdapter(draftedListAdapter);

    }

    @Override
    protected void initInjector() {
        surveyComponent = DaggerSurveyComponent.builder().baseAppComponent(((SurveyAppApplication) getApplication()).getBaseAppComponent()).build();
        surveyComponent.inject(this);
    }

    @Override
    public int getViewToCreate() {
        return R.layout.activity_drafted_list;
    }

    @Override
    public IDraftedListActivityContract.IDraftedListActivityPresenter getPresenter() {
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

    private void initView() {
        mActivityDraftedList = findViewById(R.id.activity_drafted_list);
    }
}
