package com.softminesol.propertysurvey_qc.home.view;

import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import com.softminesol.propertysurvey.R;
import com.softminesol.propertysurvey_qc.home.di.DaggerDashBoardComponent;
import com.softminesol.propertysurvey_qc.home.di.DashBoardComponent;
import com.softminesol.propertysurvey_qc.home.presenter.DashBoardContractor;
import com.softminesol.propertysurvey_qc.home.presenter.DashBoardPresenter;
import com.softminesol.survey_framework.SurveyAppApplication;

import javax.inject.Inject;

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

    public static Intent getIntent(Context context) {
        Intent i = new Intent(context, DashBoardActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_CLEAR_TASK |
                Intent.FLAG_ACTIVITY_NEW_TASK);
        return i;
    }

    @Override
    protected void initInjector() {
        dashBoardComponent = DaggerDashBoardComponent.builder().baseAppComponent(((SurveyAppApplication) getApplication()).getBaseAppComponent()).build();
        dashBoardComponent.inject(this);
    }


    @Override
    public int getViewToCreate() {
        return R.layout.activity_dashboard;
    }

    @Override
    public DashBoardContractor.Presenter getPresenter() {
        return presenter;
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

    @OnClick(R.id.btn_qc_property)
    void onQcClick() {
        getPresenter().onPropertySearchClick();
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
