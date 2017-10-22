package pavel.bogrecov.omertex.presentation.app;

import android.app.Application;
import android.content.Context;

import pavel.bogrecov.omertex.di.module.AppContextModule;
import pavel.bogrecov.omertex.di.module.component.AppComponent;
import pavel.bogrecov.omertex.di.module.component.DaggerAppComponent;

/**
 * Created by pavel on 20.10.2017.
 */

public class AppClass extends Application {
    private static AppComponent appComponent;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        initAppComponent();
    }

    public static AppComponent getNetComponent() {
        return appComponent;
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder().appContextModule(new AppContextModule(this)).build();
    }

    public static Context getContext() {
        return context;
    }
}
