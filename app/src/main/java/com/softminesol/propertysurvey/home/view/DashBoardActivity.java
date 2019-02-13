package com.softminesol.propertysurvey.home.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.view.menu.ActionMenuItem;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.softminesol.propertysurvey.R;
import com.softminesol.propertysurvey.SurveyAppApplication;
import com.softminesol.propertysurvey.home.di.DaggerDashBoardComponent;
import com.softminesol.propertysurvey.home.di.DashBoardComponent;
import com.softminesol.propertysurvey.home.presenter.DashBoardContractor;
import com.softminesol.propertysurvey.home.presenter.DashBoardPresenter;
import com.softminesol.propertysurvey.roomDb.PropertySurveyDB;
import com.softminesol.propertysurvey.roomDb.SurveyPropertyDao;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import frameworks.appsession.AppSessionManager;
import frameworks.appsession.SessionValue;
import frameworks.basemvp.AppBaseActivity;

/**
 * Created by sandeepgoyal on 10/05/18.
 */

public class DashBoardActivity extends AppBaseActivity<DashBoardContractor.Presenter> implements DashBoardContractor.View {


    @Inject
    DashBoardPresenter presenter;
    DashBoardComponent dashBoardComponent;
    @BindView(R.id.btn_new_property)
    View btnNewProperty;
    @BindView(R.id.btn_old_property)
    View btnOldProperty;
    @BindView(R.id.btn_bill_distribution)
    View btnBillDistribution;
    @BindView(R.id.btn_add_apartment)
    View btnAddApartment;
    @BindView(R.id.btn_total_cache_property)
    TextView propertyCount;
    @BindView(R.id.btn_total_cache_apartment)
    TextView apartmentCount;
    @BindView(R.id.btn_showDrafts)
    TextView showDrafts;

    @Override
    protected void initInjector() {
        dashBoardComponent = DaggerDashBoardComponent.builder().baseAppComponent(((SurveyAppApplication) getApplication()).getBaseAppComponent()).build();
        dashBoardComponent.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        propertyCount.setText(String.format(getResources().getString(R.string.property_cache_count),PropertySurveyDB.getInstance(this).getPropertyDao().getNonDraftedPropertiesCount()));
        apartmentCount.setText(String.format(getResources().getString(R.string.apartment_cache_count),PropertySurveyDB.getInstance(this).getApartmentDao().getNondraftedApartementCount()));
        showDrafts.setText(String.format(getResources().getString(R.string.show_drafts),PropertySurveyDB.getInstance(this).getApartmentDao().getdraftedApartementCount() +
                PropertySurveyDB.getInstance(this).getPropertyDao().getDraftedPropertiesCount()));

    }



    @Override
    public int getViewToCreate() {
        return R.layout.activity_dashboard;
    }

    @Override
    public DashBoardContractor.Presenter getPresenter() {
        return presenter;
    }


    @OnClick({R.id.btn_new_property, R.id.btn_old_property, R.id.btn_bill_distribution,R.id.btn_add_apartment,R.id.btn_showDrafts})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_new_property:
                getPresenter().onNewPropertInfoClick();
                break;
            case R.id.btn_add_apartment:
                getPresenter().onAddApartmentClick();
                break;
            case R.id.btn_showDrafts:
                getPresenter().onShowDraftClick();
                break;
        }
    }



    @Override
    public void setNewPropertyInvisible() {
        btnNewProperty.setVisibility(View.GONE);
    }

    @Override
    public void setUpdatePropertyInvisible() {
        btnOldProperty.setVisibility(View.GONE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logoutmenu,menu);
        AppSessionManager appSessionManager = new AppSessionManager(this);
        if(appSessionManager.getSession().getUserInfo() != null) {
            setRightText(appSessionManager.getSession().getUserInfo().getName());
        }
         return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.logout) {
            presenter.onLogout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
