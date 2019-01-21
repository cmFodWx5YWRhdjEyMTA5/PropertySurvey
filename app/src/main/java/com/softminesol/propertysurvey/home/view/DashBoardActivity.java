package com.softminesol.propertysurvey.home.view;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.softminesol.propertysurvey.R;
import com.softminesol.propertysurvey.SurveyAppApplication;
import com.softminesol.propertysurvey.home.di.DaggerDashBoardComponent;
import com.softminesol.propertysurvey.home.di.DashBoardComponent;
import com.softminesol.propertysurvey.home.presenter.DashBoardContractor;
import com.softminesol.propertysurvey.home.presenter.DashBoardPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import frameworks.basemvp.AppBaseActivity;

/**
 * Created by sandeepgoyal on 10/05/18.
 */

public class DashBoardActivity extends AppBaseActivity<DashBoardContractor.Presenter> implements DashBoardContractor.View {


    @Inject
    DashBoardPresenter presenter;
    DashBoardComponent dashBoardComponent;
    @BindView(R.id.btn_new_property)
    Button btnNewProperty;
    @BindView(R.id.btn_old_property)
    Button btnOldProperty;
    @BindView(R.id.btn_bill_distribution)
    Button btnBillDistribution;
    @BindView(R.id.btn_add_apartment)
    Button btnAddApartment;
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
