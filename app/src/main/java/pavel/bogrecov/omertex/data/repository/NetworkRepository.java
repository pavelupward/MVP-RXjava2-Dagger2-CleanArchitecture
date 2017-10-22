package pavel.bogrecov.omertex.data.repository;

import io.reactivex.Observable;
import pavel.bogrecov.omertex.data.api.JsonAPI;
import pavel.bogrecov.omertex.data.api.PhotoApi;
import pavel.bogrecov.omertex.data.model.ExampleModel;
import pavel.bogrecov.omertex.data.model.PhotoModel;
import pavel.bogrecov.omertex.data.model.Profile;

/**
 * Created by pavel on 21.10.2017.
 */

public class NetworkRepository implements INetworkRepository {
    private JsonAPI jsonAPI;
    private PhotoApi photoApi;


    public NetworkRepository(JsonAPI jsonAPI, PhotoApi photoApi
            ) {
        this.jsonAPI = jsonAPI;
        this.photoApi = photoApi;

    }

    @Override
    public Observable<ExampleModel[]> getResponse() {
        return jsonAPI.getAllPost();
    }

    @Override
    public Observable<PhotoModel[]> getPhotoResponse() {
        return photoApi.getAllPhoto();
    }

    @Override
    public Observable<Profile> combineObservable() {
        return null;
    }

}
