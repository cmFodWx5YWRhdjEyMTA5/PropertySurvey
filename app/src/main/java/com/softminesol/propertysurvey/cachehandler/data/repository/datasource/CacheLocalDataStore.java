package com.softminesol.propertysurvey.cachehandler.data.repository.datasource;

import android.content.Context;

import com.softminesol.propertysurvey.survey.common.model.PropertyCategoryList;
import com.softminesol.propertysurvey.survey.common.model.formData.FormData;
import com.softminesol.propertysurvey.survey.common.realm.RealmPropertyDataMapper;
import com.softminesol.propertysurvey.survey.distributionbill.model.BillDetails;

import java.util.List;

import javax.inject.Inject;

import frameworks.di.qualifier.ApplicationContext;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class CacheLocalDataStore {
    RealmPropertyDataMapper realPropertyDataMapper;

    @Inject
    public CacheLocalDataStore(@ApplicationContext Context context) {
        realPropertyDataMapper = RealmPropertyDataMapper.getInstance(context);
    }

    public boolean saveDataStore(List<FormData> formDataList) {
        return realPropertyDataMapper.addOrUpdatePropertyDataList(formDataList);
    }
    public boolean saveBillingDetails(List<BillDetails> billDetails) {
        return realPropertyDataMapper.addOrUpdateDistributionDataList(billDetails);
    }

    public Observable<Boolean> isDataExist() {
        return realPropertyDataMapper.getFormDataList().map(new Func1<List<FormData>, Boolean>() {
            @Override
            public Boolean call(List<FormData> propertyCategoryList) {
                return propertyCategoryList != null && propertyCategoryList.size()>0;
            }
        }) ;
    }
    public Observable<Boolean> isBillingDetailExist() {
        return realPropertyDataMapper.getAllBillDistributionForm().map(new Func1<List<BillDetails>, Boolean>() {
            @Override
            public Boolean call(List<BillDetails> billDetails) {
                return billDetails != null && billDetails.size()>0;
            }
        });
    }

    public void clearCache() {
        realPropertyDataMapper.clearCache();
    }


}
