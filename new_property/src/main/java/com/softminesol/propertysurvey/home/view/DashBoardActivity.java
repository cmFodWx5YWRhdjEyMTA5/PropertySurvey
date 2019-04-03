package com.softminesol.propertysurvey.home.view;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.softminesol.survey_framework.R;
import com.softminesol.survey_framework.R2;
import com.softminesol.survey_framework.SurveyAppApplication;
import com.softminesol.propertysurvey.home.di.DaggerDashBoardComponent;
import com.softminesol.propertysurvey.home.di.DashBoardComponent;
import com.softminesol.propertysurvey.home.presenter.DashBoardContractor;
import com.softminesol.propertysurvey.home.presenter.DashBoardPresenter;
import com.softminesol.survey_framework.roomDb.PropertySurveyDB;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import frameworks.appsession.AppSessionManager;
import frameworks.basemvp.AppBaseActivity;

/**
 * Created by sandeepgoyal on 10/05/18.
 */

public class DashBoardActivity extends AppBaseActivity<DashBoardContractor.Presenter> implements DashBoardContractor.View {


    @Inject
    DashBoardPresenter presenter;
    DashBoardComponent dashBoardComponent;
    @BindView(R2.id.btn_new_property)
    View btnNewProperty;
    @BindView(R2.id.btn_old_property)
    View btnOldProperty;
    @BindView(R2.id.btn_bill_distribution)
    View btnBillDistribution;
    @BindView(R2.id.btn_add_apartment)
    View btnAddApartment;
    @BindView(R2.id.btn_total_cache_property)
    TextView propertyCount;
    @BindView(R2.id.btn_total_cache_apartment)
    TextView apartmentCount;
    @BindView(R2.id.btn_showDrafts)
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


    @OnClick({R2.id.btn_new_property, R2.id.btn_old_property, R2.id.btn_bill_distribution,R2.id.btn_add_apartment,R2.id.btn_showDrafts})
    public void onViewClicked(View view) {
        if (view.getId() == R.id.btn_new_property) {
            getPresenter().onNewPropertInfoClick();

        }else if(view.getId() == R.id.btn_add_apartment) {
            getPresenter().onAddApartmentClick();
        }else if( view.getId() == R.id.btn_showDrafts) {
            getPresenter().onShowDraftClick();
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
