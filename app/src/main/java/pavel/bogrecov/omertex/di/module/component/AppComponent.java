package pavel.bogrecov.omertex.di.module.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import pavel.bogrecov.omertex.data.api.JsonAPI;
import pavel.bogrecov.omertex.di.module.AppContextModule;
import pavel.bogrecov.omertex.di.module.NetworkModule;
import pavel.bogrecov.omertex.di.module.PresentationModule;
import pavel.bogrecov.omertex.presentation.mvp.view.BaseActivity;
import pavel.bogrecov.omertex.presentation.mvp.view.MainActivity;
import pavel.bogrecov.omertex.utils.rx.RxSchedulers;

@Singleton
@Component(modules = {NetworkModule.class, AppContextModule.class,
        PresentationModule.class})
public interface AppComponent {

    RxSchedulers rxSchedulers();

    JsonAPI apiService();

    Context context();

    void inject(MainActivity homeActivity);

    void inject(BaseActivity homeActivity);

}
