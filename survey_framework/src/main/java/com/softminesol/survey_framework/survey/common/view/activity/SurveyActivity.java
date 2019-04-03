package com.softminesol.survey_framework.survey.common.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.softminesol.survey_framework.R;
import com.softminesol.survey_framework.R2;

import butterknife.BindView;
import frameworks.basemvp.AppBaseActivity;
import frameworks.basemvp.IPresenter;

/**
 * Created by sandeep on 5/5/18.
 */
public abstract class SurveyActivity extends AppBaseActivity implements onMenuClick {
    @BindView(R2.id.survey_form_container)
    ViewPager surveyFormContainer;
    int pageSelected;

    @Override
    protected void initInjector() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final FragmentPagerAdapter adapter = getAdapter();
        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                pageSelected = position;
                setTitle(adapter.getPageTitle(position));
                setmAddedFragment(adapter.getItem(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        };
        surveyFormContainer.addOnPageChangeListener(onPageChangeListener);
        surveyFormContainer.setAdapter(adapter);
        onPageChangeListener.onPageSelected(0);
    }

    public abstract FragmentPagerAdapter getAdapter();

    @Override
    public int getViewToCreate() {
        return R.layout.activity_survey;
    }

    @Override
    public IPresenter getPresenter() {
        return null;
    }

    @Override
    public void onNextClick() {
        surveyFormContainer.setCurrentItem(pageSelected + 1);
    }

    @Override
    public void onBackClick() {
        surveyFormContainer.setCurrentItem(pageSelected - 1);
    }

    @Override
    public void onFinishCLick() {
    }
}
