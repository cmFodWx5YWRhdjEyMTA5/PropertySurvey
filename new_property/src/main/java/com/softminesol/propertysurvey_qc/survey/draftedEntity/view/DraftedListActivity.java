package com.softminesol.propertysurvey_qc.survey.draftedEntity.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.softminesol.propertysurvey_qc.survey.newPropertyEntry.di.NewSurveyComponent;
import com.softminesol.propertysurvey_qc.survey.newPropertyEntry.di.DaggerNewSurveyComponent;
import com.softminesol.survey_framework.R;
import com.softminesol.survey_framework.SurveyAppApplication;
import com.softminesol.survey_framework.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.survey_framework.survey.common.model.property.SavePropertyRequest;

import java.util.List;

import javax.inject.Inject;

import frameworks.basemvp.AppBaseActivity;

public class DraftedListActivity extends AppBaseActivity<IDraftedListActivityContract.IDraftedListActivityPresenter> implements IDraftedListActivityContract.IDraftedListActivityView {
    NewSurveyComponent surveyComponent;
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
        surveyComponent = DaggerNewSurveyComponent.builder().baseAppComponent(((SurveyAppApplication) getApplication()).getBaseAppComponent()).build();
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
