package pavel.bogrecov.example.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pavel.bogrecov.example.domain.InteractorNetwork;
import pavel.bogrecov.example.presentation.mvp.presenter.PresenterMainActivity;
import pavel.bogrecov.example.presentation.mvp.view.adapter.AdapterRecyler;
import pavel.bogrecov.example.utils.rx.AppRxSchedulers;
import pavel.bogrecov.example.utils.rx.RxSchedulers;

/**
 * Created by pavel on 20.10.2017.
 */
@Module
public class PresentationModule {

    @Provides
    RxSchedulers provideRxSchedulers() {
        return new AppRxSchedulers();
    }

    @Provides
    @Singleton
    PresenterMainActivity provideIPresenterMainActivity(InteractorNetwork interactorNetwork,
            RxSchedulers rxSchedulers) {
        return new PresenterMainActivity(interactorNetwork, rxSchedulers);
    }

    @Provides
    @Singleton
    AdapterRecyler provideAdapterRecyler() {
        return new AdapterRecyler();
    }
}
