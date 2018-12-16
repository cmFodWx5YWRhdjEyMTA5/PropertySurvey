package frameworks.di.module;

import android.content.Context;


import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import frameworks.appsession.AppSessionManager;
import frameworks.appsession.SessionValue;
import frameworks.di.module.net.NetModule;
import frameworks.di.qualifier.ApplicationContext;
import frameworks.di.scope.ApplicationScope;
import frameworks.routers.ILoginInterceptor;
import frameworks.utils.GsonFactory;


@Module (includes = {NetModule.class})
public class AppModule {

    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @ApplicationScope
    @Provides
    @ApplicationContext
    public Context provideContext() {
        return context.getApplicationContext();
    }

    @ApplicationScope
    @Provides
    SessionValue provideUserSession(AppSessionManager appSessionManager){
        return appSessionManager.getSession();
    }

    @ApplicationScope
    @Provides
    AppSessionManager provideSessionManager(@ApplicationContext Context context){
        return new AppSessionManager(context);
    }

    @ApplicationScope
    @Provides
    ILoginInterceptor provideAbstractionRouter(@ApplicationContext Context context){
        if(context instanceof ILoginInterceptor){
            return ((ILoginInterceptor)context);
        }else{
            return null;
        }
    }


}
