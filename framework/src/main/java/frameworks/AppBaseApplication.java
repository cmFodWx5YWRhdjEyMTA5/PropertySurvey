package frameworks;

import android.app.Application;
import android.content.Intent;


import net.danlew.android.joda.JodaTimeAndroid;

import frameworks.di.component.BaseAppComponent;
import frameworks.di.component.DaggerBaseAppComponent;
import frameworks.di.module.AppModule;

/**
 * Created by Sandeep on 21/01/2017.
 */

public abstract class AppBaseApplication extends Application {
    protected static AppBaseApplication mApplication;


    public static String TAG = AppBaseApplication.class.getName();

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        JodaTimeAndroid.init(this);
    }

    private BaseAppComponent baseAppComponent;

    public BaseAppComponent getBaseAppComponent(){
        if (baseAppComponent == null) {
            DaggerBaseAppComponent.Builder daggerBuilder = DaggerBaseAppComponent.builder()
                    .appModule(new AppModule(this));
            baseAppComponent = daggerBuilder.build();
        }
        return baseAppComponent;
    }


    public static AppBaseApplication getApplication() {
        return mApplication;
    }

}
