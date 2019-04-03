package com.softminesol.survey_framework.location;

import android.content.Context;

import com.softminesol.survey_framework.SurveyAppApplication;
import com.softminesol.survey_framework.location.di.DaggerLocationUploadComponent;
import com.softminesol.survey_framework.location.di.LocationUploadComponent;
import com.softminesol.survey_framework.location.domain.intractor.LocationUploadUseCase;
import com.softminesol.survey_framework.location.model.LatLongUpload;

import javax.inject.Inject;

import frameworks.network.model.BaseResponse;
import frameworks.network.usecases.RequestParams;
import rx.Subscriber;

/**
 * Created by sandeepgoyal on 18/05/18.
 */

public class LocationUploadManager {
    private static LocationUploadManager ourInstance;
    Context context;
    @Inject
    LocationUploadUseCase locationUploadUseCase;
    LocationUploadComponent component;

    private LocationUploadManager(Context context) {
        this.context = context;
        initInjector();
    }

    public static LocationUploadManager getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new LocationUploadManager(context);
        }
        return ourInstance;
    }

    private void initInjector() {
        component = DaggerLocationUploadComponent.builder().baseAppComponent(((SurveyAppApplication) context).getBaseAppComponent()).build();
        component.inject(this);
    }

    public void uploadLocation(LatLongUpload latLongUpload) {
        RequestParams requestParams = RequestParams.create();
        requestParams.putObject(LocationUploadUseCase.LOCATION_OBJECT, latLongUpload);
        locationUploadUseCase.execute(requestParams, new Subscriber<BaseResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(BaseResponse baseResponse) {

            }
        });
    }
}
