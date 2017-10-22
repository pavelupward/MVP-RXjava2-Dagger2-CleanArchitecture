package pavel.bogrecov.omertex.di.module;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import pavel.bogrecov.omertex.data.api.JsonAPI;
import pavel.bogrecov.omertex.data.api.PhotoApi;
import pavel.bogrecov.omertex.data.mapper.UserEntityDataMapper;
import pavel.bogrecov.omertex.data.repository.NetworkRepository;
import pavel.bogrecov.omertex.domain.InteractorNetwork;
import pavel.bogrecov.omertex.utils.rx.AppRxSchedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static pavel.bogrecov.omertex.data.api.URLAPI.BASE_PHOTO;
import static pavel.bogrecov.omertex.data.api.URLAPI.BASE_URL;

@Module
public class NetworkModule {
    @Singleton
    @Provides
    UserEntityDataMapper provideUserEntityDataMapper() {
        return new UserEntityDataMapper();
    }

    @Singleton
    @Provides
    InteractorNetwork provideInteractorNetwork(NetworkRepository iNetworkRepository,UserEntityDataMapper userEntityDataMapper) {
        return new InteractorNetwork(iNetworkRepository,userEntityDataMapper);
    }

    @Singleton
    @Provides
    JsonAPI provideApiService(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder().client(client).baseUrl(BASE_URL)
                .addConverterFactory(provideGsonClient()).
                        addCallAdapterFactory(provideRxAdapter()).build();

        return retrofit.create(JsonAPI.class);
    }

    @Singleton
    @Provides
    PhotoApi providePhotoApiService(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder().client(client).baseUrl(BASE_PHOTO)
                .addConverterFactory(provideGsonClient()).
                        addCallAdapterFactory(provideRxAdapter()).build();

        return retrofit.create(PhotoApi.class);
    }

    @Provides
    @Singleton
    NetworkRepository providerNetworkRepository(JsonAPI jsonAPI,PhotoApi photoApi) {
        return new NetworkRepository(jsonAPI,photoApi);
    }

    @Provides
    @Singleton
    OkHttpClient provideHttpClient() {

        return new OkHttpClient().newBuilder().build();
    }

    @Singleton
    @Provides
    RxJava2CallAdapterFactory provideRxAdapter() {
        return RxJava2CallAdapterFactory.createWithScheduler(AppRxSchedulers.INTERNET_SCHEDULERS);
    }

    @Provides
    GsonConverterFactory provideGsonClient() {
        return GsonConverterFactory.create();
    }

}

