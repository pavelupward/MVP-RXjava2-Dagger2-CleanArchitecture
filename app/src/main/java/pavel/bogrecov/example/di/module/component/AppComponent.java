package pavel.bogrecov.example.di.module.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import pavel.bogrecov.example.data.api.JsonAPI;
import pavel.bogrecov.example.di.module.AppContextModule;
import pavel.bogrecov.example.di.module.NetworkModule;
import pavel.bogrecov.example.di.module.PresentationModule;
import pavel.bogrecov.example.presentation.mvp.view.BaseActivity;
import pavel.bogrecov.example.presentation.mvp.view.MainActivity;
import pavel.bogrecov.example.utils.rx.RxSchedulers;

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
